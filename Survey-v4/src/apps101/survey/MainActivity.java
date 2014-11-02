/*
Copyright (c) 2014 Lawrence Angrave
Dual licensed under Apache2.0 ((http://www.apache.org/licenses/LICENSE-2.0.txt) 
and MIT Open Source License (included below): 
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package apps101.survey;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText mName;
	private EditText mPhone;
	private EditText mEmail;
	private EditText mComment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		// Look for these views after we've created them !

		mName = (EditText) findViewById(R.id.name);
		mPhone = (EditText) findViewById(R.id.phone);
		mEmail = (EditText) findViewById(R.id.email);
		mComment = (EditText) findViewById(R.id.comments);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void processForm(View duck) {
		Log.d("MainActivity", "processForm");

		// Assumes these variables are non-null
		// i.e. we set them during onCreate
		String comments = mComment.getText().toString();
		String email = mEmail.getText().toString();
		String phone = mPhone.getText().toString();
		String name = mName.getText().toString();

		// Notice '=' means assign to the variable on the left
		// to the value of the right hand side

		int position = email.indexOf("@");

		// Notice '==' means see if these integers are the same
		if (position == -1) {
			// Alternatively... if( ! email.contains("@") )

			Toast.makeText(this.getApplicationContext(),
					"Invalid email address!", Toast.LENGTH_LONG).show();
			mEmail.requestFocus();
			return;
		}

		// You can ask a string for its length (number of characters)
		int len = comments.length();

		// To see if two integer values are equal use ==
		// But don't use == for Strings (see below)!
		if (len == 0) {
			Toast.makeText(this.getApplicationContext(), "Give me comments!",
					Toast.LENGTH_LONG).show();
			mComment.requestFocus();
			return;
		}
		// To see if two String objects are equal use the "equals" method
		// For String pointers, '==' compares two memory pointers to see if they
		// point to the same object
		//
		// if (name == "Fred") Not OK! (because name can point to a different
		// String object, that might also contain F-r-e-d)
		//
		// if( name == null) is OK for this special case of comparing with null
		//
		if (name.equals("Fred")) {
			Toast.makeText(this.getApplicationContext(), "Hi Fred!",
					Toast.LENGTH_LONG).show();
		}

		// We might run into some surprises when we try to convert
		// a string to an integer value
		// Convert a string (a sequence of characters) "123123123" into an
		// integer value

		// Notice we declare these variables OUTSIDE the try-catch block
		// So we can use them after the catch block ends
		int value = -1; // we will change this
		boolean valueOK = false; // will become true if everything works out OK

		try {
			// The next line will throw an exception if it does not like our
			// string!
			// e.g. if phone is an empty string "3000000000" or "askdgahksdg"
			value = Integer.parseInt(phone);

			// We will skip this code if parseInt throws its
			// NumberFormatException
			// If everything goes to plan though we will just continue here...

			valueOK = true; // Change AFTER parseInt has returned
			Log.d("MainActivity", "Phone number:" + value);

		} catch (Exception e) {
			// Uh oh... We caught that nasty exception!!
			// (FYI More experienced programmers might choose to catch
			// NumberFormatException)

			Log.d("MainActivity",
					"Invalid Phone Number!? Could not be turned into an Java integer value"
							+ phone);
		}

		if (valueOK) {
			Log.d("MainActivity", "Phone number as an integer value:" + value);
		}

		String username = email.substring(0, position);
		String thankyou = "Thankyou " + username + "!";

		Toast.makeText(this.getApplicationContext(), thankyou,
				Toast.LENGTH_LONG).show();

		// Move the duck to the right and fade it out
		Animation anim = AnimationUtils.makeOutAnimation(this, true);
		duck.startAnimation(anim);
		//
		// duck.setVisibility(View.INVISIBLE);
		// Toast.makeText(this.getApplicationContext(), R.string.app_name,
		// Toast.LENGTH_LONG).show();
	}
}
