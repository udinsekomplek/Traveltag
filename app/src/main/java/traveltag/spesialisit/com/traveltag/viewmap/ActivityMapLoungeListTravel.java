package traveltag.spesialisit.com.traveltag.viewmap;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import traveltag.spesialisit.com.traveltag.R;
import traveltag.spesialisit.com.traveltag.adapter.LocalTourAdapter;
import traveltag.spesialisit.com.traveltag.api.RequestRegister;
import traveltag.spesialisit.com.traveltag.api.Retroserver;
import traveltag.spesialisit.com.traveltag.model.LocalTourData;
import traveltag.spesialisit.com.traveltag.model.LocalTourResponse;

public class ActivityMapLoungeListTravel extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<LocalTourData> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.acitivty_login);
        pd = new ProgressDialog(ActivityMapLoungeListTravel.this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(ActivityMapLoungeListTravel.this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        RequestRegister api = Retroserver.getClient().create(RequestRegister.class);
        Call<LocalTourResponse> getdata = api.getUserLocal();
        getdata.enqueue(new Callback<LocalTourResponse>() {
            @Override
            public void onResponse(Call<LocalTourResponse> call, Response<LocalTourResponse> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new LocalTourAdapter(ActivityMapLoungeListTravel.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<LocalTourResponse> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }



}