package veiculos;
public class Moto extends Veiculo{
    private String marca;
    private int cilindradas;

    public Moto(String placa, String marca,int cilindradas){
        super(placa,"moto");
        this.marca=marca;
        this.cilindradas=cilindradas;
    }

    @Override
    public String getDetalhes() {
        return "Moto - Placa: " + placa + ", Marca: " + marca + ", Cilindradas: " + cilindradas;
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
