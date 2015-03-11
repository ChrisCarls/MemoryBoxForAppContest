package chris.com.slider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * Created by Chris on 3/5/2015.
 */
public class EXPERIMENT_FRAGMENT extends Fragment {
    View rootView;

    // Vibrate for 500 milliseconds


    TextView namePersonOne, descriptionPersonOne;
    ImageView number1;
    ImageView givenPhoto;
    final Context context = getActivity();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,ViewGroup container,Bundle savedInstaceState){
        rootView = inflater.inflate(R.layout.experiment_layout, container,false);
        namePersonOne = (TextView)rootView.findViewById(R.id.namePerson1);
        descriptionPersonOne =(TextView)rootView.findViewById(R.id.descriptionPerson1);
        final Vibrator vib = (Vibrator) this.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        number1 = (ImageView)rootView.findViewById(R.id.addNewPerson1);
        number1.setOnLongClickListener(new OnLongClickListener() {
           @Override
            public boolean onLongClick(View v) {
               vib.vibrate(500);
                View promptsView = inflater.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);
                 givenPhoto = (ImageView)promptsView.findViewById(R.id.yourPicture);
                 givenPhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select a picture"), 1);
                    }
                });
                final EditText givenName = (EditText) promptsView.findViewById(R.id.YourName);
                final EditText givenDescription = (EditText) promptsView.findViewById(R.id.yourDescription);
           // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
                                        namePersonOne.setText(givenName.getText());
                                        descriptionPersonOne.setText(givenDescription.getText());

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                return true;
            }
        });

    number1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Drawable drawable = number1.getDrawable();
          Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress (Bitmap.CompressFormat.PNG,100,baos);
            byte[] b = baos.toByteArray();

           Intent intent = new Intent(getActivity(), photoExpander.class);
          intent.putExtra("picture",b);

            startActivity(intent);


        }
    });


                return rootView;
            }
public void onActivityResult(int reqCode, int resCode, Intent data){
    if (resCode == Activity.RESULT_OK)
        if (reqCode == 1){
            givenPhoto.setImageURI(data.getData());
            number1.setImageURI(data.getData());

}}
}
