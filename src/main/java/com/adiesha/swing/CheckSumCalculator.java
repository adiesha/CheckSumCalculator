package com.adiesha.swing;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class CheckSumCalculator {

    private static CheckSumCalculator privateInstance = null;
    private static Map<Integer, String> mapAlgoIDtoName = null;

    protected CheckSumCalculator() {
        mapAlgoIDtoName = new HashMap<Integer, String>();
        mapAlgoIDtoName.put(1, "SHA-256");
        mapAlgoIDtoName.put(2, "SHA-512");
        mapAlgoIDtoName.put(3, "MD5");
    }

    public static synchronized CheckSumCalculator getInstance() {
        if (privateInstance == null) {
            privateInstance = new CheckSumCalculator();
        }
        return privateInstance;
    }

    public byte[] calculate(int algoID, String filePath) throws IOException {
        MessageDigest md = getHashAlgo(algoID);
        FileInputStream fileInputStream = getFileInputStream(filePath);
        byte[] dataBytes = new byte[1024];
        int nread = 0;
        while ((nread = fileInputStream.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
        }

        byte[] mdbytes = md.digest();
        return mdbytes;
    }

    public MessageDigest getHashAlgo(int algoID) {
        if (!mapAlgoIDtoName.containsKey(algoID)) {
            System.out.println("Choosing default algorithm SHA-256");
            algoID = 1;
        }
        try {
            return MessageDigest.getInstance(mapAlgoIDtoName.get(algoID));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No such algorithm exist");
            e.printStackTrace();
            exit(-1);
        }
        return null;
    }

    public FileInputStream getFileInputStream(String filePath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error: cannot read the file");
            exit(-1);
        }
        return fileInputStream;
    }

    public static String parseByteToHexFormat(byte[] input) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length; i++) {
            sb.append(Integer.toString((input[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println("Hex Format: " + sb.toString());
        System.out.println("Hex Format: " + DatatypeConverter.printHexBinary(input));
        return sb.toString();
    }
}
