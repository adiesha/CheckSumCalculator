package com.adiesha.swing;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static java.lang.System.exit;


public class App
{
    public static void main( String[] args ) {
        byte signedByte = -1;
        int unsignedByte =  signedByte & 0xff;

        System.out.println("Signed: " + signedByte + " Unsigned: " + unsignedByte);
        int as = 132;
        byte as2 = (byte) as;
        System.out.println(as2);
        System.out.println( "Hello World!" );
        System.out.println(Integer.toString(-122,16));
        SHA256CheckSumCalculator sha256CheckSumCalculator = new SHA256CheckSumCalculator();
        try {
            sha256CheckSumCalculator.run();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame();


        final JTextField tf = new JTextField();
        tf.setBounds(50,50,150,20);
        JButton jb = new JButton("Click Here");
        jb.setBounds(50,100,95,30);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setVisible(true);
                tf.setText("Button clicked");
            }
        });

        f.add(jb);
        f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        tf.setVisible(false);

    }
}
