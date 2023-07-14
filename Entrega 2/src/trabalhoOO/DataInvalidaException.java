package trabalhoOO;

public class DataInvalidaException extends Exception {
	private int dia; 
	private int mes; 
	private int ano; 
	
	DataInvalidaException(int dia, int mes, int ano){
		this.dia = dia; 
		this.mes = mes; 
		this.ano = ano; 
	}
	
	public String toString() {
		return "A data " + dia + "/" + mes + "/" + ano + " é inválida!\nInsira a data novamente:" ; 
	}
}