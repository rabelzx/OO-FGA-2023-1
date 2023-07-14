package trabalhoOO;


import javax.swing.*;
import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private int capacidade;
    private float valCon;
    private Horario abrir;
    private Horario fechar;
    ArrayList<Acesso> acessos = new ArrayList<>();
    ArrayList<Evento> eventos = new ArrayList<>();
    private Valores valores;


    public Estacionamento() {} //Padrão

    public Estacionamento(String nome, int capacidade, Horario abrir,Horario fechar, float valCon) throws ValorAcessoInvalidoException {
    	if(capacidade <= 0 || valCon <= 0) {
    		throw new ValorAcessoInvalidoException(); 
    	}
   
        this.capacidade = capacidade;
        this.abrir = abrir;
        this.fechar = fechar;
        this.valCon = valCon;
        this.nome = nome;

    }
    
   //Cadastro de Acessos
    public void cadastrarAcesso(String placa, Boolean mensalista,Data dtEntrada, Data dtSaida, Horario entrada, Horario saida) {
        if (mensalista) {
            acessos.add(new AcessoMensalista(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        } else if (acessoEvento(eventos, dtEntrada)) {
            acessos.add(new AcessoEvento(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        } else if (Horario.diferencaMinutos(entrada, saida) > 540 || ((entrada.getHora() >= fechar.getHora() && entrada.getMinuto() >= fechar.getMinuto())
                    && (saida.getHora() <= abrir.getHora() && saida.getMinuto() <= abrir.getMinuto()))){
            acessos.add(new AcessoDiaria(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        } else if (Horario.diferencaMinutos(entrada,saida) > 0 &&  Horario.diferencaMinutos(entrada,saida) < 60){
            acessos.add(new AcessoFracaoHora(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        }else {
            acessos.add(new AcessoHoraCheia(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar));
        }

    //Apaga acesssos já feitos
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
    //Cadastra os preços do estacionamento
    public void cadastrarValores(float fracao, float desNoturno, float desHora, float diurna, float mensalidade, float evento) throws ValorAcessoInvalidoException {
    	if (fracao <= 0 || diurna <= 0 || desNoturno <= 0 || mensalidade <= 0 || evento <= 0 || desHora <= 0) {
    	    throw new ValorAcessoInvalidoException(); 
    	}
    	
        float descontoHora = desHora / 100; 
        float descontoNoturno = desNoturno / 100;
     
        valores = new Valores(fracao, diurna, descontoNoturno, mensalidade, evento, valCon, descontoHora);
    }
    
    //Cadastra os eventos que vão ocorrer
    public void cadastrarEvento(String nome, Data dataInicio, Data dataFim, Horario horaInicio, Horario horaFim){
        eventos.add(new Evento(nome,dataInicio,dataFim,horaInicio,horaFim));
    }


    //Calcula o retorno do contratante
    public float calcRetorno() {

        float retorno = 0;
        ArrayList<String> placas = new ArrayList<>();




        for (int i = 0; i < acessos.size(); i++) {
            if (acessos.get(i).getClass() == AcessoMensalista.class) {
                if (placas.equals(acessos.get(i).getPlaca())) ;
                else {
                    AcessoMensalista mensal = (AcessoMensalista) acessos.get(i);
                    retorno += mensal.calcPrice(abrir, fechar, valores);

                }
            } else{
                retorno += acessos.get(i).calcPrice(abrir, fechar, valores);

            }
        }

        //Contabiliza os mensalistas
        for (int j = 0; j < placas.size(); j++) {//Vai fazer o codigo abaixo para cada placa mensalista
            ArrayList<Data> verificadas = new ArrayList<>();//Datas que já foram verificadas

            for (int i = 0; i < acessos.size(); i++) { //Passa pelo vetor de acesso
                if (placas.get(j) == acessos.get(i).getPlaca()) {//Verifica se o acesso possui a placa mensalista

                //===========================================================================================================
                    //Preenche os intervalos caso o acesso tenha sido feito por um tempo maior que 1 mes.
                    //O acesso mensalista por si só já calcula o preço certo caso ele tenha passado mais de um mês
                    //estacionado. No entanto, a Array de verificadas não sabe disso, portanto essa parte do código é
                    //para não serem contabilizados o mesmo mês para uma mesma placa mais de uma vez

                    for (int k = 0; k < verificadas.size(); k++) {//Varre o vetor das Verificadas
                        int anosPassados=0,mes = acessos.get(i).getDtEntrada().getMes();

                        do {
                            mes++;
                            if (acessos.get(i).getDtEntrada().compararMesAno(acessos.get(i).getDtSaida())){
                                break;//Quebra o Do While caso a entrada e saida tenha sido feito no mesmo mês
                            }
                            else if (mes > 12) {      //Em caso de virada de ano
                                anosPassados++;       //Aumenta a quantidade de anos que se passaram
                                mes -= 12;            //Reseta o contador do Mês
                                verificadas.add(new Data(1, mes, acessos.get(i).getDtEntrada().getAno()+anosPassados, false));
                            }
                            else {
                                verificadas.add(new Data(1, mes, acessos.get(i).getDtEntrada().getAno()+anosPassados, false));
                            }
                        }while (mes != acessos.get(i).getDtSaida().getMes());
                    }
                //===========================================================================================================

                    for (int k = 0; k < verificadas.size(); k++) {                           //Varre o vetor das Verificadas
                        if (verificadas.get(k).compararMesAno(acessos.get(i).getDtEntrada()))//Compara mês e ano das datas já verificadas com a atual
                        {}                                                                   //se o Mês já recebeu acesso nada acontece

                        else {                                                           //Se o mês não recebeu acesso
                            retorno += acessos.get(i).calcPrice(abrir, fechar, valores); //Soma o valor ao montante
                            verificadas.add(acessos.get(i).getDtEntrada());              //E adiciona a data deste acesso às datas verificadas
                        }

                    }

                }
            }

        }

        return retorno*valCon;}
     //Verifica se um acesso é do tipo Eventos
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
    //====================================================================================
    //Sets e Gets
    //====================================================================================
    void setCapacidade(int capacidade){this.capacidade = capacidade;}

    void setNome(String nome){this.nome = nome;}

    void setAbrir(Horario abrir){this.abrir = abrir;}

    void setFechar(Horario fechar){this.fechar = fechar;}

    void  setValCon(float valCon){this.valCon = valCon;}

    void setValores(Valores valores){this.valores = valores;}

    String getNome(){return nome;}

    Horario getAbrir(){return abrir;}

    Horario getFechar(){return fechar;}

    int getCapacidade(){return capacidade;}

    Valores getValores(){return valores;}

}

