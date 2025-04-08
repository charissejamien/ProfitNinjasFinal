package org.example.Accounts;

import org.example.Extensions.RoundedButton;
import org.example.MarketsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage {

    public HomePage(JFrame frame) {

        frame.setSize(1250, 850);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.decode("#141414"));

        ImageIcon logo = new ImageIcon("src/main/java/org/example/Images/Logo.png");
        JLabel logoImg = new JLabel(logo);
        logoImg.setBounds(69, 71, 350, 62);
        frame.add(logoImg);

        ImageIcon arrow = new ImageIcon("src/main/java/org/example/Images/ArrowWhite.png");
        JLabel arrowImg = new JLabel(arrow);
        arrowImg.setBounds(82, 1, 50, 50);

        ImageIcon purpleArrow1 = new ImageIcon("src/main/java/org/example/Images/ArrowPurple.png");
        JLabel purple = new JLabel(purpleArrow1);
        purple.setBounds(82, 1, 50, 50);

        RoundedButton loginButton = new RoundedButton(25, 2, Color.decode("#141414"));
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(40, 12, 100, 27);
        loginLabel.setFont(new Font("Arial", 1, 20));
        loginLabel.setForeground(Color.white);
        loginButton.add(arrowImg);
        loginButton.add(loginLabel);
        loginButton.setBounds(811, 71, 155, 51);
        loginButton.setBackground(Color.decode("#141414"));
        loginButton.setFocusable(false);
        loginButton.setLayout(null);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginButton.add(arrowImg);
                loginLabel.setForeground(Color.decode("#9853ED"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.add(purple);
                loginLabel.setForeground(Color.white);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new SignInPage(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(loginButton);

        ImageIcon arrow1 = new ImageIcon("src/main/java/org/example/Images/ArrowWhite.png");
        JLabel arrowImg1 = new JLabel(arrow1);
        arrowImg1.setBounds(92, 1, 50, 50);

        RoundedButton signupButton = new RoundedButton(25, 2, Color.decode("#141414"));
        JLabel signupLabel = new JLabel("Sign Up");
        signupLabel.setBounds(25, 12, 90, 27);
        signupLabel.setFont(new Font("Arial", 1, 20));
        signupLabel.setForeground(Color.white);
        signupButton.add(arrowImg1);
        signupButton.add(signupLabel);
        signupButton.setBounds(977, 71, 155, 51);
        signupButton.setBackground(Color.decode("#9853ED"));
        signupButton.setFocusable(false);
        signupButton.setLayout(null);
        signupButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                signupButton.setBackground(Color.decode("#A98FC8"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                signupButton.setBackground(Color.decode("#9853ED"));
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new SignUpPage(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(signupButton);

        JLabel worldwideTrading = new JLabel("Worldwide Trading");
        worldwideTrading.setBounds(91, 261, 259, 34);
        worldwideTrading.setFont(new Font("Arial", 1, 28));
        worldwideTrading.setForeground(Color.decode("#B596FC"));
        frame.add(worldwideTrading);

        JLabel nextLevel = new JLabel("Next Level");
        nextLevel.setBounds(91, 295, 428, 96);
        nextLevel.setFont(new Font("Arial", 1, 80));
        nextLevel.setForeground(Color.white);
        frame.add(nextLevel);

        JLabel trading = new JLabel("Trading");
        trading.setBounds(91, 391, 300, 96);
        trading.setFont(new Font("Arial", 1, 80));
        trading.setForeground(Color.white);
        frame.add(trading);

        JLabel description1 = new JLabel("Buy, Trade & Hold Bitcoin, USDT, Shares, Commodities and Other");
        description1.setBounds(91, 499, 635, 30);
        description1.setFont(new Font("Arial", 0, 20));
        description1.setForeground(Color.white);
        frame.add(description1);

        JLabel description2 = new JLabel("100+ Altcoins Using Our Wide Variety Trading Plan.");
        description2.setBounds(91, 529, 635, 30);
        description2.setFont(new Font("Arial", 0, 20));
        description2.setForeground(Color.white);
        frame.add(description2);

        ImageIcon zigzagArrow = new ImageIcon("src/main/java/org/example/Images/Arrow1.png");
        JLabel zigzagArrowImg = new JLabel(zigzagArrow);
        zigzagArrowImg.setBounds(153, 3, 50, 50);

        RoundedButton startTradingButton = new RoundedButton(25, 2, Color.decode("#141414"));
        JLabel startTradingLabel = new JLabel("Start Trading");
        startTradingLabel.setBounds(30, 3, 142, 50);
        startTradingLabel.setFont(new Font("Arial", 1, 20));
        startTradingLabel.setForeground(Color.white);
        startTradingButton.add(zigzagArrowImg);
        startTradingButton.add(startTradingLabel);
        startTradingButton.setLayout(null);
        startTradingButton.setBounds(91, 582, 227, 51);
        startTradingButton.setBackground(Color.decode("#9853ED"));
        startTradingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                startTradingButton.setBackground(Color.decode("#A98FC8"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                startTradingButton.setBackground(Color.decode("#9853ED"));
            }
        });
        startTradingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MarketsGUI(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(startTradingButton);

        ImageIcon purpleArrow = new ImageIcon("src/main/java/org/example/Images/ArrowPurple.png");
        JLabel purpleArrowImg = new JLabel(purpleArrow);
        purpleArrowImg.setBounds(7, 7, 50, 20);

        ImageIcon arrow11 = new ImageIcon("src/main/java/org/example/Images/ArrowWhite.png");
        JLabel arrowImg11 = new JLabel(arrow11);
        arrowImg11.setBounds(7, 7, 50, 20);

        JButton signinButton = new JButton();
        JLabel signinLabel = new JLabel("Sign In");
        signinLabel.setBounds(50, 5, 75, 27);
        signinLabel.setForeground(Color.decode("#9853ED"));
        signinLabel.setFont(new Font("Arial", 1, 20));
        signinButton.add(purpleArrowImg);
        signinButton.add(signinLabel);
        signinButton.setBounds(350, 591, 150, 40);
        signinButton.setBackground(Color.decode("#141414"));
        signinButton.setLayout(null);
        signinButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#9853ED")));
        signinButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                signupButton.add(arrowImg11);
                signinLabel.setForeground(Color.white);
                signinButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                signinButton.add(purpleArrowImg);
                signinLabel.setForeground(Color.decode("#9853ED"));
                signinButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#9853ED")));

            }
        });
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new SignInPage(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        frame.add(signinButton);

        ImageIcon display = new ImageIcon("src/main/java/org/example/Images/img 1 (2).png");
        JLabel displayImg = new JLabel(display);
        displayImg.setBounds(636, 133, 619, 612);
        frame.add(displayImg);

        frame.setVisible(true);

    }
}
