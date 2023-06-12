package trabalhoOO;


import javax.swing.*;
import java.util.ArrayList;

public class Estacionamento {
	private int capacidade;
	private float valCon;
	private Horario abrir;
	private Horario fechar;
	ArrayList<Acesso> acessos = new ArrayList<>();
	private Valores valores;

	private int quantidade_Acessos=0;

	public Estacionamento() {} //Padrão
	public Estacionamento(int capacidade, Horario abrir,Horario fechar, float valCon) {
		this.capacidade = capacidade;
		this.abrir = abrir;
		this.fechar = fechar;
		this.valCon = valCon;
	}
	public void cadastrarAcesso(String placa, Boolean evento, Boolean mensalista,Data data, Horario entrada, Horario saida) {
		acessos.set(quantidade_Acessos, new Acesso(placa, evento, mensalista, entrada, saida, data, valores, abrir, fechar));
		quantidade_Acessos++;
	}

	public void cadastrarValores(float fracao,float hora_cheia, int diurnapercent,int noturnapercent, float mensalidade, float evento){
		float diurna = (diurnapercent/100), noturna = (noturnapercent/100);
		valores = new Valores(fracao,hora_cheia,diurna,noturna,mensalidade,evento);
	}
	//Calcula o retorno do contratante
	public float calcRetorno(int contratantePercent) {
		int retorno = 0;
		for (int i = 0; i < quantidade_Acessos; i++) {//Verífica todos os acessos

			if (acessos.get(i).getChkMens()) {//Verifica se o acesso é de uma placa mensalista
				for (int j = 0; j < i; j++) {//Varre o vetor até o ponto que estamos na verificação

					if (acessos.get(i).getPlaca() == acessos.get(j).getPlaca()) { //Verifica se o carro já fez uma acesso no mês
						i++;} //caso ele tenha feito outro acesso no mês ele passa para o próximo no vetor

					else {//Caso contrário ele adiciona o acesso mensal ao montante
						retorno += acessos.get(i).calcPrice(abrir, fechar, valores);}//Adiciona o que o carro pagou ao montante
				}

			}
			else{retorno += acessos.get(i).calcPrice(abrir, fechar, valores);}//Adiciona o que o carro pagou ao montante
		}
		return retorno * valCon;}//Retorna o quanto o contratante recebeu


	//====================================================================================
	//Sets e Gets
	//====================================================================================
	void setCapacidade(int capacidade){
		this.capacidade = capacidade;
	}
	void setAbrir(Horario abrir){
		this.abrir = abrir;
	}
	void setFechar(Horario fechar){this.fechar = fechar;}
	void  setValCon(float valCon){
		this.valCon = valCon;
	}
	Horario getAbrir(){return abrir;}
	Horario getFechar(){return fechar;}
	int getCapacidade(){return capacidade;}

}

