package com.adiesha.swing.gui.actions;

import com.adiesha.swing.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ActionListenerJMenuItemOpen implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser("E:\\Apps\\datagrip-2017.3.4.exe");
        int i = jfc.showOpenDialog((Component) e.getSource());
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            String filePath = f.getPath();
            System.out.println("File path: " + filePath);
            App.filePath = filePath;
        }
    }
}
