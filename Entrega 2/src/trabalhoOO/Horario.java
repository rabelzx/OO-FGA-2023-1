
package trabalhoOO;

public class Horario {
    private int hora;
    private int minuto;

    public Horario(){}

    public Horario(int hora){
        if (hora >= 24 || hora < 0){
            throw new RuntimeException("\na Hora inserida é invalida!!\n");}
        else {
            this.hora = hora;

        }
    }
    public Horario(int hora, int minuto){
        this(hora);
        if (minuto >= 60 || minuto < 0) {
            throw new RuntimeException("\nO minuto inserido é invalido!!\n");
        }else {
            this.minuto = minuto;

        }
    }
    
    //Função para calcular a diferença de tempo em minutos
    public static int diferencaMinutos(Horario entrada, Horario saida) {
        int minutosEntrada = entrada.getHora() * 60 + entrada.getMinuto();
        int minutosSaida = saida.getHora() * 60 + saida.getMinuto();
        return minutosSaida - minutosEntrada;
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
