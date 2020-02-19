package cn.shuangze.assetsms.view;
import cn.shuangze.assetsms.dao.impl.AssetsDaoJDBCImpl;
import cn.shuangze.assetsms.entity.Assets;
import cn.shuangze.assetsms.dao.impl.AssetsTrjnDaoJDBCImpl;
import cn.shuangze.assetsms.entity.AssetsTrjn;
import cn.shuangze.assetsms.dao.impl.AssetsTypeDaoJDBCImpl;
import cn.shuangze.assetsms.entity.AssetsType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import cn.shuangze.assetsms.dao.AssetsDao;
import cn.shuangze.assetsms.dao.AssetsTypeDao;
import cn.shuangze.assetsms.dao.AssetsTrjnDao;
import com.eltima.components.ui.DatePicker;
/**
 *
 * @author yuanshuai
 */
public class ZiChanGuanLi extends JFrame implements ActionListener, ListSelectionListener {

    AssetsDao assetsDao;
    AssetsTypeDao assetsTypeDao;
    AssetsTrjnDao assetsTrjnDao;
    
    Container contentPane;
    //定义所用的面板
    JPanel upPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel downPanel = new JPanel();

    //框架的大小
    Dimension faceSize = new Dimension(400, 400);

    //定义图形界面元素
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    
    JButton addInfo = new JButton();
    JButton modifyInfo = new JButton();
    JButton deleteInfo = new JButton();
    
    JButton check = new JButton();
    JButton bb = new JButton();
    JButton bc = new JButton("获取时间");
    
    TimeTable ab=new TimeTable();
    DatePicker datepick;

    JTextField jTextField1 = new JTextField(8);
    JTextField jTextField2 = new JTextField(8);
    JComboBox comboBox;
    JTextField jTextField4 = new JTextField(8);
    JTextField jTextField5 = new JTextField(8);
    JTextField jTextField6 = new JTextField(8);
    JTextField jTextField7 = new JTextField(8);
    JTextField jTextField8 = new JTextField(8);

