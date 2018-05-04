package com.gongy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class MenuBar extends JMenuBar {

    /**
    * （进货管理）菜单项
    * */
    private JMenu jinhuo_Menu = null;

    /**
    * （进货单）菜单项，位于（进货管理）菜单内
    * */
    private JMenuItem jinhuoItem = null;

    /**
    * （进货退货单）菜单项，位于（进货管理）菜单内
    * */
    private JMenuItem jinhuo_tuihuoItem = null;

    /**
    * （销售管理）菜单项
    * */
    private JMenu xiaoshou_Menu = null;

    /**
    * （库存管理）菜单项
    * */
    private JMenu kucun_Menu = null;

    /**
    * （信息查询）菜单项
    * */
    private JMenu xinxi_chaxun_Menu = null;

    /**
    * （基本资料）菜单项
    * */
    private JMenu jiben_ziliao_Menu = null;

    /**
    * （系统维护）菜单项
    * */
    private JMenu xitong_weihu_Menu = null;

    /**
    * （窗口）菜单项
    * */
    private JMenu chuangkou_Menu = null;

    /**
    * （帮助）菜单项
    * */
    private JMenu bangzhu_Menu = null;

    /**
    * （关于）菜单项，位于（帮助）菜单内
    * */
    private JMenuItem guanyu_Item = null;

    /**
    * （联系技术支持）菜单项，位于（帮助）菜单内
    * */
    private JMenuItem support_Item = null;

    /**
    * （访问技术网站）菜单项，位于（帮助）菜单内
    * */
    private JMenuItem jisu_wangzhan_Item = null;

    /**
    * （销售单）菜单项，位于（销售管理）菜单项内
    * */
    private JMenuItem xiaoshoudan_Item = null;

    /**
    * （销售退货）菜单项，位于（销售管理）菜单内
    * */
    private JMenuItem xiaoshou_tuihuo_Item = null;

    /**
    * （库存盘点）菜单项，位于（库存管理）菜单项内
    * */
    private JMenuItem kucun_pandian_Item = null;

    /**
    * （价格调整）菜单项，位于（库存管理）菜单项内
    * */
    private JMenuItem jiage_tiaozheng_Item = null;

    /**
    * （销售查询）菜单项，位于（信息查询）菜单项内
    * */
    private JMenuItem xiaoshou_chaxun_Item = null;

    /**
    * （商品查询）菜单项，位于（信息查询）菜单内
    * */
    private JMenuItem shangpin_chaxun_Item = null;

    /**
    * （销售排行）菜单项，位于（信息查询）菜单内
    * */
    private JMenuItem xiaoshou_paihang_Item = null;

    /**
    * （商品管理）菜单项，位于（基本资料）菜单内
    * */
    private JMenuItem shangpin_guanli_Item = null;

    /**
    * （客户管理）菜单项，位于（基本资料）菜单内
    * */
    private JMenuItem kehu_guanli_Item = null;

    /**
    * （供应商管理）菜单项，位于（基本资料）菜单内
    * */
    private JMenuItem gys_guanli_Item = null;

    /**
    * （经手人设置）菜单项，位于（基本资料）菜单内
    * */
    private JMenuItem jsr_guanli_Item = null;

    /**
    * （密码修改）菜单项，位于（系统维护）菜单内
    * */
    private JMenuItem mima_xiugai_Item = null;

    /**
    * （数据库备份与恢复）菜单项，位于（系统维护）菜单内
    * */
    private JMenuItem shuju_beifen_Item = null;

    /**
     * （退出）菜单项，位于（窗口）菜单内
     * */
    private JMenuItem exitItem = null;

    /**
    * （窗口平铺）菜单项，位于（窗口）菜单内
    * */
    private JMenuItem pingpu_Item = null;

    /**
    * 容纳内部窗体的桌面面板
    * */
    private JDesktopPane desktopPanel = null;

    /**
    * 内部窗体的集合
    * */
    private Map<JMenuItem, JInternalFrame> iFrames = null;

    /**
    * 内部窗体的位置坐标
    * */
    private int nextFrameX, nextFramY;

    /**
    * （全部关闭）菜单项，位于（窗口）菜单内
    * */
    private JMenuItem closeAll_Item = null;

    /**
    * （全部最小化）菜单项，位于（窗口）菜单内
    * */
    private JMenuItem allIcon_Item = null;

    /**
    * （全部还原）菜单项，位于（窗口）菜单内
    * */
    private JMenuItem allResume_Item = null;

    /**
    * 状态栏的内部窗体提示标签
    * */
    private JLabel stateLabel = null;

    // 默认的构造方法
    private MenuBar(){}

    public MenuBar(JDesktopPane desktopPanel, JLabel label) {
        super();
        iFrames = new HashMap<JMenuItem, JInternalFrame>();
        this.desktopPanel = desktopPanel;
        this.stateLabel = label;
        initialize();
    }

    /**
     * 初始化菜单栏界面的方法
     * */
    private void initialize() {
        this.setSize(new Dimension(600, 24));

    }

    /**
     * 初始化进货管理菜单的方法
     * */
    public JMenu getJinhuo_Menu() {
        if (jinhuo_Menu == null) {
            jinhuo_Menu = new JMenu();
            jinhuo_Menu.setText("进货管理(J)");
            jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
            jinhuo_Menu.add(getJinhuoItem());               // 进货菜单项
            jinhuo_Menu.add(getJinhuo_tuihuoItem());        // 退货菜单项
        }
        return jinhuo_Menu;
    }

    /**
     * 初始化（进货单）菜单项的方法，该方法定义菜单项打开进货单窗口，并使窗口处于被选择状态
     * */
    public JMenuItem getJinhuoItem() {
        if (jinhuoItem == null) {
            jinhuoItem = new JMenuItem();
            jinhuoItem.setText("进货单");
            jinhuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jinhuodan.png")));
            // jinhuoItem.addActionListener(new ActionListener() {
            //     @Override
            //     public void actionPerformed(ActionEvent e) {
            //
            //     }
            // });
        }
        return jinhuoItem;
    }

    /**
     * 初始化（进货退货）菜单项的方法，该方法定义菜单项打开（进货退货）窗体，并使用窗体处于已选择状态。
     * */
    public JMenuItem getJinhuo_tuihuoItem() {
        if (jinhuo_tuihuoItem == null) {
            jinhuo_tuihuoItem = new JMenuItem();
            jinhuo_tuihuoItem.setText("进货退货");
            jinhuo_tuihuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jinhuo_tuihuo.png")));

        }
        return jinhuo_tuihuoItem;
    }

    /**
     * 初始化（销售管理）菜单的方法，该方法定义菜单项打开内部窗体，并使窗体处于已选择状态。
     * */
    public JMenu getXiaoshou_Menu() {
        if (xiaoshou_Menu == null) {
            xiaoshou_Menu = new JMenu();
            xiaoshou_Menu.setText("销售管理(X)");
            xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
            xiaoshou_Menu.add(getXiaoshoudan_Item());         // 销售单
            xiaoshou_Menu.add(getJinhuo_tuihuoItem());        // 销售退货
        }
        return xiaoshou_Menu;
    }

    /**
     * 初始化（销售单）菜单项的方法
     * */
    public JMenuItem getXiaoshoudan_Item() {
        if (xiaoshoudan_Item == null) {
            xiaoshoudan_Item = new JMenuItem();
            xiaoshoudan_Item.setText("销售单");
            xiaoshoudan_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshoudan.png")));

        }
        return xiaoshoudan_Item;
    }

    /**
     * 初始化（销售退货）菜单项的方法
     * */
    public JMenuItem getXiaoshou_tuihuo_Item() {
        if (xiaoshou_tuihuo_Item == null) {
            xiaoshou_tuihuo_Item = new JMenuItem();
            xiaoshou_tuihuo_Item.setText("销售退货");
            xiaoshou_tuihuo_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_tuihuo.png")));

        }
        return xiaoshou_tuihuo_Item;
    }


    private JInternalFrame createIFrame(JMenuItem item, Class c) {
        return null;
    }
}
