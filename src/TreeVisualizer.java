import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TreeVisualizer {

    public static void abrir() {
        MorseBST morseTree = new MorseBST();
        morseTree.construirArvoreMorse();

        int height = getAltura(morseTree);
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        drawTree(canvas, morseTree);

        Group root = new Group(canvas);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);

        Stage stage = new Stage();
        stage.setTitle("Visualizador de Árvore Morse");
        stage.setScene(scene);
        stage.show();
    }

    private static int getAltura(MorseBST bst) {
        return getAlturaRec(bst.root);
    }

    private static int getAlturaRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getAlturaRec(node.left), getAlturaRec(node.right));
    }

    private static void drawTree(Canvas canvas, MorseBST tree) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        drawNode(gc, tree.root, canvas.getWidth() / 2, 40, canvas.getWidth() / 4);
    }

    private static void drawNode(GraphicsContext gc, Node node, double x, double y, double xOffset) {
        if (node == null) return;

        gc.strokeOval(x - 15, y - 15, 30, 30);
        gc.strokeText(String.valueOf(node.letra), x - 5, y + 5);

        if (node.left != null) {
            double newX = x - xOffset;
            double newY = y + 100;
            gc.strokeLine(x, y + 15, newX, newY - 15);
            drawNode(gc, node.left, newX, newY, xOffset / 2);
        }

        if (node.right != null) {
            double newX = x + xOffset;
            double newY = y + 100;
            gc.strokeLine(x, y + 15, newX, newY - 15);
            drawNode(gc, node.right, newX, newY, xOffset / 2);
        }
    }
}
