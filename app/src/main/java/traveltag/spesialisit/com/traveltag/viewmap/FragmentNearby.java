package traveltag.spesialisit.com.traveltag.viewmap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import traveltag.spesialisit.com.traveltag.R;

public class FragmentNearby extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_nearby_fragment, container, false);
    }
}