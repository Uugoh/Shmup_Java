package projetonavinha;

/**
 *
 * @author hugop
 */
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Jogador {

    //movimentação
    private int x, y;
    private int dx, dy;

    //imagem
    private Image imagem;

    //colisão
    private int altura, largura;

//Criando uma lista para alocar os tiros que o jogador pode da
    private List<Tiro> tiros;
    private boolean isVisivel;

    public Jogador() {

        //onde o jogador vai começar
        this.x = 350;
        this.y = 350;

        //instanciando o Tiro
        isVisivel = true;

        tiros = new ArrayList<Tiro>();
    }

    //colando a Sprite
    public void load() {
        ImageIcon referencia = new ImageIcon("res\\Navinha.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public void update() {

        //fazer com que a nave se mova 
        x += dx;
        y += dy;
    }

    public void tiroSimples() {

        //posição que o tiro vai surgir
        this.tiros.add(new Tiro(x + (largura / 4), y - (altura / 2)));
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    //Entrada no teclado
    public void KeyPressed(KeyEvent tecla) {

        //para reconhcer a tecla
        int codigo = tecla.getKeyCode();
        if (codigo == KeyEvent.VK_A) {
            ReproduzirSom.playSound("res\\Tiro.wav");
            tiroSimples();
        }

        //controle
        if (codigo == KeyEvent.VK_UP) {
            ImageIcon referencia = new ImageIcon("res\\Navinha 2.png");
            imagem = referencia.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            dy = -3;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            ImageIcon referencia = new ImageIcon("res\\Navinha 2.png");
            imagem = referencia.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            dy = 3;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            ImageIcon referencia = new ImageIcon("res\\Navinha 2.png");
            imagem = referencia.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            dx = 3;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            ImageIcon referencia = new ImageIcon("res\\Navinha 2.png");
            imagem = referencia.getImage();
            altura = imagem.getHeight(null);
            largura = imagem.getWidth(null);
            dx = -3;
        }
    }

    //fazer a nave parar
    public void KeyRelease(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        if (codigo == KeyEvent.VK_UP) {
            ImageIcon referencia = new ImageIcon("res\\Navinha.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
            dy = 0;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            ImageIcon referencia = new ImageIcon("res\\Navinha.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
            dy = 0;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            ImageIcon referencia = new ImageIcon("res\\Navinha.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
            dx = 0;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            ImageIcon referencia = new ImageIcon("res\\Navinha.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getimagem() {
        return imagem;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
}
