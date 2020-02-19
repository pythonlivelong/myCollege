/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.dao.impl;
import cn.shuangze.assetsms.dao.DBUtil;
import cn.shuangze.assetsms.entity.Assets;
import java.util.List;
import static cn.shuangze.assetsms.dao.DBUtil.exceuteUpdate;
import static cn.shuangze.assetsms.dao.DBUtil.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.shuangze.assetsms.dao.AssetsDao;
import cn.shuangze.assetsms.entity.AssetsType;

/**
 *
 * @author yuanshuai
 */
public class AssetsDaoJDBCImpl implements AssetsDao{
     @Override
    public int add(Assets assets) throws Exception {
        String sql = "insert into assets(name,typeid,model,price,buydate,status,other) values(?,?,?,?,?,?,?)";
         try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{assets.getName(), assets.getTypeID(),assets.getModel(),assets.getPrice(),assets.getBuyDate(),assets.getStatus(),assets.getOther()});
        }

    }//添加

    @Override

    public int delete(int id) throws Exception {
        String sql = "delete from assets where assetsid=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Integer[]{id});
        }
    }//删除

    @Override
    public int modify(Assets assets) throws Exception {
        String sql = "update assets set name=?,typeid=?,model=?,price=?,buydate=?,status=?,other=? where assetsid=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{assets.getName(), assets.getTypeID(),assets.getModel(),assets.getPrice(),assets.getBuyDate(),assets.getStatus(),assets.getOther(),assets.getAssetsID()});
        }
    }//修改

   

    @Override
    public Assets findByAssetsID(int assetsID) throws Exception {
        String sql = "select * from assets where assetsid=?";
        Assets result = null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, assetsID);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new Assets(rs.getInt("assetsid"), rs.getString("name"), rs.getInt("typeid"),rs.getString("model"),rs.getString("price"),rs.getDate("buydate"),rs.getString("status"),rs.getString("other"));
                }
                return result;
            }
        }
    }//利用资产编号查找

    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from assets";
        List<Assets> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new Assets(rs.getInt("assetsid"), rs.getString("name"), rs.getInt("typeid"),rs.getString("model"),rs.getString("price"),rs.getDate("buydate"),rs.getString("status"),rs.getString("other")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = String.valueOf(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate().toString() ;
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
                
        }
        return sn;
    }//找出所有资产信息
     @Override
    public int[] findTypeID() throws Exception {
        String sql = "select * from assetstype";
        List<AssetsType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new AssetsType(rs.getInt("typeid"), rs.getString("b_type"), rs.getString("s_type")));
            }
        }
        int[] sn=new int[list.size()];
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new int[list.size()];
        }
        for (int i = 0; i < size; i++) {
            sn[i] = list.get(i).getTypeID();
            
        }
        return sn;
    }//通过资产类别表中的编号查询资产信息
    @Override
    public List<Assets> findByTypeID(int TypeID) throws Exception {
        String sql = "select * from assets where typeid=?";
        List<Assets> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, TypeID);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Assets(rs.getInt("assetsid"), rs.getString("name"), rs.getInt("typeid"),rs.getString("model"),rs.getString("price"),rs.getDate("buydate"),rs.getString("status"),rs.getString("other")));
            }
                return list;
            }
        }
    }
    @Override
    public String[][] findByStatus(String status) throws Exception {
        String sql = "select * from assets where status=?";
        List<Assets> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, status);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Assets(rs.getInt("assetsid"), rs.getString("name"), rs.getInt("typeid"),rs.getString("model"),rs.getString("price"),rs.getDate("buydate"),rs.getString("status"),rs.getString("other")));
            }              
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate().toString();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
   public String[][] findBynotStatus(String status) throws Exception {
        String sql = "select * from assets where status<>?";
        List<Assets> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, status);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Assets(rs.getInt("assetsid"), rs.getString("name"), rs.getInt("typeid"),rs.getString("model"),rs.getString("price"),rs.getDate("buydate"),rs.getString("status"),rs.getString("other")));
            }              
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate().toString();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
}
