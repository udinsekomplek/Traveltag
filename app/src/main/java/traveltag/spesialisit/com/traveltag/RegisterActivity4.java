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

public class RegisterActivity4 extends AppCompatActivity {
    TextInputEditText nama, usia, domisili;

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
        domisili = (TextInputEditText) findViewById(R.id.editTextPassword);



        pd = new ProgressDialog(this);


        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity4.this, RegisterUploadActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button buttonRegister = (Button) findViewById(R.id.btn_next);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("send data ... ");
                pd.setCancelable(false);
                pd.show();
                RegisterActivity.reg1 ids = RegisterActivity.reg1.getInstance();
                RegisterActivity2.reg2 id2 = RegisterActivity2.reg2.getInstance();
                RegisterActivity3.reg3 id3 = RegisterActivity3.reg3.getInstance();
                String snama = nama.getText().toString();
                String susia = usia.getText().toString();
                String sdomisili = domisili.getText().toString();
                RequestRegister api = Retroserver.getClient().create(RequestRegister.class);

                Call<ResponsModelRegister> sendbio = api.sendBiodata(ids.getUser(),ids.getPass(),ids.getEmail(),ids.getTipe()
                        ,id2.gettglLahir(),id3.getNegara(),id3.getJk(),id3.getBio(),"y");
                sendbio.enqueue(new Callback<ResponsModelRegister>() {
                    @Override
                    public void onResponse(Call<ResponsModelRegister> call, Response<ResponsModelRegister> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();

                        if(kode.equals("1"))
                        {
                            Toast.makeText(RegisterActivity4.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(RegisterActivity4.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModelRegister> call, Throwable t) {
                        pd.hide();
                        Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                    }
                });
            }
        });


    }
}