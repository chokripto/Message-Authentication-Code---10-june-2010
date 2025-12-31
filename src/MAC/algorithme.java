/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MAC;

/**
 *
 * @author choukri
 */


import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author AOOA
 *
 */
public class algorithme extends JFrame {
     public algorithme() {   }

    String algo="AES";
    int taille=128;  //AES = 128 et DES = 56
    String cle="AzertyutAzertyut";
    byte[] Key=cle.getBytes();
    

    public byte[]  generateKey() {
        KeyGenerator key_gen = null;
        try {
            key_gen = KeyGenerator.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        key_gen.init(taille);
        return key_gen.generateKey().getEncoded();
    }

    public byte[] crypt(byte[] text) {
        byte[] encrypted = null;
        try {
            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Key, algo));
            encrypted = cipher.doFinal(text);

        } catch (Exception ex) {
            Logger.getLogger(algorithme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encrypted;
    }

    public byte[] decrypt(byte[] ciphertext) {
        byte[] decrypted = null;
        try {
            Cipher cipher = Cipher.getInstance(algo); //$NON-NLS-1$
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Key, algo));
            decrypted = cipher.doFinal(ciphertext);
        }  catch (Exception ex) {
            Logger.getLogger(algorithme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decrypted;
    }

    public String afficher(byte[] tab) {
        int n = tab.length;
        String x = "";
        for (int i = 0; i < n; i++) {
            x += tab[i] + " ";
        }
        return x + "\n";
    }

    public String ToString(byte[] tab) {
        String x = "";
        int i = tab.length - 1;
        int c;
        while (i >= 0) {
            x = (char) tab[i--] + x;
        }
        return x;
    }
    public String[] decomposer(String texte,int taille){
        int n=texte.length();
        int k;
        if(n%taille!=0){
            k=taille-n%taille;
            n+=k;
            for(int i=0;i<k;i++)
                texte+="0";
        }
        k=n/taille;
        String[] tab=new String[k];
        for(int i=0;i<k;i++){
            tab[i]=texte.substring(i*taille, (i+1)*taille);
        }
        return tab;
    }

    public byte[] Xor(byte[] t1,String t2){
        return (new BigInteger(t1)).xor(new BigInteger(t2.getBytes())).toByteArray();
    }

    public String Hex(byte[] t) {
        String x = "";
        String y;
        char[] tab={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int n = t.length;
        int k;
        for (int i = 0; i < n; i++) {
            k=t[i];
            if(k<0)
                k+=256;
            x+=tab[k/16]+""+tab[k%16];
        }
        return x;
    }


    //Main
    public static void main(String[] argv) {
        algorithme aes = new algorithme();
        String msg = "" +"salut ca va";
        String[] s=aes.decomposer(msg,10);
        byte[] b=aes.crypt(s[0].getBytes());
        String str;
        int j=1;
        while(j<s.length){
            b=aes.crypt(aes.Xor(b,s[j++]));
        }

        System.out.println(aes.Hex(b));


        
       }
}