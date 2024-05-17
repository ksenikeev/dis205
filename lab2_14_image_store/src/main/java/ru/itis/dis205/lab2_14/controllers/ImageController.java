package ru.itis.dis205.lab2_14.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.dis205.lab2_14.model.ImageFileData;
import ru.itis.dis205.lab2_14.model.User;
import ru.itis.dis205.lab2_14.model.UserInfo;
import ru.itis.dis205.lab2_14.security.UserDetailImpl;
import ru.itis.dis205.lab2_14.service.UserService;

import java.io.*;
import java.net.URL;
import java.net.http.HttpClient;
import java.time.LocalDateTime;

@Controller
public class ImageController {

    private Logger log = LoggerFactory.getLogger(ImageController.class);

    // Путь к файловому хранилищу
    @Value("${app.imgstore.path}")
    private String imgStorePath;

    private String defaultImg = "<?xml version=\"1.0\" encoding=\"utf-8\"?><svg width=\"800px\" height=\"800px\" viewBox=\"0 0 16 16\" xmlns=\"http://www.w3.org/2000/svg\"><g color=\"#000000\" font-weight=\"400\" font-family=\"Ubuntu\" letter-spacing=\"0\" word-spacing=\"0\" white-space=\"normal\" fill=\"gray\"><path d=\"M8 2a2.84 2.84 0 0 0-1.12.221c-.345.141-.651.348-.906.615v.003l-.001.002c-.248.269-.44.592-.574.96-.137.367-.203.769-.203 1.2 0 .435.065.841.203 1.209.135.361.327.68.574.95l.001.002c.254.267.558.477.901.624v.003c.346.141.723.21 1.12.21.395 0 .77-.069 1.117-.21v-.002c.343-.147.644-.357.892-.625.255-.268.45-.59.586-.952.138-.368.204-.774.204-1.21h.01c0-.43-.065-.831-.203-1.198a2.771 2.771 0 0 0-.585-.963 2.5 2.5 0 0 0-.897-.618A2.835 2.835 0 0 0 7.999 2zM8.024 10.002c-2.317 0-3.561.213-4.486.91-.462.35-.767.825-.939 1.378-.172.553-.226.975-.228 1.71L8 14.002h5.629c-.001-.736-.052-1.159-.225-1.712-.172-.553-.477-1.027-.94-1.376-.923-.697-2.124-.912-4.44-.912z\" style=\"line-height:125%;-inkscape-font-specification:'Ubuntu, Normal';font-variant-ligatures:normal;font-variant-position:normal;font-variant-caps:normal;font-variant-numeric:normal;font-variant-alternates:normal;font-feature-settings:normal;text-indent:0;text-align:start;text-decoration-line:none;text-decoration-style:solid;text-decoration-color:#000000;text-transform:none;text-orientation:mixed;shape-padding:0;isolation:auto;mix-blend-mode:normal\"overflow=\"visible\"/></g></svg>";

    @Autowired
    private UserService userService;

    /*
        Аватарки будем хранить по пути ${app.imgstore.path}/avatars/@{user.id}/@{imgeFile.id}.@{mim_type}
    */
    @PostMapping("/loadavatar")
    public String loadAvatar(@RequestParam("avatar") MultipartFile file, Authentication authentication) {

        User user = ((UserDetailImpl) authentication.getPrincipal()).getUser();

        log.debug(imgStorePath);
        try {
            log.debug(file.getOriginalFilename());
            log.debug(String.valueOf(file.getBytes().length));

            UserInfo userInfo = user.getUserInfo() != null ? user.getUserInfo() : new UserInfo();
            ImageFileData imageFileData = userInfo.getAvatar() != null ? userInfo.getAvatar() : new ImageFileData();

            imageFileData.setFileName(file.getOriginalFilename());
            imageFileData.setPath("avatar/" + String.valueOf(user.getId()) + "/");
            imageFileData.setAttachDate(LocalDateTime.now());

            userInfo.setAvatar(imageFileData);

            userInfo.setUser(user);

            user.setUserInfo(userInfo);

            userService.save(user);

            File path = new File(imgStorePath, imageFileData.getPath());
            if (!path.exists()) {
                path.mkdir();
            }

            try (FileOutputStream fos =
                 new FileOutputStream(new File(path, file.getOriginalFilename()))) {
                fos.write(file.getBytes());
                fos.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/cabinet";
    }


    @GetMapping("/imgstore/**")
    @ResponseBody
    public void getImageFromImageStore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug(request.getServletPath());
        log.debug(request.getServletPath().substring("/imgstore/".length()));
        byte[] content = null;
        File imageFullPath = new File(imgStorePath, request.getServletPath().substring("/imgstore/".length()));
        log.debug(imageFullPath.getAbsolutePath());
        try (FileInputStream fis = new FileInputStream(imageFullPath)) {
            content = fis.readAllBytes();
            log.debug(String.valueOf(content.length));
        } catch (Exception e) {
            content = defaultImg.getBytes();
        }

        response.setContentLength(content.length);
        response.getOutputStream().write(content);
    }

    // Вариант использования статических ресурсов
    //@GetMapping("/static/**")
    @ResponseBody
    public void getStaticResources(HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.debug(request.getServletPath());
        log.debug(request.getServletPath().substring("/static/".length()));
        byte[] content = null;
        URL staticPath = this.getClass().getClassLoader()
                .getResource("static");
        log.debug(staticPath.getPath());

        File imageFullPath = new File(staticPath.getPath(), request.getServletPath().substring("/static/".length()));
        log.debug(imageFullPath.getAbsolutePath());
        try (FileInputStream fis = new FileInputStream(imageFullPath)) {
            content = fis.readAllBytes();
            log.debug(String.valueOf(content.length));
        } catch (Exception e) {
            content = defaultImg.getBytes();
        }

        response.setContentType("image/svg+xml");
        response.setContentLength(content.length);
        response.getOutputStream().write(content);
    }

    private String getFileExtension(String file) {;
        int lastIndexOf = file.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return file.substring(lastIndexOf);
    }

}
