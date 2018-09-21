package traveltag.spesialisit.com.traveltag.model.mapLounge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result4 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("hobi")
    @Expose
    private String hobi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

}