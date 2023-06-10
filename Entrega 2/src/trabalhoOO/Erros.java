package trabalhoOO;

public class erros () {
    float ValorP1
    public float DescricaoEmBrancoException (String strValorP1){

        strValorP1 = JOptionPane.showInputDialog("");
        if (strValorP1.length()==0) {
            System.out.printf("DescricaoEmBrancoException");
            break;
        }
        else {
            valorP1 = Float.parseFloat(strValorP1);
            return valorP1;
        }

    }
    public float ValorAcessoInvalidoException (String strValorP1){
        valorP1 = Float.parseFloat(strValorP1);
        strValorP1 = JOptionPane.showInputDialog("");
        if (ValorP1<=0) {
            System.out.printf("ValorAcessoInvalidoException");
            break;
        }
        else {
            return ValorP1;
        }

    }
}
