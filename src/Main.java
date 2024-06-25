public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();

        // Cadastro de vagas
        estacionamento.cadastrarVagas(1, "A1", 1);
        estacionamento.cadastrarVagas(2, "A2", 1);
        estacionamento.cadastrarVagas(3, "A3", 1);

        // Cadastro de clientes
        estacionamento.cadastrarCliente("João Silva", "123456789", "joao@example.com");
        Cliente cliente=estacionamento.buscarCliente("João Silva");

        // Registro de veículos
        Carro carro = new Carro("ABC-1234", "Vermelho", "Ford", "Fiesta");
        System.out.println("Registrando entrada do carro...");
        estacionamento.registrarEntrada(carro);

        // Simulando uma espera de 61 segundos para teste
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Registrando saída do carro...");
        estacionamento.registrarSaida(carro, "cartão", cliente);

        // Gerar relatórios
        System.out.println("Gerando relatório de ocupação...");
        estacionamento.gerarRelatorioOcupacao();
        System.out.println("Gerando relatório financeiro...");
        estacionamento.gerarRelatorioFinanceiro();
    }
}
