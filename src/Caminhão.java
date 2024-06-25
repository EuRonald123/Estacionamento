public class Caminhão extends Veiculo {
    private float cargaMax;
    private float comprimentoCaminhão;

    public Caminhão(String placa, float cargaMax,float comprimentoCaminhão){
        super(placa,"caminhao");
        this.cargaMax=cargaMax;
        this.comprimentoCaminhão=comprimentoCaminhão;
    }

    public float getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(float cargaMax) {
        this.cargaMax = cargaMax;
    }

    public float getComprimentoCaminhão() {
        return comprimentoCaminhão;
    }

    public void setComprimentoCaminhão(float comprimentoCaminhão) {
        this.comprimentoCaminhão = comprimentoCaminhão;
    }
}
