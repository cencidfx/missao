import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Foguete> foguetes = new ArrayList<>();
        ArrayList<Satelite> satelites = new ArrayList<>();

        // ================= FOGUETES =================
        System.out.print("Quantos foguetes deseja cadastrar? ");
        int qtdFoguetes = input.nextInt();
        input.nextLine();

        for (int i = 0; i < qtdFoguetes; i++) {

            System.out.println("\nFoguete " + (i + 1));

            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Combustível: ");
            float combustivel = input.nextFloat();

            System.out.print("Carga: ");
            float carga = input.nextFloat();
            input.nextLine();

            foguetes.add(new Foguete(nome, combustivel, carga));
        }

        // ================= SATÉLITES =================
        System.out.print("\nQuantos satélites deseja cadastrar? ");
        int qtdSatelites = input.nextInt();
        input.nextLine();

        for (int i = 0; i < qtdSatelites; i++) {

            System.out.println("\nSatélite " + (i + 1));

            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Massa: ");
            float massa = input.nextFloat();
            input.nextLine();

            System.out.print("Órbita: ");
            String orbita = input.nextLine();

            System.out.print("Energia: ");
            float energia = input.nextFloat();
            input.nextLine();

            satelites.add(new Satelite(nome, massa, orbita, energia));
        }

        // ================= RELATÓRIO INICIAL =================
        System.out.println("\n===== RELATÓRIO INICIAL =====");

        for (Foguete f : foguetes) {
            System.out.println(f);
        }

        for (Satelite s : satelites) {
            System.out.println(s);
        }

        // ================= LANÇAMENTO =================
        System.out.println("\n===== LANÇAMENTO =====");

        if (!foguetes.isEmpty() && !satelites.isEmpty()) {

            System.out.print("Escolha o número do foguete (1): ");
            int iF = input.nextInt() - 1;

            System.out.print("Escolha o número do satélite (1): ");
            int iS = input.nextInt() - 1;

            Foguete f = foguetes.get(iF);
            Satelite s = satelites.get(iS);

            if (f.lancar()) {
                System.out.println("Satélite " + s.getNome() + " foi enviado!");

                s.ativarPainel();
                s.enviarDados("Dados da missão");
            } else {
                System.out.println("Falha no lançamento!");
            }
        }

        // ================= RELATÓRIO FINAL =================
        System.out.println("\n===== RELATÓRIO FINAL =====");

        for (Foguete f : foguetes) {
            System.out.println(f);
        }

        for (Satelite s : satelites) {
            System.out.println(s);
        }

        input.close();
    }
}
