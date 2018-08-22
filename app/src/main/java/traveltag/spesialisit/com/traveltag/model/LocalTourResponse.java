package traveltag.spesialisit.com.traveltag.model;
import java.util.List;

public class LocalTourResponse {

    String  kode, pesan;
    List<LocalTourData> result;

    public List<LocalTourData> getResult() {
        return result;
    }

    public void setResult(List<LocalTourData> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
