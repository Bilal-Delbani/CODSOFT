package Customising;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {
    private Color backgroundColor;
    private Color hoverColor;
    private Color originalColor;

    public CustomButton(String text, Color color, Color hoverColor) {
        super(text);
        this.backgroundColor = color;
        this.hoverColor = hoverColor;
        this.originalColor = color;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(new Color(88,88,88));
        setFont(new Font("Aptos", Font.BOLD, 16));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backgroundColor = hoverColor;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backgroundColor = originalColor;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Create a 3D effect
        g2.setColor(backgroundColor.darker());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

        super.paintComponent(g2);
        g2.dispose();
    }
}
