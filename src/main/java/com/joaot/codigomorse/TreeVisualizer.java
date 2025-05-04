package com.joaot.codigomorse;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TreeVisualizer {

    public static void desenhar(GraphicsContext gc, Node root, double x, double y, double offset) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        desenharNo(gc, root, x, y, offset);
    }

    private static void desenharNo(GraphicsContext gc, Node node, double x, double y, double offset) {
        if (node == null) return;

        gc.setFill(Color.BLACK);
        gc.fillOval(x - 15, y - 15, 30, 30);
        gc.setFill(Color.WHITE);
        gc.fillText(String.valueOf(node.letra), x - 4, y + 5);

        if (node.left != null) {
            gc.setStroke(Color.GRAY);
            gc.strokeLine(x, y + 15, x - offset, y + 65);
            desenharNo(gc, node.left, x - offset, y + 65, offset / 2);
        }

        if (node.right != null) {
            gc.setStroke(Color.GRAY);
            gc.strokeLine(x, y + 15, x + offset, y + 65);
            desenharNo(gc, node.right, x + offset, y + 65, offset / 2);
        }
    }
}
