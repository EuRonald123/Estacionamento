import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Cadastro de vagas
        estacionamento.cadastrarVagas(1, "A1", 1);
        estacionamento.cadastrarVagas(2, "A2", 1);
        estacionamento.cadastrarVagas(3, "A3", 1);

        // Cadastro de clientes
        estacionamento.cadastrarCliente("João Silva", "123456789", "joao@example.com");
        Cliente cliente = estacionamento.buscarCliente("João Silva");

        estacionamento.cadastrarCliente("Ronald", "123456789", "ron@example.com");
        Cliente cliente2 = estacionamento.buscarCliente("Ronald");
        Carro carro = new Carro("ABC-1234", "Vermelho", "Ford", "Fiesta");
        Moto moto = new Moto("AB-34A1", "Honda", 1200);

        // Loop while para gerenciar entrada e saída de veículos
        while (continuar) {
            System.out.println("Digite 'entrada carro' para registrar a entrada de um carro,");
            System.out.println("'saida carro' para registrar a saída de um carro,");
            System.out.println("'entrada moto' para registrar a entrada de uma moto,");
            System.out.println("'saida moto' para registrar a saída de uma moto,");
            System.out.println("'relatorio' para gerar os relatórios,");
            System.out.println("ou 'sair' para encerrar:");

            String comando = scanner.nextLine();
            

            switch (comando.toLowerCase()) {
                case "entrada carro":
                    //Carro carro = new Carro("ABC-1234", "Vermelho", "Ford", "Fiesta");
                    System.out.println("Registrando entrada do carro...");
                    estacionamento.registrarEntrada(carro);
                    break;
                case "saida carro":
                
                    System.out.println("Registrando saída do carro...");
                    estacionamento.registrarSaida(carro, "dinheiro", cliente);
                    break;
                case "entrada moto":
                    //Moto moto = new Moto("AB-34A1", "Honda", 1200);
                    System.out.println("Registrando entrada da moto...");
                    estacionamento.registrarEntrada(moto);
                    break;
                case "saida moto":
                    System.out.println("Registrando saída da moto...");
                    estacionamento.registrarSaida(moto, "dinheiro", cliente2);
                    break;
                case "relatorio":
                    System.out.println("Gerando relatório de ocupação...");
                    estacionamento.gerarRelatorioOcupacao();
                    System.out.println("Gerando relatório financeiro...");
                    estacionamento.gerarRelatorioFinanceiro();
                    break;
                case "sair":
                    continuar = false;
                    break;
                default:
                    System.out.println("Comando inválido. Tente novamente.");
                    break;
            }

        }
        System.out.println("Gerando relatório de ocupação...");
        estacionamento.gerarRelatorioOcupacao();
        System.out.println("Gerando relatório financeiro...");
        estacionamento.gerarRelatorioFinanceiro();
        // Fechar Scanner
        scanner.close();
    }
}
