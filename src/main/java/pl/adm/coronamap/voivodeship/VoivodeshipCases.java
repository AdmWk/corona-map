
package pl.adm.coronamap.voivodeship;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoivodeshipCases {

    @SerializedName("infected")
    @Expose
    private Integer infected;
    @SerializedName("deceased")
    @Expose
    private Integer deceased;
    @SerializedName("infectedByRegion")
    @Expose
    private List<InfectedByRegion> infectedByRegion = null;
    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;
    @SerializedName("lastUpdatedAtApify")
    @Expose
    private String lastUpdatedAtApify;
    @SerializedName("readMe")
    @Expose
    private String readMe;

    public Integer getInfected() {
        return infected;
    }

    public void setInfected(Integer infected) {
        this.infected = infected;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public List<InfectedByRegion> getInfectedByRegion() {
        return infectedByRegion;
    }

    public void setInfectedByRegion(List<InfectedByRegion> infectedByRegion) {
        this.infectedByRegion = infectedByRegion;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getLastUpdatedAtApify() {
        return lastUpdatedAtApify;
    }

    public void setLastUpdatedAtApify(String lastUpdatedAtApify) {
        this.lastUpdatedAtApify = lastUpdatedAtApify;
    }

    public String getReadMe() {
        return readMe;
    }

    public void setReadMe(String readMe) {
        this.readMe = readMe;
    }

    public int getAllCases(){
        return getDeceased()+getInfected();
    }

}
