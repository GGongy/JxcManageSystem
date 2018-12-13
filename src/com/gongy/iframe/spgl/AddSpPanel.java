package com.gongy.iframe.spgl;

import com.gongy.Item;
import com.gongy.dao.Dao;
import com.gongy.dao.model.TbSpinfo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddSpPanel extends JPanel {

    private JComboBox gysqc;        // “供应商全称”下拉列表
    private JTextField beizhu;      // “备注”文本框
    private JTextField pzwn;        // “批准文号”文本框
    private JTextField pihao;       // “批号”文本框
    private JTextField baozhuang;   // “包装”文本框
    private JTextField guige;       // “规格”文本框
    private JTextField danwei;      // “单位”文本框
    private JTextField chandi;      // “产地”文本框
    private JTextField jc;          // “简称”文本框
    private JTextField spmc;        // “商品名称”文本框
    private JButton resetButton;    // “重制”按钮

    // 商品添加模板
    public AddSpPanel() {
        setLayout(new GridLayout());
        setBounds(10,10,550,400);
        setupComponent(new JLabel("商品名称："), 0, 0, 1, 1, false);     // 设置”商品名称“标签位置并添加到容器
        spmc = new JTextField();        // ”商品名称“对话框
        setupComponent(spmc, 1, 0, 3, 1, true);     // 设置”商品名称“文本框位置并添加到容器

        setupComponent(new JLabel("简称："), 0, 0, 1, 1, false);
        jc = new JTextField();
        setupComponent(jc, 1, 1, 3, 10, true);

        setupComponent(new JLabel("产地："), 0, 2, 1, 1, false);
        chandi = new JTextField();
        setupComponent(chandi, 1,2, 3, 300, true);

        setupComponent(new JLabel("单位："), 0, 3, 1, 1, false);
        danwei = new JTextField();
        setupComponent(danwei, 1, 3, 1, 130, true);

        setupComponent(new JLabel("规格："), 2, 3, 1, 1, false);
        guige = new JTextField();
        setupComponent(guige, 3, 3, 1, 1, true);

        setupComponent(new JLabel("包装："), 0, 4, 1, 1, false);
        baozhuang = new JTextField();
        setupComponent(baozhuang, 1, 4, 1, 1, true);

        setupComponent(new JLabel("批号："), 2, 4, 1, 1, false);
        pihao = new JTextField();
        setupComponent(pihao, 3, 4, 1, 1, true);

        setupComponent(new JLabel("批准文号："), 0, 5, 1, 1, false);
        pzwn = new JTextField();
        setupComponent(pzwn, 1, 5, 3, 1, true);

        setupComponent(new JLabel("供应商全称："), 0, 6, 1, 1, false);
        gysqc = new JComboBox();        // 下拉列表
        gysqc.setMaximumRowCount(5);    // 下拉列表显示最大行数
        setupComponent(gysqc, 1, 6, 3, 1, true);

        setupComponent(new JLabel("备注："), 0, 7, 1, 1, false);
        beizhu = new JTextField();
        setupComponent(beizhu, 1, 7, 3, 1, true);

        final JButton addButton = new JButton();        // “添加”按钮
        // 为“添加”按钮添加动作监听事件
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (spmc.getText().equals("") || jc.getText().equals("") || chandi.getText().equals("") ||
                        danwei.getText().equals("") || guige.getText().equals("") || baozhuang.getText().equals("")
                        || pihao.getText().equals("") || pzwn.getText().equals("")) {
                    JOptionPane.showMessageDialog(AddSpPanel.this, "请填写未完成信息", "商品添加", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // 执行 sql 查询语句获得结果集
                ResultSet rs = Dao.query("select * from tb_spinfo where spname='" + spmc.getText().trim() + "'");
                try {
                    if (rs.next()) {
                        System.out.println("Error");
                        JOptionPane.showMessageDialog(AddSpPanel.this, "添加失败，存在相同商品", "客户添加信息", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                ResultSet maxid = Dao.query("select max(id) from tb_spinfo");
                String id = null;
                try {
                    if (maxid != null && maxid.next()) {
                        String sid = maxid.getString(1);
                        if (sid == null) {
                            id = "sp0001";
                        } else {
                            String str = sid.substring(2);
                            id = "sp" + (Integer.parseInt(str) + 1);
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                TbSpinfo spinfo = new TbSpinfo();
                spinfo.setId(id);
                spinfo.setSpname(spmc.getText().trim());
                spinfo.setJc(jc.getText().trim());
                spinfo.setCd(chandi.getText().trim());
                spinfo.setDw(danwei.getText().trim());
                spinfo.setGg(guige.getText().trim());
                spinfo.setBz(baozhuang.getText().trim());
                spinfo.setPh(pihao.getText().trim());
                spinfo.setPzwh(pzwn.getText().trim());
                spinfo.setGysname(gysqc.getSelectedItem().toString().trim());
                spinfo.setBz(beizhu.getText().trim());
                Dao.addSp(spinfo);
                JOptionPane.showMessageDialog(AddSpPanel.this, "添加成功", "商品添加", JOptionPane.ERROR_MESSAGE);
                resetButton.doClick();
            }
        });
        addButton.setText("添加");
        setupComponent(addButton, 1, 8, 1, 1, false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 65, 0, 15);
        gbc.gridx = 1;
        gbc.gridy = 8;
        resetButton = new JButton();
        setupComponent(resetButton, 3, 8, 1, 1, false);
        // “重置”按钮添加监听事件
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                spmc.setText("");
                jc.setText("");
                chandi.setText("");
                danwei.setText("");
                guige.setText("");
                baozhuang.setText("");
                pihao.setText("");
                pzwn.setText("");
                beizhu.setText("");
            }
        });
        resetButton.setText("重置");
    }

    // 设置组件的位置并添加到容器里
    private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
        final GridBagConstraints gbc = new GridBagConstraints();    // 创建网格限制对象
        gbc.gridx = gridx;      // 设置组件位于网格的横向索引为 dridx
        gbc.gridy = gridy;      // 设置组件位于网格的纵向索引为 dridy
        gbc.insets = new Insets(5,1,3,1);   // 组件彼此的间距
        if (gridwidth > 1) {
            gbc.gridwidth = gridwidth;
        }
        if (ipadx < 0) {
            gbc.ipadx = ipadx;
        }
        if (fill) {
            gbc.fill = GridBagConstraints.HORIZONTAL;
        }
        add(component, gbc);
    }

    // 初始化供应商下拉选择框
    public void initGysBox() {
        List gysInfo = Dao.getGysInfos();
        List<Item> items = new ArrayList<>();
        gysqc.removeAllItems();
        for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {
            List element = (List)iter.next();
            Item item = new Item();
            item.setId(element.get(0).toString().trim());
            item.setName(element.get(1).toString().trim());
            if (items.contains(item)) {
                continue;
            }
            items.add(item);
            gysqc.addItem(item);
        }

    }

}
