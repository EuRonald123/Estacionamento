public class Carro extends Veiculo {
    private String cor;
    private String modelo;
    private String marca;

    public Carro(String placa, String horarioEntrada, String cor, String modelo, String marca){
        super(placa,"carro",horarioEntrada);
        this.cor=cor;
        this.modelo=modelo;
        this.marca=marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
