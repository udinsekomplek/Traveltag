package traveltag.spesialisit.com.traveltag.model;


        import java.util.List;


public class ResponsModelRegister {

    String  kode, pesan;
    List<DataModelRegister> result;

    public List<DataModelRegister> getResult() {
        return result;
    }

    public void setResult(List<DataModelRegister> result) {
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
