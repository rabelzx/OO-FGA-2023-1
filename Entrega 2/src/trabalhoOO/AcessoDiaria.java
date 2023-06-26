package trabalhoOO;

public class AcessoDiaria extends Acesso {
	
	//construtor
    public AcessoDiaria(String placa, Horario entrada, Horario saida, Data dtAcesso, Valores valores, Horario abrir, Horario fechar) {
        super(placa,  entrada, saida, dtAcesso, valores, abrir, fechar);
    }

    //sobrescreve calculo de valor do acesso
    @Override
    public float calcPrice(Horario abrir, Horario fechar, Valores valores) {
    	if(getEntrada().getHora() > fechar.getHora() && getSaida().getHora() < abrir.getHora())
    		return valores.getDiurna() * valores.getNoturna(); 
    	else  	
    		return valores.getDiurna(); 
   
    }
}
