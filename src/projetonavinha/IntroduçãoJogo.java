package projetonavinha;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hugop
 */
public class IntroduçãoJogo extends JFrame {

    String nomeJogador = obterNomeJogador();
    private JPanel jpanel;
    private StringBuilder texto, texto1, texto2;
    private Timer timer;
    private int indice;
    private Image fundo;

    IntroduçãoJogo() {
        ImageIcon referencia = new ImageIcon("res\\Introdução.png");
        fundo = referencia.getImage();
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jpanel = new JPanel();
        jpanel.setLayout(null);

        String texto = "<html> A solidão e o vazio desse vasto universo<br> agora preenche a sua alma...<br> O vazio também faz parte de você</html>";
        indice = 0;
        JLabel label = new JLabel(texto);
        label.setBounds(200, 150, 360, 260);
        jpanel.add(label);

        getContentPane().add(jpanel);
        setVisible(true);

        Font fontePersonalizada = new Font("Consolas", Font.BOLD, 15);

        label.setFont(fontePersonalizada);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indice < texto.length()) {
                    label.setText(texto.substring(0, indice + 1));
                    indice++;
                } else {
                    timer.stop();
                }
            }
        };

        timer = new Timer(100, actionListener);
        timer.start(); // Inicia o Timer
        try {
            Thread.sleep(15000); // Tempo em milissegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dispose();
        startGame();
        
        

    }
        private String obterNomeJogador() {
        String nome = JOptionPane.showInputDialog(null, "Digite seu nome (3 caracteres):", "Nome do Jogador", JOptionPane.PLAIN_MESSAGE);

        // Verifica se o nome foi digitado
        if (nome == null || nome.trim().isEmpty()) {
            // Nome em branco, define um nome padrão
            nome = "AAA";
        } else {
            // Limita o nome a apenas 3 caracteres
            nome = nome.substring(0, Math.min(nome.length(), 3)).toUpperCase();
        }

        return nome;
    }

    private void startGame() {

        new Conteiner();
    }

    public static void main(String[] args) {

    }
}
