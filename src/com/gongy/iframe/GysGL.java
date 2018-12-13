package com.gongy.iframe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 供应商管理内部窗体
 * */
public class GysGL extends JInternalFrame {
    public GysGL() {
        setIconifiable(true);
        setClosable(true);
        setTitle("供应商管理");
        JTabbedPane tabPane = new JTabbedPane();

        getContentPane().add(tabPane);
        tabPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
        pack();
        setVisible(true);
    }

}
