package cn.haokuai.supershop.app.ui;

import cn.haokuai.supershop.app.R;
import cn.haokuai.supershop.app.R.id;
import cn.haokuai.supershop.app.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class PerSonal extends Fragment {
	private RelativeLayout r1;
	private View mPersonal;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mPersonal = inflater.inflate(R.layout.personal, null);
		init();
		return mPersonal;
	}

	private void init() {
		r1 = (RelativeLayout) mPersonal.findViewById(R.id.relativeLayout2);
		r1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}
}
