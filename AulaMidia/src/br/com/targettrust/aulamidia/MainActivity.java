package br.com.targettrust.aulamidia;

import java.io.File;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	MediaPlayer mp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void play(View v) {
   		MediaPlayer mp = MediaPlayer.create(getBaseContext(),
    				R.raw.beep6);
		mp.start();
    }
    
    
    public void playExt(View v) {
    	
    	
    	File tempMp3 = new File(
    			Environment.getExternalStorageDirectory() +
    			"/sultans.mp3");
    	
		 mp = MediaPlayer.create(getBaseContext(), 
				 Uri.fromFile(tempMp3));

		 mp.start();
    }
    
    public void stop (View v) {
    	
    	if ((mp != null) && mp.isPlaying()) {
    		mp.stop();
    	}
    	
    }
    
}
