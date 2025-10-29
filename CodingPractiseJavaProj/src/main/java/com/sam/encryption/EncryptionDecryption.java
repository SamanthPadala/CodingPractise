package com.sam.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionDecryption {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";

    public static void main(String[] args) {
        String inputCsvFile = "input.csv";
        String encryptedFile = "encrypted.csv";
        String decryptedFile = "decrypted.csv";

        try {
            SecretKey key = generateKey();
            // Example: Save the Key to a file, or use a secure Key management system.
            // This is only for example purposes.
            String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
            Files.write(Paths.get("key.txt"), encodedKey.getBytes());


            encryptFile(inputCsvFile, encryptedFile, key);
            System.out.println("CSV file encrypted successfully.");

            // Example: Loading the Key from a file, or use a secure Key management system.
            byte[] decodedKey = Base64.getDecoder().decode(Files.readString(Paths.get("key.txt")));
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, KEY_ALGORITHM);


            decryptFile(encryptedFile, decryptedFile, originalKey);
            System.out.println("CSV file decrypted successfully.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void encryptFile(String inputFilePath, String outputFilePath, SecretKey key) throws Exception {
        byte[] iv = generateIv();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {

            fos.write(iv);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void decryptFile(String inputFilePath, String outputFilePath, SecretKey key) throws Exception {
        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath)) {

            byte[] iv = new byte[16];
            fis.read(iv);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

            try (CipherInputStream cis = new CipherInputStream(fis, cipher)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = cis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        }
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(256); // AES-256
        return keyGenerator.generateKey();
    }

    // Initialization Vector (IV)
    private static byte[] generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

}
