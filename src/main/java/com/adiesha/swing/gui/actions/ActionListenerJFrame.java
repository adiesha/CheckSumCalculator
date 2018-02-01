package com.adiesha.swing.gui.actions;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActionListenerJFrame extends WindowAdapter {
    private JFrame jf;

    public ActionListenerJFrame(JFrame jFrame) {
        this.jf = jFrame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(jf, "Are you sure to close this window?", "Really closing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
