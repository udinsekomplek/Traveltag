package traveltag.spesialisit.com.traveltag;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.design.widget.TextInputEditText;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.util.SortedList;
        import android.util.Log;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.text.SimpleDateFormat;
        import java.util.Calendar;

        import traveltag.spesialisit.com.traveltag.api.RequestRegister;
        import traveltag.spesialisit.com.traveltag.api.Retroserver;
        import traveltag.spesialisit.com.traveltag.model.ResponsModelRegister;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
/**
 * Created by amardeep on 10/24/2017.
 */

public class RegisterActivity2 extends AppCompatActivity {
    TextInputEditText nama, usia, domisili;
    DatePicker dpResult;
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register2);


        Button textViewLogin = (Button) findViewById(R.id.btn_prev);

        nama = (TextInputEditText) findViewById(R.id.editTextUserName);
        usia = (TextInputEditText) findViewById(R.id.editTextEmail);
        domisili = (TextInputEditText) findViewById(R.id.editTextPassword);
        dpResult = (DatePicker) findViewById(R.id.date_picker);


        pd = new ProgressDialog(this);


        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity2.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button buttonRegister = (Button) findViewById(R.id.btn_next);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int   day  = dpResult.getDayOfMonth();
                int   month= dpResult.getMonth();
                int   year = dpResult.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String formatedDate = sdf.format(calendar.getTime());

                reg2 data_tglLahir = reg2.getInstance();
                data_tglLahir.settglLahir(formatedDate);

                Intent intent = new Intent(RegisterActivity2.this, RegisterActivity3.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public static class reg2 {
        private static reg2 instance;

        // Global variable
        private String tglLahir;

        // Restrict the constructor from being instantiated
        private reg2() {
        }

        public void settglLahir(String d) {
            this.tglLahir = d;
        }

        public String gettglLahir() {
            return this.tglLahir;
        }
        public synchronized static reg2 getInstance(){
            if(instance==null){
                instance=new reg2();
            }
            return instance;
        }

    }
}