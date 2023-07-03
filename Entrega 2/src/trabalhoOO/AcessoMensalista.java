package trabalhoOO;

public class AcessoMensalista extends Acesso {
	
	//construtor
    public AcessoMensalista(String placa,  Horario entrada, Horario saida, Data dtEntrada, Data dtSaida,Valores valores, Horario abrir, Horario fechar) {
        super(placa, entrada, saida, dtEntrada, dtSaida, valores, abrir, fechar);
    }

    //sobrescreve calculo de valor do acesso
    @Override
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
        // Lógica de cálculo do valor para acesso mensalista
    	return valores.getMensalista()*checkInOut(getDtEntrada(), getDtSaida());
    }
}