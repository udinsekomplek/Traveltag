package traveltag.spesialisit.com.traveltag.viewmap;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import traveltag.spesialisit.com.traveltag.R;

public class ActivityProfileTraveler extends AppCompatActivity {
    de.hdodenhof.circleimageview.CircleImageView imageView;
    TextView txUser,txJk,txBio,txJob,txNgr,txItg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_profile);

        String iuser=getIntent().getStringExtra("iuser").toString();
        String igender=getIntent().getStringExtra("igender").toString();
        String ibio=getIntent().getStringExtra("ibio").toString();
        String ingr=getIntent().getStringExtra("ingr").toString();
        String iimg=getIntent().getStringExtra("iimg").toString();

        txUser = (TextView) findViewById(R.id.txUser);
        txJk = (TextView) findViewById(R.id.txJk);
        txBio = (TextView) findViewById(R.id.txBio);
        txJob = (TextView) findViewById(R.id.txJob);
        txNgr = (TextView) findViewById(R.id.txNgr);
        txItg = (TextView) findViewById(R.id.txItg);
        imageView = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.profile_image);

        txUser.setText(iuser);
        txJk.setText("( "+igender+", 20 )");
        txBio.setText(ibio);
        txNgr.setText(ingr);

        Picasso.with(ActivityProfileTraveler.this).load("http://107.189.5.17/demo/traveltag/profilepicture/"+iimg).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);

    }



}
