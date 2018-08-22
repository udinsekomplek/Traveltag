package traveltag.spesialisit.com.traveltag;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.ResponsModelRegister;

/**
 * Created by amardeep on 10/24/2017.
 */

public class RegisterActivity3 extends AppCompatActivity {
    TextInputEditText nama, usia, domisili;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register3);


        Button textViewLogin = (Button) findViewById(R.id.btn_prev);

        nama = (TextInputEditText) findViewById(R.id.editTextUserName);
        usia = (TextInputEditText) findViewById(R.id.editTextEmail);


        radioGroup = (RadioGroup) findViewById(R.id.rJk);


        pd = new ProgressDialog(this);


        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity3.this, RegisterUploadActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button buttonRegister = (Button) findViewById(R.id.btn_next);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg3 data_user = reg3.getInstance();
                reg3 data_email = reg3.getInstance();
                reg3 data_pass = reg3.getInstance();

                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);


                data_user.setNegara(nama.getText().toString());
                data_email.setBio(usia.getText().toString());
                data_pass.setJk(radioButton.getText().toString());

                Intent intent = new Intent(RegisterActivity3.this, RegisterUploadActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public static class reg3 {
        private static reg3 instance;

        // Global variable
        private String negara;
        private String bio;
        private String jk;

        // Restrict the constructor from being instantiated
        private reg3() {
        }

        public void setNegara(String d) {
            this.negara = d;
        }

        public String getNegara() {
            return this.negara;
        }

        public void setBio(String d) {
            this.bio = d;
        }

        public String getBio() {
            return this.bio;
        }

        public void setJk(String d) {
            this.jk = d;
        }

        public String getJk() {
            return this.jk;
        }


        public synchronized static reg3 getInstance(){
            if(instance==null){
                instance=new reg3();
            }
            return instance;
        }
    }
}