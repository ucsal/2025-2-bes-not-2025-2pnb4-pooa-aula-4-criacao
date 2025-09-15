package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::createAndShow);
    }

    private static void createAndShow() {
        setSystemLookAndFeel();

        JFrame frame = new JFrame("Figure Editor (clique para inserir)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawing = new DrawingPanel();
        frame.setContentPane(drawing);

        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
    }
}
