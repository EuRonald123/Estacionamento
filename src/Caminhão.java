public class Caminhão extends Veiculo {
    private float cargaMax;
    private float comprimentoCaminhao;

    public Caminhão(String placa, float cargaMax,float comprimentoCaminhão){
        super(placa,"caminhao");
        this.cargaMax=cargaMax;
        this.comprimentoCaminhao=comprimentoCaminhão;
    }

    @Override
    public String getDetalhes() {
        return "Caminhão - Placa: " + placa + ", Carga Máxima: " + cargaMax + "kg, Comprimento: " + comprimentoCaminhao + "m";
    }

    public float getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(float cargaMax) {
        this.cargaMax = cargaMax;
    }

    public float getComprimentoCaminhao() {
        return comprimentoCaminhao;
    }

    public void setComprimentoCaminhao(float comprimentoCaminhao) {
        this.comprimentoCaminhao = comprimentoCaminhao;
    }
}
