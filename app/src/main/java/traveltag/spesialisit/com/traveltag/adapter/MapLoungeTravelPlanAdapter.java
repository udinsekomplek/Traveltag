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
import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelPlan;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeMonthList;


public class MapLoungeTravelPlanAdapter extends RecyclerView.Adapter<MapLoungeTravelPlanAdapter.HolderData> {
    private String adapintent;
    private List<ResultTravelPlan> mList ;
    private Context ctx;


    public MapLoungeTravelPlanAdapter(Context ctx, List<ResultTravelPlan> mList, String intent)
    {
        this.ctx = ctx;
        this.mList = mList;
        this.adapintent= intent;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_map_lounge_travel_plan,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HolderData holder, int position) {
        final RecyclerView.ViewHolder vh = null;
        final ResultTravelPlan dm = mList.get(position);
        holder.txBulan.setText(dm.getBulan());
        holder.ngr.setText(dm.getNegara());




           String dt= dm.getTglBerangkat().toString();
            String brgkt= dm.getTglSelesai().toString();
            Date dtng=null,brg = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            try {
                dtng = dateFormat.parse(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                 brg = dateFormat.parse(brgkt);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            long diff =  brg.getTime() - dtng.getTime();
            int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
        holder.txWaktu.setText("( "+ brg.getDay() +" - "+dtng.getDay()+" )");
        holder.txHari.setText(numOfDays +" Days");
//            Log.d(TAG, "tottgl: "+dt + "-" +brgkt+" = "+numOfDays);


        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView txWaktu, txBulan, ngr,txHari;
        ResultTravelPlan dm;
        public HolderData (View v)
        {
            super(v);

            txBulan  = (TextView) v.findViewById(R.id.txBulan);
            ngr = (TextView) v.findViewById(R.id.txNegara);
            txWaktu = (TextView) v.findViewById(R.id.txWaktu);
            txHari = (TextView) v.findViewById(R.id.txHari);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx,ActivityMapLoungeMonthList.class);
                    goInput.putExtra("idplan", adapintent.toString());
                    goInput.putExtra("bulan", dm.getBulan());
                    ctx.startActivity(goInput);
                }
            });
        }
    }
}
