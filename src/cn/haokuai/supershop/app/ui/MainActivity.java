package cn.haokuai.supershop.app.ui;

import java.util.ArrayList;
import java.util.List;

import cn.haokuai.supershop.app.R;
import cn.haokuai.supershop.app.adpter.ChatAdapter;
import cn.haokuai.supershop.app.adpter.ListViewItemAdpter;
import cn.haokuai.supershop.app.adpter.Message;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * 参�?�链接： http://android.amberfog.com/?p=296
 * http://www.cnblogs.com/devinzhang/archive/2012/07/02/2573554.html
 * http://stackoverflow
 * .com/questions/4777272/android-listview-with-different-layout-for-each-row
 * 
 * */
public class MainActivity extends Fragment {

	private ListView lvData;
	private View mHomePage;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mHomePage = inflater.inflate(R.layout.activity_main, null);
		lvData = (ListView) mHomePage.findViewById(R.id.lv_data);
		lvData.setDivider(null);
		lvData.setAdapter(getAdapter());
		return mHomePage;
	}

	private BaseAdapter getAdapter() {

		return new ChatAdapter(getActivity(), getMyData());
	}

	private List<Message> getMyData() {

		List<Message> msgList = new ArrayList<Message>();
		Message msg;
		msg = new Message();
		msg.setType(ChatAdapter.VALUE_TIME_TIP);
		msg.setValue("0");
		msgList.add(msg);

		msg = new Message();
		msg.setType(ChatAdapter.VALUE_TIME_TIP_);
		msg.setValue("1");
		msgList.add(msg);

		msg = new Message();
		msg.setType(ChatAdapter.VALUE_LEFT_TEXT);
		msg.setValue("2");
		msgList.add(msg);

		msg = new Message();
		msg.setType(ChatAdapter.VALUE_LEFT_IMAGE);
		msg.setValue("3");
		msgList.add(msg);

		msg = new Message();
		msg.setType(ChatAdapter.VALUE_LEFT_AUDIO);
		msg.setValue("4");
		msgList.add(msg);

		msg = new Message();
		msg.setType(ChatAdapter.VALUE_RIGHT_TEXT);
		msg.setValue("5");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(ChatAdapter.VALUE_RIGHT_TEXT_);
		msg.setValue("6");
		msgList.add(msg);
		return msgList;

	}

}
