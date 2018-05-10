package com.gongy;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

// 工具条
public class ToolBar extends JToolBar {

    private MenuBar menuBar;        // 菜单栏

    /**
     * 空构造函数
     * */
    private ToolBar(){}

    /**
     * 完整构造函数
     * */
    public ToolBar(MenuBar frameMenuBar) {
        super();        // 调用父类 JToolBar 的构造器
        this.menuBar = frameMenuBar;
        initialize();
    }

    /**
     * 界面初始化方法
     * */
    private void initialize() {
        setSize(new Dimension(600, 24));                        // 设置工具条的宽高
        setBorder(BorderFactory.createBevelBorder(EtchedBorder.LOWERED));    // 设置工具条的边框
        add(createToolButton(menuBar.getJinhuoItem()));                      // 向工具条中添加进货单
        add(createToolButton(menuBar.getXiaoshoudan_Item()));                // 向工具条中添加销售单
        add(createToolButton(menuBar.getKucun_pandian_Item()));              // 向工具条中添加库存盘点
        add(createToolButton(menuBar.getJiage_tiaozheng_Item()));            // 向工具条中添加价格调整
        add(createToolButton(menuBar.getShangpin_chaxun_Item()));            // 向工具条中添加商品查询
        add(createToolButton(menuBar.getShangpin_guanli_Item()));            // 向工具条中添加商品资料管理
        add(createToolButton(menuBar.getKehu_guanli_Item()));                // 向工具条中添加客户资料管理
        add(createToolButton(menuBar.getGys_guanli_Item()));                 // 向工具条中添加供应商资料管理
        add(createToolButton(menuBar.getExitItem()));                        // 向工具条中添加退出系统
    }

    /**
     * 创建工具栏按钮的方法
     * */
    private JButton createToolButton(final JMenuItem item) {
        JButton button = new JButton();         // 工具栏按钮
        button.setText(item.getText());         // 设置工具栏按钮的文本内容
        button.setToolTipText(item.getText());  // 设置工具栏按钮的悬浮效果
        button.setIcon(item.getIcon());         // 设置工具栏按钮图标
        button.setFocusable(false);             // 让工具栏按钮失去焦点
        // 为工具栏按钮添加单击事件
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                item.doClick();                 // 菜单项的点击事件
            }
        });
        return button;
    }

    // 设置菜单栏
    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }
}
