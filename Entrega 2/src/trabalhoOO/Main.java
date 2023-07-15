package trabalhoOO; 
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        ArrayList<Estacionamento> estacionamentos = new ArrayList<>( );
        int opcao = 5;

        do {
            try {
                String opcao1 = JOptionPane.showInputDialog(null,
                        "1. Cadastrar\n" +
                                "2. Buscar\n" +
                                "3. Apagar\n" +
                                "0. Sair\n\n" +
                                "Escolha uma opção:", "Menu", JOptionPane.PLAIN_MESSAGE);
                if (opcao1.length() == 0) {
                    throw new DescricaoEmBrancoException();
                }
                opcao=Integer.parseInt(opcao1);

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
            } catch (DescricaoEmBrancoException e) { JOptionPane.showMessageDialog(null,e.toString());}
        } while (opcao != 0);
    }

    public static void cadastrarOpcoes(ArrayList<Estacionamento> estacionamentos) {

        int opcao=0;

        do {
            try {
            String opcao1 = JOptionPane.showInputDialog(null,
                    "CADASTRAR\n" +
                            "1. Cadastrar estacionamento\n" +
                            "2. Cadastrar acesso\n" +
                            "3. Cadastrar evento\n" +
                            "0. Voltar\n\n" +
                            "Escolha uma opção:", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                if (opcao1.length() == 0) {
                    throw new DescricaoEmBrancoException();
                }
                opcao=Integer.parseInt(opcao1);
            } catch (DescricaoEmBrancoException e) { JOptionPane.showMessageDialog(null,e.toString());}



            switch (opcao) {
                case 1:

                    try {
                    String cadastroE[] = new String[13];

                    cadastroE[0] = JOptionPane.showInputDialog(null, "Insira o nome do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastroE[1] = JOptionPane.showInputDialog(null, "Insira a capacidade do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    //Horarios

                    cadastroE[2] = JOptionPane.showInputDialog(null, "Insira a hora de abertura do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastroE[3] = JOptionPane.showInputDialog(null, "Insira os minutos de abertura do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);

                    cadastroE[4] = JOptionPane.showInputDialog(null, "Insira a hora de encerramento do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                    cadastroE[5] = JOptionPane.showInputDialog(null, "Insira os minutos de encerramento do estacionamento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);


                    // Valores Float
                        cadastroE[6] = JOptionPane.showInputDialog(null, "Insira a porcentagem de retorno do contratante:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                        cadastroE[7] = JOptionPane.showInputDialog(null, "Insira o valor da fracao:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                        cadastroE[8] = JOptionPane.showInputDialog(null, "Insira a porcentagem de desconta da hora cheia:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                        cadastroE[9] = JOptionPane.showInputDialog(null, "Insira o valor da diária:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                        cadastroE[10] = JOptionPane.showInputDialog(null, "Insira o desconto da diária noturna:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                        cadastroE[11] = JOptionPane.showInputDialog(null, "Insira o valor da mensalidade:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);
                        cadastroE[12] = JOptionPane.showInputDialog(null, "Insira o valor do evento:", "Cadastrar Estacionamento", JOptionPane.PLAIN_MESSAGE);

                        for (int i = 0; i < cadastroE.length; i++) {
                            if (cadastroE[i].length() == 0) {
                                throw new DescricaoEmBrancoException();
                            }
                        }
                        Horario horarioEncerramento = new Horario(Integer.parseInt(cadastroE[4]), Integer.parseInt(cadastroE[5]));
                        Horario horarioAbertura = new Horario(Integer.parseInt(cadastroE[2]), Integer.parseInt(cadastroE[3]));
                        Estacionamento estacionamentoNovo = new Estacionamento(cadastroE[0], Integer.parseInt(cadastroE[1]), horarioAbertura, horarioEncerramento, Float.parseFloat(cadastroE[6]) / 100);
                        estacionamentoNovo.cadastrarValores(Float.parseFloat(cadastroE[7]), Float.parseFloat(cadastroE[10]), Float.parseFloat(cadastroE[8]), Float.parseFloat(cadastroE[9]), Float.parseFloat(cadastroE[11]), Float.parseFloat(cadastroE[12]));

                        JOptionPane.showMessageDialog(null, "\nEstacionamento cadastradocom sucesso!");
                        estacionamentos.add(estacionamentoNovo);

                    } catch (DescricaoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, e.toString() + "\nEstacionamento não cadastrado...");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Caracter invalido inserido...\nEstacionamento não cadastrado...");
                    } catch (ValorAcessoInvalidoException e) {
                        JOptionPane.showMessageDialog(null, e.toString() + "\nEstacionamento não cadastrado...");
                    }   catch (HorarioInvalidoException e){
                        JOptionPane.showMessageDialog(null, e.toString() + "\nEstacionamento não cadastrado...");
                    }


                    break;
                case 2:
                    int i = escolhaEstacionamento(estacionamentos);

                    try {
                        String cadastroA[] = new String[11];
                        cadastroA[0] = JOptionPane.showInputDialog(null, "Insira a placa do veículo:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                    //Hora de Acesso
                        cadastroA[1] = JOptionPane.showInputDialog(null, "Insira a hora de início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[2] = JOptionPane.showInputDialog(null, "Insira os minutos de início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[3] = JOptionPane.showInputDialog(null, "Insira a hora de saída do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[4] = JOptionPane.showInputDialog(null, "Insira os minutos de saída do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                    //Datas de Acesso e Saida
                        cadastroA[5] = JOptionPane.showInputDialog(null, "Insira o dia do início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[6] =  JOptionPane.showInputDialog(null, "Insira o mês do início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[7] = JOptionPane.showInputDialog(null, "Insira o ano do início do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);

                        cadastroA[8] = JOptionPane.showInputDialog(null, "Insira o dia do fim do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[9] = JOptionPane.showInputDialog(null, "Insira o mês do fim do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);
                        cadastroA[10] = JOptionPane.showInputDialog(null, "Insira o ano do fim do acesso:", "Cadastrar Acesso", JOptionPane.PLAIN_MESSAGE);


                    //Mensalista
                    int mensalistaResposta = JOptionPane.showOptionDialog(null, "O acesso é do tipo mensalista", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, null);
                    boolean mensChk = (mensalistaResposta == JOptionPane.YES_OPTION);
                    
                    //caso o acesso nao seja do tipo mensalista, ele pergunta se é do tipo evento
                    boolean evntChk = false; 
                    if(!mensChk) {
                        int eventoResposta = JOptionPane.showOptionDialog(null, "O acesso é do tipo evento", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, null);
                        evntChk = (eventoResposta == JOptionPane.YES_OPTION);
                    }
                    
                    
                        for (int j = 0; j < cadastroA.length; j++) {
                            if (cadastroA[j].length() == 0) {
                                throw new DescricaoEmBrancoException();
                            }
                        }

                    Data  dtSaida = new Data(Integer.parseInt(cadastroA[8]), Integer.parseInt(cadastroA[9]), Integer.parseInt(cadastroA[10]));
                    Data dtEntrada = new Data(Integer.parseInt(cadastroA[5]), Integer.parseInt(cadastroA[6]), Integer.parseInt(cadastroA[7]));
                    Horario entrada = new Horario(Integer.parseInt(cadastroA[1]), Integer.parseInt(cadastroA[2]));
                    Horario saida = new Horario(Integer.parseInt(cadastroA[3]), Integer.parseInt(cadastroA[4]));

                        estacionamentos.get(i).cadastrarAcesso(cadastroA[0], mensChk, evntChk, dtEntrada, dtSaida, entrada, saida);
                        JOptionPane.showMessageDialog(null, "Acesso cadastrado com sucesso!");

                    } catch(DescricaoEmBrancoException e ) {
                        JOptionPane.showMessageDialog(null, e.toString() + "\nAcesso não cadastrado...");
                    } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Caracter invalido inserido...\nEstacionamento não cadastrado...");
                    } catch (DataInvalidaException e) {
                        JOptionPane.showMessageDialog(null, e.toString() + "\nAcesso não cadastrado...");
                    }catch (HorarioInvalidoException e) {
                        JOptionPane.showMessageDialog(null, e.toString() + "\nAcesso não cadastrado...");
                    }

                    break;
                
                case 3:
                    String cadastroC[] = new String[10];
                    int j = escolhaEstacionamento(estacionamentos);

                    String evento = JOptionPane.showInputDialog(null, "Insira o nome do evento:", "Cadastrar Evento", JOptionPane.PLAIN_MESSAGE);

                    Data dtInicio = null;
                    Data dtFim = null;

                        try {
                        //Data Inicio
                            cadastroC[0] = JOptionPane.showInputDialog(null, "Insira o dia do início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                            cadastroC[1] =JOptionPane.showInputDialog(null, "Insira o mês do início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                            cadastroC[2] = JOptionPane.showInputDialog(null, "Insira o ano do início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);

                        //Data fim
                            cadastroC[3] = JOptionPane.showInputDialog(null, "Insira o dia do fim do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                            cadastroC[4] = JOptionPane.showInputDialog(null, "Insira o mês do fim do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                            cadastroC[5] = JOptionPane.showInputDialog(null, "Insira o ano do fim do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);

                        //Hora Inicio
                            cadastroC[6] = JOptionPane.showInputDialog(null, "Insira a hora de início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                            cadastroC[7] = JOptionPane.showInputDialog(null, "Insira os minutos de início do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                        //Hora Fim
                            cadastroC[8] = JOptionPane.showInputDialog(null, "Insira a hora de encerramento do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);
                            cadastroC[9] = JOptionPane.showInputDialog(null, "Insira os minutos de encerramento do evento:", "Cadastrar evento", JOptionPane.PLAIN_MESSAGE);

                            for (int k = 0; k < cadastroC.length; k++) {
                                if (cadastroC[k].length() == 0) {
                                    throw new DescricaoEmBrancoException();
                                }
                            }
                            dtFim = new Data(Integer.parseInt(cadastroC[3]), Integer.parseInt(cadastroC[4]), Integer.parseInt(cadastroC[5]));
                            dtInicio = new Data(Integer.parseInt(cadastroC[0]), Integer.parseInt(cadastroC[1]), Integer.parseInt(cadastroC[2]));
                            Horario inicio = new Horario(Integer.parseInt(cadastroC[6]), Integer.parseInt(cadastroC[7]));
                            Horario fim = new Horario(Integer.parseInt(cadastroC[8]), Integer.parseInt(cadastroC[9]));




                            estacionamentos.get(j).cadastrarEvento(evento, dtInicio, dtFim, inicio, fim);
                            JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");

                        }catch (DescricaoEmBrancoException e) {
                            JOptionPane.showMessageDialog(null, e.toString() + "\nEvento não cadastrado...");

                        }catch (DataInvalidaException e) {
                            JOptionPane.showMessageDialog(null, e.toString() + "\nEvento não cadastrado...");
                        }catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Caracter invalido inserido...\nEstacionamento não cadastrado...");
                        }catch (HorarioInvalidoException e) {
                            JOptionPane.showMessageDialog(null, e.toString() + "\nEvento não cadastrado...");
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

    public static void buscarOpcoes(ArrayList<Estacionamento> estacionamentos) {
        int opcao= 0;

         try {
            String opcao1 = JOptionPane.showInputDialog(null,
                    "BUSCAR\n" +
                            "1. Buscar acessos por placa\n" +
                            "2. Buscar estacionamento por nome\n" +
                            "0. Voltar\n\n" +
                            "Escolha uma opção:", "Buscar", JOptionPane.PLAIN_MESSAGE);
        if (opcao1.length() == 0) {
            throw new DescricaoEmBrancoException();
        }
        opcao=Integer.parseInt(opcao1);
    } catch (DescricaoEmBrancoException e) { JOptionPane.showMessageDialog(null,e.toString());}

            switch (opcao) {
                case 1:
                    try {
                        // Buscar acessos por placa
                        String placa = JOptionPane.showInputDialog(null, "Digite a placa a ser buscada:", "Buscar Acessos por Placa", JOptionPane.PLAIN_MESSAGE);

                        ArrayList<Acesso> acessosEncontrados = new ArrayList<>();
                        ArrayList<Estacionamento> estacAcesso = new ArrayList<>();

                        for (Estacionamento estac : estacionamentos) {
                            for (Acesso acesso : estac.acessos) {
                                if (acesso.getPlaca().equals(placa)) {
                                    acessosEncontrados.add(acesso);
                                    estacAcesso.add(estac);
                                }
                            }
                        }

                        if (acessosEncontrados.isEmpty()) {
                            throw new ObjetoNaoEncontradoException();
                        } else {
                            StringBuilder mensagemAcessos = new StringBuilder("Acessos encontrados:\n");
                            for (int i = 0; i < acessosEncontrados.size(); i++) {
                                Acesso acesso = acessosEncontrados.get(i);
                                Estacionamento estacionamento = estacAcesso.get(i);
                                mensagemAcessos.append("Placa: ").append(acesso.getPlaca()).append("\n");
                                mensagemAcessos.append("Estacionamento: ").append(estacionamento.getNome()).append("\n");
                                mensagemAcessos.append("Entrada: ").append(acesso.getEntrada().getHora()).append(":").append(acesso.getEntrada().getMinuto()).append("\n");
                                mensagemAcessos.append("Saída: ").append(acesso.getSaida().getHora()).append(":").append(acesso.getSaida().getMinuto()).append("\n");
                                mensagemAcessos.append("Valor do acesso: ").append(acesso.calcPrice(estacionamento.getAbrir(), estacionamento.getFechar(), estacionamento.getValores())).append("\n");
                                mensagemAcessos.append("----------------------------------------\n\n");
                                // Adicione outros detalhes do acesso e estacionamento que deseja exibir
                            }
                            JOptionPane.showMessageDialog(null, mensagemAcessos.toString());
                        }
                    } catch (ObjetoNaoEncontradoException e){ JOptionPane.showMessageDialog(null, e.toString());}
                    break;

                case 2:
                    try {
                        // Buscar estacionamento por nome
                        String nomeEstacionamento = JOptionPane.showInputDialog(null, "Digite o nome do estacionamento a ser buscado:", "Buscar Estacionamento por Nome", JOptionPane.PLAIN_MESSAGE);
                        ArrayList<Estacionamento> estacionamentosEncontrados = new ArrayList<>();

                        for (Estacionamento estacionamento : estacionamentos) {
                            if (estacionamento.getNome().equalsIgnoreCase(nomeEstacionamento)) {
                                estacionamentosEncontrados.add(estacionamento);
                            }
                        }

                        if (estacionamentosEncontrados.isEmpty()) {
                            throw new ObjetoNaoEncontradoException();
                        } else {
                            StringBuilder mensagemEstacionamentos = new StringBuilder("Estacionamentos encontrados:\n");
                            for (Estacionamento estacionamento : estacionamentosEncontrados) {
                                mensagemEstacionamentos.append("Nome: ").append(estacionamento.getNome()).append("\n");
                                mensagemEstacionamentos.append("Hora de abertura: ").append(estacionamento.getAbrir().getHorario()).append("\n");
                                mensagemEstacionamentos.append("Hora de fechamento: ").append(estacionamento.getFechar().getHorario()).append("\n");
                                mensagemEstacionamentos.append("capacidade: ").append((estacionamento.acessos.size() + "/")).append(estacionamento.getCapacidade() + "\n");
                                if (estacionamento.acessos.size() < 1) {
                                    mensagemEstacionamentos.append("nenhum acesso cadastrado");
                                } else {
                                    mensagemEstacionamentos.append("lucro do contratante:").append(estacionamento.calcRetorno());
                                }
                                //  Adicione outras características do estacionamento que deseja exibir
                            }
                            JOptionPane.showMessageDialog(null, mensagemEstacionamentos.toString());
                        }
                    } catch (ObjetoNaoEncontradoException e){ JOptionPane.showMessageDialog(null, e.toString());}
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }

        }

    public static void apagarOpcoes(ArrayList<Estacionamento> estacionamentos) {
        int opcao = 0;

            try {
            String opcao1 = JOptionPane.showInputDialog(null,
                    "APAGAR\n" +
                            "1. Apagar acessos\n" +
                            "2. Apagar estacionamentos\n" +
                            "0. Voltar\n\n" +
                            "Escolha uma opção:", "Apagar", JOptionPane.PLAIN_MESSAGE);
                if (opcao1.length() == 0) {
                    throw new DescricaoEmBrancoException();
                }
                opcao=Integer.parseInt(opcao1);
            } catch (DescricaoEmBrancoException e) { JOptionPane.showMessageDialog(null,e.toString());}

            switch (opcao) {
                case 1:
                    try {
                        estacionamentos.get(escolhaEstacionamento(estacionamentos)).apagarAcesso();
                    } catch (ObjetoNaoEncontradoException e){ JOptionPane.showMessageDialog(null, e.toString());}
                    break;

                case 2:
                    // Apagar estacionamentos
                    try {
                        if (estacionamentos.isEmpty()) {
                            throw new ObjetoNaoEncontradoException();
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
                                throw new ObjetoNaoEncontradoException();
                            }
                        }
                    }catch (ObjetoNaoEncontradoException e){ JOptionPane.showMessageDialog(null, e.toString());}
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

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

