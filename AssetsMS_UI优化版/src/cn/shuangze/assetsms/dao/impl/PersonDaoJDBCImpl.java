/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.dao.impl;
import cn.shuangze.assetsms.dao.DBUtil;
import cn.shuangze.assetsms.entity.Person;
import java.util.List;
import static cn.shuangze.assetsms.dao.DBUtil.exceuteUpdate;
import static cn.shuangze.assetsms.dao.DBUtil.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.shuangze.assetsms.dao.PersonDao;
/**
 *
 * @author yuanshuai
 */
public class PersonDaoJDBCImpl implements PersonDao{
     @Override
    public int add(Person person) throws Exception {
        String sql = "insert into Person(name,sex,dept,job,other) values(?,?,?,?,?)";
         try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new String[]{person.getName(), person.getSex(),person.getDept(),person.getJob(),person.getOther()});
        }
    }
    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from person where personid=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Integer[]{id});
        }
    }
    @Override
    public int modify(Person person) throws Exception {
        String sql = "update person set name=?,sex=?,dept=?,job=?,other=? where personid=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{person.getName(), person.getSex(),person.getDept(),person.getJob(),person.getOther(),person.getPersonID()});
        }
    }
    @Override
    public Person findByPersonID(int personID) throws Exception {
        String sql = "select * from person where personid=?";
        Person result = null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, personID);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new Person(rs.getInt("personid"), rs.getString("name"), rs.getString("sex"),rs.getString("dept"),rs.getString("job"),rs.getString("other"));
                }
                return result;
            }
        }
    }
    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from person";
        List<Person> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new Person(rs.getInt("personid"), rs.getString("name"), rs.getString("sex"),rs.getString("dept"),rs.getString("job"),rs.getString("other")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][6];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getPersonID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = list.get(i).getSex();
            sn[i][3] = list.get(i).getDept();
            sn[i][4] = list.get(i).getJob();
            sn[i][5] = list.get(i).getOther();         
        }
        return sn;
    }
   
}
