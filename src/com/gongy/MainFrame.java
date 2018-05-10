package com.gongy;

import com.gongy.login.LoginDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import static java.awt.BorderLayout.*;
import static javax.swing.border.BevelBorder.*;


// 主窗体
public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel frameContentPane = null;         // 内容面板
    private MenuBar frameMenuBar = null;            // 菜单栏
    private ToolBar toolBar = null;                 // 工具栏
    private DesktopPanel desktopPanel = null;       // 桌面面板
    private JLabel stateLabel = null;               // 选定窗体状态标签
    private JPanel statePanel = null;               // 状态面板（内含选定窗体状态，操作员，当前日期，公司名称等信息）
    private JLabel nameLabel = null;                // “公司名称”标签
    private JLabel nowDateLabel = null;             // “当前日期”标签
    private static JLabel czyStateLabel = null;     // “操作员”标签
    private JSeparator jSeparator1 = null;          // 分隔符
    private JSeparator jSeparator2 = null;          // 分隔符

    public static void main(String[] args) {
        SplashScreen splashScreen = SplashScreen.getSplashScreen();
        JFrame login = new LoginDialog();
        if (splashScreen != null) {
            try {
                login.setDefaultCloseOperation(EXIT_ON_CLOSE);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        login.setVisible(true);
    }

    /**
     * 初始化桌面面板的方法
     * */
    private DesktopPanel getDesktopPanel() {
        if (desktopPanel == null) {
            desktopPanel = new DesktopPanel();
        }
        return desktopPanel;
    }

    /**
     * 初始化窗体菜单栏的方法
     * */
    protected MenuBar getFrameMenuBar() {
        if (frameMenuBar == null) {
            frameMenuBar = new MenuBar(getDesktopPanel(), getStateLabel());     // 创建菜单栏对象
        }
        return frameMenuBar;
    }

    /**
     * 初始化工具栏的方法
     * */
    protected ToolBar getToolBar() {
        // 工具栏对象为空
        if (toolBar == null) {
            toolBar = new ToolBar(getFrameMenuBar());           // 创建工具栏对象
            toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 设置光标图像
        }
        return toolBar;
    }

    /**
     * 初始化状态栏面板的方法
     * */
    private JPanel getStatePanel() {
        if (statePanel == null) {
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();     // 创建网格限制对象
            gridBagConstraints6.gridx = 2;                              // 组件位于网格的横向索引为 2
            gridBagConstraints6.fill = GridBagConstraints.VERTICAL;     // 组件垂直扩大以占据空白区域
            gridBagConstraints6.insets = new Insets(0, 5, 0,5);     // 组件彼此的间距
            gridBagConstraints6.gridy = 0;                              // 组件位于网格的纵向索引为0

            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();     // 创建网格限制对象
            gridBagConstraints5.gridx = 3;          // 组件位于网格的横向索引为3
            gridBagConstraints5.gridy = 0;          // 组件位于网格的纵向索引为0

            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();     // 创建网格限制对象
            gridBagConstraints4.gridx = 6;          // 组件位于网格的横向索引为6
            gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints4.insets = new Insets(0, 5, 0,5);     // 组件彼此的间距
            gridBagConstraints4.gridy = 0;          // 组件位于网格的纵向索引为0

            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();     // 创建网格限制对象
            gridBagConstraints3.gridx = 5;          // 组件位于网格的横向索引为5
            gridBagConstraints3.insets = new Insets(0, 5, 0,5);     // 组件彼此的间距
            gridBagConstraints3.gridy = 0;          // 组件位于网格的纵向索引为0
            nowDateLabel = new JLabel();            // "当前日期“标签
            Date now = new Date();                  // 创建 Date 对象
            nowDateLabel.setText(String.format("%tF", now));    // 设置“当前日期”标签的文本内容

            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();     // 创建网格限制对象
            gridBagConstraints2.gridx = 7;          // 组件位于网格的横向索引为7
            gridBagConstraints2.weightx = 0.0;      // 组件横向上不扩大
            gridBagConstraints2.fill = GridBagConstraints.NONE; // 组件不扩大
            gridBagConstraints2.gridy = 0;          // 组件位于网格的纵向索引为0
            nameLabel = new JLabel("XX有限公司");   // “公司名称”标签

            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();     // 创建网格限制对象
            gridBagConstraints1.gridx = 4;          // 组件位于网格的横向索引为4
            gridBagConstraints1.fill = GridBagConstraints.VERTICAL; // 组件垂直扩大以占据空白区域
            gridBagConstraints1.weighty = 1.0;      // 组件纵向扩大的权重是1.0
            gridBagConstraints1.insets = new Insets(0, 5, 0,5);     // 组件彼此的间距
            gridBagConstraints1.gridy = 0;          // 组件位于网格的纵向索引为0

            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;           // 组件位于网格的横向索引为0
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;    // 组件水平扩大以占据空白区域
            gridBagConstraints.weightx = 1.0;       // 组件横向扩大的权重是1.0
            gridBagConstraints.gridy = 0;           // 组件位于网格的纵向索引为0

            statePanel = new JPanel();              // 状态面板
            statePanel.setLayout(new GridLayout()); // 设置状态面板
            statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));  // 设置状态面板的边框
            statePanel.add(getStateLabel(), gridBagConstraints);        // 向状态面板中添加选定窗体状态标签
            statePanel.add(getjSeparator(), gridBagConstraints1);       // 向状态面板中添加分隔符
            statePanel.add(nameLabel, gridBagConstraints2);             // 向状态面板中添加“公司名称”标签
            statePanel.add(getjSeparator1(), gridBagConstraints4);      // 向状态面板中添加分隔符
            statePanel.add(nowDateLabel, gridBagConstraints3);          // 向状态面板中添加“当前日期”标签
            statePanel.add(getCzyStateLabel(), gridBagConstraints5);    // 向状态面板中添加“操作员”标签
            statePanel.add(getjSeparator2(), gridBagConstraints6);      // 向状态面板中添加分隔符
        }
        return statePanel;
    }

    // 获得“操作员”标签
    public static JLabel getCzyStateLabel() {
        if (czyStateLabel == null) {
            czyStateLabel = new JLabel("操作员：");     // 创建“操作员”标签
        }
        return czyStateLabel;
    }

    // 获得分隔符
    private JSeparator getjSeparator() {
        JSeparator jSeparator = new JSeparator();       // 创建分隔符对象
        jSeparator.setOrientation(JSeparator.VERTICAL); // 竖直分隔符
        return jSeparator;
    }

    // 获得分隔符
    private JSeparator getjSeparator1() {
        if (jSeparator1 == null) {              // 当分隔符对象为空时
            jSeparator1 = new JSeparator();     // 创建分隔符对象
            jSeparator1.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparator1;
    }

    // 获得分隔符
    private JSeparator getjSeparator2() {
        if (jSeparator2 == null) {              // 当分隔符对象为空时
            jSeparator2 = new JSeparator();     // 创建分隔符对象
            jSeparator2.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparator2;
    }

    // 构造函数
    public MainFrame() {
        super();
        initialize();
    }

    // 初始化主窗体的方法
    private void initialize() {
        this.setSize(800,600);          // 设置窗体的宽高
        this.setJMenuBar(getFrameMenuBar());         // 设置菜单栏
        this.setContentPane(getFrameContentPane());  // 设置内容面板
        this.setTitle("进销存管理系统");               // 设置窗体的标题
    }

    // 获得选定窗体状态标签的方法
    public JLabel getStateLabel() {
        if (stateLabel == null) {
            stateLabel = new JLabel();              // 创建选定窗体状态标签
            stateLabel.setText("当前没有选定窗体");    // 设置选定窗体状态标签的文本内容
        }
        return stateLabel;
    }

    // 获得内容面板的方法
    private JPanel getFrameContentPane() {
        if (frameContentPane == null) {
            frameContentPane = new JPanel();                    // 创建内容面板
            frameContentPane.setLayout(new BorderLayout());     // 设置内容面板的布局
            frameContentPane.add(getStatePanel(), SOUTH);// 状态面板置于内容面板的南部
            frameContentPane.add(getToolBar(), NORTH);          // 工具栏置于面板的北部
            frameContentPane.add(getDesktopPanel(), CENTER);    // 背景面板置于内容面板的中部
        }
        return frameContentPane;
    }
}
