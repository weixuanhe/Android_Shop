package cn.haokuai.supershop.app.adpter;

import java.util.List;

import cn.haokuai.supershop.app.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 比原来的多了getItemViewType和getViewTypeCount这两个方法，
 * 
 * */
public class ChatAdapter extends BaseAdapter {

	public static final String KEY = "key";
	public static final String VALUE = "value";

	public static final int VALUE_TIME_TIP = 0;// 7种不同的布局
	public static final int VALUE_TIME_TIP_ = 1;// 7种不同的布局
	public static final int VALUE_LEFT_TEXT = 2;
	public static final int VALUE_LEFT_IMAGE = 3;
	public static final int VALUE_LEFT_AUDIO = 4;
	public static final int VALUE_RIGHT_TEXT = 5;
	public static final int VALUE_RIGHT_TEXT_ = 6;
	private LayoutInflater mInflater;

	private List<Message> myList;

	public ChatAdapter(Context context, List<Message> myList) {
		this.myList = myList;

		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return myList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return myList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {

		Message msg = myList.get(position);
		int type = getItemViewType(position);
		// ViewHolderTime holderTime = null;
		// ViewHolderRightText holderRightText = null;
		// ViewHolderRightImg holderRightImg = null;
		// ViewHolderRightAudio holderRightAudio = null;
		// ViewHolderLeftText holderLeftText = null;
		// ViewHolderLeftImg holderLeftImg = null;
		// ViewHolderLeftAudio holderLeftAudio = null;

		if (convertView == null) {
			switch (type) {
			case VALUE_TIME_TIP:
				// holderTime = new ViewHolderTime();
				convertView = mInflater.inflate(R.layout.home_page, null);
				// convertView.setTag(holderTime);
				break;
			case VALUE_TIME_TIP_:
				// holderTime = new ViewHolderTime();
				convertView = mInflater.inflate(R.layout.main_item1, null);
				// convertView.setTag(holderTime);
				break;
			// 左边
			case VALUE_LEFT_TEXT:
				// holderLeftText = new ViewHolderLeftText();
				convertView = mInflater.inflate(R.layout.main_item2, null);
				// convertView.setTag(holderLeftText);
				break;

			case VALUE_LEFT_IMAGE:
				// holderLeftImg = new ViewHolderLeftImg();
				convertView = mInflater.inflate(R.layout.main_item3, null);
				// convertView.setTag(holderLeftImg);
				break;

			case VALUE_LEFT_AUDIO:
				// holderLeftAudio = new ViewHolderLeftAudio();
				convertView = mInflater.inflate(R.layout.main_item4, null);
				// holderLeftAudio.tvLeftAudioTime.setText(msg.getValue());
				// convertView.setTag(holderLeftAudio);
				break;
			// 右边
			case VALUE_RIGHT_TEXT:
				// holderRightText = new ViewHolderRightText();
				convertView = mInflater.inflate(R.layout.main_item5, null);
				// convertView.setTag(holderRightText);
				break;
			case VALUE_RIGHT_TEXT_:
				// holderRightText = new ViewHolderRightText();
				convertView = mInflater.inflate(R.layout.listview_item, null);
				// convertView.setTag(holderRightText);
				break;
			default:
				break;
			}

		} else {
			Log.d("baseAdapter", "Adapter_:" + (convertView == null));
			switch (type) {
			case VALUE_TIME_TIP:
				// holderTime = (ViewHolderTime) convertView.getTag();
				break;
			case VALUE_TIME_TIP_:
				// holderTime = (ViewHolderTime) convertView.getTag();
				break;
			case VALUE_LEFT_TEXT:
				// holderLeftText = (ViewHolderLeftText) convertView.getTag();
				break;
			case VALUE_LEFT_IMAGE:
				// holderLeftImg = (ViewHolderLeftImg) convertView.getTag();
				break;
			case VALUE_LEFT_AUDIO:
				// holderLeftAudio = (ViewHolderLeftAudio) convertView.getTag();
				break;
			case VALUE_RIGHT_TEXT:
				// holderRightText = (ViewHolderRightText) convertView.getTag();
				break;
			case VALUE_RIGHT_TEXT_:
				// holderRightText = (ViewHolderRightText) convertView.getTag();
				break;
			default:
				break;
			}

		}
		return convertView;
	}

	/**
	 * 根据数据源的position返回�?要显示的的layout的type
	 * 
	 * type的�?�必须从0�?�?
	 * 
	 * */
	@Override
	public int getItemViewType(int position) {

		Message msg = myList.get(position);
		int type = msg.getType();
		Log.e("TYPE:", "" + type);
		return type;
	}

	/**
	 * 返回�?有的layout的数�?
	 * 
	 * */
	@Override
	public int getViewTypeCount() {
		return 7;
	}

	// class ViewHolderTime {
	// private TextView tvTimeTip;// 时间
	// }
	//
	// class ViewHolderRightText {
	// private ImageView ivRightIcon;// 右边的头�?
	// private Button btnRightText;// 右边的文�?
	// }
	//
	// class ViewHolderRightImg {
	// private ImageView ivRightIcon;// 右边的头�?
	// private ImageView ivRightImage;// 右边的图�?
	// }
	//
	// class ViewHolderRightAudio {
	// private ImageView ivRightIcon;// 右边的头�?
	// private Button btnRightAudio;// 右边的声�?
	// private TextView tvRightAudioTime;// 右边的声音时�?
	// }
	//
	// class ViewHolderLeftText {
	// private ImageView ivLeftIcon;// 左边的头�?
	// private Button btnLeftText;// 左边的文�?
	// }
	//
	// class ViewHolderLeftImg {
	// private ImageView ivLeftIcon;// 左边的头�?
	// private ImageView ivLeftImage;// 左边的图�?
	// }
	//
	// class ViewHolderLeftAudio {
	// private ImageView ivLeftIcon;// 左边的头�?
	// private Button btnLeftAudio;// 左边的声�?
	// private TextView tvLeftAudioTime;// 左边的声音时�?
	// }

}
