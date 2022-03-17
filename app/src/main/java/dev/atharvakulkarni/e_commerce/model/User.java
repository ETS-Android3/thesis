package dev.atharvakulkarni.e_commerce.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User {
    private String mId;
    private String mName;
    private String mEmail;
    private String mTelephone;
    private String mPassword;
    private long last_updated;
    private boolean remembering;
    private String mType; // buyer/ shop's owner

    public User(String email,String password)
    {
        this.mEmail = email;
        this.mPassword = password;
    }

    public User(String name,String email,String password)
    {
        this.mName = name;
        this.mEmail = email;
        this.mPassword = password;
    }
    public User(){}

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public boolean isValidEmail()
    {
        return !TextUtils.isEmpty(mEmail) && Patterns.EMAIL_ADDRESS.matcher(mEmail).matches();
    }
    public boolean isValidPassword()
    {
        return !TextUtils.isEmpty(mPassword) && mPassword.length() >= 6;
    }


    public boolean isRemembering() {
        return remembering;
    }

    public void setRemembering(boolean remembering) {
        this.remembering = remembering;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTelephone() {
        return mTelephone;
    }

    public void setTelephone(String telephone) {
        mTelephone = telephone;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
