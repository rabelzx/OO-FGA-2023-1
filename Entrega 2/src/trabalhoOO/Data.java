package trabalhoOO;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {}

	public Data(int dia, int mes, int ano) throws DataInvalidaException {
	    if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1800) {
	        throw new DataInvalidaException(dia, mes, ano);
	    }
	    this.dia = dia;
	    this.mes = mes;
	    this.ano = ano;
	}
	
	public Data(int dia, int mes, int ano, boolean tratarExcecao) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public Boolean compararDia(Data data){
        if (data.getDia() == this.dia && data.getMes() == this.mes && data.getAno() == this.ano){
            return true;
        }
        return false;}

    public Boolean compararMesAno(Data data){
        if (data.getMes() == this.mes && data.getAno() == this.ano){
            return true;
        }
    return false;}
    //-----------setters and getters------------
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
