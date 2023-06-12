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
    public Acesso(String placa, boolean chkEvent, boolean chkMens, Horario entrada, Horario saida, Valores valores, Horario abrir, Horario fechar) {
        this.placa = placa;
        this.chkEvent = chkEvent;
        this.chkMens = chkMens;
        this.entrada = entrada;
        this.saida = saida;
        this.valorTotal = calcPrice(abrir,fechar, valores);
    }
    
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
        int tempoPermanencia =  Horario.diferencaMinutos(entrada, saida);
        
        if(chkMens) 
        	return valores.getMensalista();
        else if(chkEvent)
        	return valores.getEvento();
        else {
        	if(entrada.getHora() > fechar.getHora() && saida.getHora() < abrir.getHora())
        		return valores.getDiurna() * valores.getNoturna(); 
        	else {        		
        		if(tempoPermanencia > 0 && tempoPermanencia < 60) {
        			int valorFracao = tempoPermanencia / 15; 
        			return valorFracao * valores.getFracao();
        		} else if(tempoPermanencia >= 60 && tempoPermanencia <= 540) {
        			int horasCheias = tempoPermanencia / 60; 
        			int fracaoCheia = (tempoPermanencia - horasCheias * 60) / 15;
        			return ((horasCheias * 4) * valores.getFracao()) * valores.getHora_cheia() + fracaoCheia * valores.getFracao();     			
        		} else
        			return valores.getDiurna(); 			
        	}
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

}
