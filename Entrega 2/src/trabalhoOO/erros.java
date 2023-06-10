package trabalhoOO;

public class erros (String[] args) {
    int valorP1;
    String strValorP1;
    strValorP1 = JOptionPane.showInputDialog("");
    if (strValorP1.length()==0) {
        System.out.printf("");
    }
    else {
        valorP1 = Integer.parseInt(ValorP1);
        System.out.println(valorP1);
    }
}