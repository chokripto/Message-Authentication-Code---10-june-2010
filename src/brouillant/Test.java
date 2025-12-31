/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brouillant;

import java.math.BigInteger;

/**
 *
 * @author choukri
 */
public class Test {

    public static String tohex(byte[] tab) {
        char a[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int n = tab.length;
        String x = "";
        int c;
        for (int i = 0; i < n; i++) {
            c = tab[i];
            if (c < 0) {
                c += 256;
            }
            x += (a[c / 16]) + "" + (a[c % 16]);
        }
        return x;
    }

    public static String opad(int bit) {
        bit /= 8;
        byte[] a = new byte[bit];
        for (int i = 0; i < bit; i++) {
            a[i] = (byte) 0x5c;
        }
        return new String(a);
    }

    public static String ipad(int bit) {
        bit /= 8;
        byte[] a = new byte[bit];
        for (int i = 0; i < bit; i++) {
            a[i] = (byte) 0x36;
        }
        return new String(a);
    }

    public static void main(String[] argv) {
      //  byte a = 0x36;
        String Ipad=ipad(256);
        //BigInteger p =new BigInteger(Ipad);
        System.out.println((Ipad));
    }
}
