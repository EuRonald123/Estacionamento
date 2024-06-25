import java.util.List;
import java.util.ArrayList;

public class GerenciamentoVagas {
    private List<Vagas> vagas;

    public GerenciamentoVagas(){
        this.vagas=new ArrayList<>();
    }

    //status é int para converter, 0 ocupada, 1 livre e -1 reservada
    public void adicionarVaga(int numero, String localizacao, int status){
        Vagas vaga = new Vagas(numero,localizacao,status);
        vagas.add(vaga);
    }

    //mais complicadinho de fazer
    public boolean atualizarVaga(int numero, int novoStatus){
        Vagas vagaAchada=buscarVagaPorNumero(numero);
        if(vagaAchada!=null){
            if(vagaAchada.getStatus()!=1){
                vagaAchada.setStatus(novoStatus);
                return true;
            }
        }
        return false;
        
    }

    //percorre o array e procura por vagas disponiveis
    public List<Vagas> getVagasDisponiveis(String tipoVeiculo){
        List<Vagas> vagasDisponiveis=new ArrayList<>();
        for(Vagas x:vagas){
            if(x.getStatus()==1){
                vagasDisponiveis.add(x);
            }
        }
        return vagasDisponiveis;
    }

    public Vagas buscarVagaPorNumero(int numero) {
        for (Vagas x : vagas) {
            if (x.getNumero() == numero) {
                return x;
            }
        }
        return null;
    }

    public List<Vagas> getTodasVagas() {
        return new ArrayList<>(vagas);
    }
    
}
