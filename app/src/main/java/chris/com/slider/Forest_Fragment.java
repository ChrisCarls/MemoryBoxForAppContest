package chris.com.slider;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Chris on 3/1/2015.
 */
public class Forest_Fragment extends Fragment implements OnClickListener{
//View rootView;
    ImageButton deer, owl, fox, raccoon, bear;
    MediaPlayer deerMP, owlMP, foxMP, raccoonMP, bearMP;

        @Nullable
        @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstaceState) {
            View rootView = inflater.inflate(R.layout.forest_layout, container, false);

        //Get the image buttons for the animals
            deer = (ImageButton) rootView.findViewById(R.id.deeer);
            owl = (ImageButton) rootView.findViewById(R.id.owlImgBtn);
            fox = (ImageButton) rootView.findViewById(R.id.foxImgBtn);
            raccoon = (ImageButton) rootView.findViewById(R.id.raccoonImgBtn);
            bear = (ImageButton) rootView.findViewById(R.id.bearImgBtn);

        //Set animal sounds
            deerMP = MediaPlayer.create(rootView.getContext(), R.raw.deer_noise);
            owlMP = MediaPlayer.create(rootView.getContext(),R.raw.owl_noise);
            foxMP = MediaPlayer.create(rootView.getContext(),R.raw.fox_noise);
            raccoonMP = MediaPlayer.create(rootView.getContext(),R.raw.raccoon_noise);
            bearMP = MediaPlayer.create(rootView.getContext(),R.raw.bear_noise);

        //set the onClickListener for the different buttons
            deer.setOnClickListener(this);
            owl.setOnClickListener(this);
            fox.setOnClickListener(this);
            raccoon.setOnClickListener(this);
            bear.setOnClickListener(this);

            return rootView;
        }

        // Find which button was pressed and act accordingly
            @Override
            public void onClick (View v){
            switch(v.getId()){
                case R.id.deeer:
                    deerMP.start();
                    Intent intent1 = new Intent(getActivity(), deerExplain.class);
                    startActivity(intent1);
                    break;
                case R.id.owlImgBtn:
                    owlMP.start();
                    Intent intent2 = new Intent(getActivity(), owlExplain.class);
                    startActivity(intent2);
                    break;
                case R.id.foxImgBtn:
                    foxMP.start();
                    Intent intent3 = new Intent(getActivity(), foxExplain.class);
                    startActivity(intent3);
                    break;
                case R.id.bearImgBtn:
                    bearMP.start();
                    Intent intent4 = new Intent(getActivity(), bearExplain.class);
                    startActivity(intent4);
                    break;
                case R.id.raccoonImgBtn:
                    raccoonMP.start();
                    Intent intent5 = new Intent(getActivity(), raccoonExplain.class);
                    startActivity(intent5);
                    break;
            }//End Switch case statements
         }//End onClick
    }//End Class







