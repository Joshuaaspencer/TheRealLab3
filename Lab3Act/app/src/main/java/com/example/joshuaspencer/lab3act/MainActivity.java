package com.example.joshuaspencer.lab3act;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Lab 3
 * Douglas Applegate
 * Nick Love(is cool)
 * Dave McVicar
 * Joshua Spencer
 */

public class MainActivity extends Activity {
    public static final int REQUEST_CODE_TAKE_FROM_CAMERA = 0;
    public static final int REQUEST_CODE_CROP_PHOTO = 2;

    private static final String IMAGE_UNSPECIFIED = "image/*";
    private static final String URI_INSTANCE_STATE_KEY = "saved_uri";

    private Uri imageCaptureUri;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.Profile_Picture);

        if(savedInstanceState != null)
           imageCaptureUri = savedInstanceState.getParcelable(URI_INSTANCE_STATE_KEY);

        loadSnap();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Saving image uri before activity goes into bground
        outState.putParcelable(URI_INSTANCE_STATE_KEY, imageCaptureUri);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK)
            return;
        switch (requestCode){
            case REQUEST_CODE_TAKE_FROM_CAMERA:
                //cropPhoto(); //Send picture taken to be cropped
                break;
            case REQUEST_CODE_CROP_PHOTO:
                break;
        }
    }

    private void loadSnap() {
        // Load profile photo from internal storage
        try {
            FileInputStream fis = openFileInput(getString(R.string.profile_photo_file_name));
            Bitmap bmap = BitmapFactory.decodeStream(fis);
            mImageView.setImageBitmap(bmap);
            fis.close();
        } catch (IOException e) {
            // Default profile photo if no photo saved before.
            mImageView.setImageResource(R.drawable.photo);
        }
    }

    private void saveSnap() {
        // Commit all the changes into preference file
        // Save profile image into internal storage.
        mImageView.buildDrawingCache();
        Bitmap bmap = mImageView.getDrawingCache();
        try {
            FileOutputStream fos = openFileOutput(
                    getString(R.string.profile_photo_file_name), MODE_PRIVATE);
            bmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
/*on button clicks*/

    /*public void onChangePictureClick(View view){
    }*/

/*Private Helpers*/
}











