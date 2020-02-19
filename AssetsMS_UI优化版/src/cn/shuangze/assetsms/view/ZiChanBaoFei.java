package cn.shuangze.assetsms.view;
import cn.shuangze.assetsms.dao.impl.AssetsTrjnDaoJDBCImpl;
import cn.shuangze.assetsms.dao.impl.AssetsDaoJDBCImpl;
import cn.shuangze.assetsms.entity.AssetsTrjn;
import cn.shuangze.assetsms.entity.Assets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import cn.shuangze.assetsms.dao.AssetsTrjnDao;
import cn.shuangze.assetsms.dao.AssetsDao;
import cn.shuangze.assetsms.dao.PersonDao;
import cn.shuangze.assetsms.dao.impl.PersonDaoJDBCImpl;
import com.eltima.components.ui.DatePicker;
import java.util.Arrays;
/**
 *
 * @author yuanshuai
 */
public class ZiChanBaoFei extends JFrame implements ActionListener, ListSelectionListener{
     AssetsTrjnDao assetsTrjnDao;
     AssetsDao assetsDao;
     PersonDao personDao;
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
    JLabel jLabel9 = new JLabel();

    JTextField jTextField1 = new JTextField(8);
    JTextField jTextField2 = new JTextField(8);
    JTextField jTextField3 = new JTextField(8);
    JTextField jTextField4 = new JTextField(8);
    JComboBox<Integer> comboBox1;
    JTextField jTextField6 = new JTextField(8);
    JTextField jTextField7 = new JTextField(8);

    JButton scrap = new JButton();
    JButton bb = new JButton();
    JButton bc = new JButton("获取时间");
    
    TimeTable ab=new TimeTable();
    DatePicker datepick;
    //定义表格
    JScrollPane jScrollPane11;
    JTable jTable1;
    DefaultTableModel tableModel1;

    
    JScrollPane jScrollPane12;
    JTable jTable2;
    DefaultTableModel tableModel2;
    ListSelectionModel listSelectionModel2 = null;

    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;
    
    

    public ZiChanBaoFei() {

        assetsTrjnDao = new AssetsTrjnDaoJDBCImpl();
        assetsDao = new AssetsDaoJDBCImpl();
        personDao = new PersonDaoJDBCImpl();
        //设置框架的大小

        try {
            int[] b=assetsTrjnDao.findPersonID();
            String[] name=new String[b.length];
            for(int i=0;i<b.length;i++)
            name[i]=personDao.findByPersonID(b[i]).getName();
            comboBox1 = new JComboBox(name);
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
public ZiChanBaoFei(int i) {

        assetsTrjnDao = new AssetsTrjnDaoJDBCImpl();
        
        //设置框架的大小

        try {
            Findinit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Findinit() throws Exception {
       try{
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产报废");
        this.setResizable(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AssetsMain.class.getResource("2.jpg")));
        
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 1600) / 2 + 45,
                (screenSize.height - 300) / 2 + 45);
        //中部面板的布局List<AssetsTrjn> findByFromAcc(String fromacc) throws Exception
         java.util.List<AssetsTrjn> list = assetsTrjnDao.findByFromAcc("报废");
         
          String[][] colValue = null;
        int size = list.size();
        if (!list.isEmpty()) {
            colValue = new String[list.size()][7];
        }
        for (int i = 0; i < size; i++) {
            colValue[i][0] = Integer.toString(list.get(i).getJourNo());
            colValue[i][1] = list.get(i).getFromAcc();
            colValue[i][2] = Integer.toString(list.get(i).getAssetsID());
            colValue[i][3] = list.get(i).getRegDate().toString();
            colValue[i][4] = Integer.toString(list.get(i).getPersonID());
            colValue[i][5] = list.get(i).getPurpose();
            colValue[i][6] = list.get(i).getOther();
        }
        if (colValue == null) {
            colValue = new String[1][7];
        }
        String[] colName = {"编号", "操作类型", "资产编号","操作时间","领用人编号","用途","备注"};
        tableModel1 = new DefaultTableModel(colValue, colName);
        jTable1 = new JTable(tableModel1);
        jTable1.setPreferredScrollableViewportSize(new Dimension(800, 300));
        jScrollPane11 = new JScrollPane(jTable1);
        jScrollPane11.setPreferredSize(new Dimension(800, 300));

        upPanel.add(jScrollPane11);
        contentPane.add(upPanel, BorderLayout.NORTH);
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
    private void init() throws Exception {
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产报废");
        this.setResizable(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AssetsMain.class.getResource("2.jpg")));
        
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 1600) / 2 + 45,
                (screenSize.height - 300) / 2 + 45);
        //中部面板的布局
         String[][] colValue2 = assetsDao.findBynotStatus("报废");
        if (colValue2 == null) {
            colValue2 = new String[1][8];
        }
        String[] colName2 = {"资产编号", "资产名称", "资产类别编号","型号","价格","购买日期","状态","备注"};
        tableModel2 = new DefaultTableModel(colValue2, colName2);
        jTable2 = new JTable(tableModel2);
        jTable2.setPreferredScrollableViewportSize(new Dimension(800, 300));
        listSelectionModel2 = jTable2.getSelectionModel();
        listSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel2.addListSelectionListener(this);
        jScrollPane12 = new JScrollPane(jTable2);
        jScrollPane12.setPreferredSize(new Dimension(800, 300));
        
        jLabel8.setText("<html>资<br>产<br>信<br>息<br>表");
        jLabel8.setFont(new Font("Dialog", Font.BOLD, 12));
   
        upPanel.add(jLabel8);

        upPanel.add(jScrollPane12);
        
        String[][] colValue1 = assetsTrjnDao.findAll();
        if (colValue1 == null) {
            colValue1 = new String[1][7];
        }
        String[] colName1 = {"编号", "操作类型", "资产编号","操作时间","领用人编号","用途","备注"};
        tableModel1 = new DefaultTableModel(colValue1, colName1);
        jTable1 = new JTable(tableModel1);
        jTable1.setPreferredScrollableViewportSize(new Dimension(800, 300));
        
        jScrollPane11 = new JScrollPane(jTable1);
        jScrollPane11.setPreferredSize(new Dimension(800, 300));
        
        jLabel9.setText("<html>资<br>产<br>领<br>用<br>流<br>水<br>表");
        jLabel9.setFont(new Font("Dialog", Font.BOLD, 12));
 
        upPanel.add(jLabel9);

        upPanel.add(jScrollPane11);
        contentPane.add(upPanel, BorderLayout.NORTH);
        
       

        jLabel1.setText("编号");
        jLabel1.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel1);
        centerPanel.add(jTextField1);

