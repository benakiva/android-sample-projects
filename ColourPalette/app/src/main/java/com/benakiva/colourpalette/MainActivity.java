package com.benakiva.colourpalette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mVibrant;
    private TextView mVibrantDark;
    private TextView mVibrantLight;
    private TextView mMuted;
    private TextView mMutedDark;
    private TextView mMutedLight;

    private ImageView mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVibrant = (TextView) findViewById(R.id.textView1);
        mVibrantDark = (TextView) findViewById(R.id.textView2);
        mVibrantLight = (TextView) findViewById(R.id.textView3);
        mMuted = (TextView) findViewById(R.id.textView4);
        mMutedDark = (TextView) findViewById(R.id.textView5);
        mMutedLight = (TextView) findViewById(R.id.textView6);

        mPhoto = (ImageView) findViewById(R.id.imageView1);

        Bitmap bitmap = ((BitmapDrawable)mPhoto.getDrawable()).getBitmap();;

        if (bitmap != null) {
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    setViewSwatch(mVibrant, palette.getVibrantSwatch(), "Vibrant");
                    setViewSwatch(mVibrantDark, palette.getDarkVibrantSwatch(), "Dark Vibrant");
                    setViewSwatch(mVibrantLight, palette.getLightVibrantSwatch(), "Light Vibrant");
                    setViewSwatch(mMuted, palette.getMutedSwatch(), "Muted");
                    setViewSwatch(mMutedDark, palette.getDarkMutedSwatch(), "Dark Muted");
                    setViewSwatch(mMutedLight, palette.getLightMutedSwatch(), "Light Muted");
                }
            });
        }
    }

    private void setViewSwatch(TextView view, Palette.Swatch swatch, final String title) {
        if (swatch != null) {
            // Set the background color of a layout based on the vibrant color
            view.setBackgroundColor(swatch.getRgb());
            view.setText(title);
            view.setTextColor(swatch.getTitleTextColor());
        }
    }
}
