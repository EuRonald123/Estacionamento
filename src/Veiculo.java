public class Veiculo {
    private String placa;
    private String tipo;
    private String horarioEntrada;

    public Veiculo(String placa, String tipo, String horarioEntrada){
        this.placa=placa;
        this.tipo=tipo;
        this.horarioEntrada=horarioEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    
}
