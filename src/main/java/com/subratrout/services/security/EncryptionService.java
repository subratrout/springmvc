package com.subratrout.services.security;

/**
 * Created by subratrout on 3/29/17.
 */
public interface EncryptionService {

    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
