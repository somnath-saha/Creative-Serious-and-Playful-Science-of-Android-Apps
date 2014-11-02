package abc.def.topmovies;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity5);
		setTitle("Pulp Fiction");
	}

	public void wiki(View v){
		String url="http://en.wikipedia.org/wiki/Pulp_Fiction";
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
	public void imdb(View v){
		String url="http://www.imdb.com/title/tt0110912/?ref_=chttp_tt_5";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void previous(View v)
	{
		finish();
	}
}
