public class Moto extends Veiculo{
    private String marca;
    private int cilindradas;

    public Moto(String placa, String horarioEntrada, String marca,int cilindradas){
        super(placa,"moto",horarioEntrada);
        this.marca=marca;
        this.cilindradas=cilindradas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}
