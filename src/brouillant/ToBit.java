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
public class ToBit {

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//NB:les carcteres spetiaux ne donnent pas des resultats satsisfaisants par
//cette fonction "à,ç"$*.....donc tu dois utiliser que les alphabets,les lettres,-,et _

    public static String StringToBinary(String text) {
        String textBinary = "";
        String s7 = "0000000", s6 = "000000", s5 = "00000", s4 = "0000", s3 = "000", s2 = "00", s1 = "0";


        int textLenth = text.length();
        //on decoupe le texte sous forme de carctères
        char[] c = text.toCharArray();
        //
        int[] b = new int[textLenth];
        String[] st = new String[textLenth];
        //
        for (int g = 0; g < textLenth; g++) {
            b[g] = (byte) c[g];//on converti chaque carctère a son code ascii
            st[g] = Integer.toBinaryString(b[g]);//on converti chaque code ascci sous sa forme binaire
            // System.out.println(st[g]);
            if (st[g].length() == 1) {
                st[g] = s7 + st[g];
            }//pour avoir des squences de 8 bits
            if (st[g].length() == 2) {
                st[g] = s6 + st[g];
            }//ca sera utile por le découpage pendant
            if (st[g].length() == 3) {
                st[g] = s5 + st[g];
            }//le déchifrement
            if (st[g].length() == 4) {
                st[g] = s4 + st[g];
            }
            if (st[g].length() == 5) {
                st[g] = s3 + st[g];
            }
            if (st[g].length() == 6) {
                st[g] = s2 + st[g];
            }
            if (st[g].length() == 7) {
                st[g] = s1 + st[g];
            }
            textBinary += st[g];
            //System.out.println(g+"\t"+st[g].toString());


        }
        //System.out.println(textBinary);
        return textBinary;
    }


 public static void main(String[] args) {
        String msg ="nouar choukri";
        char tab[] = new char[10];
        //String [] tab = StringToBinary(msg);
             for(int i=0;i<msg.length();i++)
        {
         //   tab[i]=(char)StringToBinary(msg).getBytes();
        }
           // ToBit m=new ToBit();
        for(int i=0;i<tab.length;i++)
          System.out.println(tab[i]);
        }

}

