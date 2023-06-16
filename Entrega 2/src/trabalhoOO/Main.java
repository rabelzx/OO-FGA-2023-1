package trabalhoOO; 
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
	
	
    public static void main(String[] args) {
    	
    	ArrayList<Estacionamento> estacionamentos = new ArrayList<>( );
    	ArrayList<Acesso> acessos = new ArrayList<>( );
    	
    	
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Cadastrar\n" +
                    "2. Buscar\n" +
                    "3. Apagar\n" +
                    "0. Sair\n\n" +
                    "Escolha uma opção:", "Menu", JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1:
                    cadastrarOpcoes(estacionamentos, acessos);
                    break;
                case 2:
                    buscarOpcoes();
                    break;
                case 3:
                    apagarOpcoes();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);
    }

    public static void cadastrarOpcoes(ArrayList<Estacionamento> estacionamentos, ArrayList<Acesso> acessos ) {


        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "CADASTRAR\n" +
                    "1. Cadastrar estacionamento\n" +
                    "2. Cadastrar acesso\n" +
                    "3. Cadastrar evento\n" +
                    "0. Voltar\n\n" +
                    "Escolha uma opção:", "Cadastrar", JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1:
                    String nomeEstacionamento = JOptionPane.showInputDialog(null, "Insira o nome do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    int capacidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a capacidade do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    int horaAbertura = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de abertura do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    int minutosAbertura = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de abertura do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                        //Verífica se existem erros no Horário de abertura
                    try {
                        new Horario(horaAbertura, minutosAbertura);
                    }
                    catch (RuntimeException HoraInvalida){
                        HoraInvalida.getMessage();
                    }
                    Horario horarioAbertura = new Horario(horaAbertura, minutosAbertura);//Se a verificação passar ele instancia
                    int horaEncerramento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de encerramento do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    int minutosEncerramento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de encerramento do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    //Verifica se existem erros no Horário de Fechamento
                    try {
                        new Horario(horaEncerramento, minutosEncerramento);
                    }
                    catch (RuntimeException HoraInvalida){
                        HoraInvalida.getMessage();
                    }
                    Horario horarioEncerramento = new Horario(horaEncerramento, minutosEncerramento);//Se a verificação passar ele instancia

                    int valorContratante = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a porcentagem de retorno do contratante:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    float fracao = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o valor da fracao:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    int descontaHora = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a porcentagem de desconta da hora cheia:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    float diurna = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o valor da diária:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    int descontoNoturna = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o desconto da diária noturna:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    float mensalidade = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o valor da mensalidade:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    float valorEvento = Float.parseFloat(JOptionPane.showInputDialog(null, "Insirao valor do evento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE));
                    
                    float valorContratantePct = valorContratante / 100; 


                    Estacionamento estacionamentoNovo = new Estacionamento(nomeEstacionamento, capacidade, horarioAbertura, horarioEncerramento, valorContratantePct);
                    estacionamentoNovo.cadastrarValores(fracao,  descontoNoturna, descontaHora, diurna, mensalidade, valorEvento );
                    
                    estacionamentos.add(estacionamentoNovo);
            	    JOptionPane.showMessageDialog(null, "Estacionamento cadastrado com sucesso!");
                    break;
                case 2:
                	String nomesEstacionamentos = new String();  
                    for(int i = 0; i < estacionamentos.size(); i++) 
                    	nomesEstacionamentos += (i+" - "+estacionamentos.get(i).getNome()+"\n"); 
                    int escolhaEstacionamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o estacionamento do acesso?\n" + nomesEstacionamentos,  JOptionPane.PLAIN_MESSAGE));
                 
                	String placa = JOptionPane.showInputDialog(null, "Insira a placa do veículo:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                	int horaEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int minutosEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int horaSaida = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de saída do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int minutosSaida = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de saída do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    
                    int diaAcesso = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o dia do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int mesAcesso =  Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o mês do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int anoAcesso = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE)); 
                    
                    int eventoResposta = JOptionPane.showOptionDialog(null, "O acesso é do tipo evento?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, null);
                    boolean eventoChk = (eventoResposta == JOptionPane.YES_OPTION);
                   
                    int mensalistaResposta = JOptionPane.showOptionDialog(null, "O acesso é do tipo mensalista", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, null);
                    boolean mensChk = (mensalistaResposta == JOptionPane.YES_OPTION);
                    
                    
                    Horario entrada = new Horario(horaEntrada, minutosEntrada); 
                    Horario saida = new Horario(horaSaida, minutosSaida); 
                    
                    Data dtAcesso = new Data(diaAcesso, mesAcesso, anoAcesso); 
                    
                    estacionamentos.get(escolhaEstacionamento).cadastrarAcesso(placa, eventoChk, mensChk, dtAcesso, entrada, saida);
                    
                	JOptionPane.showMessageDialog(null, "Estacionamento cadastrado com sucesso!");
                    break;
                case 3: 
                	String evento = JOptionPane.showInputDialog(null, "Insira o nome do evento:", "Cadastar Evento", JOptionPane.PLAIN_MESSAGE);
                	break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);
    }

    public static void buscarOpcoes() {
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "BUSCAR\n" +
                    "1. Buscar acessos por placa\n" +
                    "2. Buscar estacionamento por nome\n" +
                    "3. Buscar eventos por nome\n" +
                    "0. Voltar\n\n" +
                    "Escolha uma opção:", "Buscar", JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1:
                   
                    break;
                case 2:
                  
                    break;
                case 3:
                   
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);
    }

    public static void apagarOpcoes() {
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "APAGAR\n" +
                    "1. Apagar acessos\n" +
                    "2. Apagar estacionamentos\n" +
                    "0. Voltar\n\n" +
                    "Escolha uma opção:", "Apagar", JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);
    }

}

