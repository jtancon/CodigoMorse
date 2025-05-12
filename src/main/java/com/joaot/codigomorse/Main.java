package com.joaot.codigomorse;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    MorseBST arvoreMorse = new MorseBST();
    Label resultado = new Label();
    Canvas canvas = new Canvas(1200, 400);

    @Override
    public void start(Stage stage) {
        stage.setTitle("🌐 Decodificador e Codificador Morse");

        // Header azul com imagem
        ImageView logo = new ImageView();
        InputStream iconStream = getClass().getClassLoader().getResourceAsStream("icons/icon.png");
        if (iconStream != null) {
            logo.setImage(new Image(iconStream));
            logo.setFitHeight(100);
            logo.setPreserveRatio(true);
        }

        VBox header = new VBox(logo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #0A1536;");

        // Inputs
        Label labelMorse = new Label("Digite o código morse:");
        labelMorse.setFont(Font.font("Arial", 14));
        TextField entradaMorse = new TextField();

        Label labelTexto = new Label("Digite o texto para converter em Morse:");
        labelTexto.setFont(Font.font("Arial", 14));
        TextField entradaTexto = new TextField();

        resultado.setTextFill(Color.web("#0A1536"));
        resultado.setFont(Font.font("Arial", 14));

        // Botões
        Button btnDecodificar = new Button("Decodificar");
        Button btnCodificar = new Button("Codificar");
        Button btnVisualizar = new Button("Visualizar Árvore");

        for (Button btn : new Button[]{btnDecodificar, btnCodificar, btnVisualizar}) {
            btn.setStyle("-fx-background-color: #0A1536; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20;");
            btn.setMaxWidth(200);
        }

        btnDecodificar.setOnAction(e -> {
            String texto = entradaMorse.getText().trim();
            String decodificado = arvoreMorse.decodificarFrase(texto);
            resultado.setText("Resultado: " + decodificado);
        });

        btnCodificar.setOnAction(e -> {
            String texto = entradaTexto.getText().trim();
            String codificado = arvoreMorse.codificarTexto(texto);
            resultado.setText("Resultado: " + codificado);
        });

        btnVisualizar.setOnAction(e -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            TreeVisualizer.desenhar(gc, arvoreMorse.root, canvas.getWidth() / 2, 20, canvas.getWidth() / 4);
        });

        VBox formulario = new VBox(15,
                labelMorse, entradaMorse,
                labelTexto, entradaTexto,
                btnDecodificar, btnCodificar, btnVisualizar,
                resultado, canvas
        );
        formulario.setAlignment(Pos.CENTER);
        formulario.setPadding(new Insets(30));

        // Layout final
        VBox layout = new VBox(header, formulario);
        layout.setStyle("-fx-background-color: white;");
        layout.setAlignment(Pos.TOP_CENTER);

        Scene cena = new Scene(new StackPane(layout), 1000, 700);
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
