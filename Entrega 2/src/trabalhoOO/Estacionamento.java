package trabalhoOO;


public class Estacionamento {
	private int capacidade;
	private float valCon;
	private Horario abrir;
	private Horario fechar;


	public Estacionamento() {} //Padrão
	public Estacionamento(int capacidade, Horario abrir,Horario fechar, float valCon) {
		this.capacidade = capacidade;
		this.abrir = abrir;
		this.fechar = fechar;
		this.valCon = valCon;
	}
	public void cadastrarAcesso() {
		if (Horario.diferencaMinutos(abrir,fechar) > 0) {
			// Verificar se o estacionamento está lotado
			if (acessos.size() <= capacidade) {
				// Realizar o cadastro do acesso
				try {
					if (descricao.isEmpty()) {
						throw new Erros.DescricaoEmBrancoException();
					}
					if (valorAcesso <= 0) {
						throw new Erros.ValorAcessoInvalidoException();
					}
					acessos.add(horario);
					System.out.println("Acesso cadastrado com sucesso.");
				} catch (Erros.DescricaoEmBrancoException | Erros.ValorAcessoInvalidoException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("O estacionamento está lotado. Acesso não permitido.");
			}
		} else {
			System.out.println("O estacionamento está fechado. Acesso não permitido.");
		}
	}
	public float calcRetorno(){return 0;}
	void setCapacidade(int capacidade){
		this.capacidade = capacidade;
	}
	void setAbrir(Horario abrir){
		this.abrir = abrir;
	}
	void setFechar(Horario fechar){
		this.fechar = fechar;

	}
	void  setValCon(float valCon){
		this.valCon = valCon;
	}
	Horario getAbrir(){return abrir;}
	Horario getFechar(){return fechar;}
	int getCapacidade(){return capacidade;}

}
//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
