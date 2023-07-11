package trabalhoOO;

public class HorarioInvalidoException extends Exception {
    private int hora, minuto;
    HorarioInvalidoException(int hora){
        this.hora  = hora;
        this.minuto = 0;
    }
    HorarioInvalidoException(int hora, int minuto){
        this.hora  = hora;
        this.minuto = minuto;
    }
    public String toString() {
        return "O horário:\n"+hora+":"+minuto+"\né invalido";
    }

}
