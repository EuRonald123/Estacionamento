public class Pagamento {
    private EntradaSaida entradaSaida;
    private double valor;
    private String metodoPagamento;

    public Pagamento(EntradaSaida entradaSaida, double valor, String metodoPagamento) {
        this.entradaSaida = entradaSaida;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public void emitirRecibo() {
        System.out.println("Recibo:");
        System.out.println("Veículo: " + entradaSaida.getVeiculo().getDetalhes());
        System.out.println("Tempo de Permanência: " + entradaSaida.getTempoPermanencia() + " segundos");
        System.out.println("Valor Pago: R$ " + valor);
        System.out.println("Método de Pagamento: " + metodoPagamento);
    }
}

