package abc.def.topmovies;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		setTitle("The Godfather");
	}
	public void wiki(View v){
		String url="http://en.wikipedia.org/wiki/The_Godfather";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void imdb(View v){
		String url="http://www.imdb.com/title/tt0068646/?ref_=chttp_tt_2";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void next(View v)
	{
		Intent intent = new Intent();
		intent.setClass(this, MainActivity3.class);
		startActivity(intent);
	}
	public void previous(View v)
	{
		finish();
	}
}
