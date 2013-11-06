package com.ilost;

import android.os.Bundle;

import com.ilost.fragments.BehindMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class HomeActivity extends BaseSlidingFragmentActivity {

	private BehindMenuFragment behindMenuFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.primary_screen);
		setBehindContentView(R.layout.behind_screen);
		setLeftRightSlidingMenu();
		setBehindMenuFragment();
	}

	public void setBehindMenuFragment() {
		behindMenuFragment = new BehindMenuFragment();
		replaceFragment(R.id.behind_frame, behindMenuFragment);
	}

	public void setLeftRightSlidingMenu() {
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.setSlidingEnabled(false);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
}
