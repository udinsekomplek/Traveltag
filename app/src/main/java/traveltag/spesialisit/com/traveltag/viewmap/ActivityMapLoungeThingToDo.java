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
import traveltag.spesialisit.com.traveltag.adapter.MapLoungeThingToDoAdapter;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result2;
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultToDo;

public class ActivityMapLoungeThingToDo extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Result2> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.list_map_lounge_travel_plan);
        TextView txJudul = (TextView) findViewById(R.id.txJudul);
        String inegara=getIntent().getStringExtra("negara").toString();

        txJudul.setText(" "+inegara+" - Things ToDo");


        pd = new ProgressDialog(ActivityMapLoungeThingToDo.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeThingToDo.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();
        String idplan=getIntent().getStringExtra("idplan").toString();

        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<ResultToDo> getdata = api.rToDo(idplan);
        getdata.enqueue(new Callback<ResultToDo>() {
            @Override
            public void onResponse(Call<ResultToDo> call, Response<ResultToDo> response) {
                pd.hide();
               // Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult2();

                mAdapter = new MapLoungeThingToDoAdapter(ActivityMapLoungeThingToDo.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResultToDo> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}