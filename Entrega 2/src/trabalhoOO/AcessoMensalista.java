package trabalhoOO;

public class AcessoMensalista extends Acesso {
	
	//construtor
    public AcessoMensalista(String placa, boolean chkMens, Horario entrada, Horario saida, Data dtAcesso, Valores valores, Horario abrir, Horario fechar) {
        super(placa, chkMens, entrada, saida, dtAcesso, valores, abrir, fechar);
    }

    //sobrescreve calculo de valor do acesso
    @Override
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
        // Lógica de cálculo do valor para acesso mensalista
    	return valores.getMensalista(); 
    }
}