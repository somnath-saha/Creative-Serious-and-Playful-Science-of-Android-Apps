package abc.def.topmovies;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main);
		setTitle("The Shawshank Redemption");
	}

	public void wiki(View v){
		String url="http://en.wikipedia.org/wiki/The_Shawshank_Redemption";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void imdb(View v){
		String url="http://www.imdb.com/title/tt0111161/?ref_=chttp_tt_1";
		Intent intent=new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	public void next(View v)
	{
		Intent intent = new Intent(MainActivity.this, MainActivity2.class);
		startActivity(intent);
	}
	
	protected void onResume() {
		Log.e("Surprise!","onResume called in Surprise activity");
		super.onResume();
	}
}
