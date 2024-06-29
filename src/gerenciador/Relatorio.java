package gerenciador;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private List<EntradaSaida> registros;
    private List<Pagamento> pagamentos;

    public Relatorio() {
        registros = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public void adicionarRegistro(EntradaSaida entradaSaida) {
        registros.add(entradaSaida);
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public List<EntradaSaida> getRegistros() {
        return registros;
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        for (EntradaSaida es : registros) {
            String status = es.getVagas().getStatus() == 1 ? "Livre" : es.getVagas().getStatus() == 0 ? "Ocupado" : "Reservado";
            System.out.println("Veículo: " + es.getVeiculo().getDetalhes() + ", Vaga: " + es.getVagas().getNumero() + ", Status: " + status);
        }
    }

    public void gerarRelatorioFinanceiro() {
        double total = 0;
        System.out.println("Relatório Financeiro Diário:");
        for (Pagamento pagamento : pagamentos) {
            total += pagamento.getValor();
        }
        System.out.println("Total arrecadado: R$ " + total);
    }

    
}
