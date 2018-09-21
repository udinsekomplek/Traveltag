package traveltag.spesialisit.com.traveltag.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import traveltag.spesialisit.com.traveltag.R;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result3;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeThingToDo;


public class MapLoungeMonthListAdapter extends RecyclerView.Adapter<MapLoungeMonthListAdapter.HolderData> {

    private List<Result3> mList ;
    private Context ctx;


    public MapLoungeMonthListAdapter(Context ctx, List<Result3> mList)
    {
        this.ctx = ctx;
        this.mList = mList;

    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_map_lounge_month_item,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HolderData holder, int position) {
        final RecyclerView.ViewHolder vh = null;
        final Result3 dm = mList.get(position);
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
        holder.txWaktu.setText("( "+ dm.getTglBerangkat() +" - "+dm.getTglSelesai()+" )"+numOfDays +" Days");

//            Log.d(TAG, "tottgl: "+dt + "-" +brgkt+" = "+numOfDays);


        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView txWaktu, ngr;
        Result3 dm;
        public HolderData (View v)
        {
            super(v);

            ngr = (TextView) v.findViewById(R.id.txNegara);
            txWaktu = (TextView) v.findViewById(R.id.txWaktu);
           
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx,ActivityMapLoungeThingToDo.class);

                    goInput.putExtra("negara", dm.getBulan());
                    goInput.putExtra("idplan", dm.getId());
                    ctx.startActivity(goInput);
                }
            });
        }
    }
}
