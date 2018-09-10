package traveltag.spesialisit.com.traveltag.model.mapLounge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resulthobi {

    @SerializedName("hobi")
    @Expose
    private String hobi;

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

}