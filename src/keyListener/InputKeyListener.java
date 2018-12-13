package keyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 输入键监听类继承键盘监听事件
 * */
public class InputKeyListener extends KeyAdapter{
    public void keyTyped(KeyEvent e) {
        String key = "-0123456789" + (char)8;       // 定义通过键盘可以输入的按键
        if (key.indexOf(e.getKeyChar()) < 0) {      // 当前按下的按键没有在 key 列表里
            e.consume();                            // 销毁没有在 key 列表里的按键
        }
    }
}
