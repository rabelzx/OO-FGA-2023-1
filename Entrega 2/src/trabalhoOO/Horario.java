package trabalhoOO;

public class Horario {
    private int hora;
    private int minuto;


    public Horario(){}
    public Horario(int hora, int minuto){
        if (hora >= 24 || hora < 0){
            System.out.printf("\na Hora inserida é invalida!!\n");
        } else if (minuto >= 60 || minuto < 0) {
            System.out.printf("\nO minuto inserido é invalido!!\n");
        }else {
            this.hora = hora;
            this.minuto = minuto;
            System.out.printf("Hora Registrada com Sucesso\n");
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
