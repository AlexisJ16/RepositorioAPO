package ui;

import java.time.LocalDate;
import java.util.Scanner;

import model.NeoTunesController;
import model.TypeGender;

public class NeoTunesManager {

    private Scanner sc;
    private NeoTunesController NeoTunesController;

    public NeoTunesManager() {

        this.sc = new Scanner(System.in);
        this.NeoTunesController = new NeoTunesController();

    }

    public void menu() {
        System.out.println("\nBienvenido a NeoTunes, ¡tu mejor app de Streaming de musica!\n");

        boolean exit = false;

        while (!exit) {

            System.out.println("**MENU**"
                    + "\n1. Registrar un usuario Consumidor Estandar"
                    + "\n2. Registrar un usuario Consumidor Premium\n "
                    + "\n3. Registrar un usuario Productor Artista"
                    + "\n4. Registrar un usuario Productor Creador de Contenido\n"
                    + "\n0. Para salir del programa\n");
            // Saves the user's choice.
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    registerStandardConsumer();
                    break;

                case 2:
                    registerPremiumConsumer();
                    break;

                case 3:
                    registerProducerArtist();
                    break;

                case 4:
                    registerProducerContentCreator();
                    break;

                case 5:
                    registerSong();
                    break;

                case 0:
                    System.out.println("\nGracias por usar el programa!\n");
                    exit = true;
                    break;
            }

        }
    }

    /**
     * Executable menu.
     * 
     * @param args String: main argument.
     */
    public static void main(String[] args) {
        NeoTunesManager menu = new NeoTunesManager();
        menu.menu();
    }

    private void registerStandardConsumer() {

        System.out.println("\nVas a registrar un Usuario Consumidor Estandar!");

        System.out.println("\nIngresa el nombre del usuario");
        sc.nextLine(); // Refresh buffer.
        String nickname = sc.nextLine();

        System.out.println("\nIngresa el id del usuario");
        int id = sc.nextInt();

        System.out.println("Ingresa la fecha de registro del usuario en la plataforma (YYYY-MM-DD):");
        String dateOfAffiliation = sc.nextLine();

        int year = Integer.parseInt(dateOfAffiliation.split("-")[0]);
        int month = Integer.parseInt(dateOfAffiliation.split("-")[1]);
        int day = Integer.parseInt(dateOfAffiliation.split("-")[2]);

        LocalDate afilliationDate = LocalDate.of(year, month, day);

        System.out.println("Ingrese la fecha de compra de una cancion: (YYYY-MM-DD): ");
        String dateOfPurchase = sc.nextLine();

        year = Integer.parseInt(dateOfPurchase.split("-")[0]);
        month = Integer.parseInt(dateOfPurchase.split("-")[1]);
        day = Integer.parseInt(dateOfPurchase.split("-")[2]);

        LocalDate purchaseDate = LocalDate.of(year, month, day);

        System.out.println("\nIngresa el acumulado de reproducciones");
        int accumulatedNumberOfReproductions = sc.nextInt();

        System.out.println("\nIngresa el tiempo total reproducido");
        int totalTimePlayed = sc.nextInt();

        // Control condition that warns if the action performed was completed
        // successfully.
        if (NeoTunesController.registerStandardConsumer(nickname, id, afilliationDate, purchaseDate,
                accumulatedNumberOfReproductions, totalTimePlayed)) {
            System.out.println("\nUsuario Consumidor Estandar registrado exitosamente\n");
        } else {
            System.out.println("\nNo se pudo realizar el registro de manera exitosa\n");
        }

    }

    private void registerPremiumConsumer() {

        System.out.println("\nVas a registrar un Usuario Consumidor Premium!");

        System.out.println("\nIngresa el nombre del usuario");
        sc.nextLine(); // Refresh buffer.
        String nickname = sc.nextLine();

        System.out.println("\nIngresa el id del usuario");
        int id = sc.nextInt();

        System.out.println("Ingresa la fecha de registro del usuario en la plataforma (YYYY-MM-DD):");
        String dateOfAffiliation = sc.nextLine();

        int year = Integer.parseInt(dateOfAffiliation.split("-")[0]);
        int month = Integer.parseInt(dateOfAffiliation.split("-")[1]);
        int day = Integer.parseInt(dateOfAffiliation.split("-")[2]);

        LocalDate afilliationDate = LocalDate.of(year, month, day);

        System.out.println("Ingrese la fecha de compra de una cancion: (YYYY-MM-DD): ");
        String dateOfPurchase = sc.nextLine();

        year = Integer.parseInt(dateOfPurchase.split("-")[0]);
        month = Integer.parseInt(dateOfPurchase.split("-")[1]);
        day = Integer.parseInt(dateOfPurchase.split("-")[2]);

        LocalDate purchaseDate = LocalDate.of(year, month, day);

        System.out.println("\nIngresa el acumulado de reproducciones");
        int accumulatedNumberOfReproductions = sc.nextInt();

        System.out.println("\nIngresa el tiempo total reproducido");
        int totalTimePlayed = sc.nextInt();

        // Control condition that warns if the action performed was completed
        // successfully.
        if (NeoTunesController.registerPremiumConsumer(nickname, id, afilliationDate, purchaseDate,
                accumulatedNumberOfReproductions, totalTimePlayed)) {
            System.out.println("\nUsuario Consumidor Premium registrado exitosamente\n");
        } else {
            System.out.println("\nNo se pudo realizar el registro de manera exitosa\n");
        }

    }

    private void registerProducerArtist() {

        System.out.println("\nVas a registrar un Usuario Productor Artista!");

        System.out.println("\nIngresa el nombre del usuario");
        sc.nextLine(); // Refresh buffer.
        String name = sc.nextLine();

        System.out.println("Ingresa la fecha de registro del usuario en la plataforma (YYYY-MM-DD):");
        String dateOfAffiliation = sc.nextLine();

        int year = Integer.parseInt(dateOfAffiliation.split("-")[0]);
        int month = Integer.parseInt(dateOfAffiliation.split("-")[1]);
        int day = Integer.parseInt(dateOfAffiliation.split("-")[2]);

        LocalDate afilliationDate = LocalDate.of(year, month, day);

        System.out.println("\nIngresa la URL de su foto o imagen distintiva");
        String distinctiveImageUrl = sc.nextLine();

        // Control condition that warns if the action performed was completed
        // successfully.
        if (NeoTunesController.registerProducerArtist(name, afilliationDate, distinctiveImageUrl)) {
            System.out.println("\nUsuario Productor Artista registrado exitosamente\n");
        } else {
            System.out.println("\nNo se pudo realizar el registro de manera exitosa\n");
        }

    }

    private void registerProducerContentCreator() {

        System.out.println("\nVas a registrar un Usuario Productor Creador de Contenido!");

        System.out.println("\nIngresa el nombre del usuario");
        sc.nextLine(); // Refresh buffer.
        String name = sc.nextLine();

        System.out.println("Ingresa la fecha de registro del usuario en la plataforma (YYYY-MM-DD):");
        String dateOfAffiliation = sc.nextLine();

        int year = Integer.parseInt(dateOfAffiliation.split("-")[0]);
        int month = Integer.parseInt(dateOfAffiliation.split("-")[1]);
        int day = Integer.parseInt(dateOfAffiliation.split("-")[2]);

        LocalDate afilliationDate = LocalDate.of(year, month, day);

        System.out.println("\nIngresa la URL de su foto o imagen distintiva");
        String distinctiveImageUrl = sc.nextLine();

        // Control condition that warns if the action performed was completed
        // successfully.
        if (NeoTunesController.registerProducerContentCreator(name, afilliationDate, distinctiveImageUrl)) {
            System.out.println("\nUsuario Productor Creador de Contenido registrado exitosamente\n");
        } else {
            System.out.println("\nNo se pudo realizar el registro de manera exitosa\n");
        }

    }

    private void registerSong() {

        System.out.println("\nVas a registrar una Cancion!");

        System.out.println("\nIngresa el nombre del usuario");
        sc.nextLine(); // Refresh buffer.
        String name = sc.nextLine();

        System.out.println("\nIngresa el nombre del album al que pertenece");
        String album = sc.nextLine();

        System.out.println("Escoge el tipo de genero de la cancion:\n");
        System.out.println("1. ROCK");
        System.out.println("2. POP");
        System.out.println("3. TRAP");
        System.out.println("4. HOUSE\n");
        int selection = sc.nextInt();

        System.out.println("Ingresa la fecha de registro del usuario en la plataforma (YYYY-MM-DD):");
        String dateOfAffiliation = sc.nextLine();

        int year = Integer.parseInt(dateOfAffiliation.split("-")[0]);
        int month = Integer.parseInt(dateOfAffiliation.split("-")[1]);
        int day = Integer.parseInt(dateOfAffiliation.split("-")[2]);

        LocalDate afilliationDate = LocalDate.of(year, month, day);

        System.out.println("\nIngresa la URL de su foto o imagen distintiva");
        String distinctiveImageUrl = sc.nextLine();

        // Control condition that warns if the action performed was completed
        // successfully.
        if (NeoTunesController.registerSong(name, album, null, album, day, year, month, day)) {
            System.out.println("\nUsuario Productor Creador de Contenido registrado exitosamente\n");
        } else {
            System.out.println("\nNo se pudo realizar el registro de manera exitosa\n");
        }

    }
}
