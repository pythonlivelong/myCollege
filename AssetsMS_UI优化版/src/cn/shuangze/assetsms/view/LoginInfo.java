package cn.shuangze.assetsms.view;
import cn.shuangze.assetsms.dao.impl.LoginDaoJDBCImpl;
import cn.shuangze.assetsms.entity.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cn.shuangze.assetsms.dao.LoginDao;
import javax.swing.JPasswordField;
/**
 *
 * @author yuanshuai
 */
public class LoginInfo extends JFrame implements ActionListener{
    LoginDao loginDao;
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

    JTextField jTextField1 = new JTextField(20);
    JPasswordField jTextField2 = new JPasswordField(20);

    JButton addInfo = new JButton();
    JButton loginInfo = new JButton();
    JButton clearInfo = new JButton();
    JButton eixtInfo = new JButton();

    

    GridBagLayout girdBag = new GridBagLayout();
    GridBagConstraints girdBagCon;

    public LoginInfo() {

        loginDao = new LoginDaoJDBCImpl();

        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }//构造方法

    private void init() throws Exception {
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(faceSize);
        //设置标题
        this.setTitle("登陆界面");
        this.setResizable(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AssetsMain.class.getResource("2.jpg")));
        
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        jLabel1.setText("账号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        centerPanel.add(jLabel1);
        centerPanel.add(jTextField1);

        jLabel2.setText("密码");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        centerPanel.add(jLabel2);
        centerPanel.add(jTextField2);
        
        contentPane.add(centerPanel, BorderLayout.CENTER);
        
        jTextField1.setEditable(true);
        jTextField2.setEditable(true);
        
        this.addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
                });//使用户点击右上角关闭窗口时，程序停止运行
    }//设置界面

    /**
     * 下部面板的布局
     */
    public void downInit() {

        addInfo.setText("创建账户");
        addInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(addInfo);
        
        loginInfo.setText("登陆");
        loginInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(loginInfo);
        clearInfo.setText("清空");
        clearInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(clearInfo);
        eixtInfo.setText("退出");
        eixtInfo.setFont(new Font("Dialog", 0, 12));
        downPanel.add(eixtInfo);

        contentPane.add(downPanel, BorderLayout.SOUTH);
        //添加事件侦听
        addInfo.addActionListener(this);
        
        loginInfo.addActionListener(this);
        clearInfo.addActionListener(this);
        eixtInfo.addActionListener(this);


        addInfo.setEnabled(true);
        loginInfo.setEnabled(true);
        clearInfo.setEnabled(true);
        eixtInfo.setEnabled(true);
    }//增加按钮，并对事件进行监听

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
                
                if(jTextField1.getText().equals("")) JOptionPane.showMessageDialog(null, "账号为空！", "账号添加", JOptionPane.INFORMATION_MESSAGE);
                 else if(jTextField2.getText().equals("")) JOptionPane.showMessageDialog(null, "密码为空！", "账号添加", JOptionPane.INFORMATION_MESSAGE);
                else if((loginDao.findByAccount(jTextField1.getText())==null)&&jTextField2.getText().equals("")==false&&jTextField1.getText().equals("")==false)
                {
                    loginDao.add(new Login(jTextField1.getText(), jTextField2.getText()));
                    JOptionPane.showMessageDialog(null, "账号添加成功！", "账号添加", JOptionPane.INFORMATION_MESSAGE);
                }
               
                else JOptionPane.showMessageDialog(null, "已有该账户，请更换账户名！", "账户添加", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            LoginInfo typeMan = new LoginInfo();
            typeMan.downInit();
            typeMan.pack();
            typeMan.setVisible(true);
        } //增加账户
         else if (obj == loginInfo) {
            try{    
            Login a=loginDao.findByAccount(jTextField1.getText());
                 if(a==null||jTextField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "账户不存在！", "登陆", JOptionPane.INFORMATION_MESSAGE); 
                 }
                 else if(a.getPassword().equals(jTextField2.getText())&&a!=null&&jTextField1.getText().equals("")==false&&jTextField2.getText().equals("")==false)
                 {
                     JOptionPane.showMessageDialog(null, "登陆成功！", "登陆", JOptionPane.INFORMATION_MESSAGE);
                     this.dispose();
                     AssetsMain frame = new AssetsMain();
                     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
                this.addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
                 }
                 else JOptionPane.showMessageDialog(null, "账号或密码错误！", "登陆", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                
            }//登陆账户

         else if (obj == clearInfo) { //清空
            setNull();
        }//将账号密码两个文本框清空
         else if (obj == eixtInfo) { //退出
            this.dispose();
        }//退出程序
       
        
    }
    /**
     * 将文本框清空
     */
    void setNull() {
        jTextField1.setText(null);
        jTextField2.setText(null);
    }//清空文本框
}

