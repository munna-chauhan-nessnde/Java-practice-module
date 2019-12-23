package org.sample.solution;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA_256 {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = scan.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        BigInteger number = new BigInteger(1, md.digest(input.getBytes(StandardCharsets.UTF_8)));
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        System.out.println(hexString.toString());
    }
}
