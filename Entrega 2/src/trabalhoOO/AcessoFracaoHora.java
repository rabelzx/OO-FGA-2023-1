package trabalhoOO;

public class AcessoFracaoHora extends Acesso {

	//construtor
    public AcessoFracaoHora(String placa, Horario entrada, Horario saida, Data dtEntrada, Data dtSaida, Valores valores, Horario abrir, Horario fechar) {
        super(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar);
    }
    
    
    //sobrescreve calculo de valor do acesso
    @Override
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
        int tempoPermanencia = Horario.diferencaMinutos(getEntrada(), getSaida());
        
        if (tempoPermanencia > 0 && tempoPermanencia < 60) {
            int valorFracao = tempoPermanencia / 15;
            return valorFracao * valores.getFracao();
        } else {
            int horasCheias = tempoPermanencia / 60;
            int fracaoCheia = (tempoPermanencia - horasCheias * 60) / 15;
            float valorHoraCheia = horasCheias * valores.getHora_cheia();
            float valorFracaoCheia = fracaoCheia * valores.getFracao();
            return valorHoraCheia + valorFracaoCheia;
        }
    }

}
