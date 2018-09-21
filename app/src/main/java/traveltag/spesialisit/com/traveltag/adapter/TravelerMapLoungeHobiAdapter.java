package traveltag.spesialisit.com.traveltag.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import traveltag.spesialisit.com.traveltag.R;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result4;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Resulthobi;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Resultplan;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeListHobi;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeTravelPlan;


public class TravelerMapLoungeHobiAdapter extends RecyclerView.Adapter<TravelerMapLoungeHobiAdapter.HolderData> {

    private List<Result4> mList ;
    private Context ctx;


    public TravelerMapLoungeHobiAdapter(Context ctx, List<Result4> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_map_lounge_hobi,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HolderData holder, int position) {
        final RecyclerView.ViewHolder vh = null;
        final Result4 dm = mList.get(position);
        holder.txJudul.setText(dm.getHobi());

        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView txJudul;
        Result4 dm;
        public HolderData (View v)
        {
            super(v);

            txJudul  = (TextView) v.findViewById(R.id.txJudul);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent goInput = new Intent(ctx,MainActivity.class);
//                    goInput.putExtra("id", dm.getId());
//                    goInput.putExtra("nama", dm.getNama());
//                    goInput.putExtra("usia", dm.getUsia());
//                    goInput.putExtra("domisili", dm.getDomisili());
//
//                    ctx.startActivity(goInput);
                }
            });
        }
    }
}
