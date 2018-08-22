package traveltag.spesialisit.com.traveltag.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import traveltag.spesialisit.com.traveltag.R;
import traveltag.spesialisit.com.traveltag.model.LocalTourData;


public class LocalTourAdapter extends RecyclerView.Adapter<LocalTourAdapter.HolderData> {

    private List<LocalTourData> mList ;
    private Context ctx;


    public  LocalTourAdapter (Context ctx, List<LocalTourData> mList)
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
    public void onBindViewHolder(HolderData holder, int position) {
        final RecyclerView.ViewHolder vh = null;
        LocalTourData dm = mList.get(position);
        holder.tuser.setText(dm.getUsername());
        holder.bio.setText(dm.getBio());
        holder.ngr.setText(dm.getNational());

        Picasso.with(ctx).load("http://107.189.5.17/demo/traveltag/profilepicture/"+dm.getImg()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);

        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView tuser, bio, ngr;
        LocalTourData dm;
        public  de.hdodenhof.circleimageview.CircleImageView imageView;
        public HolderData (View v)
        {
            super(v);

            bio  = (TextView) v.findViewById(R.id.txBio);
            ngr = (TextView) v.findViewById(R.id.txNegara);
            tuser = (TextView) v.findViewById(R.id.txUser);
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
