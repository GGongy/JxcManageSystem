package com.gongy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

// 桌面面板
public class DesktopPanel extends JDesktopPane {

    private static final long serialVersionUID = 1L;
    private final Image backImage;          // 背景图片

    // 桌面面板的构造器方法
    public DesktopPanel() {
        // 调用父类 JDesktopPane 的构造器
        super();
        URL url = DesktopPanel.class.getResource("/res/back.jpg");      // 获得背景图片的路径
        backImage = new ImageIcon(url).getImage();                            // 获取背景图片
    }

    // 重写绘制组件的方法
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();             // 定义桌面面板的宽度
        int height = this.getHeight();      // 定义桌面面板的高度
        g.drawImage(backImage, 0, 0, width, height, this);      // 绘制背景图片
    }
}
