/**
 * PostItemAdapter.java
 * 
 * Adapter Class which configs and returns the View for ListView
 * 
 */
package br.com.jacksonfdam.targettrust.blog.adapters;

import br.com.jacksonfdam.targettrust.blog.R;
import br.com.jacksonfdam.targettrust.blog.vo.PostData;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PostItemAdapter extends ArrayAdapter<PostData> {
	private Activity myContext;
	private PostData[] datas;
	LayoutInflater inflater;

	public PostItemAdapter(Context context, int textViewResourceId,
			PostData[] objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		myContext = (Activity) context;
		datas = objects;
	}

	static class ViewHolder {
		TextView postTitleView;
		TextView postDateView;
		ImageView postThumbView;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.postitem, null);

			viewHolder = new ViewHolder();
			viewHolder.postThumbView = (ImageView) convertView
					.findViewById(R.id.postThumb);
			viewHolder.postTitleView = (TextView) convertView
					.findViewById(R.id.postTitleLabel);
			viewHolder.postDateView = (TextView) convertView
					.findViewById(R.id.postDateLabel);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (datas[position].postThumbUrl == null) {
			viewHolder.postThumbView
					.setImageResource(R.drawable.ic_launcher);
		}

		viewHolder.postTitleView.setText(datas[position].postTitle);
		viewHolder.postDateView.setText(datas[position].postDate);

		return convertView;
	}

}
