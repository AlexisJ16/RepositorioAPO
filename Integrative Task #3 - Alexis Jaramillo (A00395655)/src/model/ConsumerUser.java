package model;

import java.time.LocalDate;

public class ConsumerUser extends User {

    private Playlist[] playlists;
    private Song[] songs;

    private LocalDate dateOfPurchase;
    private int accumulatedNumberOfReproductions;
    private int totalTimePlayed; // En segundos para convertir a minutos

    public ConsumerUser(String nickname, int id, LocalDate dateOfAffiliation, LocalDate dateOfPurchase,
            int accumulatedNumberOfReproductions, int totalTimePlayed) {
        super(nickname, id, dateOfAffiliation);

        this.playlists = new Playlist[20];
        this.songs = new Song[100];

        this.dateOfPurchase = dateOfPurchase;
        this.accumulatedNumberOfReproductions = accumulatedNumberOfReproductions;
        this.totalTimePlayed = totalTimePlayed;
    }

    private void createPlaylist() {

    }

    private void CalculateDateOfPurchase() {

    }

    private void typeOfContent() {

        System.out.println("Hola");
    }

    private void calculateAccumulatedTimePlayedBack() {

    }

    private void mostListenedCategory() {

    }

    private void mostPlayedArtist() {

    }

    private void mostListenedContentCreator() {

    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getAccumulatedNumberOfReproductions() {
        return accumulatedNumberOfReproductions;
    }

    public void setAccumulatedNumberOfReproductions(int accumulatedNumberOfReproductions) {
        this.accumulatedNumberOfReproductions = accumulatedNumberOfReproductions;
    }

    public int getTotalTimePlayed() {
        return totalTimePlayed;
    }

    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }

    @Override
    public String toString() {
        return "ConsumerUser [dateOfPurchase=" + dateOfPurchase + ", accumulatedNumberOfReproductions="
                + accumulatedNumberOfReproductions + ", totalTimePlayed=" + totalTimePlayed + "]";
    }

}
