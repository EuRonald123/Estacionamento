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


    //Falta concertar (ou após sair o carro informar qual vaga ele estava para liberar a vaga automaticamente)
    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        for (EntradaSaida es : registros) {
            String status = es.getVaga().getStatus() == 1 ? "Livre" : es.getVaga().getStatus() == 0 ? "Ocupado" : "Reservado";
            System.out.println("Veículo: " + es.getVeiculo().getDetalhes() + ", Vaga: " + es.getVaga().getNumero() + ", Status: " + status);
        }
    }

    public void gerarRelatorioFinanceiro() {
        double total = 0;
        System.out.println("Relatório Financeiro Diário:");
        for (Pagamento pagamento : pagamentos) {
            System.out.println(pagamento.getValor());
            total += pagamento.getValor();
        }
        System.out.println("Total arrecadado: R$ " + total);
    }
}
