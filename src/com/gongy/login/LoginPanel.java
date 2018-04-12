package com.gongy.login;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoginPanel extends JPanel {

    public int width, height;       // 面板的宽高
    private Image img;            // 登录面板的背景图片

    // 登录面板的构造方法
    public LoginPanel() {
        super();        // 调用父类 JPanel 的构造器
        URL url = getClass().getResource("/res/login.jpg");     // 获得登录面板背景图片的路径
        img = new ImageIcon(url).getImage();        // 获得登录面板的背景图片
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                      // 绘制组件
        g.drawImage(img, 0, 0, this);   // 绘制图片
    }
}
