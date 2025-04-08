package org.example.TradingPages;

import javax.swing.*;
import java.awt.*;

public class RunningBalances {

    public RunningBalances(JFrame frame) {

        JLabel equityLabel = new JLabel("Equity");
        equityLabel.setBounds(67, 603, 30, 13);
        equityLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#BFBFB9")));
        equityLabel.setForeground(Color.decode("#BFBFB9"));
        equityLabel.setFont(new Font("Arial", 0, 10));
        frame.add(equityLabel);

        JLabel equity= new JLabel("0.00");
        equity.setBounds(67, 620, 19, 11);
        equity.setForeground(Color.white);
        equity.setFont(new Font("Arial", 0, 9));
        frame.add(equity);

        JLabel accountBalanceLabel = new JLabel("Account Balance");
        accountBalanceLabel.setBounds(131, 603, 85, 13);
        accountBalanceLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#BFBFB9")));
        accountBalanceLabel.setForeground(Color.decode("#BFBFB9"));
        accountBalanceLabel.setFont(new Font("Arial", 0, 10));
        frame.add(accountBalanceLabel);

        JLabel accountBalance= new JLabel("0.00");
        accountBalance.setBounds(131, 620, 19, 11);
        accountBalance.setForeground(Color.white);
        accountBalance.setFont(new Font("Arial", 0, 9));
        frame.add(accountBalance);

        JLabel unrealizedPnlLabel = new JLabel("Unrealized PnL");
        unrealizedPnlLabel.setBounds(240, 603, 73, 13);
        unrealizedPnlLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#BFBFB9")));
        unrealizedPnlLabel.setForeground(Color.decode("#BFBFB9"));
        unrealizedPnlLabel.setFont(new Font("Arial", 0, 10));
        frame.add(unrealizedPnlLabel);

        JLabel unrealizedPnl= new JLabel("0.00");
        unrealizedPnl.setBounds(240, 620, 19, 11);
        unrealizedPnl.setForeground(Color.white);
        unrealizedPnl.setFont(new Font("Arial", 0, 9));
        frame.add(unrealizedPnl);

        JLabel availMarginLabel = new JLabel("Avail. Margin");
        availMarginLabel.setBounds(341, 603, 64, 13);
        availMarginLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#BFBFB9")));
        availMarginLabel.setForeground(Color.decode("#BFBFB9"));
        availMarginLabel.setFont(new Font("Arial", 0, 10));
        frame.add(availMarginLabel);

        JLabel availMargin= new JLabel("0.00");
        availMargin.setBounds(341, 620, 19, 11);
        availMargin.setForeground(Color.white);
        availMargin.setFont(new Font("Arial", 0, 9));
        frame.add(availMargin);
    }
}
