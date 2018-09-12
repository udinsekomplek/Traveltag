package traveltag.spesialisit.com.traveltag.model.mapLounge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultToDo {

    @SerializedName("ids")
    @Expose
    private String ids;
    @SerializedName("idt")
    @Expose
    private String idt;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("kegiatan")
    @Expose
    private String kegiatan;
    @SerializedName("id")
    @Expose
    private String id;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}