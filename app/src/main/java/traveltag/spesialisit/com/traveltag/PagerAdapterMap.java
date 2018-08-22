package traveltag.spesialisit.com.traveltag;

import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;

import traveltag.spesialisit.com.traveltag.viewmap.FragmentLocalTour;
import traveltag.spesialisit.com.traveltag.viewmap.FragmentMapLounge;
import traveltag.spesialisit.com.traveltag.viewmap.FragmentNearby;

public class PagerAdapterMap extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterMap(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentMapLounge tab1 = new FragmentMapLounge();
                return tab1;
            case 1:
                FragmentLocalTour tab2 = new FragmentLocalTour();
                return tab2;
            case 2:
                FragmentNearby tab3 = new FragmentNearby();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}