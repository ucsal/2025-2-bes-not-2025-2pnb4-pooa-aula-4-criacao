package br.com.mariojp.figureeditor;

import java.awt.*;

public class AddShapeCommand implements Command{
    private final DrawingPanel panel;
    private final Shape shape;

    public AddShapeCommand(DrawingPanel panel, Shape shape){
        this.panel = panel;
        this.shape = shape;
    }
    @Override
    public void execute() {
        panel.addShape(shape);
    }

    @Override
    public void undo() {
        panel.removeShape(shape);
    }
}
