/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.entity;
import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author yuanshuai
 */
public class Assets implements Serializable{
    
    private int AssetsID;
    private String Name;
    private int TypeID;
     private String Model;
     private String Price;
     private Date BuyDate;
     private String Status;
     private String Other;//备注
    

    public Assets(String Name, int TypeID, String Model, String Price, Date BuyDate, String Status,String Other) {
        this.Name= Name;
        this.TypeID = TypeID;
        this.Model=Model;
        this.Price=Price;
        this.BuyDate=BuyDate;
        this.Status=Status;
        this.Other=Other;
    }

    public Assets(int AssetsID,String Name, int TypeID, String Model, String Price, Date BuyDate, String Status) {
        this.AssetsID = AssetsID;
        this.Name= Name;
        this.TypeID = TypeID;
        this.Model=Model;
        this.Price=Price;
        this.BuyDate=BuyDate;
        this.Status=Status;
    }
    
     public Assets(int AssetsID,String Name, int TypeID, String Model, String Price, Date BuyDate, String Status,String Other) {
        this.AssetsID = AssetsID;
        this.Name= Name;
        this.TypeID = TypeID;
        this.Model=Model;
        this.Price=Price;
        this.BuyDate=BuyDate;
        this.Status=Status;
        this.Other=Other;
    }

    public int getAssetsID() {
        return AssetsID;
    }

    public void setAssetsID(int AssetsID) {
        this.AssetsID = AssetsID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }
    
    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model= Model;
    } 
    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    } 
    public Date getBuyDate() {
        return BuyDate;
    }

    public void setBuyDate(Date BuyDate) {
        this.BuyDate = BuyDate;
    } 
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
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
        hash = 61 * hash + this.AssetsID;
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
        final Assets other = (Assets) obj;
        if (this.AssetsID!= other.AssetsID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "资产编号：" + AssetsID + ", 资产名称：" +Name + ", 所属类型：" + TypeID+",型号：" + Model+",价格："+ Price+",购买日期："+ BuyDate+",状态："+ Status+",备注："+ Other;
    }
    


}
