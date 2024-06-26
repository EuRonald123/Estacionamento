public class EntradaSaida {
    private Veiculo veiculo;
    private Vagas vaga;
    private long horarioSaida;

    public EntradaSaida(Veiculo veiculo, Vagas vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.veiculo.setHorarioEntrada(System.currentTimeMillis());
    }

    public void registrarSaida() {
        this.horarioSaida = System.currentTimeMillis();
        this.vaga.setStatus(1);
    }

    public long getTempoPermanencia() {
        return (horarioSaida - veiculo.getHorarioEntrada()) / 1000;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vagas getVaga() {
        return vaga;
    }

    public long getHorarioSaida() {
        return horarioSaida;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setVagas(Vagas vaga) {
        this.vaga = vaga;
    }

    public void setHorarioSaida(long horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
    
}
