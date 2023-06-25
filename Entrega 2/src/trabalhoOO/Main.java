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
                    buscarOpcoes(estacionamentos, acessos);
                    break;
                case 3:
                    apagarOpcoes(estacionamentos, acessos);
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

    public static void buscarOpcoes(ArrayList<Estacionamento> estacionamentos, ArrayList<Acesso> acessos) {
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "BUSCAR\n" +
                            "1. Buscar acessos por placa\n" +
                            "2. Buscar estacionamento por nome\n" +
                            "0. Voltar\n\n" +
                            "Escolha uma opção:", "Buscar", JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1:
                    // Buscar acessos por placa
                    String placa = JOptionPane.showInputDialog(null, "Digite a placa a ser buscada:", "Buscar Acessos por Placa", JOptionPane.PLAIN_MESSAGE);
                    ArrayList<Acesso> acessosEncontrados = new ArrayList<>();

                    for (Acesso acesso : acessos) {
                        if (acesso.getPlaca().equalsIgnoreCase(placa)) {
                            acessosEncontrados.add(acesso);
                        }
                    }

                    if (acessosEncontrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum acesso encontrado para a placa informada.");
                    } else {
                        StringBuilder mensagemAcessos = new StringBuilder("Acessos encontrados:\n");
                        for (Acesso acesso : acessosEncontrados) {
                            mensagemAcessos.append("Placa: ").append(acesso.getPlaca()).append("\n");
                            // Adicione outros detalhes do acesso que deseja exibir
                        }
                        JOptionPane.showMessageDialog(null, mensagemAcessos.toString());
                    }
                    break;

                case 2:
                    // Buscar estacionamento por nome
                    String nomeEstacionamento = JOptionPane.showInputDialog(null, "Digite o nome do estacionamento a ser buscado:", "Buscar Estacionamento por Nome", JOptionPane.PLAIN_MESSAGE);
                    ArrayList<Estacionamento> estacionamentosEncontrados = new ArrayList<>();

                    for (Estacionamento estacionamento : estacionamentos) {
                        if (estacionamento.getNome().equalsIgnoreCase(nomeEstacionamento)) {
                            estacionamentosEncontrados.add(estacionamento);
                        }
                    }

                    if (estacionamentosEncontrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum estacionamento encontrado com o nome informado.");
                    } else {
                        StringBuilder mensagemEstacionamentos = new StringBuilder("Estacionamentos encontrados:\n");
                        for (Estacionamento estacionamento : estacionamentosEncontrados) {
                            mensagemEstacionamentos.append("Nome: ").append(estacionamento.getNome()).append("\n");
                            // Adicione outros detalhes do estacionamento que deseja exibir
                        }
                        JOptionPane.showMessageDialog(null, mensagemEstacionamentos.toString());
                    }
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

    public static void apagarOpcoes(ArrayList<Estacionamento> estacionamentos, ArrayList<Acesso> acessos) {
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
                    // Apagar acessos
                    if (acessos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há acessos cadastrados para serem apagados.");
                    } else {
                        StringBuilder mensagemAcessos = new StringBuilder("Acessos cadastrados:\n");
                        for (int i = 0; i < acessos.size(); i++) {
                            mensagemAcessos.append(i).append(". ").append(acessos.get(i).getPlaca()).append("\n");
                        }
                        int escolhaAcessos = Integer.parseInt(JOptionPane.showInputDialog(null, mensagemAcessos.toString(), "Apagar Acesso", JOptionPane.PLAIN_MESSAGE));

                        if (escolhaAcessos >= 0 && escolhaAcessos < acessos.size()) {
                            acessos.remove(escolhaAcessos);
                            JOptionPane.showMessageDialog(null, "Acesso apagado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                    }
                    break;

                case 2:
                    // Apagar estacionamentos
                    if (estacionamentos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há estacionamentos cadastrados para serem apagados.");
                    } else {
                        StringBuilder mensagemEstacionamentos = new StringBuilder("Estacionamentos cadastrados:\n");
                        for (int i = 0; i < estacionamentos.size(); i++) {
                            mensagemEstacionamentos.append(i).append(". ").append(estacionamentos.get(i).getNome()).append("\n");
                        }
                        int escolhaEstacionamentos = Integer.parseInt(JOptionPane.showInputDialog(null, mensagemEstacionamentos.toString(), "Apagar Estacionamento", JOptionPane.PLAIN_MESSAGE));

                        if (escolhaEstacionamentos >= 0 && escolhaEstacionamentos < estacionamentos.size()) {
                            Estacionamento estacionamento = estacionamentos.get(escolhaEstacionamentos);
                            for (Acesso acesso : acessos) {
                                if (acesso.getPlaca().equals(estacionamento.getNome())) {
                                    acessos.remove(acesso);
                                }
                            }
                            estacionamentos.remove(escolhaEstacionamentos);
                            JOptionPane.showMessageDialog(null, "Estacionamento apagado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                    }
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

