package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MarketsGUI {

    private JFrame frame;
    private JPanel marketsPanel;
    private JScrollPane scrollPane;
    private JScrollBar verticalScrollBar;
    private int tileHeight = 100;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1); // Two threads


    public MarketsGUI(JFrame frame) {
        this.frame = frame;
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
                tradeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#9E23B1")));
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
        marketsButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#9E23B1")));
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
                marketsButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#9E23B1")));
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
                buyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#9E23B1")));
                tradeButton.setBorder(null);
                marketsButton.setBorder(null);
                frame.getContentPane().removeAll();
                new BuyGUI(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(buyButton);

        JLabel marketLabel = new JLabel("Markets");
        marketLabel.setBounds(78, 108, 166, 39);
        marketLabel.setFont(new Font("Arial", Font.BOLD, 40));
        marketLabel.setForeground(Color.white);
        frame.add(marketLabel);

        JLabel coinLabel = new JLabel("Coin");
        coinLabel.setBounds(114, 196, 80, 24);
        coinLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        coinLabel.setForeground(Color.white);
        frame.add(coinLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(312, 196, 59, 24);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        priceLabel.setForeground(Color.white);
        frame.add(priceLabel);

        JLabel changeLabel = new JLabel("24h Change");
        changeLabel.setBounds(481, 196, 140, 24);
        changeLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        changeLabel.setForeground(Color.white);
        frame.add(changeLabel);

        JLabel highLabel = new JLabel("24h High");
        highLabel.setBounds(683, 196, 106, 24);
        highLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        highLabel.setForeground(Color.white);
        frame.add(highLabel);

        JLabel lowLabel = new JLabel("24h Low");
        lowLabel.setBounds(843, 196, 106, 24);
        lowLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        lowLabel.setForeground(Color.white);
        frame.add(lowLabel);

        JLabel marketCapLabel = new JLabel("Market Cap");
        marketCapLabel.setBounds(998, 193, 133, 24);
        marketCapLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        marketCapLabel.setForeground(Color.white);
        frame.add(marketCapLabel);

        JButton line1 = new JButton();
        line1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        line1.setBounds(56, 237, 1117, 1);
        frame.add(line1);

        // Create the markets panel where the coin details will be added
        marketsPanel = new JPanel();
        marketsPanel.setBounds(61, 251, 1110, 535);
        marketsPanel.setBackground(Color.decode("#141414"));
        marketsPanel.setLayout(null);
        marketsPanel.setBorder(BorderFactory.createEmptyBorder());

        scrollPane = new JScrollPane(marketsPanel);
        scrollPane.setBounds(61, 251, 1110, 535);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(tileHeight);

        startCoinDataUpdate();
    }


    private void startCoinDataUpdate() {
        executor.scheduleAtFixedRate(() -> {
            List<API.Coin> coins = API.getCoins();
            SwingUtilities.invokeLater(() -> displayCoins(coins));
        }, 0, 10, TimeUnit.SECONDS);
    }

    private static String formatMarketCap(double marketCap) {
        DecimalFormat df = new DecimalFormat("#.##");

        if (marketCap >= 1_000_000_000_000L) {
            return df.format(marketCap / 1_000_000_000_000L) + "T";
        } else if (marketCap >= 1_000_000_000) {
            return df.format(marketCap / 1_000_000_000) + "B";
        } else if (marketCap >= 1_000_000) {
            return df.format(marketCap / 1_000_000) + "M";
        } else {
            return df.format(marketCap);
        }
    }

    private void displayCoins(List<API.Coin> coins) {
        marketsPanel.removeAll();

        int yPosition = 10;

        for (API.Coin coin : coins) {
            JButton coinPanel = new JButton();
            coinPanel.setBounds(0, yPosition, 1110, 100);
            coinPanel.setLayout(null);
            coinPanel.setBackground(Color.decode("#141414"));
            coinPanel.setBorder(BorderFactory.createEmptyBorder());
            coinPanel.setFocusable(false);
            coinPanel.setFocusPainted(false);
            coinPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    new CoinTradingGUI(frame, coin.name, coin.price);
                    frame.repaint();
                    frame.revalidate();
                }
            });

            ImageIcon coinImage = new ImageIcon(new ImageIcon(coin.imageUrl).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            JLabel imageLabel = new JLabel(coinImage);
            imageLabel.setBounds(20, 29, 38, 39);
            coinPanel.add(imageLabel);

            JLabel nameLabel = new JLabel(coin.name);
            nameLabel.setBounds(48, 20, 150, 29);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
            nameLabel.setForeground(Color.white);
            coinPanel.add(nameLabel);

            JLabel symbolLabel = new JLabel(coin.symbol);
            symbolLabel.setBounds(49, 46, 110, 29);
            symbolLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            symbolLabel.setForeground(Color.white);
            coinPanel.add(symbolLabel);

            JLabel priceUsdLabel = new JLabel(String.format("%.2f", coin.price));
            priceUsdLabel.setBounds(230, 19, 113, 29);
            priceUsdLabel.setFont(new Font("Arial", Font.BOLD, 22));
            priceUsdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            priceUsdLabel.setForeground(Color.white);
            coinPanel.add(priceUsdLabel);

            JLabel changeLabel = new JLabel(String.format("%.2f", coin.priceChangePercentage) + "%");
            changeLabel.setBounds(452, 34, 71, 29);
            changeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            changeLabel.setForeground(coin.priceChange >= 0 ? Color.green : Color.red);
            coinPanel.add(changeLabel);

            JLabel lowLabel = new JLabel(String.format("%.2f", coin.low));
            lowLabel.setBounds(785, 34, 150, 29);
            lowLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            lowLabel.setForeground(Color.white);
            coinPanel.add(lowLabel);

            JLabel highLabel = new JLabel(String.format("%.2f", coin.high));
            highLabel.setBounds(619, 34, 150, 29);
            highLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            highLabel.setForeground(Color.white);
            coinPanel.add(highLabel);

            JLabel marketCapLabel = new JLabel(formatMarketCap(coin.marketCap));
            marketCapLabel.setBounds(970, 34, 90, 29);
            marketCapLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            marketCapLabel.setForeground(Color.white);
            marketCapLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            coinPanel.add(marketCapLabel);

            marketsPanel.add(coinPanel);

            yPosition += 90;
        }

        marketsPanel.setPreferredSize(new Dimension(1110, yPosition));

        frame.revalidate();
        frame.repaint();
    }
}
