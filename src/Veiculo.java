public abstract class Veiculo {
    protected String placa;
    protected String tipo;
    protected long horarioEntrada;

    public Veiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public long getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(long horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public abstract String getDetalhes();
}

