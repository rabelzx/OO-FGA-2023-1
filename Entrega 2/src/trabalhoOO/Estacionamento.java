package trabalhoOO;

public class Estacionamento {
	private int capacidade;
	private float valCon;
	private Horario abrir;
	private Horario fechar;

	public Estacionamento() {} //Padrão
	public Estacionamento(int capacidade, Horario abrir,Horario fechar) {
		this.capacidade = capacidade;
		this.abrir = abrir;
		this.fechar = fechar;
	}
	public void cadastrarAcesso(){
		//PlaceHolder
	}
	public float calcRetorno(){
		return 0;
	}



}
