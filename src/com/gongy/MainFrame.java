package com.gongy;

import com.gongy.login.LoginDialog;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
        JFrame login = new LoginDialog();
        login.setVisible(true);
    }
}
