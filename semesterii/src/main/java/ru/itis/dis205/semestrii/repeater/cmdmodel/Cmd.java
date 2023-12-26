package ru.itis.dis205.semestrii.repeater.cmdmodel;

public class Cmd {
    /*

    {"cmd":3, "otherClientName":"Kamil", "data":""}

    2. Получение списка пользователей
 *
 * 3. Передача данных другому клиенту
 *
 * 4. Завершение сессии
     */
    public Integer cmd;
    public String otherClientName;
    // данные в base64
    public String data;

    @Override
    public String toString() {
        return "Cmd{" +
                "cmd=" + cmd +
                ", otherClientName='" + otherClientName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
