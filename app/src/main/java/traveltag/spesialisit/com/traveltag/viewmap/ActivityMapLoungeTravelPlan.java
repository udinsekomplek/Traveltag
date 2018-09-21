package traveltag.spesialisit.com.traveltag.viewmap;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

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
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result1;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelPlan;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelerMapLounge;

public class ActivityMapLoungeTravelPlan extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Result1> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.list_map_lounge_travel_plan);
        TextView txJudul = (TextView) findViewById(R.id.txJudul);
        txJudul.setText("Travel Plan Summary");
        final String nma=getIntent().getStringExtra("iduser").toString();

        pd = new ProgressDialog(ActivityMapLoungeTravelPlan.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeTravelPlan.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();
        Log.d("RETROOOOO", "RESPONSE : " + nma);
        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<ResultTravelPlan> getdata = api.rTravelPlan(nma);
        getdata.enqueue(new Callback<ResultTravelPlan>() {
            @Override
            public void onResponse(Call<ResultTravelPlan> call, Response<ResultTravelPlan> response) {
                pd.hide();
               // Log.d("RETRO", "RESPONSE : " + response.body().getKode());
               mItems = response.body().getResult1();

                mAdapter = new MapLoungeTravelPlanAdapter(ActivityMapLoungeTravelPlan.this,mItems,nma);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResultTravelPlan> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}