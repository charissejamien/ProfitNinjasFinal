package org.example.Accounts;

import org.example.Databases.usersDatabase;
import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.MarketsGUI;
import org.example.TradingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignInPage {

    public SignInPage(JFrame frame) {

        frame.repaint();
        frame.revalidate();

        JLabel errorLabel = new JLabel();

        ImageIcon logo = new ImageIcon("ProfitNinjas/src/main/java/org/example/Images/Logo.png");
        JLabel logoImg = new JLabel(logo);
        logoImg.setBounds(69, 71, 350, 62);
        frame.add(logoImg);

        JLabel buySellLabel = new JLabel("Buy, Sell &");
        buySellLabel.setBounds(90, 241, 300, 61);
        buySellLabel.setForeground(Color.white);
        buySellLabel.setFont(new Font("Arial", 1, 50));
        frame.add(buySellLabel);

        JLabel exchangeDigitalLabel = new JLabel("Exchange Digital");
        exchangeDigitalLabel.setBounds(90, 302, 410, 61);
        exchangeDigitalLabel.setForeground(Color.white);
        exchangeDigitalLabel.setFont(new Font("Arial", 1, 50));
        frame.add(exchangeDigitalLabel);

        JLabel currenciesLabel = new JLabel("Currencies");
        currenciesLabel.setBounds(90, 363, 271, 61);
        currenciesLabel.setForeground(Color.white);
        currenciesLabel.setFont(new Font("Arial", 1, 50));
        frame.add(currenciesLabel);

        JLabel description1 = new JLabel("Seamlessly trade digital assets with");
        description1.setBounds(90, 437, 352, 24);
        description1.setForeground(Color.white);
        description1.setFont(new Font("Arial", 0, 20));
        frame.add(description1);

        JLabel description2 = new JLabel("confidence. Buy, sell, and exchange ");
        description2.setBounds(90, 461, 353, 24);
        description2.setForeground(Color.white);
        description2.setFont(new Font("Arial", 0, 20));
        frame.add(description2);

        JLabel description3 = new JLabel("cryptocurrencies on a secure and user-friendly ");
        description3.setBounds(90, 485, 446, 24);
        description3.setForeground(Color.white);
        description3.setFont(new Font("Arial", 0, 20));
        frame.add(description3);

        JLabel description4 = new JLabel("platform. Start your journey today!");
        description4.setBounds(90, 509, 338, 24);
        description4.setForeground(Color.white);
        description4.setFont(new Font("Arial", 0, 20));
        frame.add(description4);

        JPanel signInPanel = new JPanel();
        signInPanel.setBounds(652, 179, 495, 561);
        signInPanel.setBorder(new RoundedBorder(50, Color.decode("#B596FC")));
        signInPanel.setBackground(Color.decode("#141414"));
        signInPanel.setLayout(null);
        frame.add(signInPanel);

        JLabel signInLabel = new JLabel("Sign In");
        signInLabel.setBounds(198, 39, 110, 36);
        signInLabel.setForeground(Color.white);
        signInLabel.setFont(new Font("Arial", 1, 30));
        signInPanel.add(signInLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(62, 124, 121, 30);
        usernameLabel.setForeground(Color.decode("#B596FC"));
        usernameLabel.setFont(new Font("Arial", 0, 25));
        signInPanel.add(usernameLabel);

        RoundedTextfield usernameTextfield = new RoundedTextfield();
        usernameTextfield.setBounds(59, 167, 357, 54);
        usernameTextfield.setBackground(Color.decode("#141414"));
        usernameTextfield.setFont(new Font("Arial", 0, 20));
        usernameTextfield.setForeground(Color.white);
        signInPanel.add(usernameTextfield);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(62, 243, 116, 30);
        passwordLabel.setForeground(Color.decode("#B596FC"));
        passwordLabel.setFont(new Font("Arial", 0, 25));
        signInPanel.add(passwordLabel);

        JPasswordField passwordTextfield = new JPasswordField();
        passwordTextfield.setBounds(59, 281, 357, 54);
        passwordTextfield.setBackground(Color.decode("#141414"));
        passwordTextfield.setFont(new Font("Arial", 0, 20));
        passwordTextfield.setBorder(new RoundedBorder(20, Color.white));
        passwordTextfield.setForeground(Color.white);
        signInPanel.add(passwordTextfield);

        RoundedButton loginButton = new RoundedButton(20, 2, Color.decode("#141414"));
        loginButton.setLayout(null);
        JLabel login = new JLabel("Login");
        login.setBounds(85, 10, 70,30);
        login.setFont(new Font("Arial", 1, 22));
        login.setForeground(Color.white);
        loginButton.add(login);
        loginButton.setBounds(128, 385, 227, 51);
        loginButton.setBackground(Color.decode("#9853ED"));
        loginButton.setFocusable(false);
        loginButton.setLayout(null);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginButton.setBackground(Color.decode("#DBC8F1"));
                login.setForeground(Color.decode("#141414"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.setBackground(Color.decode("#9853ED"));
                login.setForeground(Color.white);

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput = usernameTextfield.getText();
                String passwordInput = new String(passwordTextfield.getPassword());

                boolean authenticate = usersDatabase.authenticateUser(usernameInput, passwordInput);

                if (usernameInput.isEmpty() && passwordInput.isEmpty()){
                    errorLabel.setText("Username and Password cannot be empty");
                    errorLabel.setBounds(120, 348, 500, 18);
                    errorLabel.setForeground(Color.decode("#FF4035"));
                    errorLabel.setVerticalTextPosition(SwingConstants.CENTER);
                    errorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                } else if(usernameInput.isEmpty()) {
                    errorLabel.setText("Username cannot be empty");
                    errorLabel.setBounds(128, 348, 500, 18);
                    errorLabel.setForeground(Color.decode("#FF4035"));
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                } else if (passwordInput.isEmpty()) {
                    errorLabel.setText("Password cannot be empty");
                    errorLabel.setBounds(128, 348, 500, 18);
                    errorLabel.setForeground(Color.decode("#FF4035"));
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                } else if (authenticate) {
                    frame.getContentPane().removeAll();
                    new MarketsGUI(frame);
                    frame.repaint();
                    frame.revalidate();
                } else {
                    errorLabel.setText("Invalid username or password");
                    errorLabel.setBounds(128, 348, 500, 18);
                    errorLabel.setForeground(Color.decode("#FF4035"));
                    errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    usernameTextfield.setText("");
                    passwordTextfield.setText("");
                }
            }
        });
        signInPanel.add(errorLabel);
        signInPanel.add(loginButton);

        JLabel orLabel = new JLabel("or");
        orLabel.setBounds(228, 463, 20, 24);
        orLabel.setForeground(Color.white);
        orLabel.setFont(new Font("Arial", 0, 20));
        signInPanel.add(orLabel);

        JButton createAccountButton = new JButton("Create an Account");
        createAccountButton.setBounds(173, 505, 141, 19);
        createAccountButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        createAccountButton.setBackground(Color.decode("#141414"));
        createAccountButton.setFont(new Font("Arial", 0, 16));
        createAccountButton.setForeground(Color.white);
        createAccountButton.setFocusable(false);
        createAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                createAccountButton.setForeground(Color.blue);
                createAccountButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                createAccountButton.setForeground(Color.white);
                createAccountButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new SignUpPage(frame);
                frame.repaint();
                frame.revalidate();
            }
        });
        signInPanel.add(createAccountButton);

        JButton line1 = new JButton();
        line1.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
        line1.setBounds(70, 475, 144, 1);
        signInPanel.add(line1);

        JButton line2 = new JButton();
        line2.setBorder(BorderFactory.createMatteBorder(0,0,1, 0, Color.white));
        line2.setBounds(262, 475, 144, 1);
        signInPanel.add(line2);
    }
}
