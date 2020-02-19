package cn.shuangze.assetsms.view;
import cn.shuangze.assetsms.dao.impl.PersonDaoJDBCImpl;
import cn.shuangze.assetsms.entity.Person;
import cn.shuangze.assetsms.dao.impl.AssetsTrjnDaoJDBCImpl;
import cn.shuangze.assetsms.entity.AssetsTrjn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import cn.shuangze.assetsms.dao.PersonDao;
import cn.shuangze.assetsms.dao.AssetsTrjnDao;
import java.util.ArrayList;
/**
 *
 * @author yuanshuai
 */
public class RenYuanGuanLi extends JFrame implements ActionListener, ListSelectionListener {
     PersonDao personDao;
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
    
    JButton addInfo = new JButton();
    JButton modifyInfo = new JButton();
    JButton deleteInfo = new JButton();
    JButton check = new JButton();

    JTextField jTextField1 = new JTextField(8);
    JTextField jTextField2 = new JTextField(8);
    JTextField jTextField3 = new JTextField(8);
    JTextField jTextField4 = new JTextField(8);
    JTextField jTextField5 = new JTextField(8);
    JTextField jTextField6 = new JTextField(8);


    //定义表格
    JScrollPane jScrollPane1;
    JTable jTable;
    DefaultTableModel tableModel;
    ListSelectionModel listSelectionModel = null;

    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public RenYuanGuanLi(){

        personDao = new PersonDaoJDBCImpl();
        assetsTrjnDao=new AssetsTrjnDaoJDBCImpl();
        //设置框架的大小

        try {
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
        this.setTitle("人员信息");
        this.setResizable(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AssetsMain.class.getResource("2.jpg")));
        
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 1400) / 2 + 45,
                (screenSize.height - 300) / 2 + 45);
        //中部面板的布局
        String[][] colValue = personDao.findAll();
        if (colValue == null) {
            colValue = new String[1][6];
        }
        String[] colName = {"人员编号", "姓名", "性别","部门","职位","其他"};
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

        jLabel1.setText("人员编号");
        jLabel1.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel1);
        centerPanel.add(jTextField1);

        jLabel2.setText("姓名");
        jLabel2.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel2);
        centerPanel.add(jTextField2);

        jLabel3.setText("性别");
        jLabel3.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel3);
        centerPanel.add(jTextField3);
        
        jLabel4.setText("部门");
        jLabel4.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel4);
        centerPanel.add(jTextField4);
        
        jLabel5.setText("职位");
        jLabel5.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel5);
        centerPanel.add(jTextField5);
        
        jLabel6.setText("其他");
        jLabel6.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel6);
        centerPanel.add(jTextField6);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        
        centerPanel.setVisible(false);//修改部分！！
        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);

    }

    /**
     * 下部面板的布局
     */
   public void add(){
       centerPanel.setVisible(true);
       addInfo.setText("增加");
        addInfo.setFont(new Font("Dialog", Font.BOLD, 12));
        downPanel.add(addInfo);
         contentPane.add(downPanel, BorderLayout.SOUTH);
         addInfo.addActionListener(this);
         addInfo.setEnabled(true);
   }
   public void modify(){
       centerPanel.setVisible(true);
        modifyInfo.setText("修改");
        modifyInfo.setFont(new Font("Dialog", Font.BOLD, 12));
        downPanel.add(modifyInfo);
         contentPane.add(downPanel, BorderLayout.SOUTH);
         modifyInfo.addActionListener(this);
         modifyInfo.setEnabled(true);
         
   }
   public void delect(){
      
       deleteInfo.setText("删除");
        deleteInfo.setFont(new Font("Dialog", Font.BOLD, 12));
        downPanel.add(deleteInfo);
         contentPane.add(downPanel, BorderLayout.SOUTH);
         deleteInfo.addActionListener(this);
         deleteInfo.setEnabled(true);
    
   }
   public void check(){
       jTextField1.setEditable(true);
       jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        
       centerPanel.setVisible(true);
       upPanel.setVisible(false);
       check.setText("按编号查询");
        check.setFont(new Font("Dialog", Font.BOLD, 12));
        downPanel.add(check);
        contentPane.add(downPanel, BorderLayout.SOUTH);
         check.addActionListener(this);
          check.setEnabled(true);
   }

    /**
     * 事件处理
     * @param e
     */
     @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == addInfo) {
            try {
                //增加

                personDao.add(new Person(jTextField2.getText(),jTextField3.getText(), jTextField4.getText(), jTextField5.getText(),jTextField6.getText()));
                JOptionPane.showMessageDialog(null, "人员信息添加成功！", "人员信息添加", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            RenYuanGuanLi typeMan = new RenYuanGuanLi();
            typeMan.add();
            typeMan.pack();
            typeMan.setVisible(true);
        } else if (obj == modifyInfo) {
            try {
                //修改

                personDao.modify(new Person(Integer.parseInt(jTextField1.getText()),jTextField2.getText(),jTextField3.getText(), jTextField4.getText(), jTextField5.getText(),jTextField6.getText()));
                JOptionPane.showMessageDialog(null, "人员信息修改成功！", "人员信息修改", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();

           RenYuanGuanLi typeMan = new  RenYuanGuanLi();
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
                                list=assetsTrjnDao.findByPerson(Integer.parseInt(jTextField1.getText()));
                                for(int j=0;j<list.size();j++)
                                {
                                    assetsTrjnDao.delete(list.get(j).getJourNo());
                                }
//                        tableModel.removeRow(jTable.getSelectedRow());
//                       tableModel.setRowCount(rowcount);//删除行比较简单，只要用DefaultTableModel的removeRow()方法即可。删除行完毕后必须重新设置行数，也就是使用DefaultTableModel的setRowCount()方法来设置当前行。
                        personDao.delete(Integer.parseInt(jTextField1.getText()));
                    }

                    JOptionPane.showMessageDialog(null, "人员信息删除成功！", "人员信息删除", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                this.dispose();
                 RenYuanGuanLi typeMan = new  RenYuanGuanLi();
                typeMan.delect();
                typeMan.pack();
                typeMan.setVisible(true);
            }

        }else if (obj == check) { //按编号查询
        
            jTextField1.setEditable(true);    
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        int i=Integer.parseInt(jTextField1.getText());
        
          try{
              Person a=personDao.findByPersonID(i);
              if(a==null)
                  JOptionPane.showMessageDialog(null, "此编号不存在，请重新输入！", "按编号查询", JOptionPane.INFORMATION_MESSAGE);
              else{
        jTextField1.setText(String.valueOf(a.getPersonID()));
        jTextField2.setText(a.getName());
        jTextField3.setText(a.getSex());
        jTextField4.setText(a.getDept());
        jTextField5.setText(a.getJob());
        jTextField6.setText(a.getOther()); 

         
        JOptionPane.showMessageDialog(null, "按编号查询成功！", "按编号查询", JOptionPane.INFORMATION_MESSAGE);
              }
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
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
        jTextField1.setText((String) jTable.getValueAt(selectedRow, 0));
        jTextField2.setText((String) jTable.getValueAt(selectedRow, 1));
        jTextField3.setText((String) jTable.getValueAt(selectedRow, 2));
        jTextField4.setText((String) jTable.getValueAt(selectedRow, 3));
        jTextField5.setText((String) jTable.getValueAt(selectedRow, 4));
        jTextField6.setText((String) jTable.getValueAt(selectedRow, 5)); 

        //设置是否可操作
        jTextField2.setEditable(true);
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);


        ///addInfo.setEnabled(false);
        modifyInfo.setEnabled(true);
        deleteInfo.setEnabled(true);
        //clearInfo.setEnabled(true);
    }
}
