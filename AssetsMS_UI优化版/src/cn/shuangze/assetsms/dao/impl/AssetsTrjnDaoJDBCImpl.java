/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.dao.impl;
import cn.shuangze.assetsms.dao.DBUtil;
import cn.shuangze.assetsms.entity.AssetsTrjn;
import java.util.List;
import static cn.shuangze.assetsms.dao.DBUtil.exceuteUpdate;
import static cn.shuangze.assetsms.dao.DBUtil.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.shuangze.assetsms.dao.AssetsTrjnDao;
import cn.shuangze.assetsms.entity.Assets;
import cn.shuangze.assetsms.entity.Person;
/**
 *
 * @author yuanshuai
 */
public class AssetsTrjnDaoJDBCImpl implements AssetsTrjnDao{
     @Override
    public int add(AssetsTrjn assetsTrjn) throws Exception {
        String sql = "insert into assetstrjn(fromacc,assetsid,regdate,personid,purpose,other) values(?,?,?,?,?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{assetsTrjn.getFromAcc(), assetsTrjn.getAssetsID(), assetsTrjn.getRegDate(), assetsTrjn.getPersonID(), assetsTrjn.getPurpose(), assetsTrjn.getOther()});
        }
    }
    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from assetstrjn where journo=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Integer[]{id});
        }
    }
    @Override
    public int modify(AssetsTrjn assetsTrjn) throws Exception {
        String sql = "update assetstrjn set fromacc=?,assetsid=?,regdate=?,personid=?,purpose=?,other=? where journo=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{assetsTrjn.getFromAcc(), assetsTrjn.getAssetsID(), assetsTrjn.getRegDate(), assetsTrjn.getPersonID(), assetsTrjn.getPurpose(), assetsTrjn.getOther(),assetsTrjn.getJourNo()});
        }
    }
    @Override
    public List<AssetsTrjn> findByFromAcc(String fromacc) throws Exception {
        String sql = "select * from assetstrjn where fromacc=?";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, fromacc);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsTrjn(rs.getInt("journo"), rs.getString("fromacc"), rs.getInt("assetsid"), rs.getDate("regdate"), rs.getInt("personid"), rs.getString("purpose"), rs.getString("other")));
                }
                return list;
            }
        }
    }
    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from assetstrjn";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new AssetsTrjn(rs.getInt("journo"), rs.getString("fromacc"), rs.getInt("assetsid"), rs.getDate("regdate"), rs.getInt("personid"), rs.getString("purpose"), rs.getString("other")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][7];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getJourNo());
            sn[i][1] = list.get(i).getFromAcc();
            sn[i][2] = Integer.toString(list.get(i).getAssetsID());
            sn[i][3] = list.get(i).getRegDate().toString();
            sn[i][4] = Integer.toString(list.get(i).getPersonID());
            sn[i][5] = list.get(i).getPurpose();
            sn[i][6] = list.get(i).getOther();
        }
        return sn;
    }
      @Override
    public int[] findAssetsID() throws Exception {
        String sql = "select * from assets";
        List<Assets> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new Assets(rs.getInt("assetsid"), rs.getString("name"), rs.getInt("typeid"), rs.getString("model"), rs.getString("price"), rs.getDate("buydate"),  rs.getString("status"),rs.getString("other")));
            }
        }
        int[] sn=new int[list.size()];
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new int[list.size()];
        }
        for (int i = 0; i < size; i++) {
            sn[i] = list.get(i).getAssetsID();
        }
        return sn;
    }
     @Override
    public int[] findPersonID() throws Exception {
        String sql = "select * from person";
        List<Person> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new Person(rs.getInt("personid"), rs.getString("name"), rs.getString("sex"), rs.getString("dept"), rs.getString("job"),rs.getString("other")));
            }
        }
        int[] sn=new int[list.size()];
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new int[list.size()];
        }
        for (int i = 0; i < size; i++) {
            sn[i] = list.get(i).getPersonID();
            
        }
        return sn;
    }
     public List<AssetsTrjn> findByPerson(int personid) throws Exception {
        String sql = "select * from assetstrjn where personid=?";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, personid);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsTrjn(rs.getInt("journo"), rs.getString("fromacc"), rs.getInt("assetsid"), rs.getDate("regdate"), rs.getInt("personid"), rs.getString("purpose"), rs.getString("other")));
                }
                return list;
            }
        }
    }
     public List<AssetsTrjn> findByAssets(int assetsid) throws Exception {
        String sql = "select * from assetstrjn where assetsid=?";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, assetsid);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsTrjn(rs.getInt("journo"), rs.getString("fromacc"), rs.getInt("assetsid"), rs.getDate("regdate"), rs.getInt("personid"), rs.getString("purpose"), rs.getString("other")));
                }
                return list;
            }
        }

    }
}
