package cn.haokuai.supershop.app.adpter;

import cn.haokuai.supershop.app.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewItemAdpter extends BaseAdapter {

	private Context mContext;
	private int itemViewResource;// �Զ�������ͼԴ
	private LayoutInflater listContainer;// ��ͼ����

	static class ListItemView { // �Զ���ؼ�����
		public ImageView face;
		public TextView home_title;
		public TextView home_author;
		public TextView home_time;;
	}

	public ListViewItemAdpter(Context context, int resource) {
		mContext = context;
		this.itemViewResource = resource;
		listContainer = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// Log.d("method", "getView");

		// �Զ�����ͼ
		ListItemView listItemView = null;

		if (convertView == null) {
			// ��ȡlist_item�����ļ�����ͼ
			convertView = listContainer.inflate(this.itemViewResource, null);

			listItemView = new ListItemView();
			// ��ȡ�ؼ�����
			listItemView.face = (ImageView) convertView
					.findViewById(R.id.imageView1);
			listItemView.home_author = (TextView) convertView
					.findViewById(R.id.textView1);
			listItemView.home_time = (TextView) convertView
					.findViewById(R.id.textView2);
			listItemView.home_title = (TextView) convertView
					.findViewById(R.id.textView3);
			// ���ÿؼ�����convertView

			convertView.setTag(listItemView);

		} else {
			listItemView = (ListItemView) convertView.getTag();
		}
		return convertView;
	}

}
