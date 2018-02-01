package com.adiesha.swing.gui.actions;

import com.adiesha.swing.App;
import com.adiesha.swing.CheckSumCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionListenerJButtonClick implements ActionListener {
    JTextField expectedHashLabel;
    CheckSumCalculator checkSumCalculator;
    JLabel outputHashLabel;
    JLabel outputComparision;

    public ActionListenerJButtonClick(CheckSumCalculator checkSumCalculator, JLabel jLabel, JLabel resultLabel, JTextField expectedHashLabel) {
        this.checkSumCalculator = checkSumCalculator;
        this.outputHashLabel = jLabel;
        this.expectedHashLabel = expectedHashLabel;
        this.outputComparision = resultLabel;
    }

    public void actionPerformed(ActionEvent e) {
        byte[] result = null;
        try {
            if (App.filePath.equals("")) return;
            else result = checkSumCalculator.calculate(1, App.filePath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String hexResult = CheckSumCalculator.parseByteToHexFormat(result);
        outputHashLabel.setText(hexResult);

        if (hexResult.toLowerCase().equals(expectedHashLabel.getText())) {
            outputComparision.setText("CheckSum correct");
        } else {
            outputComparision.setText("CheckSum incorrect");
        }
    }
}
