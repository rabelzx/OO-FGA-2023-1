package trabalhoOO;

public class Horario {
    private int hora;
    private int minuto;

    public Horario(){}

    public Horario(int hora){
        if (hora >= 24 || hora < 0){
            System.out.printf("\na Hora inserida é invalida!!\n");}
        else {
            this.hora = hora;
            System.out.printf("\nHora Registrada com Sucesso\n");
        }
    }
    public Horario(int hora, int minuto){
        this(hora);
        if (minuto >= 60 || minuto < 0) {
            System.out.printf("\nO minuto inserido é invalido!!\n");
        }else {
            this.minuto = minuto;
            System.out.printf("Minuto Registrada com Sucesso\n");
        }
    }
    //Função que une a hora com os minutos em uma string

    //Sets e Gets
    void setHora(int hora){this.hora = hora;}
    void setMinuto(int minuto){this.minuto = minuto;}

    public String getHorario(){
        String horario = hora+":"+minuto;
        return horario;
    }
    public int getHora(){return hora;}

    public int getMinuto(){return minuto;}
}
