package trabalhoOO;

import javax.swing.*;

public class Erros {
    float ValorP1;
    //Verifica se algum valor foi inserido
    public float chkException(String strValorP1) {

        if (strValorP1.length() == 0) {
            System.out.printf("DescricaoEmBrancoException\n");
        }
        else {
            ValorP1 = Float.parseFloat(strValorP1);//Converte a String em Float para verificar se o valor é positivo

            if (ValorP1 <= 0) {System.out.printf("ValorAcessoInvalidoException\n");}//Printa erro

            else {System.out.printf("Registrado\n");
                return ValorP1;
            }
        }
        return 0;
    }
}
