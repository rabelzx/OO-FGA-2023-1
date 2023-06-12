package trabalhoOO;


import javax.swing.*;

public class Estacionamento {
	private int capacidade;
	private float valCon;
	private Horario abrir;
	private Horario fechar;
	private Acesso acessos[];
	private Valores valores;

	private int quantidade_Acessos=0;

	public Estacionamento() {} //Padrão
	public Estacionamento(int capacidade, Horario abrir,Horario fechar, float valCon) {
		this.capacidade = capacidade;
		this.abrir = abrir;
		this.fechar = fechar;
		this.valCon = valCon;
	}
	public void cadastrarAcesso(String placa, Boolean evento, Boolean mensalista, Horario entrada, Horario saida) {
		acessos[quantidade_Acessos] = new Acesso(placa,evento,mensalista,entrada,saida,valores,abrir,fechar);
		quantidade_Acessos++;
	}

	public void cadastrarValores(float fracao,float hora_cheia, int diurnapercent,int noturnapercent, float mensalidade, float evento){
		float diurna = (diurnapercent/100), noturna = (noturnapercent/100);
		valores = new Valores(fracao,hora_cheia,diurna,noturna,mensalidade,evento);
	}
	public float calcRetorno(int contratantePercent){
		int retorno = 0;
		for (int i = 0; i < quantidade_Acessos; i++){
			retorno += acessos[i].calcPrice(abrir,fechar,valores);

		}

		return retorno*valCon;
	}
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

