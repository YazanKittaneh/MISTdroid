package edu.grinnell.glimmer.nguyenti.mistdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Graphics activity that displays the rendered image
 */
public class GraphicsActivity extends Activity {

    SurView mSurView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get context information
        Intent i = getIntent();
        String code = i.getStringExtra("TAG_CODE");

        //Surfaceview view
        mSurView = new SurView(this);
        try{
            mSurView.codeIt(code);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            setContentView(mSurView);
    }

/*
    private class CheckForErrorsTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            while (!gView.hasError());
            return true;
        }

        @Override
        protected void onPostExecute(Boolean s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),
                    "There was an issue with your code. Please try again.",
                    Toast.LENGTH_SHORT).show();
        }
    }

*/

    @Override
    protected void onPause() {
        super.onPause();
        mSurView.pause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSurView.resume();
    }


}
