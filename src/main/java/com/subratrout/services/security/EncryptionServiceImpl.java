package com.subratrout.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by subratrout on 3/29/17.
 */
@Service
public class EncryptionServiceImpl implements EncryptionService{

    private StrongPasswordEncryptor strongEncryptor;

    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    public String encryptString(String input) {
        return  strongEncryptor.encryptPassword(input);
    }


    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
