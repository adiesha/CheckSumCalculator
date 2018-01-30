package com.adiesha.swing;

import com.adiesha.swing.gui.actions.ActionListenerJButtonClick;
import com.adiesha.swing.gui.actions.ActionListenerJMenuItemExit;
import com.adiesha.swing.gui.actions.ActionListenerJMenuItemOpen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class App {
    public static String filePath = "";
    public static void main(String[] args) throws IOException {


        System.out.println("Hello World!");

        JFrame f = new JFrame();
        JMenuBar mb = new JMenuBar();
        JMenu jm = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem exit = new JMenuItem("Exit");
        jm.add(open);
        jm.add(exit);
        mb.add(jm);

        JButton jb = new JButton("Calculate");
        jb.setBounds(50, 100, 95, 30);
        jb.addActionListener(new ActionListenerJButtonClick(CheckSumCalculator.getInstance()));
        exit.addActionListener(new ActionListenerJMenuItemExit());
        open.addActionListener(new ActionListenerJMenuItemOpen());
        f.setJMenuBar(mb);
        f.add(jb);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
