package com.company.JavaPractice.services;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class FileWorker {

    static protected String hashFile (File file) throws IOException {

        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IOException("SHA-256 doesn't exist.");
        }

        try (InputStream input = new FileInputStream(file)) {

            byte[] buffer = new byte[8192];
            int len = input.read(buffer);

            while (len != -1) {
                sha.update(buffer, 0, len);
                len = input.read(buffer);
            }

            return new String(sha.digest());
        }
    }

    static protected void writeToFile(File file, String data) throws FileNotFoundException {
        try (PrintStream printStream =
                     new PrintStream(
                             new FileOutputStream(file))) {
            printStream.print(data);
        }
    }

}
