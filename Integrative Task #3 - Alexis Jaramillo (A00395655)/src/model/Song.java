package model;

public class Song {

    private String name;
    private String album;
    private TypeGender gender;
    private String urlAlbumCover;
    private int duration; // En segundos
    private double salesValue; // En dolares
    private int numberOfReproductions;
    private int numberOfTimesSold;

    public Song(String name, String album, TypeGender genderSelection, String urlAlbumCover, int duration,
            double salesValue,
            int numberOfReproductions, int numberOfTimesSold) {
        this.name = name;
        this.album = album;
        this.gender = genderSelection;
        this.urlAlbumCover = urlAlbumCover;
        this.duration = duration;
        this.salesValue = salesValue;
        this.numberOfReproductions = numberOfReproductions;
        this.numberOfTimesSold = numberOfTimesSold;

        switch (selection) {

            case 1:
                gender = genderSelection.ROCK;
                break;

            case 2:
                gender = genderSelection.POP;
                break;

            case 3:
                gender = genderSelection.TRAP;
                break;

            case 4:
                gender = genderSelection.HOUSE;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public TypeGender getGender() {
        return gender;
    }

    public void setGender(TypeGender gender) {
        this.gender = gender;
    }

    public String getUrlAlbumCover() {
        return urlAlbumCover;
    }

    public void setUrlAlbumCover(String urlAlbumCover) {
        this.urlAlbumCover = urlAlbumCover;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public int getNumberOfReproductions() {
        return numberOfReproductions;
    }

    public void setNumberOfReproductions(int numberOfReproductions) {
        this.numberOfReproductions = numberOfReproductions;
    }

    public int getNumberOfTimesSold() {
        return numberOfTimesSold;
    }

    public void setNumberOfTimesSold(int numberOfTimesSold) {
        this.numberOfTimesSold = numberOfTimesSold;
    }

    @Override
    public String toString() {
        return "Song [name=" + name + ", album=" + album + ", gender=" + gender + ", urlAlbumCover=" + urlAlbumCover
                + ", duration=" + duration + ", salesValue=" + salesValue + ", numberOfReproductions="
                + numberOfReproductions + ", numberOfTimesSold=" + numberOfTimesSold + "]";
    }

}
