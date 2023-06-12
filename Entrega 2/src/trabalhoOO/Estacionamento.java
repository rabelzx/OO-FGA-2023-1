package trabalhoOO;


import javax.swing.*;

public class Estacionamento {
	private int capacidade;
	private float valCon;
	private Horario abrir;
	private Horario fechar;
	Acesso acesso;
	Valores valores;


	public Estacionamento() {} //Padrão
	public Estacionamento(int capacidade, Horario abrir,Horario fechar, float valCon) {
		this.capacidade = capacidade;
		this.abrir = abrir;
		this.fechar = fechar;
		this.valCon = valCon;
	}
	public void cadastrarAcesso(String placa, Boolean evento, Boolean mensalista, Horario entrada, Horario saida) {
		acesso = new Acesso(placa,evento,mensalista,entrada,saida,valores,abrir,fechar);
	}

	public void cadastrarValores(float fracao,float hora_cheia, int diurnapercent,int noturnapercent, float mensalidade, float evento){
		float diurna = (diurnapercent/100), noturna = (noturnapercent/100);
		valores = new Valores(fracao,hora_cheia,diurna,noturna,mensalidade,evento);
	}
	public float calcRetorno(){
		int contratantePercent;

		String strCon;
		strCon = JOptionPane.showInputDialog("Insira o quanto o contratante irá receber de volta em porcentagem: exemplo 50%");
		contratantePercent = Integer.parseInt(strCon);

		return contratantePercent/100;
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

