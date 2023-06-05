package trabalhoOO;

public class Acesso {
    private String placa;
    private boolean chkEvent;
    private boolean chkMens;
    private float valorTotal;
    private Horario in;
    private Horario out;

    //construtor vazio
    public Acesso() {}

    //construtor
    public Acesso(String placa, boolean chkEvent, boolean chkMens, Horario in, Horario out) {
        this.placa = placa;
        this.chkEvent = chkEvent;
        this.chkMens = chkMens;
        this.in = in;
        this.out = out;
    }

    public void calcPrice() {
        // -------------
    	// -------------
    	// -------------
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
    public Horario getIn() {
        return in;
    }

    public void setIn(Horario in) {
        this.in = in;
    }

    public Horario getOut() {
        return out;
    }

    public void setHorarioSaida(Horario out) {
        this.out = out;
    }

}
