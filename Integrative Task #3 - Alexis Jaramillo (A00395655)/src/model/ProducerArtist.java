package model;

import java.time.LocalDate;

public class ProducerArtist extends ProducerUser {

    public ProducerArtist(String name, LocalDate dateOfAffiliation, String distinctiveImageUrl) {
        super(name, dateOfAffiliation, distinctiveImageUrl);
    }

    public void createSong() {

    }

    @Override
    public String toString() {
        return "ProducerArtist []";
    }

}
