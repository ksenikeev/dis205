package ru.itis.dis205.lab02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab01InetAddress {
    public static void main(String[] args) {
        InetAddress iaRemoteAddress = null;
        InetAddress[] iaRemoteAll;

        String citeName = "google.com";

        try
        {
            iaRemoteAddress =
                    InetAddress.getByName(citeName);

            System.out.println(iaRemoteAddress);

            iaRemoteAll =
                    InetAddress.getAllByName(citeName);

            for (InetAddress ia : iaRemoteAll) {
                System.out.println(ia);
            }
        }
        catch(UnknownHostException ex)
        {
            System.out.println(ex.toString());
        }


    }
}
