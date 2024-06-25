public class Vagas {
    private int numero;
    private String localizacao;
    private int status;

    public Vagas(int numero, String localizacao, int status){
        this.numero=numero;
        this.localizacao=localizacao;
        this.status=status;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
