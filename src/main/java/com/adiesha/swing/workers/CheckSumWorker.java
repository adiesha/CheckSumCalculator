package com.adiesha.swing.workers;

import com.adiesha.swing.CheckSumCalculator;

import javax.swing.*;
import java.util.List;

public class CheckSumWorker extends SwingWorker<byte[], String> {
    CheckSumCalculator checkSumCalculator;
    int algoID;
    String filePath;
    JLabel outputComparision;

    public CheckSumWorker(CheckSumCalculator checkSumCalculator, int algoID, String filePath, JLabel outputComparision) {
        this.checkSumCalculator = checkSumCalculator;
        this.algoID = algoID;
        this.filePath = filePath;
        this.outputComparision = outputComparision;
    }

    @Override
    protected byte[] doInBackground() throws Exception {
        publish("Started calculating checkSum");
        byte[] result = checkSumCalculator.calculate(algoID, filePath);
        publish("Finished calculating checksum");
        return result;
    }

    @Override
    protected void process(final List<String> chunks) {
        outputComparision.setText(chunks.get(chunks.size() - 1));
    }


}
