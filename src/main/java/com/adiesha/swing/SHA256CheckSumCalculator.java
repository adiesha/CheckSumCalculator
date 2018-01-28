package com.adiesha.swing;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256CheckSumCalculator {
    public void run() throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream("E:\\Apps\\datagrip-2017.3.4.exe");

        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = fis.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
        }

        byte[] mdbytes = md.digest();

//        convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<mdbytes.length;i++) {
            System.out.println(mdbytes[i]);
            sb.append(Integer.toString((mdbytes[i] & 0xff)+ 0x100,16).substring(1));
        }

        System.out.println("Hex Format: " +  sb.toString());
        System.out.println(DatatypeConverter.printHexBinary(mdbytes));
    }
}
