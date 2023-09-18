package projetonavinha;

import javax.swing.JFrame;

public class Conteiner extends JFrame {

    public Conteiner() {
        // Adiciona uma instância da classe Fase ao conteiner
        add(new Fase());
        // Define o título da janela
        setTitle("Nave");
        // Define o tamaho da janela
        setSize(700, 700);
        // Define a ação padrão ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Impede que a janela seja redimensionada
        this.setResizable(false);
        // Torna a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        new Conteiner();
    }
}
