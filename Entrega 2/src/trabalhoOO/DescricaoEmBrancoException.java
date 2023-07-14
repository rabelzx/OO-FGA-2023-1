package trabalhoOO;

public class DescricaoEmBrancoException extends Exception{

    public DescricaoEmBrancoException(){


    }
    public String toString() {
        return "Campo obrigatória deixado em branco...";
    }

}
