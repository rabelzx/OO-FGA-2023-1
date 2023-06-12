package trabalhoOO;


public class Estacionamento {
	private int capacidade;
	private float valCon;
	private Horario abrir;
	private Horario fechar;
	Acesso acesso


	public Estacionamento() {} //Padrão
	public Estacionamento(int capacidade, Horario abrir,Horario fechar, float valCon) {
		this.capacidade = capacidade;
		this.abrir = abrir;
		this.fechar = fechar;
		this.valCon = valCon;
	}
	public void cadastrarAcesso(String placa, Boolean evento, Boolean mensalista, Horario entrada, Horario saida) {
		acesso = new Acesso(placa,evento,mensalista,entrada,saida,abrir,fechar);
	}
	public float calcRetorno(){return 0;}
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

