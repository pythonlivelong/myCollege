/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.entity;

import java.util.Date;

/**
 *
 * @author yuanshuai
 */
public class AssetsTrjn {
    private int JourNo;
    private String FromAcc;
    private int AssetsID; 
    private Date RegDate;
    private int PersonID;
    private String purpose;
    private String Other;//备注

    public AssetsTrjn(int JourNo, String FromAcc, int AssetsID, Date RegDate, int PersonID, String purpose, String Other) {
        this.JourNo = JourNo;
        this.FromAcc = FromAcc;
        this.AssetsID = AssetsID;
        this.RegDate = RegDate;
        this.PersonID = PersonID;
        this.purpose = purpose;
        this.Other = Other;
    }

    public AssetsTrjn(String FromAcc, int AssetsID, Date RegDate, int PersonID, String purpose) {
        this.FromAcc = FromAcc;
        this.AssetsID = AssetsID;
        this.RegDate = RegDate;
        this.PersonID = PersonID;
        this.purpose = purpose;
    }

    public AssetsTrjn(String FromAcc, int AssetsID, Date RegDate, int PersonID, String purpose, String Other) {
        this.FromAcc = FromAcc;
        this.AssetsID = AssetsID;
        this.RegDate = RegDate;
        this.PersonID = PersonID;
        this.purpose = purpose;
        this.Other = Other;
    }

    public int getJourNo() {
        return JourNo;
    }

    public void setJourNo(int JourNo) {
        this.JourNo = JourNo;
    }

    public String getFromAcc() {
        return FromAcc;
    }

    public void setFromAcc(String FromAcc) {
        this.FromAcc = FromAcc;
    }

    public int getAssetsID() {
        return AssetsID;
    }

    public void setAssetsID(int AssetsID) {
        this.AssetsID = AssetsID;
    }

    public Date getRegDate() {
        return RegDate;
    }

    public void setRegDate(Date RegDate) {
        this.RegDate = RegDate;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String Other) {
        this.Other = Other;
    }
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.JourNo;
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
        final AssetsTrjn other = (AssetsTrjn) obj;
        if (this.JourNo!= other.JourNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "编号：" + JourNo + ", 操作类型：" +FromAcc + ", 资产编号：" + AssetsID+",操作时间：" + RegDate+",领用人："+ PersonID+",用途："+ purpose+",备注："+ Other;
    }
}
