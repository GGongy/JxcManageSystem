package com.gongy.login;

import com.gongy.MainFrame;

import javax.swing.*;
import java.awt.*;

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
            invalidate();                       // 初始化登录窗体
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 初始化 LoginPanel 登录面板的方法
    private LoginPanel getLoginPanel() {
        // 控制面板中没有组件时
        if (loginPanel == null) {
            jLabel1 = new JLabel();             // “密码”标签
            jLabel1.setBounds(new Rectangle(96, 71, 55, 18));   // 设置“密码”标签的位置与宽高
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
        return getUserField();                  // 返回“用户名”文本框
    }

    // 初始化“密码”文本框
    private JPasswordField getPasswordField(){
        return null;
    }

    // 初始化“登录”按钮
    private JButton getLoginButton() {
        return null;
    }

    // 初始化“退出”按钮
    private JButton getExitButton() {
        return null;
    }

    // 初始化登录窗体
    private void initialize() {

    }

    // 获取“用户名”文本框中的内容
    public String getUserStr() {
        return userStr;             // 返回“用户名”文本框中的内容
    }

}
