package pl.adm.coronamap.voivodeship;

public class MapColors {
    private String region;
    private String color;

    public MapColors() {
    }

    public MapColors(String region, String color) {
        this.region = region;
        this.color = color;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
