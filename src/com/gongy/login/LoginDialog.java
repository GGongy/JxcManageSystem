package com.gongy.login;

import com.gongy.MainFrame;

import javax.swing.*;

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

}
