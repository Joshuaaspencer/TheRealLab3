package com.example.joshuaspencer.lab3act;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/**
 * Lab 3
 *      Douglas Applegate
 *      Nick Love(is cool)
 *      Dave McVicar
 *      Joshua Spencer
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
                //cropPhoto();    //Send picture taken to be cropped
                break;
            case REQUEST_CODE_CROP_PHOTO:
                break;
        }
    }

    /*on button clicks*/

    /*public void onChangePictureClick(View view){

    }*/

    /*Private Helpers*/
}
