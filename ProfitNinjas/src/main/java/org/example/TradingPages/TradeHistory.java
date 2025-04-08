package org.example.TradingPages;

import javax.swing.*;
import java.awt.*;

public class TradeHistory {

    public TradeHistory(JFrame frame) {

        JLabel tradeHistoryLabel = new JLabel("Trade History");
        tradeHistoryLabel.setBounds(371, 661, 116, 22);
        tradeHistoryLabel.setForeground(Color.white);
        tradeHistoryLabel.setFont(new Font("Arial", 0, 18));
        frame.add(tradeHistoryLabel);
    }
}
