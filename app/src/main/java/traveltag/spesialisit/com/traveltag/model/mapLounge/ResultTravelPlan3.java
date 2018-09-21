package traveltag.spesialisit.com.traveltag.model.mapLounge;

import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class ResultTravelPlan3 {

    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("result3")
    @Expose
    private List<Result3> result3 = null;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public List<Result3> getResult3() {
        return result3;
    }

    public void setResult3(List<Result3> result3) {
        this.result3 = result3;
    }

}