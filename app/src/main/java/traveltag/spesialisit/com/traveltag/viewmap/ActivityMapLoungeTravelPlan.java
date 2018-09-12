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
import traveltag.spesialisit.com.traveltag.adapter.MapLoungeTravelPlanAdapter;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelPlan;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelerMapLounge;

public class ActivityMapLoungeTravelPlan extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Result> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_localtour_fragment);

        final String nma=getIntent().getStringExtra("iduser").toString();

        pd = new ProgressDialog(ActivityMapLoungeTravelPlan.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeTravelPlan.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<List<ResultTravelPlan>> getdata = api.rTravelPlan(nma);
        getdata.enqueue(new Callback<List<ResultTravelPlan>>() {
            @Override
            public void onResponse(Call<List<ResultTravelPlan>> call, Response<List<ResultTravelPlan>> response) {
                pd.hide();
               // Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                List<ResultTravelPlan> s = response.body();

                mAdapter = new MapLoungeTravelPlanAdapter(ActivityMapLoungeTravelPlan.this,s,nma);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ResultTravelPlan>> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}