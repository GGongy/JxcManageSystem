package com.gongy.login;

import com.gongy.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// 登录窗体
public class LoginDialog extends JFrame {
    private static final long serialVersionUID = 1L;
    private LoginPanel loginPanel = null;       // 登录面板
    private JLabel jLabel = null;               // “用户名”标签
    private JTextField userField = null;        // “用户名”文本框
    private JLabel jLabel1 = null;              // “密码”标签
    private JPasswordField passwordField = null;// “密码”文本框
    private JButton loginButton = null;         // “登录”按钮
    private JButton exitButton = null;          // “退出”按钮
    private static String userStr;              // "用户名“文本框中的内容
    private MainFrame mainFrame;                // 主窗体

    // 登录窗体的构造方法
    public LoginDialog() {
        try {
            // 设置登录窗体风格
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            mainFrame = new MainFrame();        // 实例化主窗体
            initialize();                       // 初始化登录窗体
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 初始化 LoginPanel 登录面板的方法
    private LoginPanel getLoginPanel() {
        // 控制面板中没有组件时
        if (loginPanel == null) {
            jLabel1 = new JLabel();             // “密码”标签
            jLabel1.setBounds(new Rectangle(86, 71, 55, 18));   // 设置“密码”标签的位置与宽高
            jLabel1.setText("密  码：");         // 设置”密码“标签的文本
            jLabel = new JLabel();              // “用户名”标签
            jLabel.setText("用户名：");          // 设置“用户名”标签的文本
            jLabel.setBounds(new Rectangle(85, 41, 56,18));     // 设置“用户名”标签的位置与宽高
            loginPanel = new LoginPanel();      // 登录面板
            loginPanel.setLayout(null);         // 设置登录面板的布局为绝对布局
            loginPanel.setBackground(new Color(0xD8DDC7));  // 设置登录面板的背景色
            loginPanel.add(jLabel, null);   // 把“用户名”标签置于登录面板中
            loginPanel.add(getUserField(), null);   // 把“用户名”文本框置于面板中
            loginPanel.add(jLabel1, null);  // 把“密码”标签置于文本框中
            loginPanel.add(getPasswordField(), null);   // 把“密码”文本框置于面板中
            loginPanel.add(getLoginButton(), null);     // 把“登录“按钮置于面板中
            loginPanel.add(getExitButton(), null);      // 把“退出”按钮置于面板中
        }
       return loginPanel;                       // 返回登录面板
    }

    // 初始化“用户名”文本框
    private JTextField getUserField() {
        // 当“用户名”文本框对象为空时
        if (userField == null) {
            userField = new JTextField();       // 实例化“用户名”文本框
            userField.setBounds(new Rectangle(142, 39, 127, 22));   // 设置“用户名”文本框的宽高
        }
        return userField;                  // 返回“用户名”文本框
    }

    // 初始化“密码”文本框
    private JPasswordField getPasswordField(){
        // 当“密码”文本框对象为空时
        if (passwordField == null) {
            passwordField = new JPasswordField();           // 实例化“密码文本框
            // 设置“密码”文本框的位置和宽高
            passwordField.setBounds(new Rectangle(143, 69, 125, 22));
            // 为“密码”文本框添加键盘时间的监听
            passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == '\n') {           // 按下回车时
                        loginButton.doClick();              // “登录”按钮执行点击事件
                    }
                }
            });
        }
        return passwordField;                               // 返回“密码”文本框
    }

    // 初始化“登录”按钮
    private JButton getLoginButton() {
        // 当“登录”按钮对象为空时
        if (loginButton == null) {
            loginButton = new JButton();                                        // 实例化登录按钮
            // 设置“登录”按钮的位置和宽高
            loginButton.setBounds(new Rectangle(109, 114, 48, 20));
            // 设置“登录”按钮的图标
            loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));
            // 为“登录”按钮添加动作事件监听
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userStr = userField.getText();                              // 获取“文本框“中的内容
                    String passStr = new String(passwordField.getPassword());   // 获取“密码框“中的内容
                    // 验证“登录名”，“密码”为 false 时
                    // if (){
                    //
                    // }
                    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);          // 设置主窗体的关闭方式
                    mainFrame.setVisible(true);                                 // 设置住窗体可见
                    // 设置主窗体中操作员标签的字体

                    setVisible(false);                                          // 设置登录窗体不可见
                }
            });
        }
        // 返回“登录”按钮
        return loginButton;
    }

    // 初始化“退出”按钮
    private JButton getExitButton() {
        // 当“退出”按钮对象为空时
        if (exitButton == null) {
            exitButton = new JButton();                                         // 实例化“退出”按钮对象
            // 设置“退出”按钮的位置和宽高
            exitButton.setBounds(new Rectangle(181, 114, 48,20));
            // 设置“退出”按钮的图片
            exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));
            // 为“退出”按钮添加动作事件监听
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);       // 退出当前应用程序
                }
            });
        }
        return exitButton;                      // 返回“退出”按钮
    }

    // 初始化登录窗体
    private void initialize() {
        Dimension size = getToolkit().getScreenSize();   // 获取屏幕尺寸
        setLocation((size.width - 296) / 2, (size.height - 188) / 2);    // 设置登录窗体
        setSize(296, 188);                  // 设置登录窗体的宽高
        this.setTitle("登录系统");                        // 设置登录窗体的标题
        setContentPane(getLoginPanel());                 // 将登录面板置于窗体中
    }

    // 获取“用户名”文本框中的内容
    public String getUserStr() {
        return userStr;             // 返回“用户名”文本框中的内容
    }

}
