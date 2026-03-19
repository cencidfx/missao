public class Foguete {

    private String nome;
    private float combustivel;
    private float cargaMaxima;
    private String status;

    public Foguete(String nome, float combustivel, float cargaMaxima) {
        this.nome = nome;
        this.combustivel = combustivel;
        this.cargaMaxima = cargaMaxima;
        this.status = "Pronto";
    }
    public void abastecer(float quantidade) {
        combustivel += quantidade;
    }
    public boolean lancar() {
        if (combustivel > 500) {
            status = "Lançando";
            combustivel -= 500;
            status = "Em órbita";
            return true;
        } else {
            status = "Falha";
            return false;
        }
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Foguete: " + nome +
                " | Combustível: " + combustivel +
                " | Carga: " + cargaMaxima +
                " | Status: " + status;
    }
}