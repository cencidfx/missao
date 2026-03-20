import java.util.ArrayList;

public class CentroControle {

    private ArrayList<Foguete> foguetes = new ArrayList<>();
    private ArrayList<Satelite> satelites = new ArrayList<>();

    public void adicionarFoguete(Foguete f) {
        foguetes.add(f);
    }

    public void adicionarSatelite(Satelite s) {
        satelites.add(s);
    }

    public void iniciarMissao(int iFoguete, int iSatelite) {
        Foguete f = foguetes.get(iFoguete);
        Satelite s = satelites.get(iSatelite);

        if (f.lancar()) {
            s.ativarPainel();
            s.enviarDados("Missão iniciada");
        } else {
            System.out.println("Falha no lançamento");
        }
    }

    public void statusMissao() {
        for (Foguete f : foguetes) {
            System.out.println(f);
        }
        for (Satelite s : satelites) {
            System.out.println(s);
        }
    }
}
