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
    ArrayList<Evento> eventos = new ArrayList<>();
    private Valores valores;


    public Estacionamento() {} //Padrão

    public Estacionamento(String nome, int capacidade, Horario abrir,Horario fechar, float valCon) {

        this.capacidade = capacidade;
        this.abrir = abrir;
        this.fechar = fechar;
        this.valCon = valCon;
        this.nome = nome;

    }
    
    public boolean acessoEvento(ArrayList<Evento> eventos, Data dtAcesso){
        
        
        for (Evento event : eventos){
            Data inicioEvento = event.getDtInicio();
            Data fimEvento = event.getDtFim();
            if (dtAcesso.getMes() == inicioEvento.getMes() || dtAcesso.getMes() == fimEvento.getMes()){
                if(dtAcesso.getAno() == inicioEvento.getAno() || dtAcesso.getAno() == fimEvento.getAno()){
                    if (inicioEvento.getMes() != fimEvento.getMes()){
                        if(dtAcesso.getDia() >= inicioEvento.getDia() || dtAcesso.getDia() <= fimEvento.getDia()){
                            return true;
                        }
                    else if(inicioEvento.getMes() == fimEvento.getMes()){
                        if(dtAcesso.getDia() >= inicioEvento.getDia() && dtAcesso.getDia() <= fimEvento.getDia()){
                            return true;
                        }
                    }
                    }
                }
            }
        }
        return false;
    }

    public void cadastrarAcesso(String placa, Boolean mensalista,Data dtEntrada, Data dtSaida, Horario entrada, Horario saida) {
        if (mensalista) {
            acessos.add(new AcessoMensalista(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        } else if (acessoEvento(eventos, dtEntrada)) {
            acessos.add(new AcessoEvento(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        } else if (Horario.diferencaMinutos(entrada, saida) > 540 || ((entrada.getHora() >= fechar.getHora() && entrada.getMinuto() >= fechar.getMinuto())
                    && (saida.getHora() <= abrir.getHora() && saida.getMinuto() <= abrir.getMinuto()))){
            acessos.add(new AcessoDiaria(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        } else{
            acessos.add(new Acesso(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        }



    }

    public void cadastrarValores(float fracao, int desNoturno,int desHora, float diurna, float mensalidade, float evento){
        float descontoHora = desHora/100, descontoNoturno = desNoturno/100;
        valores = new Valores(fracao,diurna,descontoNoturno,mensalidade,evento,retornoCon,descontoHora);
    }

    public void cadastrarEvento(String nome, Data dataInicio, Data dataFim, Horario horaInicio, Horario horaFim){
        eventos.add(new Evento(nome,dataInicio,dataFim,horaInicio,horaFim));
    }


    //Calcula o retorno do contratante
    public float calcRetorno() {
        int retorno = 0;
           // for (int i = 0; i < acessos.size(); i++){

            //}
        
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

