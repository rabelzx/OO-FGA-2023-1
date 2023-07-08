package trabalhoOO;

public abstract class Acesso {
    private String placa;
    private Horario entrada;
    private Horario saida;
    private Data dtEntrada;
    private Data dtSaida;

    // construtor vazio
    public Acesso() {
    }

    // construtor
    public Acesso(String placa, Horario entrada, Horario saida, Data dtEntrada, Data dtSaida, Valores valores, Horario abrir, Horario fechar) {
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
    }

    public Acesso(String placa, Horario entrada, Horario saida, Valores valores, Horario abrir, Horario fechar) {
    }

    // método abstrato que será sobreescrito
    public abstract float calcPrice(Horario abrir, Horario fechar, Valores valores);

    public static int checkInOut(Data entrada, Data saida) {
        int mes = 0;
        if (entrada.compararMesAno(saida)) {
        } else {
            mes = (saida.getMes() + 12 * (saida.getAno() - entrada.getAno())) - entrada.getMes();
        }
        return mes + 1;
    }

    // --------------------getters e setters----------------------------

    // placa
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Horario getEntrada() {
        return entrada;
    }

    public void setEntrada(Horario entrada) {
        this.entrada = entrada;
    }

    public Horario getSaida() {
        return saida;
    }

    public void setSaida(Horario saida) {
        this.saida = saida;
    }

    public Data getDtEntrada() {
        return dtEntrada;
    }

    public Data getDtSaida() {
        return dtSaida;
    }
}

