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
    public Acesso(String placa, boolean chkEvent, boolean chkMens, Horario entrada, Horario saida, Horario abrir, Horario fechar) {
        this.placa = placa;
        this.chkEvent = chkEvent;
        this.chkMens = chkMens;
        this.entrada = entrada;
        this.saida = saida;
        
        int tempoPermanencia =  Horario.diferencaMinutos(entrada, saida);
        
        if(chkMens) {
        	this.valorTotal = Valores.getEvento();
        } else if(chkEvent) {
        	this.valorTotal = Valores.getMensalista(); 
        } else {
        	if(entrada.getHora() > fechar.getHora() && saida.getHora() < abrir.getHora()) {
        		this.valorTotal = Valores.getDiurna() * Valores.getNoturna(); 
        	} else {        		
        		if(tempoPermanencia > 0 && tempoPermanencia < 60) {
        			int valorFracao = tempoPermanencia / 15; 
        			this.valorTotal = valorFracao * Valores.getFracao();
        		} else if(tempoPermanencia >= 60 && tempoPermanencia <= 540) {
        			int horasCheias = tempoPermanencia / 60; 
        			int minutosRestantes = (tempoPermanencia - horasCheias * 60) / 15;
        			
        			horasCheias = ((horasCheias * 60) / 15) * Valores.getFracao(); 
        			this.valorTotal = horasCheias * Valores.getHora_cheia() + minutosRestantes * Valores.getFracao(); 
        		} else if(tempoPermanencia > 540) {
        			this.valorTotal = Valores.getDiurna(); 
        		}
        	}
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
