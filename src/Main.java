import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    MorseBST arvoreMorse = new MorseBST();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Decodificador Morse");

        // Constrói a árvore com os caracteres padrão
        arvoreMorse.construirArvoreMorse();

        Label label = new Label("Digite o código Morse (ex: .... . .-.. .-.. ---):");
        TextField entrada = new TextField();
        Button btnDecodificar = new Button("Decodificar");
        Button btnVisualizar = new Button("Visualizar Árvore");

        Label resultado = new Label();

        btnDecodificar.setOnAction(e -> {
            String texto = entrada.getText().trim();
            String decodificado = arvoreMorse.decodificarFrase(texto);
            resultado.setText("Texto decodificado: " + decodificado);
        });

        // Corrigido: chama método próprio para abrir a janela sem erro
        btnVisualizar.setOnAction(e -> {
            TreeVisualizer.abrir(); // Correto! Não chama `launch`
        });

        VBox layout = new VBox(10, label, entrada, btnDecodificar, btnVisualizar, resultado);
        Scene cena = new Scene(layout, 400, 250);
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
