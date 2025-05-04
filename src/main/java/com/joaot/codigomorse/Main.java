package com.joaot.codigomorse;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    MorseBST arvoreMorse = new MorseBST();
    Label resultado = new Label();
    Canvas canvas = new Canvas(1200, 800);

    @Override
    public void start(Stage stage) {
        stage.setTitle("🌐 Decodificador Morse");

        Label label = new Label("Digite o código Morse (ex: .... . .-.. .-.. ---):");
        label.setFont(Font.font("Arial", 14));

        TextField entrada = new TextField();
        entrada.setFont(Font.font("Arial", 14));

        Button btnDecodificar = new Button("🔍 Decodificar");
        Button btnVisualizar = new Button("🌳 Visualizar Árvore");

        btnDecodificar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 8;");
        btnVisualizar.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-background-radius: 8;");

        resultado.setFont(Font.font("Consolas", 14));
        resultado.setTextFill(Color.DARKBLUE);

        btnDecodificar.setOnAction(e -> {
            String texto = entrada.getText().trim();
            String decodificado = arvoreMorse.decodificarFrase(texto);
            resultado.setText("Texto decodificado: " + decodificado);
        });

        btnVisualizar.setOnAction(e -> desenharArvore());

        VBox entradaBox = new VBox(10, label, entrada, btnDecodificar, btnVisualizar, resultado);
        entradaBox.setAlignment(Pos.CENTER_LEFT);
        entradaBox.setPadding(new Insets(10));
        entradaBox.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #cccccc; -fx-border-width: 1;");

        VBox layout = new VBox(20, entradaBox, canvas);
        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-background-color: #ffffff;");

        Scene cena = new Scene(layout, 1280, 900);
        stage.setScene(cena);
        stage.show();
    }

    private void desenharArvore() {
        TreeVisualizer.desenhar(canvas.getGraphicsContext2D(), arvoreMorse.root, canvas.getWidth() / 2, 20, canvas.getWidth() / 4);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
