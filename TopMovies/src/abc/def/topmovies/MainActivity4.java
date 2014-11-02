package abc.def.topmovies;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity4 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity4);
		setTitle("The Dark Knight");
	}

	public void wiki(View v){
		String url="http://en.wikipedia.org/wiki/The_Dark_Knight_(film)";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void imdb(View v){
		String url="http://www.imdb.com/title/tt0468569/?ref_=chttp_tt_4";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void next(View v)
	{
		Intent intent = new Intent();
		intent.setClass(this, MainActivity5.class);
		startActivity(intent);
	}
	public void previous(View v)
	{
		finish();
	}
}
