package traveltag.spesialisit.com.traveltag.model.mapLounge;


import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Resulthobi2 {

    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("result4")
    @Expose
    private List<Result4> result4 = null;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public List<Result4> getResult4() {
        return result4;
    }

    public void setResult4(List<Result4> result4) {
        this.result4 = result4;
    }

}