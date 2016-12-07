package com.sunbeam.app.utilities;

import java.security.MessageDigest;

public class CustomMD5
{
    public static void main(String[] args)throws Exception
    {
    	String password = "rohit";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println("Encrypted Data" + sb.toString());
    }
}