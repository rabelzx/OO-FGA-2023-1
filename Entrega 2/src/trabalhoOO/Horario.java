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
            System.out.printf("Hora Registrada com Sucesso\n");
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
    public String unirHorario(){
        String horario = hora+":"+minuto;
        return horario;
    }
    //Sets
    void setHora(int hora){this.hora = hora;}
    void setMinuto(int minuto){this.minuto = minuto;}
}
