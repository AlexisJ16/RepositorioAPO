package model;

import java.time.LocalDate;

public class PremiumConsumer extends ConsumerUser {

    public PremiumConsumer(String nickname, int id, LocalDate dateOfAffiliation, LocalDate dateOfPurchase,
            int accumulatedNumberOfReproductions, int totalTimePlayed) {
        super(nickname, id, dateOfAffiliation, dateOfPurchase, accumulatedNumberOfReproductions, totalTimePlayed);
    }

    @Override
    public String toString() {
        return "PremiumConsumer []";
    }

}
