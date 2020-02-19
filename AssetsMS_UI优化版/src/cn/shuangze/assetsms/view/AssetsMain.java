/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.shuangze.assetsms.view;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.Toolkit;

class BackgroundPanel extends JPanel {
    	private static final long serialVersionUID = 1L;
	String name = "1.png"; // 将图片放在class类的同级文件夹里
 

	protected void paintComponent(Graphics g) { //关键代码：重写绘制组件外观
		super.paintComponent(g);
		ImageIcon image = new ImageIcon(getClass().getResource(name)); // 获取图片路径
		g.drawImage(image.getImage(), 0, 0, 800, 500, null);// 绘制图片与组件大小相同
	}
}
/**
 * 资产管理系统主界面
 */
public class AssetsMain extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    // 放背景面板的面板
    JPanel contentPan; 
    
    //建立菜单栏
    JMenuBar mainMenu = new JMenuBar();
    //建立“系统管理”菜单组
    JMenu menuSystem = new JMenu();
    JMenuItem itemTypeMan = new JMenuItem();
    JMenuItem itemExit = new JMenuItem();
    //建立“资产信息管理”菜单组
    JMenu menuAssets = new JMenu();
    JMenuItem itemAddAssets = new JMenuItem();
    JMenuItem itemModifyAssets = new JMenuItem();
    JMenuItem itemDeleteAssets = new JMenuItem();
    JMenu itemSelectAssets = new JMenu();
    JMenuItem itemSelectAssetsAll = new JMenuItem();
    JMenuItem itemSelectAssetsID = new JMenuItem();
    //建立“人员信息管理”菜单组
    JMenu menuPerson = new JMenu();
    JMenuItem itemAddPerson = new JMenuItem();
    JMenuItem itemModifyPerson = new JMenuItem();
    JMenuItem itemDeletePerson = new JMenuItem();
    JMenu itemSelectPerson = new JMenu();
    JMenuItem itemSelectPersonAll = new JMenuItem();
    JMenuItem itemSelectPersonID = new JMenuItem();
    //建立“资产领用”菜单组
    JMenu menuUsing = new JMenu();
    JMenuItem itemUsing = new JMenuItem();
    JMenuItem itemSelectUsing = new JMenuItem();
    //建立“资产归还”菜单组
    JMenu menuBack = new JMenu();
    JMenuItem itemBack = new JMenuItem();
    JMenuItem itemSelectBack = new JMenuItem();
    //建立“资产报废”菜单组
    JMenu menuInvalid = new JMenu();
    JMenuItem itemInvalid = new JMenuItem();
    JMenuItem itemSelectInvalid = new JMenuItem();


    /**
     * 程序初始化函数
     */
    public AssetsMain() {

        try {
            this.init();
        } catch (Exception ex) {
            Logger.getLogger(AssetsMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void init() throws Exception {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        //设置框架的大小
        this.setSize(800, 500);
        //设置标题
        this.setTitle("资产管理系统");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(AssetsMain.class.getResource("2.jpg")));


        
        contentPan = new JPanel();
	contentPan.setLayout(new BorderLayout(0, 0));// 设置边界布局
	BackgroundPanel backgroundPanel = new BackgroundPanel(); // 创建背景面板
	contentPan.add(backgroundPanel);// 添加背景面板
        this.setContentPane(contentPan);

        //添加菜单组
        menuSystem.setText("系统管理");
        menuSystem.setFont(new Font("Dialog", 0, 12));
        menuAssets.setText("资产信息管理");
        menuAssets.setFont(new Font("Dialog", 0, 12));
        menuPerson.setText("人员信息管理");
        menuPerson.setFont(new Font("Dialog", 0, 12));
        menuUsing.setText("资产领用");
        menuUsing.setFont(new Font("Dialog", 0, 12));
        menuBack.setText("资产归还");
        menuBack.setFont(new Font("Dialog", 0, 12));
        menuInvalid.setText("资产报废");
        menuInvalid.setFont(new Font("Dialog", 0, 12));

        //生成“系统管理”菜单组的选项
        itemTypeMan.setText("类别管理");
        itemTypeMan.setFont(new Font("Dialog", 0, 12));
        itemExit.setText("退出");
        itemExit.setFont(new Font("Dialog", 0, 12));
        //生成“资产信息管理”菜单组的选项
        itemAddAssets.setText("增加");
        itemAddAssets.setFont(new Font("Dialog", 0, 12));
        itemModifyAssets.setText("修改");
        itemModifyAssets.setFont(new Font("Dialog", 0, 12));
        itemDeleteAssets.setText("删除");
        itemDeleteAssets.setFont(new Font("Dialog", 0, 12));
        itemSelectAssets.setText("查询");
        itemSelectAssets.setFont(new Font("Dialog", 0, 12));
        itemSelectAssetsAll.setText("查询所有");
        itemSelectAssetsAll.setFont(new Font("Dialog", 0, 12));
        itemSelectAssetsID.setText("按编号查询");
        itemSelectAssetsID.setFont(new Font("Dialog", 0, 12));
        //生成“人员信息管理”菜单组的选项
        itemAddPerson.setText("人员信息增加");
        itemAddPerson.setFont(new Font("Dialog", 0, 12));
        itemModifyPerson.setText("人员信息修改");
        itemModifyPerson.setFont(new Font("Dialog", 0, 12));
        itemDeletePerson.setText("人员信息删除");
        itemDeletePerson.setFont(new Font("Dialog", 0, 12));
        itemSelectPerson.setText("查询人员信息");
        itemSelectPerson.setFont(new Font("Dialog", 0, 12));
        itemSelectPersonAll.setText("查询所有");
        itemSelectPersonAll.setFont(new Font("Dialog", 0, 12));
        itemSelectPersonID.setText("按编号查询");
        itemSelectPersonID.setFont(new Font("Dialog", 0, 12));
        //生成“资产领用”菜单组的选项
        itemUsing.setText("资产领用管理");
        itemUsing.setFont(new Font("Dialog", 0, 12));
        itemSelectUsing.setText("领用信息查询");
        itemSelectUsing.setFont(new Font("Dialog", 0, 12));
        //生成“资产归还”菜单组的选项
        itemBack.setText("资产归还管理");
        itemBack.setFont(new Font("Dialog", 0, 12));
        itemSelectBack.setText("归还信息查询");
        itemSelectBack.setFont(new Font("Dialog", 0, 12));
        //生成“资产报废”菜单组的选项
        itemInvalid.setText("资产报废管理");
        itemInvalid.setFont(new Font("Dialog", 0, 12));
        itemSelectInvalid.setText("报废信息查询");
        itemSelectInvalid.setFont(new Font("Dialog", 0, 12));

        //添加“系统管理”菜单组
        menuSystem.add(itemTypeMan);
        menuSystem.add(itemExit);
        //添加“资产信息管理”菜单组
        menuAssets.add(itemAddAssets);
        menuAssets.add(itemModifyAssets);
        menuAssets.add(itemDeleteAssets);
        menuAssets.addSeparator();
        menuAssets.add(itemSelectAssets);
        itemSelectAssets.add(itemSelectAssetsAll);
        itemSelectAssets.add(itemSelectAssetsID);
        //添加“人员信息管理”菜单组
        menuPerson.add(itemAddPerson);
        menuPerson.add(itemModifyPerson);
        menuPerson.add(itemDeletePerson);
        menuPerson.addSeparator();
        menuPerson.add(itemSelectPerson);
        itemSelectPerson.add(itemSelectPersonAll);
        itemSelectPerson.add(itemSelectPersonID);
        //添加“资产领用”菜单组
        menuUsing.add(itemUsing);
        menuUsing.add(itemSelectUsing);
        //添加“资产归还”菜单组
        menuBack.add(itemBack);
        menuBack.add(itemSelectBack);
        //添加“资产报废”菜单组
        menuInvalid.add(itemInvalid);
        menuInvalid.add(itemSelectInvalid);

        //添加所有的菜单组
        mainMenu.add(menuSystem);
        mainMenu.add(menuAssets);
        mainMenu.add(menuPerson);
        mainMenu.add(menuUsing);
        mainMenu.add(menuBack);
        mainMenu.add(menuInvalid);
        this.setJMenuBar(mainMenu);

        //添加事件侦听
        itemTypeMan.addActionListener(this);
        itemExit.addActionListener(this);
        itemAddAssets.addActionListener(this);
        itemModifyAssets.addActionListener(this);
        itemDeleteAssets.addActionListener(this);
        itemSelectAssetsAll.addActionListener(this);
        itemSelectAssetsID.addActionListener(this);
        itemAddPerson.addActionListener(this);
        itemModifyPerson.addActionListener(this);
        itemDeletePerson.addActionListener(this);
        itemSelectPersonAll.addActionListener(this);
        itemSelectPersonID.addActionListener(this);
        itemUsing.addActionListener(this);
        itemSelectUsing.addActionListener(this);
        itemBack.addActionListener(this);
        itemSelectBack.addActionListener(this);
        itemInvalid.addActionListener(this);
        itemSelectInvalid.addActionListener(this);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        show();
        //关闭程序时的操作
        this.addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
    }

    /**
     * 事件处理
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == itemExit) { //退出
            System.exit(0);
        } else if (obj == itemTypeMan) { //资产类别管理
            TypeInfo typeMan = new TypeInfo();
            typeMan.downInit();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if(obj==itemAddAssets){//资产信息管理(增加)
            ZiChanGuanLi ZiChanGuanLi_add=new ZiChanGuanLi();
             ZiChanGuanLi_add.add();
            ZiChanGuanLi_add.pack();
         ZiChanGuanLi_add.setVisible(true);
        }else if(obj==itemModifyAssets){//资产信息管理(修改)
            ZiChanGuanLi ZiChanGuanLi_Modify=new ZiChanGuanLi();
             ZiChanGuanLi_Modify.modify();
            ZiChanGuanLi_Modify.pack();
         ZiChanGuanLi_Modify.setVisible(true);
        }else if(obj==itemDeleteAssets){//资产信息管理(删除)
            ZiChanGuanLi ZiChanGuanLi_Delete=new ZiChanGuanLi();
             ZiChanGuanLi_Delete.delect();
            ZiChanGuanLi_Delete.pack();
            ZiChanGuanLi_Delete.setVisible(true);
        }else if(obj==itemSelectAssetsAll){//资产信息管理(查询所有)
            ZiChanGuanLi ZiChanGuanLi_SelectAll=new ZiChanGuanLi();
            ZiChanGuanLi_SelectAll.pack();
            ZiChanGuanLi_SelectAll.setVisible(true);
        }else if(obj==itemSelectAssetsID){//资产信息管理(按编号查询)
            ZiChanGuanLi ZiChanGuanLi_SelectID=new ZiChanGuanLi();
            ZiChanGuanLi_SelectID.check();
            ZiChanGuanLi_SelectID.pack();
            ZiChanGuanLi_SelectID.setVisible(true);
        }else if(obj==itemAddPerson){//人员信息管理(人员信息增加)
            RenYuanGuanLi RenYuanGuanLi_Add= new RenYuanGuanLi();
             RenYuanGuanLi_Add.add();
            RenYuanGuanLi_Add.pack();
            RenYuanGuanLi_Add.setVisible(true);
        }else if(obj==itemModifyPerson){//人员信息管理(人员信息修改)
             RenYuanGuanLi RenYuanGuanLi_Modify= new RenYuanGuanLi();
             RenYuanGuanLi_Modify.modify();
            RenYuanGuanLi_Modify.pack();
            RenYuanGuanLi_Modify.setVisible(true);
        }else if(obj==itemDeletePerson){//人员信息管理(人员信息删除)
             RenYuanGuanLi RenYuanGuanLi_Delete= new RenYuanGuanLi();
             RenYuanGuanLi_Delete.delect();
            RenYuanGuanLi_Delete.pack();
            RenYuanGuanLi_Delete.setVisible(true);
        }else if(obj==itemSelectPersonAll){//人员信息管理(查询所有)
             RenYuanGuanLi RenYuanGuanLi_SelectAll= new RenYuanGuanLi();
            RenYuanGuanLi_SelectAll.pack();
            RenYuanGuanLi_SelectAll.setVisible(true);
        }else if(obj==itemSelectPersonID){//人员信息管理(按编号查询)
             RenYuanGuanLi RenYuanGuanLi_SelectID= new RenYuanGuanLi();
             RenYuanGuanLi_SelectID.check();
            RenYuanGuanLi_SelectID.pack();
            RenYuanGuanLi_SelectID.setVisible(true);
        }else if(obj==itemUsing){//资产领用(管理)
            ZiChanLingYong ZiChanLingYong_Using=new ZiChanLingYong();
           ZiChanLingYong_Using.downInit();
            ZiChanLingYong_Using.pack();
            ZiChanLingYong_Using.setVisible(true);
        }else if(obj==itemSelectUsing){//资产领用(查询)
            ZiChanLingYong ZiChanLingYong_SelectUsing=new ZiChanLingYong(1);
            ZiChanLingYong_SelectUsing.pack();
            ZiChanLingYong_SelectUsing.setVisible(true);
        }else if(obj==itemBack){//资产归还(管理)
            ZiChanGuiHuan ZiChanGuiHuan_Back= new ZiChanGuiHuan();
            ZiChanGuiHuan_Back.downInit();
            ZiChanGuiHuan_Back.pack();
            ZiChanGuiHuan_Back.setVisible(true);
        }else if(obj==itemSelectBack){//资产归还(查询)
            ZiChanGuiHuan ZiChanGuiHuan_SelectBack= new ZiChanGuiHuan(1);
            ZiChanGuiHuan_SelectBack.pack();
            ZiChanGuiHuan_SelectBack.setVisible(true);
        }else if(obj==itemInvalid){//资产报废(管理)
            ZiChanBaoFei ZiChanBaoFei_Invalid=new ZiChanBaoFei();
            ZiChanBaoFei_Invalid.downInit();
            ZiChanBaoFei_Invalid.pack();
            ZiChanBaoFei_Invalid.setVisible(true);
        }else if(obj==itemSelectInvalid){//资产报废(查询)
            ZiChanBaoFei ZiChanBaoFei_SelectInvalid=new ZiChanBaoFei(1);
            ZiChanBaoFei_SelectInvalid.pack();
            ZiChanBaoFei_SelectInvalid.setVisible(true);
        }

    }
    

}

