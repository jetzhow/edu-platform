package com.example.eduplatform.activities;

import android.graphics.Canvas;
import android.os.Bundle;

import com.example.eduplatform.R;
import com.example.eduplatform.slidingmenu.SlidingMenu;
import com.example.eduplatform.slidingmenu.SlidingMenu.CanvasTransformer;

public class CustomAnimation extends BaseActivity {

	private CanvasTransformer mTransformer;

	public CustomAnimation(int titleRes) {
		super(titleRes);
		mTransformer = new CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				float scale = (float) (percentOpen * 0.25 + 0.75);
				canvas.scale(scale, scale, canvas.getWidth() / 2,
						canvas.getHeight() / 2);
			}
		};
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, new SampleListFragment()).commit();

		SlidingMenu sm = getSlidingMenu();
		setSlidingActionBarEnabled(true);
		sm.setBehindScrollScale(0.0f);
		sm.setBehindCanvasTransformer(mTransformer);
	}

}
