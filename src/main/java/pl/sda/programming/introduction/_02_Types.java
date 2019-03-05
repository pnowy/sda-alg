package pl.sda.programming.introduction;

import java.util.Date;

final class _02_Types {
    public static void main(String[] args) {

        // primitive types

        // integers numbers

        // byte
        byte b1 = 127; // 1 bajt
        byte b2 = -128;

        // short
        short s1 = 32_767; // 2 bajty
        short s2 = -32_768;

        // integer
        int i1 = 2_147_483_647; // 4 bajty
        int i2 = -2_147_483_648;

        // long
        long l1 = 9_223_372_036_854_775_807L; // 8 bajtow
        long l2 = -9_223_372_036_854_775_808L;

        // floating points numbers

        float f1 = 0.9999F; // 4 bajt
        double d1 = 0.9999D; // 8 bajtow

        // boolean
        boolean bb1 = true;
        boolean bb2 = false;
        System.out.println("boolean bb1 is = " + bb1);

        // chars
        char c1 = 'ę';
        char c2 = 'k';
        System.out.println(c1 + 0);
        System.out.println(c2 + 0);
        System.out.println("char is = " + c1 + c2);

        // casting down
        long l3 = 10000L;
        l3 = b1;
        l3 = s1;
        l3 = i1;

        s1 = b1;
        i1 = s1;
        l3 = i1;

        // unsafe
        s1 = (short) l3;
        System.out.println("1. unsafe short is = " + s1);

        l3 = 32_768;
        s1 = (short) l3;
        System.out.println("2. unsafe short is = " + s1);


        // double and float
        d1 = f1;
        System.out.println("float f1 is  = " + f1);
        System.out.println("double is = " + d1);
        f1 = (float) d1;
        System.out.println("float f1 is = " + f1);

        // integers and doubles
        d1 = l1;
        System.out.println(d1);
        f1 = l1;
        System.out.println(f1);

        l1 = (long) d1;
        System.out.println("long from double is = " + l1);
        l1 = (long) f1;
        System.out.println("long from float is = " + l1);


        // reference type
        Date date1 = new Date();

        // null type
        date1 = null;

        l1 = i1;

        // it will raise error
        date1.getTime();

        System.out.println("after null pointer");
    }
}
