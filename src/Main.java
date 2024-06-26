import java.util.Scanner;
import java.util.List;
//import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);

        // Cadastro de vagas
        estacionamento.adicionarVaga(1, "A1", 0);
        estacionamento.adicionarVaga(2, "A2", 1);
        estacionamento.adicionarVaga(3, "A3", 1);
        

        //teste Buscar vaga por numero
        System.out.println("***teste buscar vaga por nunmero***");
        String localização=estacionamento.buscarVagaPorNumero(3).getLocalizacao();
        System.out.println("Localização: "+localização);
        // Cadastro de clientes
        estacionamento.cadastrarCliente("Joao", "123456789", "joao@example.com");
        //Cliente cliente = estacionamento.buscarCliente("João Silva");

        estacionamento.cadastrarCliente("Ronald", "987654321", "ron@example.com");


        System.out.println("\n***Teste Buscar Cliente pelo nome");
        Cliente teste=estacionamento.buscarCliente("Joao");
        System.out.printf("Nome: %s  numero: %s  email: %s \n",teste.getNome(), teste.getTelefone(), teste.getEmail());

        Cliente teste2=estacionamento.buscarCliente("Ronald");
        System.out.printf("\nNome: %s  numero: %s email: %s  \n",teste2.getNome(), teste2.getTelefone(), teste2.getEmail());



        //Não tá atualizando as vagas
        //int vaga=estacionamento.buscarVagaPorNumero(1).getStatus();
        //System.out.println(vaga);
        //estacionamento.atualizarVaga(1, 0);
        //System.out.println(vaga);
        //new EstacionamentoGUI(estacionamento);
        

        List<Vagas> vagasD = estacionamento.getVagasDisponiveis();
        System.out.println("\n*** Teste Vagas Disponiveis***");
        for(Vagas x:vagasD){
            System.out.println("Numero: "+x.getNumero()+" Localização: " + x.getLocalizacao());
        }
        scanner.close();
    }
}
