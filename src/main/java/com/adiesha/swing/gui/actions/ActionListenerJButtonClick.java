package com.adiesha.swing.gui.actions;

import com.adiesha.swing.App;
import com.adiesha.swing.CheckSumCalculator;
import com.adiesha.swing.workers.CheckSumWorker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

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
        buttonClickTask();
    }

    private void buttonClickTask() {
        final CheckSumWorker checkSumWorker = new CheckSumWorker(checkSumCalculator, 1, App.filePath, outputComparision);
        checkSumWorker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(final PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "progress":
                        break;
                    case "state":
                        switch ((SwingWorker.StateValue) evt.getNewValue()) {
                            case DONE:
                                try {
                                    final byte[] result = checkSumWorker.get();
                                    String hexResult = CheckSumCalculator.parseByteToHexFormat(result);
                                    outputHashLabel.setText(hexResult);
                                    if (hexResult.toLowerCase().equals(expectedHashLabel.getText())) {
                                        outputComparision.setText("CheckSum correct");
                                    } else {
                                        outputComparision.setText("CheckSum incorrect");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case STARTED:
                                System.out.println("SwingWorker doInBackground() method started");
                                break;
                            case PENDING:
                                break;

                        }
                        break;

                }
            }
        });

        if (App.filePath.equals("")) {
            System.err.println("File path empty");
            return;
        }
        checkSumWorker.execute();
    }
}
