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
	// private JTextArea logArea;

	public EstacionamentoGUI(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Sistema de Estacionamento");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(new BorderLayout());
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
		Object[] message = { "Placa:", placaField, "Tipo de Veículo (carro, moto, caminhão):", tipoField, };

		int option = JOptionPane.showConfirmDialog(frame, message, "Registrar Entrada", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			String placa = placaField.getText();
			String tipo = tipoField.getText();

			if (placa != null && tipo != null) {
				Veiculo veiculo = null;
				switch (tipo.toLowerCase()) {
				case "carro":
					cadastrarCarro(placa);
					break;
				case "moto":
					cadastrarMoto(placa);
					break;
				case "caminhão":
					cadastrarCaminhao(placa);
					break;
				default:
					JOptionPane.showMessageDialog(frame, "Tipo de veículo inválido!");
					return;
				}

				// logArea.append("Entrada registrada para o veículo: " + placa + "\n");
			}
		}
	}

	private void registrarSaida() {
		JTextField placaField = new JTextField();
		JTextField metodoPagamentoField = new JTextField();
		JTextField clienteNomeField = new JTextField();
		Object[] message = { "Placa:", placaField, "Método de Pagamento:", metodoPagamentoField, "Nome do Cliente:",
				clienteNomeField, };

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
					// logArea.append("Saída registrada para o veículo: " + placa + "\n");
				} else {
					JOptionPane.showMessageDialog(frame, "Veículo ou cliente não encontrado!");
				}
			}
		}
	}

	private void gerarRelatorioOcupacao() {

		JOptionPane.showConfirmDialog(frame, estacionamento.gerarRelatorioOcupacao(), 
				"Relatorio financeiro",
				JOptionPane.CLOSED_OPTION);

	}

	private void cadastrarCarro(String placa) {

		JTextField cor = new JTextField();
		JTextField modelo = new JTextField();
		JTextField marca = new JTextField();
		Object[] message = { "Cor:", cor, "Modelo:", modelo, "Marca:", marca, };

		int option = JOptionPane.showConfirmDialog(frame, message, "Dados adicionais do carro",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String corC = cor.getText();
			String modeloC = modelo.getText();
			String marcaC = marca.getText();
			if (!corC.isEmpty() && !modeloC.isEmpty() && !marcaC.isEmpty()) {
				Veiculo veiculo = new Carro(placa, corC, marcaC, modeloC);
				estacionamento.registrarEntrada(veiculo);
				return;
			}
			JOptionPane.showMessageDialog(frame, "Há campos não preenchidos, tente novamente");

		}
	}

	private void cadastrarCaminhao(String placa) {

		JTextField comprimento = new JTextField();
		JTextField cargaMax = new JTextField();

		Object[] message = { "Comprimento :", comprimento, "Carga Maxima:", cargaMax };

		int option = JOptionPane.showConfirmDialog(frame, message, "Dados adicionais do caminhao",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			String comp = comprimento.getText();
			String carga = cargaMax.getText();
			if (!comp.isEmpty() && !carga.isEmpty()) {
				try {
					Veiculo veiculo = new Caminhão(placa, Float.parseFloat(carga), Float.parseFloat(comp));
					estacionamento.registrarEntrada(veiculo);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(frame, "Dados inseridos incorretos");
				}

				return;
			}
			JOptionPane.showMessageDialog(frame, "Há campos não preenchidos, tente novamente");

		}
	}

	private void cadastrarMoto(String placa) {

		JTextField marca = new JTextField();
		JTextField cilindrada = new JTextField();

		Object[] message = { "Marca :", marca, "Cilindradas :", cilindrada };

		int option = JOptionPane.showConfirmDialog(frame, message, "Dados adicionais da moto",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			String marcaMoto = marca.getText();
			String cilin = cilindrada.getText();
			if (!marcaMoto.isEmpty() && !cilin.isEmpty()) {
				try {
					Veiculo veiculo = new Moto(placa, marcaMoto, Integer.parseInt(cilin));
					estacionamento.registrarEntrada(veiculo);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(frame, "Dados inseridos incorretos");
				}

				return;
			}
			JOptionPane.showMessageDialog(frame, "Há campos não preenchidos, tente novamente");

		}
	}

	private void gerarRelatorioFinanceiro() {

		JOptionPane.showConfirmDialog(frame, estacionamento.gerarRelatorioFinanceiro(),
				"Relatorio financeiro",
				JOptionPane.CLOSED_OPTION);

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
