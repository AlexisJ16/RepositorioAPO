package model;

import java.time.LocalDate;

public class ProducerContentCreator extends ProducerUser {

    public ProducerContentCreator(String name, LocalDate dateOfAffiliation, String distinctiveImageUrl) {
        super(name, dateOfAffiliation, distinctiveImageUrl);
    }

    public void createPodcast() {

    }

    @Override
    public String toString() {
        return "ContentCreatorUser []";
    }

}
