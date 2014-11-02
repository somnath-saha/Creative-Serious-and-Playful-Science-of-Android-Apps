package abc.def.topmovies;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends Activity {
	
	//For pointers to the text fields for inputting ranks
	private EditText rank1, rank2, rank3, rank4, rank5;
	
	private Button button;
	private SharedPreferences mPrefs;
	
	//This pointer will be used to set TextView for the last
	//input user ranking
	private TextView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("A Quick Survey");
		setContentView(R.layout.activity_start);
		
		//Initialise pointers to the respective text fields
		rank1 = (EditText) findViewById(R.id.rank1);
		rank2 = (EditText) findViewById(R.id.rank2);
		rank3 = (EditText) findViewById(R.id.rank3);
		rank4 = (EditText) findViewById(R.id.rank4);
		rank5 = (EditText) findViewById(R.id.rank5);
		button = (Button) findViewById(R.id.button1);
		list = (TextView)findViewById(R.id.textView2);
		
		//Setup a private SharedPreferences pointer for remembering user ranking
		mPrefs = getPreferences(MODE_PRIVATE);

		//Read any saved data if exists
		String saveData="Your last favourites...\n";
		for(int i=0; i<5; ++i){
			saveData+="Rank "+(i+1)+": ";
			saveData+=mPrefs.getString(("rank"+(i+1)), "");//Key is dynamically calculated
			saveData+="\n";
		}
		list.setText(saveData);//Set the textView to display last saved ranking
		
		//Setup an onClick Listener object for the button action
		OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (formValid() == true) {
					//Since form inputs have been validated save them into memory via SharedPreferences object
					mPrefs.edit().putString("rank1", rank1.getText().toString()).commit();
					mPrefs.edit().putString("rank2", rank2.getText().toString()).commit();
					mPrefs.edit().putString("rank3", rank3.getText().toString()).commit();
					mPrefs.edit().putString("rank4", rank4.getText().toString()).commit();
					mPrefs.edit().putString("rank5", rank5.getText().toString()).commit();
					//Setup a new intent for starting the IMDb Ratings activity and start the activity
					Intent intent = new Intent(Start.this, MainActivity.class);					
					startActivity(intent);
				}
			}
		};
		button.setOnClickListener(listener);//Bind the Listener object to the button

	}

	//Returns false if invalid input else true
	//Only checks for the text fields one by one and puts focus on the blank field 
	//and requests the user to enter an input via toast
	boolean formValid() {
		if (rank1.length() == 0) {
			showToast(1);
			rank1.requestFocus();
			return false;
		} else if (rank2.length() == 0) {
			showToast(2);
			rank2.requestFocus();
			return false;
		} else if (rank3.length() == 0) {
			showToast(3);
			rank3.requestFocus();
			return false;
		} else if (rank4.length() == 0) {
			showToast(4);
			rank4.requestFocus();
			return false;
		} else if (rank5.length() == 0) {
			showToast(5);
			rank5.requestFocus();
			return false;
		}
		return true;
	}
	void showToast(int x) {
		Toast.makeText(this.getApplicationContext(), "Enter Rank " + x,
				Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
