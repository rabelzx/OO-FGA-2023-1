package trabalhoOO;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {}

    public Data(int dia, int mes, int ano) {
        if (dia < 1 || dia > 31) {
            System.out.printf("\nDia inserido inválido!\n");
        } else {
            this.dia = dia;
        }

        if (mes < 1 || mes > 12) {
            System.out.printf("\nMês inserido inválido!\n");
        } else {
            this.mes = mes;
        }

        if (ano < 1800 || ano > 2023) {
            System.out.printf("\nAno inserido inválido!\n");
        } else {
            this.ano = ano;
        }
    }

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
