package org.example;

import org.example.Databases.portfolioDatabase;
import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class BuyGUI {

    RoundedTextfield payTextfield = new RoundedTextfield();
    JLabel usdtAmountLabel = new JLabel();
    JPanel mainPanel = new JPanel();
    RoundedButton checkButton = new RoundedButton(80, 1, Color.decode("#7A797A"));


    public BuyGUI(JFrame frame) {

        frame.repaint();
        frame.revalidate();

        ImageIcon logo = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/Logo2.png");
        JLabel logoImg = new JLabel(logo);
        logoImg.setBounds(75, 34, 220, 38);
        frame.add(logoImg);

        JButton tradeButton = new JButton("Trade");
        JButton marketsButton = new JButton("Markets");
        JButton buyButton = new JButton("Buy");
        tradeButton.setBounds(328, 34, 85, 40);
        tradeButton.setBorder(null);
        tradeButton.setFocusPainted(false);
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
        buyButton.setBorder(BorderFactory.createMatteBorder(0,0, 2, 0, Color.decode("#9E23B1")));
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

        JPanel optionPanel = new JPanel();
        optionPanel.setBounds(80, 150, 165, 37);
        optionPanel.setBackground(Color.decode("#141414"));
        optionPanel.setBorder(new RoundedBorder(20, Color.white));
        optionPanel.setLayout(null);
        frame.add(optionPanel);

        RoundedButton buyButton1 = new RoundedButton(20, 1, Color.decode("#4DBDAA"));
        JLabel buyLabel = new JLabel("Buy");
        buyLabel.setBounds(25, 6, 35, 17);
        buyLabel.setForeground(Color.white);
        buyLabel.setFont(new Font("Arial", 1, 14));
        buyButton1.add(buyLabel);
        buyButton1.setBounds(4,4, 75, 29);
        buyButton1.setBackground(Color.decode("#4DBDAA"));
        buyButton1.setFocusable(false);
        buyButton1.setLayout(null);
        buyButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        optionPanel.add(buyButton1);

        RoundedButton sellButton = new RoundedButton(20, 1, Color.decode("#141414"));
        JLabel sellLabel = new JLabel("Sell");
        sellLabel.setBounds(25, 7, 27, 17);
        sellLabel.setForeground(Color.decode("#7A797A"));
        sellLabel.setFont(new Font("Arial", 0, 14));
        sellButton.add(sellLabel);
        sellButton.setBounds(86,4, 75, 29);
        sellButton.setBackground(Color.decode("#141414"));
        sellButton.setFocusable(false);
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        optionPanel.add(sellButton);

        mainPanel.setBounds(336, 231, 558, 491);
        mainPanel.setBorder(new RoundedBorder(20, Color.decode("#7A797A")));
        mainPanel.setBackground(Color.decode("#141414"));
        mainPanel.setLayout(null);
        frame.add(mainPanel);

        JLabel buyLabel1 = new JLabel("Buy");
        buyLabel1.setBounds(39, 33, 29, 19);
        buyLabel1.setFont(new Font("Arial", 0, 16));
        buyLabel1.setForeground(Color.decode("#209F86"));
        mainPanel.add(buyLabel1);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(72, 33, 39, 19);
        priceLabel.setFont(new Font("Arial", 0, 16));
        priceLabel.setForeground(Color.white);
        mainPanel.add(priceLabel);

        JLabel price = new JLabel("₱57.950");
        price.setBounds(117, 33, 69, 19);
        price.setFont(new Font("Arial", 1, 16));
        price.setForeground(Color.white);
        mainPanel.add(price);

        JLabel payLabel = new JLabel("Pay");
        payLabel.setBounds(39, 86, 28, 19);
        payLabel.setFont(new Font("Arial", 0, 16));
        payLabel.setForeground(Color.decode("#7A797A"));
        mainPanel.add(payLabel);

        ImageIcon php = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/php.png");
        JLabel phpImg = new JLabel(php);
        phpImg.setBounds(375, 12, 50, 20);

        payTextfield.setBounds(39, 111, 449, 45);
        payTextfield.setBackground(Color.decode("#141414"));
        payTextfield.setForeground(Color.white);
        payTextfield.add(phpImg);
        payTextfield.setFont(new Font("Arial", 0, 14));
        payTextfield.setLayout(null);
        payTextfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                computeUsdt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                computeUsdt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                computeUsdt();
            }
        });
        mainPanel.add(payTextfield);

        JLabel receiveLabel = new JLabel("Receive");
        receiveLabel.setBounds(39, 183, 60, 19);
        receiveLabel.setFont(new Font("Arial", 0, 16));
        receiveLabel.setForeground(Color.decode("#7A797A"));
        mainPanel.add(receiveLabel);

        usdtAmountLabel.setBounds(12, 10, 100, 25);
        usdtAmountLabel.setForeground(Color.white);
        usdtAmountLabel.setFont(new Font("Arial", 0, 14));


        ImageIcon usdt = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/usdt.png");
        JLabel usdtImg = new JLabel(usdt);
        usdtImg.setBounds(375, 12, 55, 20);

        JPanel receivePanel = new JPanel();
        receivePanel.setBounds(39, 208, 449, 45);
        receivePanel.setBackground(Color.decode("#141414"));
        receivePanel.setBorder(new RoundedBorder(20, Color.white));
        receivePanel.setForeground(Color.white);
        receivePanel.add(usdtImg);
        receivePanel.setLayout(null);
        receivePanel.add(usdtAmountLabel);
        mainPanel.add(receivePanel);


        JLabel termsLabel1 = new JLabel("The deposited funds can be used for trading within the platform and cannot");
        termsLabel1.setBounds(65, 358, 433, 15);
        termsLabel1.setFont(new Font("Arial", 0, 12));
        termsLabel1.setForeground(Color.decode("#7A797A"));
        mainPanel.add(termsLabel1);

        JLabel termsLabel2 = new JLabel("be withdrawn until after 1 day(s).");
        termsLabel2.setBounds(65, 373, 195, 15);
        termsLabel2.setFont(new Font("Arial", 0, 12));
        termsLabel2.setForeground(Color.decode("#7A797A"));
        mainPanel.add(termsLabel2);

        checkButton.setBounds(39, 360, 17, 17);
        checkButton.setBackground(Color.decode("#141414"));

        final boolean[] isChecked = {false};

        checkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (isChecked[0]) {
                    checkButton.setBackground(Color.decode("#141414"));
                } else {
                    checkButton.setBackground(Color.decode("#43ADF9"));
                }
                isChecked[0] = !isChecked[0];
            }
        });

        mainPanel.add(checkButton);

        RoundedButton cancelButton = new RoundedButton(40, 1, Color.decode("#7A797A"));
        cancelButton.setBounds(39, 414, 138, 36);
        JLabel cancelLabel = new JLabel("Cancel");
        cancelLabel.setBounds(45, 3, 53, 30);
        cancelLabel.setForeground(Color.decode("#7A797A"));
        cancelLabel.setFont(new Font("Arial", 0, 16));
        cancelButton.add(cancelLabel);
        cancelButton.setLayout(null);
        cancelButton.setBackground(Color.decode("#141414"));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cancelButton.setBackground(Color.decode("#464646"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cancelButton.setBackground(Color.decode("#141414"));
            }
        });
        mainPanel.add(cancelButton);

        RoundedButton paymentMethodButton = new RoundedButton(20, 2, Color.decode("#7A797A"));
        paymentMethodButton.setBounds(39, 287, 449, 45);
        JLabel paymentMethodLabel = new JLabel("Select Payment Method");
        paymentMethodLabel.setBounds(10, 12, 100, 25);
        paymentMethodLabel.setForeground(Color.decode("#7A797A"));
        paymentMethodLabel.setFont(new Font("Arial", 0, 14));
        paymentMethodButton.add(paymentMethodLabel);
        paymentMethodButton.setBackground(Color.decode("#141414"));
        mainPanel.add(paymentMethodButton);

        JLabel errorLabel = new JLabel();
        errorLabel.setBounds(200, 165, 127, 15);
        errorLabel.setForeground(Color.decode("#FF0007"));
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        RoundedButton purchaseBuyButton = new RoundedButton(40, 1, Color.decode("#4DBDAA"));
        purchaseBuyButton.setBounds(196, 414, 292, 36);
        JLabel purchaseBuyLabel = new JLabel("Buy USDT");
        purchaseBuyLabel.setBounds(110, 3, 100, 30);
        purchaseBuyLabel.setForeground(Color.black);
        purchaseBuyLabel.setFont(new Font("Arial", 0, 16));
        purchaseBuyButton.add(purchaseBuyLabel);
        purchaseBuyButton.setLayout(null);
        purchaseBuyButton.setBackground(Color.decode("#4DBDAA"));
        purchaseBuyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                purchaseBuyButton.setBackground(Color.decode("#9CDED3"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                purchaseBuyButton.setBackground(Color.decode("#4DBDAA"));
            }
        });
        purchaseBuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String phpText = payTextfield.getText();

                if (isChecked[0]) {
                    try {
                        double phpAmount = Double.parseDouble(phpText);
                        double conversionRate = 57.950;
                        double usdtAmount = phpAmount / conversionRate;

                        portfolioDatabase.addUSDT((float) usdtAmount);

                        mainPanel.removeAll();
                        transactionConfirmed(frame, mainPanel);
                        mainPanel.repaint();
                        mainPanel.revalidate();

                    } catch (NumberFormatException ex) {
                        System.out.println(ex);
                    }
                } else if (payTextfield.getText().isEmpty()) {
                        errorLabel.setText("Field cannot be empty");
                        mainPanel.add(errorLabel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                } else {
                        errorLabel.setText("Please tick the button");
                        mainPanel.add(errorLabel);
                }
            }
        });
        mainPanel.add(purchaseBuyButton);
    }

    public void transactionConfirmed(JFrame frame, JPanel panel) {

        ImageIcon img = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/confirmed.png");
        JLabel confirmedImg = new JLabel(img);
        confirmedImg.setBounds(160, 65, 237, 233);
        panel.add(confirmedImg);

        JLabel label1 = new JLabel("USDT order transaction confirmed and transferred.");
        label1.setBounds(113, 325, 340, 17);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Please check your account");
        label2.setBounds(192, 342, 181, 17);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label2);

        RoundedButton tradeNowButton = new RoundedButton(20, 1, Color.decode("141414"));
        JLabel tradeNowLabel = new JLabel("Trade Now");
        tradeNowLabel.setBounds(88, 8, 130, 27);
        tradeNowLabel.setForeground(Color.white);
        tradeNowLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tradeNowButton.add(tradeNowLabel);
        tradeNowButton.setBounds(136, 378, 292, 44);
        tradeNowButton.setBackground(Color.decode("#8769CC"));
        tradeNowButton.setFocusable(false);
        tradeNowButton.setLayout(null);
        tradeNowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                tradeNowButton.setBackground(Color.decode("#BAA4EE"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                tradeNowButton.setBackground(Color.decode("#8769CC"));
            }
        });
        tradeNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
               new MarketsGUI(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        panel.add(tradeNowButton);
    }

    public void computeUsdt() {
        try {
            String phpText = payTextfield.getText();
            double phpAmount = Double.parseDouble(phpText);
            double conversionRate = 57.950;
            double usdtAmount = phpAmount / conversionRate;

            usdtAmountLabel.setText(String.format("%.2f", usdtAmount));
            usdtAmountLabel.setForeground(Color.white);
        } catch (NumberFormatException e) {
            usdtAmountLabel.setText("Invalid Input");
            usdtAmountLabel.setForeground(Color.decode("#7A797A"));
        }
    }


}
