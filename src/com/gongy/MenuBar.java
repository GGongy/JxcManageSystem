package com.gongy;

import com.gongy.iframe.JinHuoDan_IFrame;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
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
    private int nextFrameX, nextFrameY;

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
        add(getJinhuo_Menu());              // 进货管理
        add(getXiaoshou_Menu());            // 销售管理
        add(getKucun_Menu());               // 库存管理
        add(getXinxi_chaxun_Menu());        // 信息查询
        add(getJiben_ziliao_Menu());        // 基本资料
        add(getXitong_weihu_Menu());        // 系统维护
        add(getChuangkou_Menu());           // 窗口
        add(getBangzhu_Menu());             // 帮助
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
            jinhuoItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createIFrame(jinhuoItem, JinHuoDan_IFrame.class);
                }
            });
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
            xiaoshou_Menu.add(getXiaoshoudan_Item());           // 销售单
            xiaoshou_Menu.add(getXiaoshou_tuihuo_Item());       // 销售退货
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

    /**
     * 初始化（库存管理）菜单的方法
     * */
    public JMenu getKucun_Menu() {
        if (kucun_Menu == null) {
            kucun_Menu = new JMenu();
            kucun_Menu.setText("库存管理(K)");
            kucun_Menu.setMnemonic(KeyEvent.VK_K);
            kucun_Menu.add(getKucun_pandian_Item());         // 库存盘点
            kucun_Menu.add(getJiage_tiaozheng_Item());       // 价格调整
        }
        return kucun_Menu;
    }

    /**
     * 初始化（库存盘点）菜单项方法
     * */
    public JMenuItem getKucun_pandian_Item() {
        if (kucun_pandian_Item == null) {
            kucun_pandian_Item = new JMenuItem();
            kucun_pandian_Item.setText("库存盘点");
            kucun_pandian_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/kucun_pandian.png")));

        }
        return kucun_pandian_Item;
    }

    /**
     * 初始化（价格调整）菜单项方法
     * */
    public JMenuItem getJiage_tiaozheng_Item() {
        if (jiage_tiaozheng_Item == null) {
            jiage_tiaozheng_Item = new JMenuItem();
            jiage_tiaozheng_Item.setText("价格调整");
            jiage_tiaozheng_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/jiage_tiaozheng.png")));

        }
        return jiage_tiaozheng_Item;
    }

    /**
     * 初始化（信息查询）菜单方法
     * */
    public JMenu getXinxi_chaxun_Menu() {
        if (xinxi_chaxun_Menu == null) {
            xinxi_chaxun_Menu = new JMenu();
            xinxi_chaxun_Menu.setText("信息查询(C)");
            xinxi_chaxun_Menu.setMnemonic(KeyEvent.VK_C);
            xinxi_chaxun_Menu.add(getXiaoshou_chaxun_Item());       // 销售查询
            xinxi_chaxun_Menu.add(getShangpin_chaxun_Item());       // 商品查询
            xinxi_chaxun_Menu.addSeparator();                       // 添加菜单项中的分隔线
            xinxi_chaxun_Menu.add(getXiaoshou_paihang_Item());      // 销售查询

        }
        return xinxi_chaxun_Menu;
    }

    /**
     * 初始化（销售查询）菜单项方法
     * */
    public JMenuItem getXiaoshou_chaxun_Item() {
        if (xiaoshou_chaxun_Item == null) {
            xiaoshou_chaxun_Item = new JMenuItem();
            xiaoshou_chaxun_Item.setText("销售查询");
            xiaoshou_chaxun_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_chaxun.png")));

        }
        return xiaoshou_chaxun_Item;
    }

    /**
     * 初始化（商品查询）菜单项方法
     * */
    public JMenuItem getShangpin_chaxun_Item() {
        if (shangpin_chaxun_Item == null) {
            shangpin_chaxun_Item = new JMenuItem();
            shangpin_chaxun_Item.setText("商品查询");
            shangpin_chaxun_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/shangpin_chaxun.png")));

        }
        return shangpin_chaxun_Item;
    }

    /**
     * 初始化（销售排行）菜单项方法
     * */
    public JMenuItem getXiaoshou_paihang_Item() {
        if (xiaoshou_paihang_Item == null) {
            xiaoshou_paihang_Item = new JMenuItem();
            xiaoshou_paihang_Item.setText("销售排行");
            xiaoshou_paihang_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_paihang.png")));

        }
        return xiaoshou_paihang_Item;
    }

    /**
     * 初始化（基本资料）菜单方法
     * */
    public JMenu getJiben_ziliao_Menu() {
        if (jiben_ziliao_Menu == null) {
            jiben_ziliao_Menu = new JMenu();
            jiben_ziliao_Menu.setText("基本资料(B)");
            jiben_ziliao_Menu.setMnemonic(KeyEvent.VK_B);
            jiben_ziliao_Menu.add(getShangpin_guanli_Item());          // 商品管理
            jiben_ziliao_Menu.add(getKehu_guanli_Item());              // 客户管理
            jiben_ziliao_Menu.add(getGys_guanli_Item());               // 供应商管理
            jiben_ziliao_Menu.addSeparator();                          // 添加菜单项中的分隔线
            jiben_ziliao_Menu.add(getJsr_guanli_Item());               // 经手人设置
        }
        return jiben_ziliao_Menu;
    }

    /**
     * 初始化（商品管理）菜单项方法
     * */
    public JMenuItem getShangpin_guanli_Item() {
        if (shangpin_guanli_Item == null) {
            shangpin_guanli_Item = new JMenuItem();
            shangpin_guanli_Item.setText("商品管理");
            shangpin_guanli_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/shangpin_guanli.png")));

        }
        return shangpin_guanli_Item;
    }

    /**
     * 初始化（客户管理）菜单项方法
     * */
    public JMenuItem getKehu_guanli_Item() {
        if (kehu_guanli_Item == null) {
            kehu_guanli_Item = new JMenuItem();
            kehu_guanli_Item.setText("客户管理");
            kehu_guanli_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/kehu_guanli.png")));

        }
        return kehu_guanli_Item;
    }

    /**
     * 初始化（供应商管理）菜单项方法
     * */
    public JMenuItem getGys_guanli_Item() {
        if (gys_guanli_Item == null) {
            gys_guanli_Item = new JMenuItem();
            gys_guanli_Item.setText("供应商管理");
            gys_guanli_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/gys_guanli.png")));

        }
        return gys_guanli_Item;
    }

    /**
     * 初始化（经手人设置）菜单项方法
     * */
    public JMenuItem getJsr_guanli_Item() {
        if (jsr_guanli_Item == null) {
            jsr_guanli_Item = new JMenuItem();
            jsr_guanli_Item.setText("经手人设置");
            jsr_guanli_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/jsr_shezhi.png")));

        }
        return jsr_guanli_Item;
    }

    /**
     * 初始化（系统维护）菜单方法
     * */
    public JMenu getXitong_weihu_Menu() {
        if (xitong_weihu_Menu == null) {
            xitong_weihu_Menu = new JMenu();
            xitong_weihu_Menu.setText("系统维护(S)");
            xitong_weihu_Menu.setMnemonic(KeyEvent.VK_S);
            xitong_weihu_Menu.add(getShuju_beifen_Item());      // 数据备份
            xitong_weihu_Menu.addSeparator();
            xitong_weihu_Menu.add(getMima_xiugai_Item());       // 密码修改
            xitong_weihu_Menu.addSeparator();
            xitong_weihu_Menu.add(getExitItem());               // 退出系统
        }
        return xitong_weihu_Menu;
    }

    /**
     * 初始化（数据库备份与恢复）菜单项方法
     * */
    public JMenuItem getShuju_beifen_Item() {
        if (shuju_beifen_Item == null) {
            shuju_beifen_Item = new JMenuItem();
            shuju_beifen_Item.setText("数据库备份与恢复");
            shuju_beifen_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/shujuku_beifen_huifu.png")));

        }
        return shuju_beifen_Item;
    }

    /**
     * 初始化（密码修改）菜单项方法
     * */
    public JMenuItem getMima_xiugai_Item() {
        if (mima_xiugai_Item == null) {
            mima_xiugai_Item = new JMenuItem();
            mima_xiugai_Item.setText("密码修改");
            mima_xiugai_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/mima_xiugai.png")));

        }
        return mima_xiugai_Item;
    }

    /**
     * 初始化（退出）菜单项方法
     * */
    public JMenuItem getExitItem() {
        if (exitItem == null) {
            exitItem = new JMenuItem();
            exitItem.setText("退出系统");
            exitItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/tuichu_xitong.png")));
            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return exitItem;
    }

    /**
     * 初始化（帮助）菜单方法
     * */
    public JMenu getBangzhu_Menu() {
        if (bangzhu_Menu == null) {
            bangzhu_Menu = new JMenu();
            bangzhu_Menu.setText("帮助(H)");
            bangzhu_Menu.setMnemonic(KeyEvent.VK_H);
            bangzhu_Menu.add(getGys_guanli_Item());         // 关于
            bangzhu_Menu.add(getSupport_Item());            // 联系技术支持
            bangzhu_Menu.add(getJisu_wangzhan_Item());      // 访问技术网站
        }
        return bangzhu_Menu;
    }

    /**
     * 初始化（关于）菜单项方法
     * */
    public JMenuItem getGuanyu_Item() {
        if (guanyu_Item == null) {
            guanyu_Item = new JMenuItem();
            guanyu_Item.setText("关于");
            guanyu_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/guanyu.png")));
            URL url = DesktopPanel.class.getResource("/res/about.jpg");
            ImageIcon aboutImage = new ImageIcon(url);
            final JLabel imgLabel = new JLabel(aboutImage);
            imgLabel.setVisible(false);
            desktopPanel.add(imgLabel);
            desktopPanel.setLayer(imgLabel, Integer.MAX_VALUE);
            guanyu_Item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int dw = desktopPanel.getWidth();
                    int dh = desktopPanel.getHeight();
                    imgLabel.setBounds((dw - 500) / 2, (dh - 350) / 2, 500, 350);
                    imgLabel.setVisible(true);
                }
            });
            imgLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    imgLabel.setVisible(false);
                }
            });
        }
        return guanyu_Item;
    }

    /**
     * 初始化（联系技术支持）菜单项方法
     * */
    public JMenuItem getSupport_Item() {
        if (support_Item == null) {
            support_Item = new JMenuItem();
            support_Item.setText("联系技术支持");
            support_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_zhichi.png")));
            support_Item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 判断当前平台是否支持此类
                    if (Desktop.isDesktopSupported()) {
                        // 获取当前平台桌面实例
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            URI uri = new URI("baidu.com");
                            desktop.mail(uri);
                        } catch (URISyntaxException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });

        }
        return support_Item;
    }

    /**
     * 初始化（访问技术网站）菜单项方法
     * */
    public JMenuItem getJisu_wangzhan_Item() {
        if (jisu_wangzhan_Item == null) {
            jisu_wangzhan_Item = new JMenuItem();
            jisu_wangzhan_Item.setText("访问技术网站");
            jisu_wangzhan_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_wangzhan.png")));
            jisu_wangzhan_Item.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    // 判断当前平台是否支持此类
                    if (Desktop.isDesktopSupported()) {
                        // 获取当前平台桌面实例
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            URL url = new URL("baidu.com");
                            desktop.browse(url.toURI());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return jisu_wangzhan_Item;
    }

    /**
     * 初始化（窗口）菜单的方法
     * */

    public JMenu getChuangkou_Menu() {
        if (chuangkou_Menu == null) {
            chuangkou_Menu = new JMenu();
            chuangkou_Menu.setText("窗口(W)");
            chuangkou_Menu.setMnemonic(KeyEvent.VK_W);
            chuangkou_Menu.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent e) {
                    chuangkou_Menu.removeAll();
                    chuangkou_Menu.add(getPingpu_Item());           // 窗口平铺
                    chuangkou_Menu.add(getCloseAll_Item());         // 全部关闭
                    chuangkou_Menu.add(getAllIcon_Item());          // 全部最小化
                    chuangkou_Menu.add(getAllResume_Item());        // 全部还原
                    chuangkou_Menu.addSeparator();
                    int count = 0;
                    // 获取桌面面板中所有内部窗体
                    JInternalFrame[] allFrames = desktopPanel.getAllFrames();
                    for (final JInternalFrame frame : allFrames) {
                        String frameTitle = frame.getTitle();
                        count++;                    // 窗体计数器
                        // 创建窗体菜单项
                        final JMenuItem item = new JMenuItem(count + " " + frameTitle);
                        chuangkou_Menu.add(item);
                        item.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 处理窗体菜单项的单击事件
                                try {
                                    frame.setIcon(false);
                                    frame.setSelected(true);
                                } catch (PropertyVetoException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        });
                    }
                }

                @Override
                public void menuDeselected(MenuEvent e) {

                }

                @Override
                public void menuCanceled(MenuEvent e) {

                }
            });
        }
        return chuangkou_Menu;
    }

    /**
     * 初始化（窗口平铺）菜单项方法
     * */
    public JMenuItem getPingpu_Item() {
        if (pingpu_Item == null) {
            pingpu_Item = new JMenuItem();
            pingpu_Item.setText("窗口层叠");
            pingpu_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/chuangkou_pingpu.png")));
            pingpu_Item.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktopPanel.getAllFrames();
                    int x = 0, y = 0;
                    for (JInternalFrame iFrame : allFrames) {
                        iFrame.setLocation(x, y);
                        try {
                            // 设置选项可用
                            iFrame.setSelected(true);
                        } catch (PropertyVetoException e1) {
                            e1.printStackTrace();
                        }
                        int frameH = iFrame.getPreferredSize().height;
                        int panelH = iFrame.getContentPane().getPreferredSize().height;
                        int fSpacing = frameH - panelH;
                        x += fSpacing;
                        y += fSpacing;
                        if (x + getWidth() / 2 > desktopPanel.getWidth()) {
                            x = 0;
                        }
                        if (y + getHeight() / 2 > desktopPanel.getHeight()) {
                            y = 0;
                        }
                    }
                }
            });
        }
        return pingpu_Item;
    }

    /**
     * 初始化（全部关闭）菜单项方法
     * */
    public JMenuItem getCloseAll_Item() {
        if (closeAll_Item == null) {
            closeAll_Item = new JMenuItem();
            closeAll_Item.setText("全部关闭");
            closeAll_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_guanbi.png")));
            closeAll_Item.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktopPanel.getAllFrames();
                    for (JInternalFrame frame : allFrames) {
                        frame.doDefaultCloseAction();
                    }
                }
            });
        }
        return closeAll_Item;
    }

    /**
     * 初始化（全部最小化）菜单项方法
     * */
    public JMenuItem getAllIcon_Item() {
        if (allIcon_Item == null) {
            allIcon_Item = new JMenuItem();
            allIcon_Item.setText("全部最小化");
            allIcon_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_zuixiaohua.png")));
            allIcon_Item.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktopPanel.getAllFrames();
                    for (JInternalFrame frame : allFrames) {
                        try {
                            frame.setIcon(true);
                        } catch (PropertyVetoException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return allIcon_Item;
    }

    /**
     * 初始化（全部还原）菜单项方法
     * */
    public JMenuItem getAllResume_Item() {
        if (allResume_Item == null) {
            allResume_Item = new JMenuItem();
            allResume_Item.setText("全部还原");
            allResume_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_huanyuan.png")));
            allResume_Item.addActionListener(new java.awt.event.ActionListener(){
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktopPanel.getAllFrames();
                    for (JInternalFrame frame : allFrames) {
                        try {
                            frame.setIcon(false);
                        } catch (PropertyVetoException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return allResume_Item;
    }

    /**
     * 创建内部窗体的方法，该方法使用反射技术获取内部窗体的构造方法，从而创建内部窗体
     * @param item: 激活该内部窗体的菜单项
     * @param c:    内部窗体的 Class 对象
     * */
    private JInternalFrame createIFrame(JMenuItem item, Class c) {
        Constructor constructor = c.getConstructors()[0];
        JInternalFrame iFrame = iFrames.get(item);
        try {
            if (iFrame == null || iFrame.isClosed()) {
                    iFrame = (JInternalFrame)constructor.newInstance(new Object[] {});
                    iFrames.put(item, iFrame);
                    iFrame.setFrameIcon(item.getIcon());
                    iFrame.setLocation(nextFrameX, nextFrameY);
                    int frameH = iFrame.getPreferredSize().height;
                    int panelH = iFrame.getContentPane().getPreferredSize().height;
                    int fSpacing = frameH - panelH;
                    nextFrameX += fSpacing;
                    nextFrameY += fSpacing;
                    if (nextFrameX + iFrame.getWidth() > desktopPanel.getHeight()) {
                        nextFrameX = 0;
                    }
                    if (nextFrameY + iFrame.getHeight() > desktopPanel.getHeight()) {
                        nextFrameY = 0;
                    }
                    desktopPanel.add(iFrame);
                    iFrame.setResizable(false);
                    iFrame.setMaximizable(false);
                    iFrame.setVisible(true);
                }
            iFrame.setSelected(true);
            stateLabel.setText(iFrame.getTitle());
            iFrame.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameActivated(InternalFrameEvent e) {
                        super.internalFrameActivated(e);
                        JInternalFrame frame = e.getInternalFrame();
                        stateLabel.setText(frame.getTitle());
                    }

                    @Override
                    public void internalFrameDeactivated(InternalFrameEvent e) {
                        stateLabel.setText("没有选择窗体");
                    }
            });
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return iFrame;
    }
}
