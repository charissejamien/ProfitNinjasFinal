package org.example.Accounts;

import org.example.Databases.usersDatabase;
import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.TradingGUI;
import org.example.BuyGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpPage {

    public SignUpPage(JFrame frame) {

        frame.repaint();
        frame.revalidate();

        JLabel errorLabel = new JLabel();

        ImageIcon logo = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/Logo.png");
        JLabel logoImg = new JLabel(logo);
        logoImg.setBounds(69, 71, 350, 62);
        frame.add(logoImg);

        JPanel createAccountPanel = new JPanel();
        createAccountPanel.setBounds(89, 187, 495, 561);
        createAccountPanel.setBorder(new RoundedBorder(50, Color.decode("#8769CC")));
        createAccountPanel.setBackground(Color.decode("#8769CC"));
        createAccountPanel.setLayout(null);
        frame.add(createAccountPanel);

        JLabel createAccountLabel = new JLabel("Create an Account");
        createAccountLabel.setBounds(111, 38, 274, 36);
        createAccountLabel.setForeground(Color.white);
        createAccountLabel.setFont(new Font("Arial", 1, 30));
        createAccountPanel.add(createAccountLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(62, 124, 121, 30);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("Arial", 0, 25));
        createAccountPanel.add(usernameLabel);

        RoundedTextfield usernameTextfield = new RoundedTextfield();
        usernameTextfield.setBounds(59, 167, 357, 54);
        usernameTextfield.setBackground(Color.white);
        usernameTextfield.setFont(new Font("Arial", 0, 20));
        createAccountPanel.add(usernameTextfield);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(62, 243, 121, 30);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Arial", 0, 25));
        createAccountPanel.add(passwordLabel);

        JPasswordField passwordTextfield = new JPasswordField();
        passwordTextfield.setBounds(59, 281, 357, 54);
        passwordTextfield.setBackground(Color.white);
        passwordTextfield.setFont(new Font("Arial", 0, 20));
        passwordTextfield.setBorder(new RoundedBorder(20, Color.decode("#8769CC")));
        createAccountPanel.add(passwordTextfield);

        RoundedButton signUpButton = new RoundedButton(20, 2, Color.decode("#8769CC"));
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setBounds(70, 3, 100, 51);
        signUpLabel.setForeground(Color.decode("#141414"));
        signUpLabel.setFont(new Font("Arial", 1, 22));
        signUpButton.add(signUpLabel);
        signUpButton.setBounds(128, 385, 227, 51);
        signUpButton.setBackground(Color.white);
        signUpButton.setFocusable(false);
        signUpButton.setLayout(null);
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                signUpButton.setBackground(Color.decode("#BCBABA"));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                signUpButton.setBackground(Color.white);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextfield.getText();
                String password = new String(passwordTextfield.getPassword());

                if(username.isEmpty() && password.isEmpty()) {
                    errorLabel.setText("Fields cannot be empty");
                    errorLabel.setBounds(140, 348, 219, 18);
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    errorLabel.setForeground(Color.decode("#BC0C02"));
                    createAccountPanel.add(errorLabel);
                    frame.revalidate();
                    frame.repaint();
                    return;

                } else if(username.isEmpty()) {
                    errorLabel.setText("Username cannot be empty");
                    errorLabel.setBounds(140, 348, 219, 18);
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    errorLabel.setForeground(Color.decode("#BC0C02"));
                    createAccountPanel.add(errorLabel);
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                    frame.revalidate();
                    frame.repaint();

                } else if (password.isEmpty()) {
                    errorLabel.setText("Password cannot be empty");
                    errorLabel.setBounds(140, 348, 219, 18);
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    errorLabel.setForeground(Color.decode("#BC0C02"));
                    createAccountPanel.add(errorLabel);
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                    frame.revalidate();
                    frame.repaint();

                } else if(!usersDatabase.isUsernameAvailable(username)){
                    errorLabel.setText("Username already exists.");
                    errorLabel.setBounds(140, 348, 219, 18);
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    errorLabel.setForeground(Color.decode("#BC0C02"));
                    createAccountPanel.add(errorLabel);
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                    frame.revalidate();
                    frame.repaint();
                    return;

                } else {
                    usersDatabase.registerUser(username, password);
                    frame.getContentPane().removeAll();
                    new TradingGUI(frame);
                    frame.repaint();
                    frame.revalidate();
                }

                usernameTextfield.setText("");
                passwordTextfield.setText("");
                frame.revalidate();
                frame.repaint();
            }
        });
        createAccountPanel.add(signUpButton);

        JLabel orLabel = new JLabel("or");
        orLabel.setBounds(228, 463, 20, 24);
        orLabel.setForeground(Color.white);
        orLabel.setFont(new Font("Arial", 0, 20));
        createAccountPanel.add(orLabel);

        JButton line1 = new JButton();
        line1.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
        line1.setBounds(70, 475, 144, 1);
        createAccountPanel.add(line1);

        JButton line2 = new JButton();
        line2.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
        line2.setBounds(262, 475, 144, 1);
        createAccountPanel.add(line2);

        JLabel alreadyhaveLabel = new JLabel("Already have an account?");
        alreadyhaveLabel.setBounds(96, 506, 195, 19);
        alreadyhaveLabel.setForeground(Color.white);
        alreadyhaveLabel.setFont(new Font("Arial", 0, 16));
        createAccountPanel.add(alreadyhaveLabel);

        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(280, 506, 47, 19);
        loginButton.setBorder(null);
        loginButton.setBackground(Color.decode("#8769CC"));
        loginButton.setFont(new Font("Arial", 0, 16));
        loginButton.setForeground(Color.decode("#43ADF9"));
        loginButton.setFocusable(false);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginButton.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.setForeground(Color.decode("#43ADF9"));
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
        createAccountPanel.add(loginButton);

        JLabel starterLabel = new JLabel("Starter Rewards");
        starterLabel.setBounds(702, 182, 397,61);
        starterLabel.setFont(new Font("Arial", 1, 50));
        starterLabel.setForeground(Color.white);
        frame.add(starterLabel);

        JLabel description1 = new JLabel("Get Up to 5,050 USDT When You");
        description1.setBounds(706, 266, 393, 29);
        description1.setFont(new Font("Arial", 0, 24));
        description1.setForeground(Color.white);
        frame.add(description1);

        JLabel description2 = new JLabel("Register, Deposit and Trade!");
        description2.setBounds(706, 295, 331, 37);
        description2.setFont(new Font("Arial", 0, 24));
        description2.setForeground(Color.white);
        frame.add(description2);

        ImageIcon rewards = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/rewards 1 (1).png");
        JLabel rewardsImg = new JLabel(rewards);
        rewardsImg.setBounds(714, 350, 385, 414);
        frame.add(rewardsImg);
    }
}

