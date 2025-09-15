package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    private static final int DEFAULT_W = 100;
    private static final int DEFAULT_H = 70;

    private final List<ShapeItem> shapes = new ArrayList<>();

    public DrawingPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                // cor padrão
                Color color = new Color(0x3B82F6); // azul
                shapes.add(new ShapeItem(p.x, p.y, DEFAULT_W, DEFAULT_H, color));
                repaint();
            }
        });
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            for (ShapeItem s : shapes) {
                g2.setColor(s.color());
                g2.fillRect(s.x(), s.y(), s.w(), s.h());

                g2.setColor(new Color(0, 0, 0, 80));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRect(s.x(), s.y(), s.w(), s.h());
            }
        } finally {
            g2.dispose();
        }
    }

    private record ShapeItem(int x, int y, int w, int h, Color color) {}
}
