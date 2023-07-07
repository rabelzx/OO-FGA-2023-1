package trabalhoOO;

public class AcessoHoraCheia extends Acesso {

    //construtor
    public AcessoHoraCheia(String placa, Horario entrada, Horario saida, Data dtEntrada, Data dtSaida, Valores valores, Horario abrir, Horario fechar) {
        super(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar);
    }


    //sobrescreve calculo de valor do acesso
    @Override
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
            int tempoPermanencia = Horario.diferencaMinutos(getEntrada(), getSaida());
            int horasCheias = tempoPermanencia / 60;
            int fracaoCheia = (tempoPermanencia - horasCheias * 60) / 15;
            float valorHoraCheia = horasCheias * valores.getHora_cheia();
            float valorFracaoCheia = fracaoCheia * valores.getFracao();
            return valorHoraCheia + valorFracaoCheia;

    }

}
