package trabalhoOO;

import javax.swing.*;

public class Horario {
    private int hora;
    private int minuto;

    public Horario(){}

    public Horario(int hora) {
        try {
            if (hora >= 24 || hora < 0){
                throw new HorarioInvalidoException(hora);
            }
            else {
                this.hora = hora;

            }
        }catch (HorarioInvalidoException e){
            JOptionPane.showMessageDialog(null, e.toString());
            if (hora>= 24){
                this.hora = 23;
                this.minuto =59;
                JOptionPane.showMessageDialog(null,"A hora foi definida como '23' por ser o mais próximo!");

            }else{
                this.hora = 0;
                this.minuto =0;

                JOptionPane.showMessageDialog(null,"A hora foi definida como '00' por ser o mais próximo!");
            }
        }

    }
    public Horario(int hora, int minuto) {
        this(hora);
        try {
            if (minuto >= 60 || minuto < 0) {
                throw new HorarioInvalidoException(hora,minuto);
            }else {
                this.minuto = minuto;

            }
        }catch (HorarioInvalidoException e){
            JOptionPane.showMessageDialog(null, e.toString());
            if (minuto >= 60){
                this.minuto =59;
                JOptionPane.showMessageDialog(null,"Os minutos foram definidos como '59' por ser o mais próximo!");
            }else {
                this.minuto = 0;
                JOptionPane.showMessageDialog(null,"Os minutos foram definidos como '00' por ser o mais próximo!");
            }
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
