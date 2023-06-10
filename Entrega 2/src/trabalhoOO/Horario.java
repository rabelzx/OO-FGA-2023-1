package trabalhoOO;

public class Horario {
    private int hora;
    private int minuto;


    public Horario(){}
    public Horario(int hora, int minuto){
        this.hora = hora;
        this.minuto = minuto;
    }
    void setHora(int hora){this.hora = hora;}
    void setMinuto(int minuto){this.minuto = minuto;}

    public String toString(){
        System.out.println(hora+";"+minuto);
        return null;
    }
}
