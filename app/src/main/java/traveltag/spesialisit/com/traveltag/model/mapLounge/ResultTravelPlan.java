package traveltag.spesialisit.com.traveltag.model.mapLounge;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ResultTravelPlan {

        @SerializedName("kode")
        @Expose
        private Integer kode;
        @SerializedName("result1")
        @Expose
        private List<Result1> result1 = null;

        public Integer getKode() {
            return kode;
        }

        public void setKode(Integer kode) {
            this.kode = kode;
        }

        public List<Result1> getResult1() {
            return result1;
        }

        public void setResult1(List<Result1> result1) {
            this.result1 = result1;
        }

    }