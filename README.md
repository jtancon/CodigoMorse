
# 🌐 Decodificador de Código Morse - JavaFX

Este projeto é uma aplicação gráfica interativa desenvolvida em Java utilizando JavaFX, que permite **decodificar mensagens em código Morse** e **visualizar graficamente a árvore Morse** binária utilizada no processo.

## 📚 Descrição

A árvore Morse é uma estrutura binária construída com base nas regras do código Morse, onde:
- Um ponto `.` indica uma **ramificação à esquerda**
- Um traço `-` indica uma **ramificação à direita**

Cada letra do alfabeto e número é inserido nessa árvore de acordo com seu código morse, permitindo uma navegação intuitiva para decodificação e codificação.

## 🧠 Funcionalidades

- ✅ Inserção dos caracteres em uma árvore binária segundo o código Morse
- ✅ Decodificação de frases em código Morse para texto comum
- ✅ Visualização gráfica da árvore Morse desenhada com JavaFX
- ✅ Interface amigável com botões, entrada de texto e renderização da árvore

## 📷 Captura de Tela

(screenshot.png)

## 🛠️ Tecnologias Utilizadas

- Java 17+ (ou superior)
- JavaFX 21
- Maven (build e gerenciamento de dependências)

## 📦 Estrutura de Arquivos

src/
├── main/
│   └── java/
│       └── com/joaot/codigomorse/
│           ├── Main.java             # Interface principal com JavaFX
│           ├── MorseBST.java         # Lógica da árvore Morse
│           ├── TreeVisualizer.java   # Renderização da árvore em Canvas
│           └── Node.java             # Estrutura de dados do nó da árvore

## ▶️ Como Executar

### Requisitos
- JDK 17 ou superior
- Maven instalado e configurado

### Passos

1. Clone este repositório:
   git clone https://github.com/seu-usuario/decodificador-morse-javafx.git
   cd decodificador-morse-javafx

2. Compile e execute com Maven:
   mvn clean javafx:run

## 📘 Como Usar

1. Digite um código Morse na entrada (ex: .... . .-.. .-.. ---)
2. Clique em **Decodificar** para ver o texto
3. Clique em **Visualizar Árvore** para desenhar a árvore morse na tela

## 👨‍💻 Autores

- João Victor Monteiro Tancon
- Carlos Eduardo Silva Rosemberg

