package org.sample.solution;

import java.util.BitSet;
import java.util.Scanner;

/**
 * AND
 * OR
 * XOR
 * FLIP
 * SET
 */
public class BitSetSolution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            switch (s) {
                case "AND":
                    if (n1 == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                    break;
                case "OR":
                    if (n1 == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                    break;
                case "XOR":
                    if (n1 == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                    break;
                case "FLIP":
                    if (n1 == 1) {
                        b1.flip(n2);
                    } else {
                        b2.flip(n2);
                    }
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                    break;
                case "SET":
                    if (n1 == 1) {
                        b1.set(n2);
                    } else {
                        b2.set(n2);
                    }
                    System.out.println(b1.cardinality()+" "+b2.cardinality());
                    break;
            }
        }
    }
}
