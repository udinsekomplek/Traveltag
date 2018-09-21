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
import traveltag.spesialisit.com.traveltag.model.mapLounge.Result2;


public class MapLoungeThingToDoAdapter extends RecyclerView.Adapter<MapLoungeThingToDoAdapter.HolderData> {

    private List<Result2> mList ;
    private Context ctx;


    public MapLoungeThingToDoAdapter(Context ctx, List<Result2> mList)
    {
        this.ctx = ctx;
        this.mList = mList;

    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_map_lounge_things_to_do,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HolderData holder, int position) {
        final RecyclerView.ViewHolder vh = null;
        final Result2 dm = mList.get(position);
        holder.txKet.setText("( "+dm.getKegiatan()+" )");





        holder.txJudul.setText(dm.getJudul());



        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView txKet, txJudul;
        Result2 dm;
        public HolderData (View v)
        {
            super(v);

            txJudul = (TextView) v.findViewById(R.id.txJudul);
            txKet = (TextView) v.findViewById(R.id.txKet);
           
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent goInput = new Intent(ctx,ActivityMapLoungeThingToDo.class);
//
//                    goInput.putExtra("idplan", dm.getId());
//                    ctx.startActivity(goInput);
                }
            });
        }
    }
}
