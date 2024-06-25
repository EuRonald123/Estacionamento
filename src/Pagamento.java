import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pagamento {
    private EntradaSaida entradaSaida;
    private double valor;
    private String metodoPagamento;
    private LocalDateTime horaPagamento;
    private Cliente cliente;

    public Pagamento(EntradaSaida entradaSaida, double valor, String metodoPagamento, Cliente cliente) {
        this.entradaSaida = entradaSaida;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.cliente = cliente;
        this.horaPagamento = LocalDateTime.now();
    }

    public void emitirRecibo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String horaPagamentoFormatada = horaPagamento.format(formatter);

        System.out.println("Recibo:");
        System.out.println("Veículo: " + entradaSaida.getVeiculo().getDetalhes());
        System.out.println("Tempo de Permanência: " + entradaSaida.getTempoPermanencia() + " segundos");
        System.out.println("Valor Pago: R$ " + valor);
        System.out.println("Método de Pagamento: " + metodoPagamento);
        System.out.println("Hora do Pagamento: " + horaPagamentoFormatada);
        System.out.println("Cliente: " + cliente.getNome());
    }

    public double getValor() {
        return valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }
}
