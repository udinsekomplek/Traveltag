package traveltag.spesialisit.com.traveltag.model.mapLounge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resultplan {

    @SerializedName("bulan")
    @Expose
    private String bulan;
    @SerializedName("negara")
    @Expose
    private String negara;
    @SerializedName("tgl_berangkat")
    @Expose
    private String tglBerangkat;
    @SerializedName("tgl_selesai")
    @Expose
    private String tglSelesai;

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getTglBerangkat() {
        return tglBerangkat;
    }

    public void setTglBerangkat(String tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }

    public String getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(String tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

}