package chris.com.slider;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewAnimator;

/**
 * Created by Chris on 3/6/2015.
 */
public class photoExpander extends Activity{
    ImageView photoExpanded;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.photo_expander_activity);

            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.x = -20;
            params.height = 450;
            params.width = 300;
            params.y = -20;
            this.getWindow().setAttributes(params);

            photoExpanded = (ImageView) findViewById(R.id.photoExpanded1);
            Bundle extras = getIntent().getExtras();
            byte[] b = extras.getByteArray("picture");
            Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
            photoExpanded.setImageBitmap(bmp);
            final ViewAnimator viewAnimator = (ViewAnimator) this.findViewById(R.id.viewFlipper);

            /**
             * Bind a click listener to initiate the flip transitions
             */
            viewAnimator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // This is all you need to do to 3D flip
                    AnimationFactory.flipTransition(viewAnimator, AnimationFactory.FlipDirection.LEFT_RIGHT);
                }

            });

            this.findViewById(R.id.photoExpanded1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // This is all you need to do to 3D flip
                    AnimationFactory.flipTransition(viewAnimator, AnimationFactory.FlipDirection.LEFT_RIGHT);

                }

            });
            this.findViewById(R.id.switcherLinearLayout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // This is all you need to do to 3D flip
                    AnimationFactory.flipTransition(viewAnimator, AnimationFactory.FlipDirection.LEFT_RIGHT);

                }

            });
        }}