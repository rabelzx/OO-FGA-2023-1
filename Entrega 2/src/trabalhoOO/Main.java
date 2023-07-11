package trabalhoOO; 
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        ArrayList<Estacionamento> estacionamentos = new ArrayList<>( );
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
                    cadastrarOpcoes(estacionamentos);
                    
                    break;
                case 2:
                    if (estacionamentos.size() > 0)
                        buscarOpcoes(estacionamentos);
                    else
                        JOptionPane.showMessageDialog(null, "Nenhum estacionamento cadastrado");

                    
                    break;
                case 3:
                    if (estacionamentos.size() > 0)
                        apagarOpcoes(estacionamentos);
                    else
                        JOptionPane.showMessageDialog(null, "Nenhum estacionamento cadastrado");
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

    public static void cadastrarOpcoes(ArrayList<Estacionamento> estacionamentos) {

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
                    String cadastro[] = new String[13];

                    cadastro[0] = JOptionPane.showInputDialog(null, "Insira o nome do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[1] = JOptionPane.showInputDialog(null, "Insira a capacidade do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);

                    //Horarios

                    cadastro[2] = JOptionPane.showInputDialog(null, "Insira a hora de abertura do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[3] = JOptionPane.showInputDialog(null, "Insira os minutos de abertura do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[4] = JOptionPane.showInputDialog(null, "Insira a hora de encerramento do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[5] = JOptionPane.showInputDialog(null, "Insira os minutos de encerramento do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);


                    //Valores Float
                    cadastro[6] = JOptionPane.showInputDialog(null, "Insira a porcentagem de retorno do contratante:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[7] = JOptionPane.showInputDialog(null, "Insira o valor da fracao:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[8] = JOptionPane.showInputDialog(null, "Insira a porcentagem de desconta da hora cheia:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[9] = JOptionPane.showInputDialog(null, "Insira o valor da diária:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[10] = JOptionPane.showInputDialog(null, "Insira o desconto da diária noturna:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[11] = JOptionPane.showInputDialog(null, "Insira o valor da mensalidade:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastro[12] = JOptionPane.showInputDialog(null, "Insira o valor do evento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    //7 campos
                    try {
                        for (int i = 0; i < cadastro.length; i++){
                            if (cadastro[i].length() == 0){
                                throw new DescricaoEmBrancoException();
                            }
                        }
                        Horario horarioAbertura =  new Horario(Integer.parseInt(cadastro[2]), Integer.parseInt(cadastro[3]));
                        Horario horarioEncerramento = new Horario(Integer.parseInt(cadastro[4]), Integer.parseInt(cadastro[5]));

                        Estacionamento estacionamentoNovo = new Estacionamento(cadastro[0], Integer.parseInt(cadastro[1]), horarioAbertura, horarioEncerramento, Float.parseFloat(cadastro[6])/100);
                        estacionamentoNovo.cadastrarValores(Float.parseFloat(cadastro[7]),  Float.parseFloat(cadastro[10]), Float.parseFloat(cadastro[8]), Float.parseFloat(cadastro[9]), Float.parseFloat(cadastro[11]), Float.parseFloat(cadastro[12]) );
                        estacionamentos.add(estacionamentoNovo);
                        JOptionPane.showMessageDialog(null, "Estacionamento cadastrado com sucesso!");

                    }catch (DescricaoEmBrancoException e){
                        JOptionPane.showMessageDialog(null, e.toString()+"\nEstacionamento não cadastrado...");
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Caracter invalido inserido...\nEstacionamento não cadastrado...");
                    }



                    

                    break;
                case 2:
                    int i = escolhaEstacionamento(estacionamentos);

                    String placa = JOptionPane.showInputDialog(null, "Insira a placa do veículo:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                    int horaEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int minutosEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int horaSaida = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de saída do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int minutosSaida = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de saída do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    
                    int diaEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o dia do início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int mesEntrada =  Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o mês do início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int anoEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    
                    int diaSaida = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o dia do fim do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int mesSaida =  Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o mês do fim do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));
                    int anoSaida = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do fim do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE));

                    //Mensalista
                    int mensalistaResposta = JOptionPane.showOptionDialog(null, "O acesso é do tipo mensalista", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, null);
                    boolean mensChk = (mensalistaResposta == JOptionPane.YES_OPTION);
                    
                    
                    Horario entrada = new Horario(horaEntrada, minutosEntrada); 
                    Horario saida = new Horario(horaSaida, minutosSaida); 
                    
                    Data dtEntrada = new Data(diaEntrada, mesEntrada, anoEntrada); 
                    Data dtSaida = new Data(diaSaida, mesSaida, anoSaida); 

                    estacionamentos.get(i).cadastrarAcesso(placa, mensChk, dtEntrada, dtSaida, entrada, saida);

                    JOptionPane.showMessageDialog(null, "Acesso cadastrado com sucesso!");
                    break;
                case 3:
                    int j = escolhaEstacionamento(estacionamentos);

                    String evento = JOptionPane.showInputDialog(null, "Insira o nome do evento:", "Cadastar Evento", JOptionPane.PLAIN_MESSAGE);

                    int diaInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o dia do início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));
                    int mesInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o mês do início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));
                    int anoInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));

                    int diaFim = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o dia do fim do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));
                    int mesFim = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o mês do fim do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));
                    int anoFim = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do fim do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));

                    int horaInicio =  Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));
                    int minutosInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));

                    int horaFim = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a hora de encerramento do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));
                    int minutosFim = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira os minutos de encerramento do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE));

                    Data dtInicio = new Data(diaInicio, mesInicio, anoInicio);
                     Data dtFim = new Data(diaFim, mesFim, anoFim);

                    Horario inicio = new Horario(horaInicio, minutosInicio);
                    Horario fim = new Horario(horaFim, minutosFim); 
                    
                    estacionamentos.get(j).cadastrarEvento(evento, dtInicio, dtFim, inicio, fim);
                    JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");

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

    public static void buscarOpcoes(ArrayList<Estacionamento> estacionamentos) {
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
                    ArrayList<Estacionamento> estacAcesso = new ArrayList<>();

                    for (Estacionamento estac : estacionamentos){
                        for (Acesso acesso : estac.acessos) {
                            if (acesso.getPlaca().equals(placa)) {
                                acessosEncontrados.add(acesso);
                                estacAcesso.add(estac);
                            }
                        }
                    }

                    if (acessosEncontrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum acesso encontrado para a placa informada.");
                    } else {
                        StringBuilder mensagemAcessos = new StringBuilder("Acessos encontrados:\n");
                        for (int i = 0; i < acessosEncontrados.size(); i++) {
                            Acesso acesso = acessosEncontrados.get(i);
                            Estacionamento estacionamento = estacAcesso.get(i);
                            mensagemAcessos.append("Placa: ").append(acesso.getPlaca()).append("\n");
                            mensagemAcessos.append("Estacionamento: ").append(estacionamento.getNome()).append("\n");
                            mensagemAcessos.append("Entrada: ").append(acesso.getEntrada().getHora()).append(":").append(acesso.getEntrada().getMinuto()).append("\n"); 
                            mensagemAcessos.append("Saída: ").append(acesso.getSaida().getHora()).append(":").append(acesso.getSaida().getMinuto()).append("\n");
                            mensagemAcessos.append("Valor do acesso: ").append(acesso.calcPrice(estacionamento.getAbrir(),estacionamento.getFechar(),estacionamento.getValores())).append("\n");
                            mensagemAcessos.append("----------------------------------------\n\n"); 
                            // Adicione outros detalhes do acesso e estacionamento que deseja exibir
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
                            mensagemEstacionamentos.append("Hora de abertura: ").append(estacionamento.getAbrir().getHorario()).append("\n");
                            mensagemEstacionamentos.append("Hora de fechamento: ").append(estacionamento.getFechar().getHorario()).append("\n");
                            mensagemEstacionamentos.append("capacidade: ").append((estacionamento.acessos.size()+"/")).append(estacionamento.getCapacidade()+"\n");
                            if (estacionamento.acessos.size()<1){mensagemEstacionamentos.append("nenhum acesso cadastrado");}
                            else {mensagemEstacionamentos.append("lucro do contratante:").append(estacionamento.calcRetorno());}
                            //  Adicione outras características do estacionamento que deseja exibir
                        }
                        JOptionPane.showMessageDialog(null, mensagemEstacionamentos.toString());
                    }
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 0);
    }
    public static void apagarOpcoes(ArrayList<Estacionamento> estacionamentos) {
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
                    estacionamentos.get(escolhaEstacionamento(estacionamentos)).apagarAcesso();

                    break;

                case 2:
                    // Apagar estacionamentos
                    if (estacionamentos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há estacionamentos cadastrados para serem apagados.");
                    } else {

                        int escolhaEstacionamentos = escolhaEstacionamento(estacionamentos);
                        if (escolhaEstacionamentos >= 0 && escolhaEstacionamentos < estacionamentos.size()) {
                            Estacionamento estacionamento = estacionamentos.get(escolhaEstacionamentos);
                            for (Estacionamento estac : estacionamentos) {
                                for (Acesso acesso : estac.acessos) {
                                    if (acesso.getPlaca().equals(estacionamento.getNome()))
                                        estac.acessos.remove(acesso);

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

    //Função para fazer a escolha dos estacionamentos;
    public static int escolhaEstacionamento(ArrayList<Estacionamento> estacionamentos) {
        String nomesEstacionamentos = new String();

        for (int i = 0; i < estacionamentos.size(); i++){
            nomesEstacionamentos += (i + " - " + estacionamentos.get(i).getNome() + "\n");
        }
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Estacionamentos cadastrados:\n" + nomesEstacionamentos, JOptionPane.PLAIN_MESSAGE));

    return num;}

}

