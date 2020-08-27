
package pl.adm.coronamap.voivodeship;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfectedByRegion {

    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("infectedCount")
    @Expose
    private Integer infectedCount;
    @SerializedName("deceasedCount")
    @Expose
    private Integer deceasedCount;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getInfectedCount() {
        return infectedCount;
    }

    public void setInfectedCount(Integer infectedCount) {
        this.infectedCount = infectedCount;
    }

    public Integer getDeceasedCount() {
        return deceasedCount;
    }

    public void setDeceasedCount(Integer deceasedCount) {
        this.deceasedCount = deceasedCount;
    }

    public int countInfectedAndDeceased(){
        int mergedCases;
        mergedCases=this.deceasedCount+this.infectedCount;
        return mergedCases;
    }
}
