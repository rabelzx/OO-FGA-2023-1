package trabalhoOO;

public class Acesso {
    private String placa;
    private boolean chkEvent;
    private boolean chkMens;
    private float valorTotal;
    private Horario entrada;
    private Horario saida;
    private Data dtEntrada;
    private Data dtSaida; 

    //construtor vazio
    public Acesso() {}

    //construtor
    public Acesso(String placa, Horario entrada, Horario saida, Data dtEntrada, Data dtSaida, Valores valores, Horario abrir, Horario fechar) {
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida; 
        this.valorTotal = calcPrice(abrir,fechar, valores);
    }

    public Acesso(String placa, Horario entrada, Horario saida, Valores valores, Horario abrir, Horario fechar) {

    }

    //calculo apenas para valores de fracao e hora cheia
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
        int tempoPermanencia =  Horario.diferencaMinutos(entrada, saida);
        	if(tempoPermanencia > 0 && tempoPermanencia < 60) {
				int valorFracao = tempoPermanencia / 15; 
				return valorFracao * valores.getFracao();
			}else {
				int horasCheias = tempoPermanencia / 60; 
				int fracaoCheia = (tempoPermanencia - horasCheias * 60) / 15;
				return horasCheias * valores.getHora_cheia() + fracaoCheia * valores.getFracao();   
			} 
    }

    public static int checkInOut(Data entrada, Data saida){
        int diferenca = 0;
        if (entrada.compararMesAno(saida)){}
        else if (entrada.getAno() < saida.getAno()){
            diferenca = (saida.getMes()+12)*(saida.getAno()-entrada.getAno()) - entrada.getMes();
        }else {
            diferenca = saida.getMes() - entrada.getMes();
        }
        return diferenca;
    }
    // --------------------getters e setters----------------------------
    
    //placa
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    //chkEvent
    public boolean getChkEvent() {
        return chkEvent;
    }

    public void setChkEvent(boolean chkEvent) {
        this.chkEvent = chkEvent;
    }

    //chkMens
    public boolean getChkMens() {
        return chkMens;
    }

    public void setChkMens(boolean chkMens) {
        this.chkMens = chkMens;
    }
    
    //valorTotal
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    //in e out
    public Horario getEntrada() {
        return entrada;
    }

    public void setEntrada(Horario entrada) {
        this.entrada = entrada;
    }

    public Horario getSaida() {
        return saida;
    }

    public void setSaida(Horario saida) {
        this.saida = saida;
    }

    public Data getDtEntrada() {
        return dtEntrada;
    }
    
    public Data getDtSaida() {
    	return dtSaida; 
    }
}
