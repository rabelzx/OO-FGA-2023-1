package trabalhoOO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

public class FormEstacionamento extends JFrame implements ActionListener {
    private JTextField fieldNome,
            horaAbertura_Field, minutoAbertura_Field, horaFechamento_Field, minutoFechamento_Field,
            valorContratante_field,capacidade_Field;
    public FormEstacionamento() {
        int screenHeight = 280, screenWidth = 400;
        //Constroi a interface
        setTitle("Cadastrar estacionamento");
        setVisible(true);
        setSize(screenWidth,screenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);



        //Botão de Cancelar
        JButton Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(screenWidth-150,screenHeight-100,100,30);
        add(Cancelar);
        Cancelar.addActionListener(this::Cancelar);
        //Botão de Confirmar
        JButton Confirmar = new JButton("Confirmar");
        Confirmar.setBounds(screenWidth-250,screenHeight-100,100,30);
        add(Confirmar);
        Confirmar.addActionListener(this);

        //Constroi o campo para inserir o nome
        JLabel nome = new JLabel("Nome:");
        nome.setFont(new Font("Arial", Font.BOLD,20));
        nome.setBounds(1,1,70,40);
        fieldNome = new JTextField();
        fieldNome.setBounds(70,1,300,30);
        add(fieldNome);
        add(nome);


        //Costrói o campo para inserir a hora de abertura
        JLabel horaAbertura = new JLabel("Abre as:");
        horaAbertura.setFont(new Font("Arial", Font.BOLD,16));
        horaAbertura.setBounds(1,50,70,40);
        horaAbertura_Field = new JTextField();
        horaAbertura_Field.setBounds(70,50,40,30);
        add(horaAbertura_Field);
        add(horaAbertura);
        //Costrói o campo para inserir o minuto de abertura
        minutoAbertura_Field = new JTextField();
        minutoAbertura_Field.setBounds(110,50,40,30);
        add(minutoAbertura_Field);


        //Costrói o campo para inserir a hora de Fechamento
        JLabel horaFechamento = new JLabel("Fecha as:");
        horaFechamento.setFont(new Font("Arial", Font.BOLD,16));
        horaFechamento.setBounds(210,50,80,40);
        horaFechamento_Field = new JTextField();
        horaFechamento_Field.setBounds(290,50,40,30);
        add(horaFechamento);
        add(horaFechamento_Field);
        //Costrói o campo para inserir o minuto de Fechamento
        minutoFechamento_Field = new JTextField();
        minutoFechamento_Field.setBounds(330,50,40,30);
        add(minutoFechamento_Field);

        //Costrói o campo para inserir a capacidade do estacionamento
        JLabel capacidade = new JLabel("Capacidade:");
        add(capacidade);
        capacidade.setFont(new Font("Arial", Font.BOLD,15));
        capacidade.setBounds(1,100,100,40);
        capacidade_Field = new JTextField();
        capacidade_Field.setBounds(110,100,40,30);
        add(capacidade_Field);

        //Costrói o campo para inserir o valor do contratante
        JLabel retornoCon = new JLabel("Retorno Contratante:");
        add(retornoCon);
        retornoCon.setFont(new Font("Arial", Font.BOLD,14));
        retornoCon.setBounds(210,100,70,30);

        valorContratante_field = new JTextField();
        add(valorContratante_field);
        valorContratante_field.setBounds(290,100,40,30);

        JLabel percent = new JLabel("%");
        add(percent);
        percent.setFont(new Font("Arial", Font.BOLD,14));
        percent.setBounds(330,100,70,30);





    }

    private void Cancelar(ActionEvent actionEvent) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Estacionamento "+fieldNome.getText()+" cadastrado com sucesso");
        
    }
}
