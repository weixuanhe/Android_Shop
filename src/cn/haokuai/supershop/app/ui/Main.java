package cn.haokuai.supershop.app.ui;

import cn.haokuai.supershop.app.R;
import cn.haokuai.supershop.app.R.id;
import cn.haokuai.supershop.app.R.layout;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class Main extends FragmentActivity implements OnClickListener {
	private RadioButton radio_homepage, radio_wujian, radio_scan, radio_detail,
			radio_my;
	protected static final String TAG = "MainActivity";
	private MainActivity framehome;
	private PerSonal frameobject;
	private PerSonal framepersonal;
	private PerSonal framescan;
	private PerSonal framesuse;
	private FragmentManager fragmentManager;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_);
		fragmentManager = getSupportFragmentManager();
		setTabSelection(0);
		findView();
	}

	private void findView() {
		radio_homepage = (RadioButton) findViewById(R.id.radio_homepage);
		radio_wujian = (RadioButton) findViewById(R.id.radio_wujian);
		radio_scan = (RadioButton) findViewById(R.id.radio_scan);
		radio_detail = (RadioButton) findViewById(R.id.radio_detail);
		radio_my = (RadioButton) findViewById(R.id.radio_my);
		radio_homepage.setOnClickListener(this);
		radio_wujian.setOnClickListener(this);
		radio_scan.setOnClickListener(this);
		radio_detail.setOnClickListener(this);
		radio_my.setOnClickListener(this);
	}

	private void hideFragments(FragmentTransaction transaction) {
		if (framehome != null) {
			transaction.hide(framehome);

		}
		if (frameobject != null) {
			transaction.hide(frameobject);

		}
		if (framescan != null) {
			transaction.hide(framescan);

		}
		if (framesuse != null) {
			transaction.hide(framesuse);

		}
		if (framepersonal != null) {
			transaction.hide(framepersonal);

		}
	}

	private void setTabSelection(int index) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			if (framehome == null) {
				framehome = new MainActivity();

				transaction.add(R.id.fl_content, framehome);
			} else {
				transaction.show(framehome);
			}
			break;
		case 1:
			if (frameobject == null) {
				frameobject = new PerSonal();

				transaction.add(R.id.fl_content, frameobject);
			} else {
				transaction.show(frameobject);
			}
			break;
		case 2:
			if (framescan == null) {
				framescan = new PerSonal();

				transaction.add(R.id.fl_content, framescan);
			} else {
				transaction.show(framescan);
			}
			break;
		case 3:
			if (framesuse == null) {
				framesuse = new PerSonal();
				transaction.add(R.id.fl_content, framesuse);
			} else {
				transaction.show(framesuse);
			}
			break;
		case 4:
			if (framepersonal == null) {
				framepersonal = new PerSonal();

				transaction.add(R.id.fl_content, framepersonal);
			} else {
				transaction.show(framepersonal);
			}
			break;

		}

		transaction.commit();
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.radio_homepage:
			setTabSelection(0);
			break;
		case R.id.radio_wujian:
			setTabSelection(1);
			break;
		case R.id.radio_scan:
			setTabSelection(2);
			break;
		case R.id.radio_detail:
			setTabSelection(3);
			break;
		case R.id.radio_my:
			setTabSelection(4);
			break;
		default:
			break;
		}
	}
}
