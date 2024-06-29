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
    	
    	StringBuilder relatorio = new StringBuilder();
    	
    	System.out.println("Relatório de Ocupação:");
    	relatorio.append("Relatório de Ocupação: \n");
    	
        for (EntradaSaida es : registros) {
            String status = es.getVagas().getStatus() == 1 ? "Livre" : es.getVagas().getStatus() == 0 ? "Ocupado" : "Reservado";
            System.out.println("Veículo: " + es.getVeiculo().getDetalhes() + ", Vaga: " + es.getVagas().getNumero() + ", Status: " + status);
            relatorio.append("Veículo: " + es.getVeiculo().getDetalhes() + ", Vaga: " + es.getVagas().getNumero() + ", Status: " + status+"\n");
            
        }
        //return relatorio.toString();
    }

    public void gerarRelatorioFinanceiro() {
        double total = 0;
        StringBuilder relatorio = new StringBuilder();
        System.out.println("Relatório Financeiro Diário:");
        relatorio.append("Relatório Financeiro Diário: \n");
        
        for (Pagamento pagamento : pagamentos) {
            total += pagamento.getValor();
        }
        System.out.println("Total arrecadado: R$ " + total);
        relatorio.append("Total arrecadado: R$ " + total).append("\n");
        //return relatorio.toString();
    }
    
    public String relatorioEntradaSaida() {
    	
    	StringBuilder relatorio = new StringBuilder();
    	StringBuilder relatorioEntrada = new StringBuilder();
    	StringBuilder relatorioSaida = new StringBuilder();
    	
    	if(registros.isEmpty()) {
    		return "Nao ha nenhum registro de entrada ou saida";
    	}
		for(EntradaSaida registro: registros) {
			if(registro.getHorarioSaida() == 0) {
				relatorioEntrada.append("Veiculo : ").append(registro.getVeiculo().getTipo()).append("\n");
			}else {
				relatorioSaida.append("Veiculo : ").append(registro.getVeiculo().getTipo()).append("\n");
			}
		}
		if(!relatorioEntrada.isEmpty()) {
			relatorio.append("Veículos que estão no estacionamento \n:");
			relatorio.append(relatorioEntrada);
		}
		if(!relatorioSaida.isEmpty()) {
			relatorio.append("Veículos que sairam do estacionamento \n:");
			relatorio.append(relatorioSaida);
		}
		return relatorio.toString();
	}

    
}
