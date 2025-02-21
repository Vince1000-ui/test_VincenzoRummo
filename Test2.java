import java.util.Scanner;

public class Test2 {
    private static String nome;
    private static String password;
    private static String domandaSegreta;
    private static String rispostaSegreta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean esci = false;

        while (!esci) {
            System.out.println("cosa vuoi fare?");
            System.out.println("1. Registrazione");
            System.out.println("2. Login");
            System.out.println("3. Modifica dati");
            System.out.println("4. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    registrazione(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    modificaDati(scanner);
                    break;
                case 4:
                    esci = true;
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
        scanner.close();
    }

    // Metodo per la registrazione di un nuovo utente
    private static void registrazione(Scanner scanner) {
        System.out.print("Inserisci il tuo nome: ");
        nome = scanner.nextLine();
        System.out.print("Inserisci la tua password: ");
        password = scanner.nextLine();
        System.out.print("Scegli una domanda segreta (es. Il nome del tuo primo animale?): ");
        domandaSegreta = scanner.nextLine();
        System.out.print("Inserisci la risposta alla domanda segreta: ");
        rispostaSegreta = scanner.nextLine();
        System.out.println("Registrazione completata con successo!");
    }

    // Metodo per effettuare il login
    private static void login(Scanner scanner) {
        if (nome == null) {
            System.out.println("Nessun utente registrato! Effettua prima la registrazione.");
            return;
        }

        System.out.print("Inserisci il tuo nome: ");
        String nomeInput = scanner.nextLine();
        System.out.print("Inserisci la tua password: ");
        String passwordInput = scanner.nextLine();

        if (nomeInput.toLowerCase().trim().equals(nome) && passwordInput.equals(password)) {
            System.out.println("Login effettuato con successo! Benvenuto, " + nome + "!");
        } else {
            System.out.println("Nome utente o password errati.");
        }
    }

    // Metodo per modificare i dati dell'utente
    private static void modificaDati(Scanner scanner) {
        if (nome == null) {
            System.out.println("Nessun utente registrato! Effettua prima la registrazione.");
            return;
        }

        System.out.println("Per modificare i tuoi dati, rispondi alla tua domanda segreta:");
        System.out.println(domandaSegreta);
        System.out.print("Risposta: ");
        String rispostaInput = scanner.nextLine();

        if (rispostaInput.equalsIgnoreCase(rispostaSegreta)) {
            System.out.print("Inserisci il nuovo nome: ");
            nome = scanner.nextLine();
            System.out.print("Inserisci la nuova password: ");
            password = scanner.nextLine();
            System.out.print("Scegli una nuova domanda segreta: ");
            domandaSegreta = scanner.nextLine();
            System.out.print("Inserisci la nuova risposta segreta: ");
            rispostaSegreta = scanner.nextLine();
            System.out.println("Dati modificati con successo!");
        } else {
            System.out.println("Risposta errata. Impossibile modificare i dati.");
        }
    }
}