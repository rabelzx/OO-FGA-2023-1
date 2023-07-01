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
    public void apagarAcesso(){
        if (this.acessos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há acessos cadastrados para serem apagados.");
        } else {
            StringBuilder mensagemAcessos = new StringBuilder("Acessos cadastrados:\n");
            for (int i = 0; i < this.acessos.size(); i++) {
                mensagemAcessos.append(i).append(". ").append(this.acessos.get(i).getPlaca()).append("\n");
            }
            int escolhaAcessos = Integer.parseInt(JOptionPane.showInputDialog(null, mensagemAcessos.toString(), "Apagar Acesso", JOptionPane.PLAIN_MESSAGE));

            if (escolhaAcessos >= 0 && escolhaAcessos < this.acessos.size()) {
                this.acessos.remove(escolhaAcessos);
                JOptionPane.showMessageDialog(null, "Acesso apagado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
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
        ArrayList<String> placas = new ArrayList<>();
           for (int i = 0; i < acessos.size(); i++){
                if (acessos.get(i).getClass() == AcessoMensalista.class){
                    if (placas.equals(acessos.get(i).getPlaca()));
                    else{placas.add(acessos.get(i).getPlaca());}
                }
                else{retorno += acessos.get(i).calcPrice(abrir,fechar,valores);}
           }
        //Contabiliza os mensalistas
            for (int j = 0; j < placas.size(); j++){//Vai fazer o codigo abaixo para cada placa mensalista
                ArrayList<Data> verificadas = new ArrayList<>();//Datas que já foram verificadas

                for (int i = 0; i < acessos.size(); i++){ //Passa pelo vetor de acesso
                    if (placas.get(j) == acessos.get(i).getPlaca()){//Verifica se o acesso possui a placa mensalista

                        for (int k = 0; k < verificadas.size(); k++)//Varre o vetor das Verificadas
                            if (verificadas.get(k).compararMesAno(acessos.get(i).getDtEntrada())){}//se o Mês já recebeu acesso
                            else{//Se o mês não recebeu acesso
                                retorno += acessos.get(i).calcPrice(abrir,fechar,valores);//Soma o valor ao montante
                                verificadas.add(acessos.get(i).getDtEntrada());// e adiciona a data deste acesso as datas verificadas
                            }

                    }
                }
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

