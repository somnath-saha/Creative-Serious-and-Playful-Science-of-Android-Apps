package com.example.musicplay;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	MediaPlayer track1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	public void google(View v)
	{
		String url="http://www.google.com";
		Intent i= new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}	
	protected void onResume()
	{
		track1=MediaPlayer.create(this, R.raw.track);
		track1.start();
		super.onResume();
	}
	protected void onPause()
	{
		track1.stop();
		track1.release();
		super.onPause();
	}
}
