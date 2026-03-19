public class Satelite {

    private String nome;
    private float massa;
    private String orbita;
    private float energia;
    private String status;

    public Satelite(String nome, float massa, String orbita, float energia) {
        this.nome = nome;
        this.massa = massa;
        this.orbita = orbita;
        this.energia = energia;
        this.status = "Em solo";
    }
    public void ativarPainel() {
        energia += 20;
        if (energia > 100) energia = 100;
        status = "Ativo";
    }
    public void enviarDados(String mensagem) {
        if (status.equals("Ativo")) {
            System.out.println("Satélite " + nome + " enviando: " + mensagem);
        } else {
            System.out.println("Satélite " + nome + " não está ativo.");
        }
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Satélite: " + nome +
                " | Massa: " + massa +
                " | Órbita: " + orbita +
                " | Energia: " + energia +
                " | Status: " + status;
    }
}