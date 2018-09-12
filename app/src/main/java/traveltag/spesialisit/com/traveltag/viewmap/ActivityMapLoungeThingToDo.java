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
import traveltag.spesialisit.com.traveltag.adapter.MapLoungeThingToDoAdapter;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultToDo;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelerMapLounge;

public class ActivityMapLoungeThingToDo extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Result> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_localtour_fragment);
        pd = new ProgressDialog(ActivityMapLoungeThingToDo.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeThingToDo.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();
        String idplan=getIntent().getStringExtra("idplan").toString();

        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<List<ResultToDo>> getdata = api.rToDo(idplan);
        getdata.enqueue(new Callback<List<ResultToDo>>() {
            @Override
            public void onResponse(Call<List<ResultToDo>> call, Response<List<ResultToDo>> response) {
                pd.hide();
               // Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                List<ResultToDo> s = response.body();

                mAdapter = new MapLoungeThingToDoAdapter(ActivityMapLoungeThingToDo.this,s);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ResultToDo>> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}