/*
Copyright (c) 2014 Lawrence Angrave

Dual licensed under Apache2.0 and MIT Open Source License (included below): 
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
package apps101.Imagen;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int REQUEST_CODE = 1;
	private static final String TAG = MainActivity.class.getSimpleName();
	private Bitmap mBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate!");
		setContentView(R.layout.activity_main);

		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Do some Intent magic to open the Gallery?
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("image/*");
				startActivityForResult(
						Intent.createChooser(intent, "Select..."), REQUEST_CODE);
			}
		};
		findViewById(R.id.button1).setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

			Uri uri = data.getData();

			Log.d(TAG, uri.toString());
			Toast.makeText(getApplicationContext(), uri.toString(),
					Toast.LENGTH_LONG).show();
			try {
				InputStream stream = getContentResolver().openInputStream(uri);

				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inJustDecodeBounds = true;

				BitmapFactory.decodeStream(stream, null, options);
				stream.close();

				int w = options.outWidth;
				int h = options.outHeight;
				Log.d(TAG, "Bitmap raw size:" + w + " x " + h);

				int displayW = getResources().getDisplayMetrics().widthPixels;
				int displayH = getResources().getDisplayMetrics().heightPixels;

				int sample = 1;

				while (w > displayW * sample || h > displayH * sample) {
					sample = sample * 2;
				}
				Log.d(TAG, "Sampling at " + sample);

				options.inJustDecodeBounds = false;
				options.inSampleSize = sample;
				
				stream = getContentResolver().openInputStream(uri);
				mBitmap = BitmapFactory.decodeStream(stream, null, options);
				stream.close();

				ImageView v = (ImageView) findViewById(R.id.imageView1);
				v.setImageBitmap(mBitmap);
			} catch (Exception e) {
				Log.e(TAG, "Decoding Bitmap", e);
			}

		}
	}
}
