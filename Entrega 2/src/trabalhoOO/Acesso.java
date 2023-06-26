package trabalhoOO;

public class Acesso {
    private String placa;
    private boolean chkEvent;
    private boolean chkMens;
    private float valorTotal;
    private Horario entrada;
    private Horario saida;
    private Data dtAcesso;

    //construtor vazio
    public Acesso() {}

    //construtor
    public Acesso(String placa, boolean chkMens, Horario entrada, Horario saida, Data dtAcesso, Valores valores, Horario abrir, Horario fechar) {
        this.placa = placa;
        this.chkMens = chkMens;
        this.entrada = entrada;
        this.saida = saida;
        this.dtAcesso = dtAcesso; 
        this.valorTotal = calcPrice(abrir,fechar, valores);
    }

    public Acesso(String placa,  Boolean mensalista, Horario entrada, Horario saida, Valores valores, Horario abrir, Horario fechar) {

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

    public Data getDtAcesso() {
        return dtAcesso;
    }
}
