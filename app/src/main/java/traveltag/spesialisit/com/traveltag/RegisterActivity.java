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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.ResponsModelRegister;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by amardeep on 10/24/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText nama, usia, domisili;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);


        Button textViewLogin = (Button) findViewById(R.id.btn_prev);

        nama = (TextInputEditText) findViewById(R.id.editTextUserName);
        usia = (TextInputEditText) findViewById(R.id.editTextEmail);
        domisili = (TextInputEditText) findViewById(R.id.editTextPassword);


        radioGroup = (RadioGroup) findViewById(R.id.rTipe);

        pd = new ProgressDialog(this);


        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, RegisterUploadActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button buttonRegister = (Button) findViewById(R.id.btn_next);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg1 data_user = reg1.getInstance();
                reg1 data_email = reg1.getInstance();
                reg1 data_pass = reg1.getInstance();
                reg1 data_tipe = reg1.getInstance();

                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);


                data_user.setUser(nama.getText().toString());
                data_email.setEmail(usia.getText().toString());
                data_pass.setPass(domisili.getText().toString());
                data_tipe.setTipe(radioButton.getText().toString());

                Intent intent = new Intent(RegisterActivity.this, RegisterActivity2.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public static class reg1 {
        private static reg1 instance;

        // Global variable
        private String user;
        private String email;
        private String pass;
        private String tipe;
        private String penjelasan;

        // Restrict the constructor from being instantiated
        private reg1() {
        }

        public void setUser(String d) {
            this.user = d;
        }

        public String getUser() {
            return this.user;
        }

        public void setEmail(String d) {
            this.email = d;
        }

        public String getEmail() {
            return this.email;
        }

        public void setPass(String d) {
            this.pass = d;
        }

        public String getPass() {
            return this.pass;
        }

        public void setTipe(String d) {
            this.tipe = d;
        }

        public String getTipe() {
            return this.tipe;
        }
        public synchronized static reg1 getInstance(){
            if(instance==null){
                instance=new reg1();
            }
            return instance;
        }
    }
}