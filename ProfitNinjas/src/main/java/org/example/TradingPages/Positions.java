package org.example.TradingPages;

import javax.swing.*;
import java.awt.*;

public class Positions {

    private JLabel coinLabel, positionLabel, marginLabel, pnlLabel;


    public Positions(JFrame frame) {


        JLabel positionsLabel = new JLabel("My Position");
        positionsLabel.setBounds(68, 661, 99, 22);
        positionsLabel.setForeground(Color.white);
        positionsLabel.setFont(new Font("Arial", 0, 18));
        frame.add(positionsLabel);

        JLabel openOrdersLabel = new JLabel("Open Orders");
        openOrdersLabel.setBounds(214, 661, 109, 22);
        openOrdersLabel.setForeground(Color.white);
        openOrdersLabel.setFont(new Font("Arial", 0, 18));
        frame.add(openOrdersLabel);

        JLabel line = new JLabel();
        line.setBounds(58, 690, 733, 1);
        line.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        frame.add(line);

        JLabel coinLabel = new JLabel("Coin");
        coinLabel.setBounds(71, 705, 31, 17);
        coinLabel.setForeground(Color.white);
        coinLabel.setFont(new Font("Arial", 0, 14));
        frame.add(coinLabel);

        JLabel marginLabel = new JLabel("Margin");
        marginLabel.setBounds(163, 705, 46, 17);
        marginLabel.setForeground(Color.white);
        marginLabel.setFont(new Font("Arial", 0, 14));
        frame.add(marginLabel);

        JLabel pnlLabel = new JLabel("PnL");
        pnlLabel.setBounds(265, 705, 45, 17);
        pnlLabel.setForeground(Color.white);
        pnlLabel.setFont(new Font("Arial", 0, 14));
        frame.add(pnlLabel);

        //Sample Trade
        JLabel coin = new JLabel();
        coin.setBounds(72, 733, 40, 17);
        coin.setFont(new Font("Arial", Font.PLAIN, 14));
        coin.setForeground(Color.white);
        frame.add(coin);

        JLabel position = new JLabel();
        position.setBounds(72, 751, 26, 13);
        position.setForeground(Color.decode("#209F86"));
        position.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(position);

        JLabel margin = new JLabel();
        margin.setBounds(165, 740, 57, 13);
        margin.setFont(new Font("Arial", Font.PLAIN, 11));
        margin.setForeground(Color.white);
        frame.add(margin);

        JLabel pnl = new JLabel();
        pnl.setBounds(266, 740, 29, 13);
        pnl.setForeground(Color.decode("#D63127"));
        pnl.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(pnl);
    }

    public void updatePosition(String coin, float margin, String positionType) {
        coinLabel.setText(coin);
        marginLabel.setText(margin + " USDT");
        positionLabel.setText(positionType);
        pnlLabel.setText("0.00"); // or calculate later
    }
}
