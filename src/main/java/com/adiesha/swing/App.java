package com.adiesha.swing;

import com.adiesha.swing.gui.actions.ActionListenerJButtonClick;
import com.adiesha.swing.gui.actions.ActionListenerJFrame;
import com.adiesha.swing.gui.actions.ActionListenerJMenuItemExit;
import com.adiesha.swing.gui.actions.ActionListenerJMenuItemOpen;

import javax.swing.*;
import java.io.IOException;


public class App {
    public static String filePath = "";

    public static void main(String[] args) throws IOException {


        System.out.println("Hello World!");

        JFrame f = new JFrame();
        JMenuBar mb = new JMenuBar();
        JMenu jm = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem exit = new JMenuItem("Exit");
        JLabel filePathLabel = new JLabel("File Path");
        JLabel filePath = new JLabel("E:\\Apps\\datagrip-2017.3.4.exe");
        JLabel expectedHashLabel = new JLabel("Expected Hash");
        JLabel outputHashLabel = new JLabel("Output Hash");
        JLabel outputHash = new JLabel("");
        JTextField hashTextField = new JTextField("a6294bb86eab3418ee8ad5248aaa739661f1535b38e8534220c338ca7735004d");
        JButton jb = new JButton("Calculate");
        JLabel outputComparision = new JLabel("");

        filePathLabel.setBounds(15, 15, 100, 30);
        expectedHashLabel.setBounds(15, 45, 100, 30);
        outputHashLabel.setBounds(15, 75, 100, 30);
        jb.setBounds(15, 105, 90, 30);

        filePath.setBounds(120, 15, 200, 30);
        hashTextField.setBounds(120, 45, 450, 30);
        outputHash.setBounds(120, 75, 450, 30);
        outputComparision.setBounds(120, 105, 300, 30);


        f.add(filePathLabel);
        f.add(filePath);
        f.add(expectedHashLabel);
        f.add(hashTextField);
        f.add(outputHashLabel);
        f.add(outputHash);
        f.add(jb);
        f.add(outputComparision);
        jm.add(open);
        jm.add(exit);
        mb.add(jm);


        jb.addActionListener(new ActionListenerJButtonClick(CheckSumCalculator.getInstance(), outputHash, outputComparision, hashTextField));
        exit.addActionListener(new ActionListenerJMenuItemExit());
        open.addActionListener(new ActionListenerJMenuItemOpen());
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new ActionListenerJFrame(f));
        f.setJMenuBar(mb);

        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
