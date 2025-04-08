package org.example;

import org.example.Databases.portfolioDatabase;
import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;
import org.example.TradingPages.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;


public class CoinTradingGUI {

    JTextField marginTextfield = new JTextField("Enter");
    JPanel orderPanel = new JPanel();
    static JLabel availableBalance = new JLabel("0.00");

    JLabel value = new JLabel();
    static JLabel estimatedAmount = new JLabel("0.00");

    public CoinTradingGUI(JFrame frame, String coinName, Double coinValue) {

        frame.repaint();
        frame.revalidate();
        orderPanel(frame);
        new BuyOrder(frame, orderPanel);

        ImageIcon logo = new ImageIcon("src/main/java/org/example/Images/Logo2.png");
        JLabel logoImg = new JLabel(logo);
        logoImg.setBounds(75, 34, 220, 38);
        frame.add(logoImg);

        JButton tradeButton = new JButton("Trade");
        JButton marketsButton = new JButton("Markets");
        JButton buyButton = new JButton("Buy");
        tradeButton.setBounds(328, 34, 85, 40);
        tradeButton.setBorder(BorderFactory.createMatteBorder(0,0, 2, 0, Color.decode("#9E23B1")));
        tradeButton.setBackground(Color.decode("#141414"));
        tradeButton.setFont(new Font("Arial", 1, 25));
        tradeButton.setFocusable(false);
        tradeButton.setForeground(Color.white);
        tradeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                tradeButton.setForeground(Color.decode("#E16BF3"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                tradeButton.setForeground(Color.white);
            }
        });
        tradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tradeButton.setBorder(BorderFactory.createMatteBorder(0,0, 2, 0, Color.decode("#9E23B1")));
                marketsButton.setBorder(null);
                buyButton.setBorder(null);
                frame.getContentPane().removeAll();
                new TradingGUI(frame);
                frame.repaint();
                frame.revalidate();

            }
        });
        frame.add(tradeButton);

        marketsButton.setBounds(460, 34, 115, 40);
        marketsButton.setBorder(null);
        marketsButton.setBackground(Color.decode("#141414"));
        marketsButton.setFont(new Font("Arial", 1, 25));
        marketsButton.setFocusable(false);
        marketsButton.setForeground(Color.white);
        marketsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                marketsButton.setForeground(Color.decode("#E16BF3"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                marketsButton.setForeground(Color.white);
            }
        });
        marketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marketsButton.setBorder(BorderFactory.createMatteBorder(0,0, 2, 0, Color.decode("#9E23B1")));
                tradeButton.setBorder(null);
                buyButton.setBorder(null);
                frame.getContentPane().removeAll();
                new MarketsGUI(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(marketsButton);

        buyButton.setBounds(620, 34, 50, 40);
        buyButton.setBorder(null);
        buyButton.setBackground(Color.decode("#141414"));
        buyButton.setFont(new Font("Arial", 1, 25));
        buyButton.setFocusable(false);
        buyButton.setForeground(Color.white);
        buyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                buyButton.setForeground(Color.decode("#E16BF3"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                buyButton.setForeground(Color.white);
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyButton.setBorder(BorderFactory.createMatteBorder(0,0, 2, 0, Color.decode("#9E23B1")));
                tradeButton.setBorder(null);
                marketsButton.setBorder(null);
                frame.getContentPane().removeAll();
                new BuyGUI(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(buyButton);

        JPanel chartPanel = new JPanel();
        chartPanel.setBounds(58, 120, 728, 460);
        chartPanel.setBackground(Color.black);
        frame.add(chartPanel);

        // Create the coin JLabel (coin name)
        JLabel coin = new JLabel();
        coin.setText(coinName); // Assuming coinName is the name of the coin
        coin.setBounds(820, 112, 150, 41);
        coin.setForeground(Color.white);
        coin.setFont(new Font("Arial", 1, 30));
        frame.add(coin);

        // Create the value JLabel to display the formatted coin price
        value = new JLabel();
        value.setText(String.valueOf(coinValue)); // Use the formatted price string
        value.setBounds(820, 162, 200, 41);
        value.setForeground(Color.white);
        value.setFont(new Font("Arial", 1, 50));
        frame.add(value);

        RoundedButton buyOrderButton = new RoundedButton(20, 1, Color.decode("#141414"));
        RoundedButton sellOrderButton = new RoundedButton(20, 1, Color.decode("#141414"));

        JLabel buyOrderLabel = new JLabel("Buy");
        buyOrderLabel.setBounds(80, 10, 40, 27);
        buyOrderLabel.setFont(new Font("Arial", 0, 22));
        buyOrderLabel.setForeground(Color.white);
        buyOrderButton.add(buyOrderLabel);
        buyOrderButton.setBounds(820, 235, 192, 46);
        buyOrderButton.setBackground(Color.decode("#4DBDAA"));
        buyOrderButton.setLayout(null);
        buyOrderButton.setFocusable(false);
        buyOrderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                buyOrderButton.setBackground(Color.decode("#A8DCD3"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                buyOrderButton.setBackground(Color.decode("#4DBDAA"));
            }
        });
        buyOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyOrderButton.setBackground(Color.decode("#4DBDAA"));
                sellOrderButton.setBackground(Color.decode("#141414"));
                orderPanel.removeAll();
                orderPanel(frame);
                new BuyOrder(frame, orderPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(buyOrderButton);

        JLabel sellOrderLabel = new JLabel("Sell");
        sellOrderLabel.setBounds(80, 10, 40, 27);
        sellOrderLabel.setFont(new Font("Arial", 0, 22));
        sellOrderLabel.setForeground(Color.white);
        sellOrderButton.add(sellOrderLabel);
        sellOrderButton.setBounds(1011, 235, 192, 46);
        sellOrderButton.setBackground(Color.decode("#141414"));
        sellOrderButton.setLayout(null);
        sellOrderButton.setFocusable(false);
        sellOrderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                sellOrderButton.setBackground(Color.decode("#EE898B"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                sellOrderButton.setBackground(Color.decode("#E2464A"));
            }
        });
        sellOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellOrderButton.setBackground(Color.decode("#E2464A"));
                buyOrderButton.setBackground(Color.decode("#141414"));
                orderPanel.removeAll();
                orderPanel(frame);
                new SellOrder(frame, orderPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(sellOrderButton);

        // Initialize available balance label
        JLabel availableBalanceLabel = new JLabel("Available balance: ");
        availableBalanceLabel.setBounds(829, 308, 140, 19);
        availableBalanceLabel.setFont(new Font("Arial", 0, 16));
        availableBalanceLabel.setForeground(Color.white);
        frame.add(availableBalanceLabel);

        // Initialize available balance value label
        availableBalance.setBounds(960, 308, 54, 19);
        availableBalance.setFont(new Font("Arial", 1, 16));
        availableBalance.setForeground(Color.white);
        frame.add(availableBalance);


        updateBalanceLabel();
        frame.repaint();
        frame.revalidate();

        new RunningBalances(frame);
        new Positions(frame);
        new TradeHistory(frame);
    }

    public void orderPanel(JFrame frame) {

        orderPanel.setBounds(822, 342, 386, 348);
        orderPanel.setBorder(new RoundedBorder(20, Color.white));
        orderPanel.setBackground(Color.decode("#141414"));
        orderPanel.setLayout(null);
        frame.add(orderPanel);

        JButton marketButton = new JButton("Market");
        JButton triggerButton = new JButton("Trigger");
        marketButton.setBounds(28, 64, 56, 19);
        marketButton.setForeground(Color.white);
        marketButton.setFont(new Font("Arial", 1, 16));
        marketButton.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
        marketButton.setBackground(Color.decode("#141414"));
        marketButton.setFocusable(false);
        marketButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                marketButton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                triggerButton.setForeground(Color.decode("#BFBFB9"));
            }
        });
        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marketButton.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
                marketButton.setForeground(Color.white);
                triggerButton.setBorder(null);
                triggerButton.setForeground(Color.decode("#BFBFB9"));
            }
        });
        orderPanel.add(marketButton);

        triggerButton.setBounds(104, 64, 58, 19);
        triggerButton.setForeground(Color.decode("#BFBFB9"));
        triggerButton.setFont(new Font("Arial", 1, 16));
        triggerButton.setBackground(Color.decode("#141414"));
        triggerButton.setBorder(null);
        triggerButton.setFocusable(false);
        triggerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                triggerButton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                triggerButton.setForeground(Color.decode("#BFBFB9"));
            }
        });
        triggerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triggerButton.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
                triggerButton.setForeground(Color.white);
                marketButton.setBorder(null);
                marketButton.setForeground(Color.decode("#BFBFB9"));

            }
        });
        orderPanel.add(triggerButton);

        JPanel marginPanel = new JPanel();
        marginPanel.setBounds(28, 105, 323, 53);
        marginPanel.setBackground(Color.decode("#222222"));
        marginPanel.setBorder(new RoundedBorder(50, Color.decode("#222222")));
        marginPanel.setLayout(null);
        orderPanel.add(marginPanel);

        JLabel marginLabel1 = new JLabel("Margin");
        marginLabel1.setBounds(13, 5, 39, 15);
        marginLabel1.setFont(new Font("Arial", 0, 12));
        marginLabel1.setForeground(Color.white);
        marginPanel.add(marginLabel1);

        marginTextfield.setBounds(13, 27, 250, 20);
        marginTextfield.setBorder(null);
        marginTextfield.setBackground(Color.decode("#222222"));
        marginTextfield.setForeground(Color.decode("#7A797A"));
        marginTextfield.setFont(new Font("Arial", 0, 12));
        marginTextfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                marginTextfield.setText("");
                marginTextfield.setForeground(Color.white);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                marginTextfield.setText("Enter");
            }
        });

        marginPanel.add(marginTextfield);

        JLabel marginLabel2 = new JLabel("USDT");
        marginLabel2.setBounds(270, 27, 33, 15);
        marginLabel2.setFont(new Font("Arial", 0, 12));
        marginLabel2.setForeground(Color.white);
        marginPanel.add(marginLabel2);

        RoundedButton button1 = new RoundedButton(8, 1, Color.decode("#141414"));
        RoundedButton button2 = new RoundedButton(8, 1, Color.decode("#141414"));
        RoundedButton button3 = new RoundedButton(8, 1, Color.decode("#141414"));
        RoundedButton button4 = new RoundedButton(8, 1, Color.decode("#141414"));

        button1.setBounds(28, 165, 50, 25);
        JLabel buttonLabel1 = new JLabel("25%");
        buttonLabel1.setBounds(17,6, 30, 12);
        buttonLabel1.setFont(new Font("Arial", 0, 11));
        buttonLabel1.setForeground(Color.decode("#7A797A"));
        button1.add(buttonLabel1);
        button1.setBackground(Color.decode("#2B2B2B"));
        button1.setLayout(null);
        button1.setFocusable(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setBackground(Color.white);
                button2.setBackground(Color.decode("#2B2B2B"));
                button3.setBackground(Color.decode("#2B2B2B"));
                button4.setBackground(Color.decode("#2B2B2B"));

                float currentBalance = portfolioDatabase.getTotalBalance();
                float percentageBalance = currentBalance * 0.25f;
                marginTextfield.setText(String.format("%.2f", percentageBalance));
                marginTextfield.setForeground(Color.white);
            }
        });
        orderPanel.add(button1);

        button2.setBounds(83, 165, 50, 25);
        JLabel buttonLabel2 = new JLabel("50%");
        buttonLabel2.setBounds(15,6, 30, 12);
        buttonLabel2.setFont(new Font("Arial", 0, 11));
        buttonLabel2.setForeground(Color.decode("#7A797A"));
        button2.add(buttonLabel2);
        button2.setBackground(Color.decode("#2B2B2B"));
        button2.setLayout(null);
        button2.setFocusable(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setBackground(Color.white);
                button1.setBackground(Color.decode("#2B2B2B"));
                button3.setBackground(Color.decode("#2B2B2B"));
                button4.setBackground(Color.decode("#2B2B2B"));

                float currentBalance = portfolioDatabase.getTotalBalance();
                float percentageBalance = currentBalance * 0.50f;
                marginTextfield.setText(String.format("%.2f", percentageBalance));
                marginTextfield.setForeground(Color.white);
            }
        });

        orderPanel.add(button2);

        button3.setBounds(138, 165, 50, 25);
        JLabel buttonLabel3 = new JLabel("75%");
        buttonLabel3.setBounds(15,6, 30, 12);
        buttonLabel3.setFont(new Font("Arial", 0, 11));
        buttonLabel3.setForeground(Color.decode("#7A797A"));
        button3.add(buttonLabel3);
        button3.setBackground(Color.decode("#2B2B2B"));
        button3.setLayout(null);
        button3.setFocusable(false);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setBackground(Color.white);
                button1.setBackground(Color.decode("#2B2B2B"));
                button2.setBackground(Color.decode("#2B2B2B"));
                button4.setBackground(Color.decode("#2B2B2B"));

                float currentBalance = portfolioDatabase.getTotalBalance();
                float percentageBalance = currentBalance * 0.75f;
                marginTextfield.setText(String.format("%.2f", percentageBalance));
                marginTextfield.setForeground(Color.white);
            }
        });

        orderPanel.add(button3);

        button4.setBounds(193, 165, 50, 25);
        JLabel buttonLabel4 = new JLabel("100%");
        buttonLabel4.setBounds(13,6, 30, 12);
        buttonLabel4.setFont(new Font("Arial", 0, 11));
        buttonLabel4.setForeground(Color.decode("#7A797A"));
        button4.add(buttonLabel4);
        button4.setBackground(Color.decode("#2B2B2B"));
        button4.setLayout(null);
        button4.setFocusable(false);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4.setBackground(Color.white);
                button1.setBackground(Color.decode("#2B2B2B"));
                button2.setBackground(Color.decode("#2B2B2B"));
                button3.setBackground(Color.decode("#2B2B2B"));

                float currentBalance = portfolioDatabase.getTotalBalance();
                float percentageBalance = currentBalance * 1.00f;
                marginTextfield.setText(String.format("%.2f", percentageBalance));
                marginTextfield.setForeground(Color.white);
            }
        });
        orderPanel.add(button4);

        JLabel estimatedAmountLabel = new JLabel("Estimated Amount: ");
        estimatedAmountLabel.setBounds(29, 203, 108, 19);
        estimatedAmountLabel.setFont(new Font("Arial", 0, 12));
        estimatedAmountLabel.setForeground(Color.white);
        orderPanel.add(estimatedAmountLabel);

        estimatedAmount.setBounds(138, 203, 36, 19);
        estimatedAmount.setFont(new Font("Arial", 1, 12));
        estimatedAmount.setForeground(Color.white);
        orderPanel.add(estimatedAmount);

        JLabel takeProfitLabel = new JLabel("Take Profit");
        takeProfitLabel.setBounds(30, 230, 61, 15);
        takeProfitLabel.setFont(new Font("Arial", 0, 12));
        takeProfitLabel.setForeground(Color.white);
        orderPanel.add(takeProfitLabel);

        JLabel stopLossLabel = new JLabel("Stop Loss");
        stopLossLabel.setBounds(30, 249, 61, 15);
        stopLossLabel.setFont(new Font("Arial", 0, 12));
        stopLossLabel.setForeground(Color.white);
        orderPanel.add(stopLossLabel);
    }

    public static void updateBalanceLabel() {
        float currentBalance = portfolioDatabase.getTotalBalance();

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedBalance = decimalFormat.format(currentBalance);

        availableBalance.setText(formattedBalance);
    }
}
