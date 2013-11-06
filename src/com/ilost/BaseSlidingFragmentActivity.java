package com.ilost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseSlidingFragmentActivity extends SlidingFragmentActivity {
	protected SlidingMenu slidingMenu;
	protected ImageView homeNavigation;
	protected TextView titleText;
	protected ActionBar actionBar;
	protected boolean isSecondarymenuVisible = false;

	public void replaceFragment(int id, Fragment fragment) {
		getSupportFragmentManager().beginTransaction().replace(id, fragment)
				.commitAllowingStateLoss();
	}

	public void setActionBarTitle(String title) {
		titleText.setText(title);
	}

	protected void initTitleBarViews(View titleBar) {
		homeNavigation = (ImageView) titleBar
				.findViewById(R.id.slide_menu_icon);
		titleText = (TextView) titleBar.findViewById(R.id.action_bar_title);

	}

	protected void setCustomTitleBar() {
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setCustomView(R.layout.title_bar);
		View titleBar = View.inflate(this, R.layout.title_bar, null);
		initTitleBarViews(titleBar);
		homeNavigation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				toggle();
			}
		});
		actionBar.setCustomView(titleBar);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getSupportActionBar();
		slidingMenu = getSlidingMenu();
		setCustomTitleBar();
	}
}