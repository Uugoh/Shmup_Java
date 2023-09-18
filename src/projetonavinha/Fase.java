package projetonavinha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hugop
 */
public class Fase extends JPanel implements ActionListener {

    private Image fundo;
    private Jogador jogador;
    private Timer timer;
    private List<Inimigo1> inimigos;
    private boolean emjogo;
    private Recorde recorde;

    public Fase() {
        
        //melhorar o desempenho 
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\cenario_um-1.png.png");
        fundo = referencia.getImage();
        
        //carregar o joagdor na fase
        jogador = new Jogador();
        jogador.load();
        
        //add o teclado na fase
        addKeyListener(new TecladoAdapter());

        //Velocidade do jogo
        timer = new Timer(2, this);
        timer.restart();

        emjogo = true;

        recorde = new Recorde();

        inicializaInimigos();
    }

    public void inicializaInimigos() {
        Random r = new Random();
        Timer timer = new Timer(10000, e -> inicializaInimigos());
        timer.start();
        //vetor para o numero de inimigos que vai ter
        int codernadas[] = new int[10];
        inimigos = new ArrayList<Inimigo1>();

        for (int i = 0; i < codernadas.length; i++) {
            int low = 0;
            int high = 700;
            int x = r.nextInt(high - low) + low;
            int baixo = - 600;
            int alto = 0;
            int y = r.nextInt(alto - baixo) + baixo;
            inimigos.add(new Inimigo1(x, y));
        }
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if (emjogo == true) {
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(jogador.getimagem(), jogador.getX(), jogador.getY(), this);
            List<Tiro> tiros = jogador.getTiros();
            
            // Desenha os tiros do jogador
            for (int i = 0; i < tiros.size(); i++) {
                Tiro m = tiros.get(i);
                m.load();
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
                
                // Desenha a pontuação na tela
                g.setColor(Color.WHITE);
                g.setFont(new Font("Consolas", Font.BOLD, 16));
                String pontosTexto = "Pontuação: " + recorde.getPontos();
                g.drawString(pontosTexto, 10, 20);
                String recordeTexto = "Recorde: " + recorde.getRecordeMaisAlto();
                g.drawString(recordeTexto, 10, 40);
            }
            
            // Desenha os inimigos
            for (int o = 0; o < inimigos.size(); o++) {
                Inimigo1 in = inimigos.get(o);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }

        } else {
            
            //adicionando tela de GameOver
            ImageIcon fimDeJogo = new ImageIcon("res\\GamerOver_1.png");
            graficos.drawImage(fimDeJogo.getImage(), 0, 0, null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //pra ficar redesenhando o sprite do jogador
        jogador.update();
        List<Tiro> tiros = jogador.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            if (m.isVisivel()) {
                m.update();
            } else {
                tiros.remove(i);
            }
        }
        for (int o = 0; o < inimigos.size(); o++) {
            Inimigo1 in = inimigos.get(o);
            if (in.isVisivel()) {
                in.update();
            } else {
                inimigos.remove(o);
            }

        }
        checarColisão();
        repaint();

    }
    
        //Colisão
    public void checarColisão() {
        Rectangle formaNave = jogador.getBounds();
        Rectangle formaInimigo;
        Rectangle formaTiro;
        
        //colisão do jogador com o inimigo
        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo1 tempInimigo1 = inimigos.get(i);
            formaInimigo = tempInimigo1.getBounds();
            if (formaNave.intersects(formaInimigo)) {
                jogador.setVisivel(false);
                tempInimigo1.setVisivel(false);
                emjogo = false;
            }                    
        }
        
        //colisão do tiro com o inimigo
        List<Tiro> tiros = jogador.getTiros();
        for (int j = 0; j < tiros.size(); j++) {
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBounds();
            for (int o = 0; o < inimigos.size(); o++) {
                Inimigo1 tempInimigo1 = inimigos.get(o);
                formaInimigo = tempInimigo1.getBounds();
                if (formaTiro.intersects(formaInimigo)) {
                       ReproduzirSom.playSound("res\\Explosão.wav");
                    int Ponto = 0;
                    Ponto++;
                    recorde.adicionarPontos(Ponto);
                    tempInimigo1.setVisivel(false);
                    tempTiro.setVisivel(false);

                }
            }
        }
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            jogador.KeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            jogador.KeyRelease(e);
        }
    }

}
