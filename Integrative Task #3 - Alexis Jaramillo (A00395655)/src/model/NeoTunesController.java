package model;

import java.time.LocalDate;

public class NeoTunesController {

    private Song[] songs;
    private ConsumerUser[] consumerUsers;
    private ProducerUser[] producerUsers;

    public NeoTunesController() {

        this.consumerUsers = new ConsumerUser[80];
        this.producerUsers = new ProducerUser[10];

    }

    public boolean registerStandardConsumer(String nickname, int id, LocalDate dateOfAffiliation,
            LocalDate dateOfPurchase, int accumulatedNumberOfReproductions, int totalTimePlayed) {
        ConsumerUser newStandardConsumer = new StandardConsumer(nickname, id, dateOfAffiliation, dateOfPurchase,
                totalTimePlayed, totalTimePlayed);
        for (int i = 0; i < consumerUsers.length; i++) {
            if (consumerUsers[i] == null) {
                consumerUsers[i] = newStandardConsumer;
                return true;
            }
        }
        return false;
    }

    public boolean registerPremiumConsumer(String nickname, int id, LocalDate dateOfAffiliation,
            LocalDate dateOfPurchase, int accumulatedNumberOfReproductions, int totalTimePlayed) {
        ConsumerUser newPremiumConsumer = new PremiumConsumer(nickname, id, dateOfAffiliation, dateOfPurchase,
                totalTimePlayed, totalTimePlayed);
        for (int i = 0; i < consumerUsers.length; i++) {
            if (consumerUsers[i] == null) {
                consumerUsers[i] = newPremiumConsumer;
                return true;
            }
        }
        return false;
    }

    public boolean registerProducerArtist(String name, LocalDate dateOfAffiliation, String distinctiveImageUrl) {
        ProducerUser newProducerArtist = new ProducerArtist(name, dateOfAffiliation, distinctiveImageUrl);
        for (int i = 0; i < producerUsers.length; i++) {
            if (producerUsers[i] == null) {
                producerUsers[i] = newProducerArtist;
                return true;
            }
        }
        return false;
    }

    public boolean registerProducerContentCreator(String name, LocalDate dateOfAffiliation,
            String distinctiveImageUrl) {
        ProducerUser newProducerContentCreator = new ProducerArtist(name, dateOfAffiliation, distinctiveImageUrl);
        for (int i = 0; i < producerUsers.length; i++) {
            if (producerUsers[i] == null) {
                producerUsers[i] = newProducerContentCreator;
                return true;
            }
        }
        return false;
    }

    public boolean registerSong(String name, String album, TypeGender gender, String urlAlbumCover, int duration,
            double salesValue, int numberOfReproductions, int numberOfTimesSold) {
        Song newSong = new Song(name, album, gender, urlAlbumCover, duration, salesValue, numberOfReproductions,
                numberOfTimesSold);
        for (int i = 0; i < songs.length; i++) {
            if (songs[i] == null) {
                songs[i] = newSong;
                return true;
            }
        }
        return false;
    }

}
