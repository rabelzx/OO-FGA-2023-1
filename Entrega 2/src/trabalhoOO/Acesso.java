package trabalhoOO;

public class Acesso {
    private String placa;
    private boolean chkEvent;
    private boolean chkMens;
    private float valorTotal;
    private Horario entrada;
    private Horario saida;

    //construtor vazio
    public Acesso() {}

    //construtor
    public Acesso(String placa, boolean chkEvent, boolean chkMens, Horario entrada, Horario saida) {
        this.placa = placa;
        this.chkEvent = chkEvent;
        this.chkMens = chkMens;
        this.entrada = entrada;
        this.saida = saida;
    }

    public float calcPrice() {
    	if(chkMens){
    		float price = getMens();
    		return price; 
    		
    	} else if(chkEvent){
    		float price = getEvent(); 
    		return price; 
    		
    	} else{
    		int tempoPermanencia = diferencaMinutos(entrada, saida); 
    		
    	}
        
    }

   
    

    // getters e setters
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

}
