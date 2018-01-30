package com.adiesha.swing.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class ActionListenerJMenuItemExit implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        exit(0);
    }
}
