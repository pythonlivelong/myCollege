/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.dao;
import cn.shuangze.assetsms.entity.Login;


/**
 *
 * @author yuanshuai
 */
public interface LoginDao {
    int add(Login login) throws Exception;//增加账户
    Login findByAccount(String account)throws Exception;
    String [][] findAll() throws Exception;
}
