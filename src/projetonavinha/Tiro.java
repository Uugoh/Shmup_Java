package projetonavinha;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author hugop
 */
public class Tiro {

    private int x, y;
    private Image Imagem;
    private int largura, altura;
    private boolean isVisivel;
    
    //Para o tiro sumir
    private static final int ALTURA = 690;
    
    //velocidade do tiro
    private static final int VELOCIDADE = 2;

    //Fazendo com que o tiro seja visivel e que o x e y dele seja o mesmo do jogador
    public Tiro(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;

    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\Tiro_1.png");
        Imagem = referencia.getImage();
        this.altura = Imagem.getHeight(null);
        this.largura = Imagem.getWidth(null);
    }

    public void update() {
        this.y -= VELOCIDADE;
        if (this.y >= ALTURA) {
            isVisivel = false;
        }
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
