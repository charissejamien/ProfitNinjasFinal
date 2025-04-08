package org.example.TradingPages;

import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SellOrder {

    public SellOrder(JFrame frame, JPanel orderPanel) {

        JLabel orderLabel = new JLabel("Sell Order");
        orderLabel.setBounds(26, 21, 109, 27);
        orderLabel.setFont(new Font("Arial", 1, 22));
        orderLabel.setForeground(Color.white);
        orderPanel.add(orderLabel);

        RoundedButton orderButton = new RoundedButton(20, 1, Color.decode("#141414"));
        orderButton.setBounds(26, 285, 330, 45);
        orderButton.setFocusable(false);
        orderButton.setBackground(Color.decode("#E2464A"));
        orderButton.setLayout(null);
        orderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                orderButton.setBackground(Color.decode("#EE898B"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                orderButton.setBackground(Color.decode("#E2464A"));
            }
        });
        orderPanel.add(orderButton);

        JLabel longLabel = new JLabel("Short (Bearish)");
        longLabel.setBounds(97, 11, 150, 24);
        longLabel.setForeground(Color.white);
        longLabel.setFont(new Font("Arial", Font.BOLD, 20));
        orderButton.add(longLabel);
    }
}
