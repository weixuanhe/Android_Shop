package cn.haokuai.supershop.app.ui;

import java.util.ArrayList;
import java.util.List;

import cn.haokuai.supershop.app.R;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.TextView;

public class MainView extends Activity {

	Context context = null;
	@SuppressWarnings("deprecation")
	LocalActivityManager manager = null;
	ViewPager pager = null;
	TabHost tabHost = null;
	TextView t1, t2, t3;

	private int offset = 0;
	private int currIndex = 0;
	private int bmpW;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mg_goods_info);

		context = MainView.this;
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);

		InitImageView();
		initTextView();
		initPagerViewer();

	}

	/**
	 * 鍒濆鍖栨爣棰?
	 */
	private void initTextView() {
		t1 = (TextView) findViewById(R.id.good_pic_detail);
		t2 = (TextView) findViewById(R.id.good_info);
		t3 = (TextView) findViewById(R.id.good_comment);

		t1.setOnClickListener(new MyOnClickListener(0));
		t2.setOnClickListener(new MyOnClickListener(1));
		t3.setOnClickListener(new MyOnClickListener(2));

	}

	/**
	 * 鍒濆鍖朠ageViewer
	 */
	private void initPagerViewer() {
		pager = (ViewPager) findViewById(R.id.good_info_pager);
		final ArrayList<View> list = new ArrayList<View>();
		Intent intent = new Intent(context, a.class);
		list.add(getView("A", intent));
		Intent intent2 = new Intent(context, b.class);
		list.add(getView("B", intent2));
		Intent intent3 = new Intent(context, c.class);
		list.add(getView("C", intent3));

		pager.setAdapter(new MyPagerAdapter(list));
		pager.setCurrentItem(0);
		pager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	private void InitImageView() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (screenW / 3 - bmpW) / 2;
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
	}

	@SuppressWarnings("deprecation")
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}

	/**
	 * Pager閫傞厤鍣?
	 */
	public class MyPagerAdapter extends PagerAdapter {
		List<View> list = new ArrayList<View>();

		public MyPagerAdapter(ArrayList<View> list) {
			this.list = list;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			ViewPager pViewPager = ((ViewPager) container);
			pViewPager.removeView(list.get(position));
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			ViewPager pViewPager = ((ViewPager) arg0);
			pViewPager.addView(list.get(arg1));
			return list.get(arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {

		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}

	/**
	 * 椤靛崱鍒囨崲鐩戝惉
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = offset * 2 + bmpW;// 椤靛崱1 -> 椤靛崱2 鍋忕Щ閲?
		int two = one * 2;// 椤靛崱1 -> 椤靛崱3 鍋忕Щ閲?

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					t1.setFocusable(true);
					t1.requestFocus();
				} else if (currIndex == 2) {
					t1.setFocusable(true);
					t1.requestFocus();
				}
				break;
			case 1:
				if (currIndex == 0) {
					t1.setFocusable(true);
					t1.requestFocus();
				} else if (currIndex == 2) {
					t1.setFocusable(true);
					t1.requestFocus();
				}
				break;
			case 2:
				if (currIndex == 0) {
					t1.setFocusable(true);
					t1.requestFocus();
				} else if (currIndex == 1) {
					t1.setFocusable(true);
					t1.requestFocus();
				}
				break;
			}
			currIndex = arg0;
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}
	}

	/**
	 * 澶存爣鐐瑰嚮鐩戝惉
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			pager.setCurrentItem(index);
		}
	};
}