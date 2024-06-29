package view;
import javax.swing.*;

import gerenciador.Cliente;
import gerenciador.EntradaSaida;
import gerenciador.Estacionamento;
import veiculos.Caminhão;
import veiculos.Carro;
import veiculos.Moto;
import veiculos.Veiculo;

//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstacionamentoGUI {
    private Estacionamento estacionamento;
    private JFrame frame;
    //private JTextArea logArea;

    public EstacionamentoGUI(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Estacionamento");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel);

        // Botões de ações
        JButton btnEntrada = new JButton("Registrar Entrada");
        JButton btnSaida = new JButton("Registrar Saída");
        JButton btnRelatorioOcupacao = new JButton("Relatório de Ocupação");
        JButton btnRelatorioFinanceiro = new JButton("Relatório Financeiro");

        buttonPanel.add(btnEntrada);
        buttonPanel.add(btnSaida);
        buttonPanel.add(btnRelatorioOcupacao);
        buttonPanel.add(btnRelatorioFinanceiro);

        // Ações dos botões
        btnEntrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEntrada();
            }
        });

        btnSaida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarSaida();
            }
        });

        btnRelatorioOcupacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarRelatorioOcupacao();
            }
        });

        btnRelatorioFinanceiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarRelatorioFinanceiro();
            }
        });

        frame.setVisible(true);
    }

    private void registrarEntrada() {
        JTextField placaField = new JTextField();
        JTextField tipoField = new JTextField();
        Object[] message = {
            "Placa:", placaField,
            "Tipo de Veículo (carro, moto, caminhão):", tipoField,
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Registrar Entrada", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String placa = placaField.getText();
            String tipo = tipoField.getText();

            if (placa != null && tipo != null) {
                Veiculo veiculo = null;
                switch (tipo.toLowerCase()) {
                    case "carro":
                        veiculo = new Carro(placa, "Vermelho", "Marca", "Modelo");
                        break;
                    case "moto":
                        veiculo = new Moto(placa, "Marca", 150);
                        break;
                    case "caminhão":
                        veiculo = new Caminhão(placa, 10000, 15);
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Tipo de veículo inválido!");
                        return;
                }

                estacionamento.registrarEntrada(veiculo);
                //logArea.append("Entrada registrada para o veículo: " + placa + "\n");
            }
        }
    }

    private void registrarSaida() {
        JTextField placaField = new JTextField();
        JTextField metodoPagamentoField = new JTextField();
        JTextField clienteNomeField = new JTextField();
        Object[] message = {
            "Placa:", placaField,
            "Método de Pagamento:", metodoPagamentoField,
            "Nome do Cliente:", clienteNomeField,
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Registrar Saída", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String placa = placaField.getText();
            String metodoPagamento = metodoPagamentoField.getText();
            String clienteNome = clienteNomeField.getText();

            if (placa != null && metodoPagamento != null && clienteNome != null) {
                Veiculo veiculo = buscarVeiculo(placa);
                Cliente cliente = estacionamento.buscarCliente(clienteNome);

                if (veiculo != null && cliente != null) {
                    estacionamento.registrarSaida(veiculo, metodoPagamento, cliente);
                    //logArea.append("Saída registrada para o veículo: " + placa + "\n");
                } else {
                    JOptionPane.showMessageDialog(frame, "Veículo ou cliente não encontrado!");
                }
            }
        }
    }

    private void gerarRelatorioOcupacao() {
        //logArea.append("Relatório de Ocupação:\n");
        estacionamento.gerarRelatorioOcupacao();
    }

    private void gerarRelatorioFinanceiro() {
        //logArea.append("Relatório Financeiro:\n");
        estacionamento.gerarRelatorioFinanceiro();
    }

    private Veiculo buscarVeiculo(String placa) {
        for (EntradaSaida es : estacionamento.getRelatorio().getRegistros()) {
            if (es.getVeiculo().getPlaca().equals(placa)) {
                return es.getVeiculo();
            }
        }
        return null;
    }
}
