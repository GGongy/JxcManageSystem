package com.gongy.iframe.gysgl;

import javax.swing.*;
import java.awt.*;

public class AddGysPanel extends JPanel{

    private JTextField EMailF;      // “电子信箱”文本框
    private JTextField bankF;       // “开户银行”文本框
    private JTextField lxrTelF;     // “联系人电话”文本框
    private JTextField lxrF;        // “联系人”文本框
    private JTextField czF;         // “传真”文本框
    private JTextField telF;        // “电话”文本框
    private JTextField addressF;    // “地址”文本框
    private JTextField codingF;     // “邮政编码”文本框
    private JTextField jcF;         // “简称”文本框
    private JTextField qcF;         // “供应商全称”文本框
    private JButton resetButton;    // “重置”文本框

    // 添加供应商面板
    public AddGysPanel() {
        setLayout(new GridLayout());    // 设置供应商添加面板的布局为网格布局
        setBounds(10, 10, 510, 302);    // 设置供应商添加面板的位置与宽高

        setupComponet(new JLabel("供应商全称："), 0, 0, 1, 1, false);
        qcF = new JTextField();
        setupComponet(qcF, 1, 0, 3, 400, true);

        setupComponet(new JLabel("简称："), 0, 1, 1, 1, false);
        jcF = new JTextField();
        setupComponet(jcF, 1, 1, 1, 160, false);

        setupComponet(new JLabel("邮政编码："), 2, 1, 1, 1, false);
        codingF = new JTextField();
        setupComponet(codingF, 3, 1, 1, 0, true);



    }

    /**
     * 设置组件的位置并添加到容器中
     * */
    private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
        final GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = gridx;
        grid.gridy = gridy;
        grid.insets = new Insets(5, 1, 3, 1);
        if (gridwidth > 1) {
            grid.gridwidth = gridwidth;
        }
        if (ipadx > 0) {
            grid.ipadx = ipadx;
        }
        if (fill) {
            grid.fill = GridBagConstraints.HORIZONTAL;
        }
        add(component,grid);
    }

}
