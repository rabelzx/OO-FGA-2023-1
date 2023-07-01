package trabalhoOO;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {}

    public Data(int dia, int mes, int ano) {
        if (dia < 1 || dia > 31) {
            throw new RuntimeException("\nDia inserido inválido!\n");
        } else {
            this.dia = dia;
        }

        if (mes < 1 || mes > 12) {
            throw new RuntimeException("\nMês inserido inválido!\n");
        } else {
            this.mes = mes;
        }

        if (ano < 1800 || ano > 2023) {
            throw new RuntimeException("\nAno inserido inválido!\n");
        } else {
            this.ano = ano;
        }
    }

    public Boolean compararMesAno(Data data){
        if (data.getMes() == this.mes && data.getAno() == this.ano){
            return true;
        }
    return false;}
    //-----------setters and getters------------
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
