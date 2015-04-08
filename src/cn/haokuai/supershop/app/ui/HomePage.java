package cn.haokuai.supershop.app.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.haokuai.supershop.app.R;
import cn.haokuai.supershop.app.adpter.ListViewItemAdpter;

public class HomePage extends Fragment {
	private View mHomePage;
	private ListViewItemAdpter lvObjectAdapter;
	private ListView mlvObject;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mHomePage = inflater.inflate(R.layout.home_page, null);
		//initPushListView();
		return mHomePage;
	}
//
//	private void initPushListView() {
//		lvObjectAdapter = new ListViewItemAdpter(getActivity(),
//				R.layout.listview_item);
//		mlvObject = (ListView) mHomePage.findViewById(R.id.listView);
//		mlvObject.setAdapter(lvObjectAdapter);
//	}
}
