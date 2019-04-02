package com.jim.xun.meetingclient.Util;

/**
 * Created by Xun.Jim on 2018/5/25.
 */
public class User {

    private String UserName;
    private String Password;
    private String Telephone;
    private String Address;
    private String QQ;
    private String Wechat;
    private String Bir;
    private String Sex;

    public User() {

    }
    public User(String UserName, String Password, String Telephone,
                String Address, String QQ, String Wechat, String Bir, String Sex) {
        this.setUserName(UserName);
        this.setPassword(Password);
        this.setTelephone(Telephone);
        this.setAddress(Address);
        this.setQQ(QQ);
        this.setWechat(Wechat);
        this.setBir(Bir);
        this.setSex(Sex);
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWechat() {
        return Wechat;
    }

    public void setWechat(String wechat) {
        Wechat = wechat;
    }

    public String getBir() {
        return Bir;
    }

    public void setBir(String bir) {
        Bir = bir;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
}
