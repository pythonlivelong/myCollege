/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.dao.impl;

import cn.shuangze.assetsms.dao.DBUtil;
import cn.shuangze.assetsms.entity.Login;
import java.util.List;
import static cn.shuangze.assetsms.dao.DBUtil.exceuteUpdate;
import static cn.shuangze.assetsms.dao.DBUtil.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.shuangze.assetsms.dao.LoginDao;
/**
 *
 * @author yuanshuai
 */
public class LoginDaoJDBCImpl implements LoginDao{

    
    @Override
    public int add(Login login) throws Exception {
        String sql = "insert into login(account,password) values(?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new String[]{login.getAccount(), login.getPassword()});
        }
    }//连接数据库添加账户

    @Override
    public Login findByAccount(String account) throws Exception {
        String sql = "select * from login where account=?";
        Login result = null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, account);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new Login(rs.getInt("loginid"), rs.getString("account"), rs.getString("password"));
                }
                return result;
            }
        }
    }//通过传入的account在数据库查找此账户，

    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from login";
        List<Login> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new Login(rs.getInt("loginid"), rs.getString("account"), rs.getString("password")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][3];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getLoginID());
            sn[i][1] = list.get(i).getAccount();
            sn[i][2] = list.get(i).getPassword();
        }
        return sn;
    }//查找所有账户
}
