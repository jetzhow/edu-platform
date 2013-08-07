package com.example.eduplatform.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.eduplatform.R;
import com.example.eduplatform.slidingmenu.SlidingMenu;
import com.example.eduplatform.slidingmenu.app.SlidingFragmentActivity;

public class HomePageActivity extends SlidingFragmentActivity {

	private Fragment mLeftMenu;
	private Fragment mRightMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(R.string.app_name);
		setContentView(R.layout.content_frame);
		// set the Behind View
		setBehindContentView(R.layout.menu_frame_left);

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setSecondaryMenu(R.layout.menu_frame_right);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager()
					.beginTransaction();
			mLeftMenu = new LeftMenuFragment();
			t.replace(R.id.menu_frame_left, mLeftMenu);
			mRightMenu = new RightMenuFragment();
			t.replace(R.id.menu_frame_right, mRightMenu);

			t.commit();
		} else {
			mLeftMenu = (Fragment) this.getSupportFragmentManager()
					.findFragmentById(R.id.menu_frame_left);
			mRightMenu = (Fragment) this.getSupportFragmentManager()
					.findFragmentById(R.id.menu_frame_right);
		}

		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setSecondaryShadowDrawable(R.drawable.shadowright);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.invalidate();

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

}