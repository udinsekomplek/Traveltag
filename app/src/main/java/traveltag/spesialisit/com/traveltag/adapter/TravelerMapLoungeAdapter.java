package traveltag.spesialisit.com.traveltag.adapter;


import android.content.Context;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import traveltag.spesialisit.com.traveltag.model.mapLounge.Resulthobi;
import traveltag.spesialisit.com.traveltag.model.mapLounge.Resultplan;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeListHobi;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeListTravel;
import traveltag.spesialisit.com.traveltag.viewmap.ActivityMapLoungeTravelPlan;

import static android.content.ContentValues.TAG;


public class TravelerMapLoungeAdapter extends RecyclerView.Adapter<TravelerMapLoungeAdapter.HolderData> {

    private List<Result> mList ;
    private Context ctx;


    public  TravelerMapLoungeAdapter (Context ctx, List<Result> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_local_tour,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HolderData holder, int position) {
        final RecyclerView.ViewHolder vh = null;
        final Result dm = mList.get(position);
        holder.tuser.setText(dm.getUsername());
        holder.bio.setText(dm.getBio());
        holder.ngr.setText(dm.getNational());
        StringBuilder sb = new StringBuilder();
        for (Resulthobi s : dm.getResulthobi())
        {
            sb.append(" Interest : "+s.getHobi().toString()+", ");
        }

        holder.txHobi.setText(sb);
        StringBuilder sbt = new StringBuilder();
        for (Resultplan st : dm.getResultplan())
        {
            String dt= st.getTglBerangkat().toString();
            String brgkt= st.getTglSelesai().toString();
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
            sbt.append(" "+ st.getNegara().toString()+", "+ brg.getDay()+"-"+dtng.getDay()+" "+ st.getBulan().toString());

//            Log.d(TAG, "tottgl: "+dt + "-" +brgkt+" = "+numOfDays);
        }

        holder.txTravelSumary.setText(sbt
        //        +", "+dm.getResultplan().get(0).getBulan().toString()+" "+dm.getResultplan().get(0).getTglBerangkat().toString()
        );

        Picasso.with(ctx).load("http://107.189.5.17/demo/traveltag/profilepicture/"+dm.getImg()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);

        holder.txTravelSumaryDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx.getApplicationContext(), ActivityMapLoungeTravelPlan.class);
                i.putExtra("iduser", dm.getId().toString());
                //i.putExtra("st", "Lunas");
                ctx.startActivity(i);

            }
        });
        holder.txHobiDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx.getApplicationContext(), ActivityMapLoungeListHobi.class);
                i.putExtra("iduser", dm.getId().toString());
                //i.putExtra("st", "Lunas");
                ctx.startActivity(i);
            }
        });
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView tuser, bio, ngr,txHobi,txTravelSumary,txTravelSumaryDetail,txHobiDetail;
        Result dm;
        public  de.hdodenhof.circleimageview.CircleImageView imageView;
        public HolderData (View v)
        {
            super(v);

            bio  = (TextView) v.findViewById(R.id.txBio);
            ngr = (TextView) v.findViewById(R.id.txNegara);
            txHobi = (TextView) v.findViewById(R.id.txHobi);
            tuser = (TextView) v.findViewById(R.id.txUser);
            txTravelSumary = (TextView) v.findViewById(R.id.txTravelSumary);
            txTravelSumaryDetail = (TextView) v.findViewById(R.id.txTravelSumaryDetail);
            txHobiDetail = (TextView) v.findViewById(R.id.txHobiDetail);
            imageView = (de.hdodenhof.circleimageview.CircleImageView) v.findViewById(R.id.profile_image);
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
