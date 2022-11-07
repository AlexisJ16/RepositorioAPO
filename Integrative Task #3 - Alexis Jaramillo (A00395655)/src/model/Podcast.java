package model;

public class Podcast {

    private String name;
    private String description;
    private TypeCategory category;
    private String distinctiveImageUrl;
    private int duration; // En segundos
    private int numberOfReproductions;

    public Podcast(String name, String description, TypeCategory category, String distinctiveImageUrl, int duration,
            int numberOfReproductions) {

        this.name = name;
        this.description = description;
        this.category = category;
        this.distinctiveImageUrl = distinctiveImageUrl;
        this.duration = duration;
        this.numberOfReproductions = numberOfReproductions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeCategory getCategory() {
        return category;
    }

    public void setCategory(TypeCategory category) {
        this.category = category;
    }

    public String getDistinctiveImageUrl() {
        return distinctiveImageUrl;
    }

    public void setDistinctiveImageUrl(String distinctiveImageUrl) {
        this.distinctiveImageUrl = distinctiveImageUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumberOfReproductions() {
        return numberOfReproductions;
    }

    public void setNumberOfReproductions(int numberOfReproductions) {
        this.numberOfReproductions = numberOfReproductions;
    }

    @Override
    public String toString() {
        return "Podcast [name=" + name + ", description=" + description + ", category=" + category
                + ", distinctiveImageUrl=" + distinctiveImageUrl + ", duration=" + duration + ", numberOfReproductions="
                + numberOfReproductions + "]";
    }

}
