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

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private ImageView mImageView;
	private Paint mPaint;
	private Bitmap mRainPenguin ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate!");
		mBitmap = Bitmap.createBitmap(480, 600, Bitmap.Config.ARGB_8888);
	
		mRainPenguin = BitmapFactory.decodeResource( getResources(), R.drawable.rain_penguin_180);
		
		mCanvas = new Canvas(mBitmap);
		mCanvas.drawColor(0xffff6600); // Orange
		
		mCanvas.drawBitmap(mRainPenguin, 100, 100, null);
		
		mPaint = new Paint();
		mPaint.setColor(0xff000099); // Blue
		mPaint.setStrokeWidth(16); // A thick line
		
		// From top left to bottom right
		mCanvas.drawLine(0, 0, 480, 600, mPaint);
		
		mImageView = new ImageView(this);
		mImageView.setImageBitmap(mBitmap);
		setContentView(mImageView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
