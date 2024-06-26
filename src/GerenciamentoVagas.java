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

    //funciona
    public Vagas buscarVagaPorNumero(int numero) {
        for (Vagas x : vagas) {
            if (x.getNumero() == numero) {
                return x;
            }
        }
        return null;
    }

    //mais complicadinho de fazer(não sei se funciona)
    public boolean atualizarVaga(int numero, int novoStatus){
        for (Vagas vagaAchada : vagas) {
            if (vagaAchada.getNumero() == numero) {
                if(vagaAchada!=null){
                    vagaAchada.setStatus(novoStatus);
                    return true;
                }
            }
        }
        return false;
    }
        
    //funciona
    //percorre o array e procura por vagas disponiveis
    public List<Vagas> getVagasDisponiveis(){
        List<Vagas> vagasDisponiveis=new ArrayList<>();
        for(Vagas x:vagas){
            if(x.getStatus()==1){
                vagasDisponiveis.add(x);
            }
        }
        return vagasDisponiveis;
    }


    //falta adicionar um mecanismo para reservar vaga para um determinado veiculo
    public Vagas buscarVagasLivre(String tipoVeiculo) {
        for (Vagas vaga : vagas) {
            if (vaga.getStatus() == 1) { // 1 para livre
                return vaga;
            }
        }
        return null;
    }

    
    
}
