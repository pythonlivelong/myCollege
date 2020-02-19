/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.entity;

import java.io.Serializable;
/**
 *
 * @author yuanshuai
 */
public class Login implements Serializable{
    private int loginID;
    private String account;
    private String password;

    public Login(int typeID, String account, String password) {
        this.loginID = typeID;
        this.account = account;
        this.password = password;
    }

    public Login(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.loginID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        if (this.loginID != other.loginID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "账号编号：" + loginID + ", 账号：" +account + ", 密码：" + password ;
    }
}
