import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Foguete> foguetes = new ArrayList<>();
        ArrayList<Satelite> satelites = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== CENTRO DE CONTROLE =====");
            System.out.println("1 - Cadastrar Foguete");
            System.out.println("2 - Cadastrar Satélite");
            System.out.println("3 - Listar Dados");
            System.out.println("4 - Simular Lançamento");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {

                // ================= CADASTRO FOGUETE =================
                case 1:

                    System.out.print("Nome do foguete: ");
                    String nomeF = input.nextLine();

                    System.out.print("Combustível: ");
                    float combustivel = input.nextFloat();

                    System.out.print("Carga: ");
                    float carga = input.nextFloat();
                    input.nextLine();

                    foguetes.add(new Foguete(nomeF, combustivel, carga));

                    System.out.println("Foguete cadastrado!");
                    break;

                // ================= CADASTRO SATELITE =================
                case 2:

                    System.out.print("Nome do satélite: ");
                    String nomeS = input.nextLine();

                    System.out.print("Massa: ");
                    float massa = input.nextFloat();
                    input.nextLine();

                    System.out.print("Órbita: ");
                    String orbita = input.nextLine();

                    System.out.print("Energia: ");
                    float energia = input.nextFloat();
                    input.nextLine();

                    satelites.add(new Satelite(nomeS, massa, orbita, energia));

                    System.out.println("Satélite cadastrado!");
                    break;

                // ================= LISTAGEM =================
                case 3:

                    System.out.println("\n--- FOGUETES ---");
                    for (Foguete f : foguetes) {
                        System.out.println(f);
                        System.out.println("----------------");
                    }

                    System.out.println("\n--- SATÉLITES ---");
                    for (Satelite s : satelites) {
                        System.out.println(s);
                        System.out.println("----------------");
                    }

                    break;

                // ================= LANÇAMENTO =================
                case 4:

                    if (foguetes.isEmpty() || satelites.isEmpty()) {
                        System.out.println("Cadastre foguetes e satélites primeiro!");
                        break;
                    }

                    System.out.println("\nEscolha um foguete:");
                    for (int i = 0; i < foguetes.size(); i++) {
                        System.out.println((i + 1) + " - " + foguetes.get(i).getNome());
                    }

                    int iF = input.nextInt() - 1;

                    System.out.println("Escolha um satélite:");
                    for (int i = 0; i < satelites.size(); i++) {
                        System.out.println((i + 1) + " - " + satelites.get(i).getNome());
                    }

                    int iS = input.nextInt() - 1;
                    input.nextLine();

                    Foguete f = foguetes.get(iF);
                    Satelite s = satelites.get(iS);

                    System.out.println("\nPreparando lançamento...");

                    if (f.lancar()) {

                        System.out.println("Satélite " + s.getNome() + " em órbita!");

                        // CORRIGIDO AQUI (sem if)
                        s.ativarPainel();
                        s.enviarDados("Dados coletados com sucesso!");

                    } else {
                        System.out.println("Falha no lançamento!");
                    }

                    break;

            }

        } while (opcao != 5);

        System.out.println("Encerrando sistema...");
        input.close();
    }
}
