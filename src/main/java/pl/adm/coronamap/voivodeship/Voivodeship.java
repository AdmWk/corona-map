package pl.adm.coronamap.voivodeship;

public class Voivodeship {
    private String region;
    private long population;
    private int area;
    private int density;
    private String percentageOfPeopleInfected;

    public Voivodeship(String region, long population, int area, int density) {
        this.region = region;
        this.population = population;
        this.area = area;
        this.density = density;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getPercentageOfPeopleInfected() {
        return percentageOfPeopleInfected;
    }

    public void setPercentageOfPeopleInfected(String percentageOfPeopleInfected) {
        this.percentageOfPeopleInfected = percentageOfPeopleInfected;
    }

}
