package model;

import java.time.LocalDate;

public class ProducerUser {

    private String name;
    private LocalDate dateOfAffiliation;
    private String distinctiveImageUrl;

    public ProducerUser(String name, LocalDate dateOfAffiliation, String distinctiveImageUrl) {

        this.name = name;
        this.dateOfAffiliation = dateOfAffiliation;
        this.distinctiveImageUrl = distinctiveImageUrl;
    }

    public void accumulatedNumberOfReproductions() {

    }

    public void totalTimePlayedByConsumers() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAffiliation() {
        return dateOfAffiliation;
    }

    public void setDateOfAffiliation(LocalDate dateOfAffiliation) {
        this.dateOfAffiliation = dateOfAffiliation;
    }

    public String getDistinctiveImageUrl() {
        return distinctiveImageUrl;
    }

    public void setDistinctiveImageUrl(String distinctiveImageUrl) {
        this.distinctiveImageUrl = distinctiveImageUrl;
    }

}