    //定义表格
    JScrollPane jScrollPane1;
    JTable jTable;
    DefaultTableModel tableModel;
    ListSelectionModel listSelectionModel = null;

    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public ZiChanGuanLi() {

        assetsDao = new AssetsDaoJDBCImpl();
        assetsTypeDao=new AssetsTypeDaoJDBCImpl();
        assetsTrjnDao=new AssetsTrjnDaoJDBCImpl();
        //设置框架的大小

        try {
            String Stringlist[][]=assetsTypeDao.findAll();
             String[] a=new String[Stringlist.length];
            for(int i=0;i<Stringlist.length;i++)
           a[i]=Stringlist[i][1]+","+Stringlist[i][2];
            comboBox = new JComboBox(a);
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产信息");
        this.setResizable(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AssetsMain.class.getResource("2.jpg")));
        
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 1600) / 2,
                (screenSize.height - 300) / 2 + 45);
        //中部面板的布局
        String[][] colValue = assetsDao.findAll();
        if (colValue == null) {
            colValue = new String[1][8];
        }
        String[] colName = {"资产编号", "资产名称", "资产类别编号","型号","价格","购买日期","状态","备注"};
        tableModel = new DefaultTableModel(colValue, colName);
        jTable = new JTable(tableModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(800, 300));
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this);
        jScrollPane1 = new JScrollPane(jTable);
        jScrollPane1.setPreferredSize(new Dimension(800, 300));

        upPanel.add(jScrollPane1);
        contentPane.add(upPanel, BorderLayout.NORTH);

        jLabel1.setText("资产编号");
        jLabel1.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel1);
        centerPanel.add(jTextField1);

        jLabel2.setText("资产名称");
        jLabel2.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel2);
        centerPanel.add(jTextField2);

        jLabel3.setText("资产类别");
        jLabel3.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel3);
        centerPanel.add(comboBox);
        
        jLabel4.setText("型号");
        jLabel4.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel4);
        centerPanel.add(jTextField4);
        
        jLabel5.setText("价格");
        jLabel5.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel5);
        centerPanel.add(jTextField5);
        
        jLabel6.setText("购买日期");
        jLabel6.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel6);
        centerPanel.add(jTextField6);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        
        bb.setText("选择时间");
        bb.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(bb);

        jLabel7.setText("状态");
        jLabel7.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel7);
        jTextField7.setText("可用");
        centerPanel.add(jTextField7);
        
        
        jLabel8.setText("备注");
        jLabel8.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel8);
        centerPanel.add(jTextField8);
        centerPanel.setVisible(false);//修改部分！！
        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        comboBox.setEditable(false);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(true);
    }

    /**
     * 下部面板的布局
     */
   public void add(){
       centerPanel.setVisible(true);
       addInfo.setText("增加");
        addInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(addInfo);
        contentPane.add(downPanel, BorderLayout.SOUTH);
        addInfo.addActionListener(this);
        addInfo.setEnabled(true);
        bb.addActionListener(this);             //添加事件监听
        bc.addActionListener(this);
   }
   public void modify(){
       centerPanel.setVisible(true);
        modifyInfo.setText("修改");
        modifyInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(modifyInfo);
        contentPane.add(downPanel, BorderLayout.SOUTH);
        modifyInfo.addActionListener(this);
        modifyInfo.setEnabled(true);
        bb.addActionListener(this);             //添加事件监听
        bc.addActionListener(this);
         
   }
   public void delect(){
      
       deleteInfo.setText("删除");
        deleteInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(deleteInfo);
         contentPane.add(downPanel, BorderLayout.SOUTH);
         deleteInfo.addActionListener(this);
         deleteInfo.setEnabled(true);
    
   }
   public void check(){
       jTextField1.setEditable(true);
       jTextField2.setEditable(false);
        comboBox.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
       centerPanel.setVisible(true);
       upPanel.setVisible(false);
       check.setText("按编号查询");
        check.setFont(new Font("Dialog", 0, 12));
        downPanel.add(check);
        contentPane.add(downPanel, BorderLayout.SOUTH);
         check.addActionListener(this);
          check.setEnabled(true);
   }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == addInfo) {
            try {
                //增加
                if(jTextField6.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "请选择日期！", "资产类别添加", JOptionPane.INFORMATION_MESSAGE);
                else{
                int sa=0;
                String ss[][]=assetsTypeDao.findAll();
                for(int i=0;i<ss.length;i++){
                    String a=ss[i][1]+","+ss[i][2];
                    if(a.equals(comboBox.getSelectedItem().toString()))
                        sa=assetsTypeDao.findBySmallType(ss[i][2]).getTypeID();
                }
                jTextField7.setText("可用");
                assetsDao.add(new Assets(jTextField2.getText(),sa, jTextField4.getText(), jTextField5.getText(),java.sql.Date.valueOf(jTextField6.getText()), jTextField7.getText(), jTextField8.getText()));
                JOptionPane.showMessageDialog(null, "资产类别添加成功！", "资产类别添加", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            ZiChanGuanLi typeMan = new ZiChanGuanLi();
            typeMan.add();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if (obj == modifyInfo) {
            try {
                //修改
                int sa=0;
                String ss[][]=assetsTypeDao.findAll();
                for(int i=0;i<ss.length;i++){
                    String a=ss[i][1]+","+ss[i][2];
                    if(a.equals(comboBox.getSelectedItem().toString()))
                        sa=assetsTypeDao.findBySmallType(ss[i][2]).getTypeID();
                }
                jTextField7.setText("可用");
                assetsDao.modify(new Assets(Integer.parseInt(jTextField1.getText()),jTextField2.getText(),sa, jTextField4.getText(), jTextField5.getText(),java.sql.Date.valueOf(jTextField6.getText()), jTextField7.getText(), jTextField8.getText()));
                JOptionPane.showMessageDialog(null, "资产类别修改成功！", "资产类别修改", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();

            ZiChanGuanLi typeMan = new ZiChanGuanLi();
            typeMan.modify();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if (obj == deleteInfo) {

            int rowcount = tableModel.getRowCount() - 1;//getRowCount返回行数，rowcount<0代表已经没有任何行了。 
            if (rowcount >= 0) {
                try {
                    //删除
                    int i = JOptionPane.showConfirmDialog(null, "确定要删除吗?", null, JOptionPane.YES_NO_CANCEL_OPTION);//单击"确定"按钮,则返回值为0.
                    if (i == 0) {
                        java.util.List<AssetsTrjn> list ;
                                list=assetsTrjnDao.findByAssets(Integer.parseInt(jTextField1.getText()));
                                for(int j=0;j<list.size();j++)
                                {
                                    assetsTrjnDao.delete(list.get(j).getJourNo());
                                }
//                        tableModel.removeRow(jTable.getSelectedRow());
//                       tableModel.setRowCount(rowcount);//删除行比较简单，只要用DefaultTableModel的removeRow()方法即可。删除行完毕后必须重新设置行数，也就是使用DefaultTableModel的setRowCount()方法来设置当前行。
                        
                    assetsDao.delete(Integer.parseInt(jTextField1.getText()));
                    }

                    JOptionPane.showMessageDialog(null, "资产类别删除成功！", "资产类别删除", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                this.dispose();
                ZiChanGuanLi typeMan = new ZiChanGuanLi();
                typeMan.delect();
                typeMan.pack();
                typeMan.setVisible(true);
            }

        
        } else if (obj == check) { //按编号查询
            
        jTextField1.setEditable(true);    
        jTextField2.setEditable(false);
        comboBox.setEnabled(false);
        comboBox.setEditable(true);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        int i=Integer.parseInt(jTextField1.getText());
          try{
              Assets a=assetsDao.findByAssetsID(i);
              if(a==null)
                  JOptionPane.showMessageDialog(null, "此编号不存在，请重新输入编号！", "按编号查询", JOptionPane.INFORMATION_MESSAGE);
              else {
        jTextField1.setText(String.valueOf(a.getAssetsID()));
        jTextField2.setText(a.getName());
        comboBox.setSelectedItem(assetsTypeDao.findByTypeID(a.getTypeID()).getBigType()+","+assetsTypeDao.findByTypeID(a.getTypeID()).getSmallType());
        jTextField4.setText(a.getModel());
        jTextField5.setText(a.getPrice());
        jTextField6.setText(a.getBuyDate().toString()); 
        jTextField7.setText(a.getStatus()); 
        jTextField8.setText(a.getOther());
              
        JOptionPane.showMessageDialog(null, "按编号查询成功！", "按编号查询", JOptionPane.INFORMATION_MESSAGE);
              }
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
            
        
        }else if(obj==bb){
             
        JFrame f = new JFrame("P");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        datepick = ab.getDatePicker();
        f.add(datepick);
        bc.setBounds(137, 183, 100, 30);
        f.add(bc);
        bc.setVisible(true);
        bb.setVisible(true);
        f.setVisible(true);
        }else if(obj==bc){
            jTextField6.setText( datepick.getText());
        }
        jTable.revalidate();
    }

 
   

    /**
     * 当表格被选中时的操作
     * @param lse
     */
    @Override
   public void valueChanged(ListSelectionEvent lse) {
        int selectedRow = jTable.getSelectedRow();
        try{
                String [][] ss = assetsTypeDao.findAll(); 
                for(int i = 0; i<ss.length; i++){
                    String a=ss[i][0];
                    String c=ss[i][1]+","+ss[i][2];
                    if(a.equals((String) jTable.getValueAt(selectedRow, 2))){
                        comboBox.setSelectedItem(c);
                        break;
                    }
                }
        }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        jTextField1.setText((String) jTable.getValueAt(selectedRow, 0));
        jTextField2.setText((String) jTable.getValueAt(selectedRow, 1));
        
        jTextField4.setText((String) jTable.getValueAt(selectedRow, 3));
        jTextField5.setText((String) jTable.getValueAt(selectedRow, 4));
        jTextField6.setText((String) jTable.getValueAt(selectedRow, 5)); 
        jTextField7.setText((String) jTable.getValueAt(selectedRow, 6)); 
        jTextField8.setText((String) jTable.getValueAt(selectedRow, 7));
        //设置是否可操作
        jTextField2.setEditable(true);
        comboBox.setEditable(false);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(true);

        modifyInfo.setEnabled(true);
        deleteInfo.setEnabled(true);
    }
}
