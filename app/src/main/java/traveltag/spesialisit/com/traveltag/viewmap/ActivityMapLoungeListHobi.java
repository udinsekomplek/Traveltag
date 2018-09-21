package traveltag.spesialisit.com.traveltag.viewmap;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import traveltag.spesialisit.com.traveltag.R;
import traveltag.spesialisit.com.traveltag.adapter.TravelerMapLoungeAdapter;
import traveltag.spesialisit.com.traveltag.adapter.TravelerMapLoungeHobiAdapter;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result4;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelerMapLounge;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Resulthobi2;

public class ActivityMapLoungeListHobi extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Result4> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_localtour_fragment);
        pd = new ProgressDialog(ActivityMapLoungeListHobi.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeListHobi.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();
        String iduser=getIntent().getStringExtra("iduser").toString();

        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<Resulthobi2> getdata = api.rHobi(iduser);
        getdata.enqueue(new Callback<Resulthobi2>() {
            @Override
            public void onResponse(Call<Resulthobi2> call, Response<Resulthobi2> response) {
                pd.hide();
               // Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult4();

                mAdapter = new TravelerMapLoungeHobiAdapter(ActivityMapLoungeListHobi.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Resulthobi2> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}