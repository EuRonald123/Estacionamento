import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vagas> vagas;
    private List<Cliente> clientes;
    private Relatorio relatorio;

    public Estacionamento() {
        vagas = new ArrayList<>();
        clientes = new ArrayList<>();
        relatorio = new Relatorio();
    }

    public void cadastrarVagas(int numero, String localizacao, int status) {
        vagas.add(new Vagas(numero, localizacao, status));
    }

    public void cadastrarCliente(String nome, String telefone, String email) {
        clientes.add(new Cliente(nome, telefone, email));
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public Vagas buscarVagasLivre(String tipoVeiculo) {
        for (Vagas vaga : vagas) {
            if (vaga.getStatus() == 1) { // 1 para livre
                return vaga;
            }
        }
        return null;
    }

    public void registrarEntrada(Veiculo veiculo) {
        Vagas vagas = buscarVagasLivre(veiculo.getTipo());
        if (vagas != null) {
            vagas.setStatus(0); // marcar como ocupado
            EntradaSaida entradaSaida = new EntradaSaida(veiculo, vagas);
            relatorio.adicionarRegistro(entradaSaida);
        } else {
            System.out.println("Não há vagas disponíveis para o tipo de veículo: " + veiculo.getTipo());
        }
    }

    public void registrarSaida(Veiculo veiculo, String metodoPagamento, Cliente cliente) {
        for (EntradaSaida es : relatorio.getRegistros()) {
            if (es.getVeiculo().equals(veiculo) && es.getVagas().getStatus() == 0) { // 0 para ocupado
                es.registrarSaida();
                double valor = calcularValor(es.getTempoPermanencia(), veiculo.getTipo());
                es.getVagas().setStatus(1); // marcar como livre
                System.out.println("Saída registrada para o veículo: " + veiculo.getDetalhes());
                System.out.println("Valor a ser pago: R$ " + valor);
                realizarPagamento(es, valor, metodoPagamento,cliente);
                break;
            }
        }
    }
    public void realizarPagamento(EntradaSaida entradaSaida, double valor, String metodoPagamento,Cliente cliente) {
        Pagamento pagamento = new Pagamento(entradaSaida, valor, metodoPagamento,cliente);
        relatorio.adicionarPagamento(pagamento);
        pagamento.emitirRecibo();
    }

    private double calcularValor(long tempoPermanencia, String tipoVeiculo) {
        // Implementar a lógica de cálculo de acordo com a tabela de preços.
        // Exemplo: R$2 por minuto para Carros, R$3 para Caminhões, R$1 para Motos
        double valorPorMinuto;
        switch (tipoVeiculo) {
            case "carro":
                valorPorMinuto = 2.0;
                break;
            case "caminhão":
                valorPorMinuto = 3.0;
                break;
            case "moto":
                valorPorMinuto = 1.0;
                break;
            default:
                valorPorMinuto = 0.0;
                break;
        }
        return (tempoPermanencia / 60.0) * valorPorMinuto;
    }

    public void gerarRelatorioOcupacao() {
        relatorio.gerarRelatorioOcupacao();
    }

    public void gerarRelatorioFinanceiro() {
        relatorio.gerarRelatorioFinanceiro();
    }
}
