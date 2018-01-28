package com.adiesha.swing;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class App
{
    public static void main( String[] args ) throws IOException {

        System.out.println( "Hello World!" );

        JFrame f = new JFrame();
        JButton jb = new JButton("Click Here");
        jb.setBounds(50,100,95,30);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckSumCalculator checkSumCalculator = CheckSumCalculator.getInstance();
                byte[] result = null;
                try {
                    result = checkSumCalculator.calculate(1,"E:\\Apps\\datagrip-2017.3.4.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                CheckSumCalculator.parseByteToHexFormat(result);
            }
        });

        f.add(jb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
