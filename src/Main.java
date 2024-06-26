import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);

        // Cadastro de vagas
        estacionamento.cadastrarVagas(1, "A1", 1);
        estacionamento.cadastrarVagas(2, "A2", 1);
        estacionamento.cadastrarVagas(3, "A3", 1);

        new EstacionamentoGUI(estacionamento);
        // Cadastro de clientes
        estacionamento.cadastrarCliente("Joao", "123456789", "joao@example.com");
        //Cliente cliente = estacionamento.buscarCliente("João Silva");

        estacionamento.cadastrarCliente("Ronald", "123456789", "ron@example.com");
        
        scanner.close();
    }
}
