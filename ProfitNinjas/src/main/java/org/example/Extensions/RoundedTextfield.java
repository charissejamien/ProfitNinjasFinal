package org.example.Extensions;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextfield extends JTextField {
    private int round = 25;  // Corner radius for rounding
    private int borderThickness = 2;  // Default border thickness
    private Color borderColor = Color.white;  // Default border color

    // Default constructor
    public RoundedTextfield() {
        setUI(new TextUI());
        setOpaque(false);
        setForeground(new Color(80, 80, 80));
        setSelectedTextColor(Color.WHITE);
        setSelectionColor(new Color(133, 209, 255));
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    // Constructor with border thickness and color
    public RoundedTextfield(int borderThickness, Color borderColor) {
        this();  // Call the default constructor to initialize common properties
        setBorderThickness(borderThickness);
        setBorderColor(borderColor);
    }

    // Getters and setters for border thickness and color
    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    // Getters and setters for corner rounding
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth();
        double height = getHeight();

        // Ensure that the border is drawn first with the desired thickness
        if (borderThickness > 0) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness));
            g2.drawRoundRect(0, 0, getWidth() - borderThickness, getHeight() - borderThickness, round, round);
        }

        // Paint the background with rounding, respecting the border thickness
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(borderThickness, borderThickness, width - 2 * borderThickness, height - 2 * borderThickness, round, round));

        g2.dispose();
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        repaint();
    }

    private class TextUI extends BasicTextFieldUI {
        @Override
        protected void paintBackground(Graphics grphcs) {
            // Do nothing to prevent default background painting
        }
    }
}


