package ru.itis.dis205.semestrii;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
public class SoundUtil {

    private Clip clip=null;
    private boolean playing = false;

    public static void main(String[] args){
        System.out.println(new Date());
        SoundUtil su = new SoundUtil();
        su.playWavFromResource("rocket.wav");
    }

     public SoundUtil(){
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playWavFromFile1(File soundFile){
        try(AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);){
            clip.open(ais);
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        playing = false;
                        synchronized(clip) {
                            clip.notify();
                        }
                    }
                }
            });
            clip.setFramePosition(0);
            clip.start();
            playing = true;
            synchronized (clip) {
                while (playing) clip.wait();
            }
            clip.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playWavFromFile(File soundFile){
        SourceDataLine clipSDL = null;
        AudioInputStream ais=null;
        byte[] b = new byte[2048];
        try {
            ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
            if (AudioSystem.isLineSupported(info)) {
                clipSDL = (SourceDataLine)AudioSystem.getLine(info);
                clipSDL.open(af);
                clipSDL.start();
                int num=0;
                while ((num=ais.read(b))!=-1)
                    clipSDL.write(b, 0, num);
                clipSDL.drain();
                ais.close();
//                Thread.sleep(clipSDL.getMicrosecondLength()/1000);
                clipSDL.stop();
                clipSDL.close();
            }else {
                System.out.println("Format "+soundFile.getName()+" not support!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playWavFromResource(String fileName){
        File file = new File(fileName);
        playWavFromFile(file);
    }
}
