import java.util.List;
import java.util.ArrayList;

public class GerenciamentoVagas {
    private List<Vagas> vagas;

    public GerenciamentoVagas(){
        this.vagas=new ArrayList<>();
    }

    //status é int para converter, 0 ocupada, 1 livre e -1 reservada
    public void adicionarVaga(int numero, String localizacao, int status){

    }

    public List<Vagas> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vagas> vagas) {
        this.vagas = vagas;
    }
    
}
