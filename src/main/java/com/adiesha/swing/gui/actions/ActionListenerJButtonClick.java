package com.adiesha.swing.gui.actions;

import com.adiesha.swing.App;
import com.adiesha.swing.CheckSumCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionListenerJButtonClick implements ActionListener {
    CheckSumCalculator checkSumCalculator;
    public ActionListenerJButtonClick(CheckSumCalculator checkSumCalculator) {
        this.checkSumCalculator = checkSumCalculator;
    }
    public void actionPerformed(ActionEvent e) {
        byte[] result = null;
        try {
            if(App.filePath.equals("")) return ;
            else result = checkSumCalculator.calculate(1, App.filePath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        CheckSumCalculator.parseByteToHexFormat(result);
    }
}
