package trabalhoOO;

public class Erros extends Exception {
    public Erros(String mensagem) {
        super(mensagem);
    }

    public static class DescricaoEmBrancoException extends Erros {
        public DescricaoEmBrancoException() {
            super("A descrição do acesso não foi informada.");
        }
    }

    public static class ValorAcessoInvalidoException extends Erros {
        public ValorAcessoInvalidoException() {
            super("O valor do acesso é inválido.");
        }
    }



}
