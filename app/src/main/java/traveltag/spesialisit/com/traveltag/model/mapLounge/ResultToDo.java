package traveltag.spesialisit.com.traveltag.model.mapLounge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultToDo {

    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("result2")
    @Expose
    private List<Result2> result2 = null;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public List<Result2> getResult2() {
        return result2;
    }

    public void setResult2(List<Result2> result2) {
        this.result2 = result2;
    }

}