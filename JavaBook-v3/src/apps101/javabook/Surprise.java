/* Copyright (c) 2013,2014 Lawrence Angrave

Provided under MIT License and the Apache open source license.
See LICENSE.txt for full details.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package apps101.javabook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Surprise extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.e("Surprise!","onCreate called in Surprise activity");

		// Remember Emily's app which also used Intents?
		// - You could start a new activity when responding to a button click.
		// By taking this code and putting inside your onClick method
		Intent intent = new Intent();
		intent.setClass(this, NasaActivity.class);
		if (Math.random() > 0.5) {
			// Open the Java Book instead!
			intent.setClass(this, MainActivity.class);
		}
		// Soon (but not immediately) 
		// a new Activity will be created and shown to the user ...
		startActivity(intent);
		// As part of starting another activity
		// onPause() and onStop() will soon be called on this Surprise Activity

		finish(); // Experiment! - I wonder what finish() does :-)
		// e.g. What happens if you remove it by either adding  '//' before it
		// or deleting the entire line

	}

	@Override
	protected void onResume() {
		Log.e("Surprise!","onResume called in Surprise activity");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.e("Surprise!","onPause called in Surprise activity");
		super.onPause();
	}
	@Override
	protected void onStop() {
		Log.e("Surprise!","onStop called in Surprise activity");
		super.onPause();
	}
}
