package chris.com.slider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chris on 3/1/2015.
 */
public class Farm_Fragment extends Fragment {
View rootView;
        @Nullable
        @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstaceState){
            rootView = inflater.inflate(R.layout.farm_layout, container,false);
            return rootView;
        }
}
