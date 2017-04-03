package com.subratrout.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * Created by subratrout on 3/29/17.
 */
public interface EncryptionService {

    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
    void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor);


}
