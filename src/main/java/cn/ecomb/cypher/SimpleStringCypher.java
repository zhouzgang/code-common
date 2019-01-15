package cn.ecomb.cypher;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author zhouzg
 * @date 2018/12/29
 */
public class SimpleStringCypher {
    private byte[] linebreak = {};
    private String secret;
    private SecretKey key;
    private Cipher cipher;
    private Base64 coder;

    public SimpleStringCypher(String secret) {
        try {
            coder = new Base64(32, linebreak, true);
    //secret 为密钥 appkey
            byte[] secrets = coder.decode(secret);
            key = new SecretKeySpec(secrets, "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    //对推送消息中 content 进行加密
    public synchronized String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return new String(coder.encode(cipherText));
    }
    //对返回结果的 content 进行解密
    public synchronized String decrypt(String codedText) throws Exception {
        byte[] encypted = coder.decode(codedText.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encypted);
        return new String(decrypted, "UTF-8");
    }


    public static void main(String[] args) {
        SimpleStringCypher simpleStringCypher = new SimpleStringCypher("PBKDF2WithHmacSHA256fA");
        try {
            System.out.println(simpleStringCypher.encrypt("fasdfafafwefasd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

