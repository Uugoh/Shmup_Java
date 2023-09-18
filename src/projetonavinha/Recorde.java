package projetonavinha;

import java.util.Stack;

/**
 *
 * @author hugop
 */
public class Recorde {

    private String nome;
    // Pilha de pontos acumulados
    private Stack<Integer> pontos;

    // Recorde mais alto alcançado
    private int recordeMaior;

    public Recorde() {
        pontos = new Stack<>();
        recordeMaior = 200;
        nome = "";
    }

    public void adicionarPontos(int quantidade) {
        pontos.push(quantidade);
        if (quantidade > recordeMaior) {
            recordeMaior = quantidade;
        }
    }

    public void zerarPontos() {
        pontos.clear();
    }

    public int getPontos() {
        int total = 0;
        for (int ponto : pontos) {
            total += ponto;
        }
        return total;
    }

    public int getRecordeMaisAlto() {
        return recordeMaior;
    }

    public void setNome(String nome) {

        if (nome.length() > 3) {

            this.nome = nome.substring(0, 3);
        } else {
            this.nome = nome;
        }
    }

    public String getNome() {
        return nome;
    }
}
