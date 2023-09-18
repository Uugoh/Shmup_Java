package projetonavinha;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author hugop
 */
public class Inimigo1 {

    private int x, y;
    private Image Imagem;
    private int largura, altura;
    private boolean isVisivel;

    // Velocidade de movimento do inimigo
    private static final int VELOCIDADE = 2;

    public Inimigo1(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;

    }
    
     // Carrega a imagem do inimigo
    public void load() {
        ImageIcon referencia = new ImageIcon("res\\Inimigos_1.png");
        Imagem = referencia.getImage();
        this.altura = Imagem.getHeight(null);
        this.largura = Imagem.getWidth(null);
    }

    
     // atualizar a posição do inimigo
    public void update() {
        this.y += VELOCIDADE;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        VELOCIDADE = VELOCIDADE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return Imagem;
    }
}
