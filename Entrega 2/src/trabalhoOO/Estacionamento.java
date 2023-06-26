package trabalhoOO;


import javax.swing.*;
import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private int capacidade;
    private float valCon;
    private float retornoCon = calcRetorno();
    private Horario abrir;
    private Horario fechar;
    ArrayList<Acesso> acessos = new ArrayList<>();
    private Valores valores;

    private int quantidade_Acessos=0;

    public Estacionamento() {} //Padrão

    public Estacionamento(String nome, int capacidade, Horario abrir,Horario fechar, float valCon) {

        this.capacidade = capacidade;
        this.abrir = abrir;
        this.fechar = fechar;
        this.valCon = valCon;
        this.nome = nome;

    }

    public void cadastrarAcesso(String placa, Boolean mensalista,Data data, Horario entrada, Horario saida) {
        if (mensalista) {
            acessos.set(quantidade_Acessos,
                    new AcessoMensalista(placa, entrada, saida, data, valores, abrir, fechar));
        }

        quantidade_Acessos++;

    }

    public void cadastrarValores(float fracao, int desNoturno,int desHora, float diurna, float mensalidade, float evento){
        float descontoHora = desHora/100, descontoNoturno = desNoturno/100;
        valores = new Valores(fracao,diurna,descontoNoturno,mensalidade,evento,retornoCon,descontoHora);
    }

    //Calcula o retorno do contratante
    public float calcRetorno() {
        int retorno = 0;
            for (int i = 0; i < acessos.size(); i++){

            }
        
        return retorno * valCon;}


    //====================================================================================
    //Sets e Gets
    //====================================================================================
    void setCapacidade(int capacidade){this.capacidade = capacidade;}

    void setNome(String nome){this.nome = nome;}

    void setAbrir(Horario abrir){this.abrir = abrir;}

    void setFechar(Horario fechar){this.fechar = fechar;}

    void  setValCon(float valCon){this.valCon = valCon;}

    String getNome(){return nome;}

    Horario getAbrir(){return abrir;}

    Horario getFechar(){return fechar;}

    int getCapacidade(){return capacidade;}

}

