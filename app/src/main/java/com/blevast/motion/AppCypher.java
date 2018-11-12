package com.blevast.motion;

import android.media.MediaCodec;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.RequiresApi;

/**
 * This is a class that serves cyphering functionality for the app
 * <p>
 * A general class to do quick
 */

@Singleton
public class AppCypher {

    private static final String TAG = AppCypher.class.getSimpleName();

    //This is just trial
    //TODO:: Never hard code this value
    private static final String ENCODED_KEY = "1234543444555666";

    @Inject
    public AppCypher() {

    }

    /**
     * Before jelly bean it was only transformations
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public String encrypt(String message) {
        try {

            byte[] key = ENCODED_KEY.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            //trim to 128 bits
            key = Arrays.copyOf(key, 16);

            Log.d(TAG, new String(key, "UTF-8"));

            Key secretKey = new SecretKeySpec(key, "AES");
            Log.d(TAG, secretKey.toString());


            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            try {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(key));
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }
            byte[] encryptedStr = cipher.doFinal(message.getBytes("UTF-8"));

            return new String(Base64.encode(encryptedStr, Base64.NO_WRAP), "UTF-8");

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new MediaCodec.CryptoException(100, ex.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public String decrypt(String encryptedMessage) {

        try {


            byte[] key = ENCODED_KEY.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            //trim to 128 bits
            key = Arrays.copyOf(key, 16);

            Log.d(TAG, new String(key, "UTF-8"));

            Key secretKey = new SecretKeySpec(key, "AES");
            Log.d(TAG, secretKey.toString());


            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            try {
                cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(key));
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }

            byte[] encrypteArr = Base64.decode(encryptedMessage, Base64.NO_WRAP);

            return new String(cipher.doFinal(encrypteArr), "UTF-8");
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new MediaCodec.CryptoException(100, ex.getMessage());
        }

    }
}
