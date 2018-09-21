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
import traveltag.spesialisit.com.traveltag.adapter.MapLoungeMonthListAdapter;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result3;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelPlan3;

public class ActivityMapLoungeMonthList extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Result3> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.list_map_lounge_travel_plan);
        TextView txJudul = (TextView) findViewById(R.id.txJudul);
        String inegara=getIntent().getStringExtra("negara").toString();
        String ibulan=getIntent().getStringExtra("bulan").toString();

        txJudul.setText(" "+inegara+" - "+ibulan);
        pd = new ProgressDialog(ActivityMapLoungeMonthList.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeMonthList.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();
        String idplan=getIntent().getStringExtra("idplan").toString();

        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<ResultTravelPlan3> getdata = api.rMonthList(idplan,ibulan);
        getdata.enqueue(new Callback<ResultTravelPlan3>() {
            @Override
            public void onResponse(Call<ResultTravelPlan3> call, Response<ResultTravelPlan3> response) {
                pd.hide();
                // Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult3();

                mAdapter = new MapLoungeMonthListAdapter(ActivityMapLoungeMonthList.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResultTravelPlan3> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}