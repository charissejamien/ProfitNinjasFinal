package org.example.Extensions;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private int round = 25;  // Default round corner radius
    private int borderThickness = 2;  // Default border thickness
    private Color borderColor = Color.BLACK;  // Default border color

    // Constructor to allow customization via user input
    public RoundedButton(int round, int borderThickness, Color borderColor) {
        this.round = round;
        this.borderThickness = borderThickness;
        this.borderColor = borderColor;

        // Set basic button appearance
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusable(true);
    }

    // Getters and setters for round corner radius
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();  // Repaint after change
    }

    // Getters and setters for border thickness
    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();  // Repaint after change
    }

    // Getters and setters for border color
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();  // Repaint after change
    }

    // Override paintComponent to draw the button with rounded corners and border
    @Override
    protected void paintComponent(Graphics g) {
        // Create a Graphics2D object to allow advanced rendering
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the button with rounded corners
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);

        // Draw the border if border thickness is set
        if (borderThickness > 0) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, round, round);
        }

        // Paint the text
        super.paintComponent(g2);

        g2.dispose();
    }

    // Override setBounds to ensure correct painting when the button is resized
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        repaint();  // Repaint after size change
    }
}
