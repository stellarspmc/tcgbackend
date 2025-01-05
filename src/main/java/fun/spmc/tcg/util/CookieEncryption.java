package fun.spmc.tcg.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Configuration
@PropertySource("classpath:/application.properties")
public class CookieEncryption {
    @Value("${cookies.key}")
    private static String key;

    @Value("${cookies.salt}")
    private static String salt;

    public static String encrypt(String input)
            throws NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, AESUtil.getKeyFromPassword(key, salt), AESUtil.generateIv());
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes()));
    }

    public static String decrypt(String input)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, AESUtil.getKeyFromPassword(key, salt), AESUtil.generateIv());
        return new String(cipher.doFinal(Base64.getDecoder().decode(input)));
    }
}
