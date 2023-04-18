/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.droneserver;

/**
 *
 * @author Zac
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayUserInterface extends JPanel {

    private Image backgroundImage;

    public DisplayUserInterface() {
        // Load the background image
        backgroundImage = new ImageIcon("background.jpg").getImage();

        // Set the panel size to match the background image size
        setPreferredSize(getBackgroundImageSize());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, null);

        // Draw a blue rectangle on the background image
        g.setColor(Color.BLUE);
        g.fillRect(300, 200, 50, 25);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Drone 02", 300, 210);

        // Draw a blue rectangle on the background image
        g.setColor(Color.BLUE);
        g.fillRect(200, 100, 50, 25);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Drone 01", 200, 110);

        // Draw a red circle with text on the background image
        g.setColor(Color.RED);
        g.fillOval(350, 300, 50, 50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Fire", 355, 330);

        // Draw a blue rectangle on the background image
        g.setColor(Color.BLUE);
        g.fillRect(400, 300, 50, 25);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Drone 03", 400, 310);

    }

    private java.awt.Dimension getBackgroundImageSize() {
        return new java.awt.Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
    }

    public void display() {
        JFrame frame = new JFrame("Display Objects on Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DisplayUserInterface panel = new DisplayUserInterface();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
