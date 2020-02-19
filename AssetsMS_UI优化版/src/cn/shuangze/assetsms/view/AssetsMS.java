/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.view;

/**
 *
 * @author Jinyu
 */

/**
 * 资产管理系统运行主类
 */
public class AssetsMS {
	boolean packFrame = false;

	/**
	 * 构造函数
	 */
	public AssetsMS() {
		
                LoginInfo frame1=new LoginInfo();
              frame1.downInit();
              frame1.pack();
            frame1.setVisible(true);
           
		//设置运行时窗口的位置
		
	}

	public static void main(String[] args) {
           		
		new AssetsMS();
	}
}