        jLabel2.setText("操作类型");
        jLabel2.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel2);
        jTextField2.setText("报废");
        centerPanel.add(jTextField2);

        jLabel3.setText("资产编号");
        jLabel3.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel3);
        centerPanel.add(jTextField3);
        
        jLabel4.setText("操作时间");
        jLabel4.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel4);
        centerPanel.add(jTextField4);
        
        bb.setText("选择时间");
        bb.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(bb);
        
        jLabel5.setText("领用人");
        jLabel5.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel5);
        centerPanel.add(comboBox1);
        
        jLabel6.setText("用途");
        jLabel6.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel6);
        centerPanel.add(jTextField6);
        
        jLabel7.setText("备注");
        jLabel7.setFont(new Font("Dialog", Font.BOLD, 12));
        centerPanel.add(jLabel7);
        centerPanel.add(jTextField7);
        
        contentPane.add(centerPanel, BorderLayout.CENTER);

        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        comboBox1.setEditable(false);
        jTextField4.setEditable(false);
    }

    /**
     * 下部面板的布局
     */
    public void downInit() {

        scrap.setText("报废");
        scrap.setFont(new Font("Dialog", Font.BOLD, 12));
        downPanel.add(scrap);

        contentPane.add(downPanel, BorderLayout.SOUTH);

        //添加事件侦听
        scrap.addActionListener(this);
        bb.addActionListener(this);
        bc.addActionListener(this);

        scrap.setEnabled(true);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == scrap) {
            try {
                //增加
                
                if(jTextField4.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "请输入日期！", "资产报废", JOptionPane.INFORMATION_MESSAGE);
                else{
                int j=0;
                String temp[][]=personDao.findAll();
                for(int i=0;i<temp.length;i++)
                    if(comboBox1.getSelectedItem().equals(temp[i][1]))
                    {
                        j=Integer.parseInt(temp[i][0]);
                    }
                Assets assets=assetsDao.findByAssetsID(Integer.parseInt(jTextField3.getText()));
                assetsTrjnDao.add(new AssetsTrjn(jTextField2.getText(),Integer.parseInt(jTextField3.getText()),java.sql.Date.valueOf(jTextField4.getText()),j,jTextField6.getText(),jTextField7.getText()));
                assetsDao.modify(new Assets(assets.getAssetsID(),assets.getName(),assets.getTypeID(),assets.getModel(),assets.getPrice(),assets.getBuyDate(),"报废",assets.getOther()));
                    JOptionPane.showMessageDialog(null, "资产报废成功！", "资产报废", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            ZiChanBaoFei typeMan = new ZiChanBaoFei();
            typeMan.downInit();
            typeMan.pack();
            typeMan.setVisible(true);
        } 
        else if(obj==bb){
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
            jTextField4.setText( datepick.getText());
        }
        
        jTable1.revalidate();
        jTable2.revalidate();
    }

    /**
     * 当表格被选中时的操作
     * @param lse
     */
     @Override
    public void valueChanged(ListSelectionEvent lse) {
        int selectedRow = jTable2.getSelectedRow();
        jTextField3.setText((String) jTable2.getValueAt(selectedRow, 0));
        
        //设置是否可操作
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        comboBox1.setEditable(false);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
    }
}
