package br.com.jacksonfdam.targettrust.blog.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.com.jacksonfdam.targettrust.blog.PostViewActivity;
import br.com.jacksonfdam.targettrust.blog.R;
import br.com.jacksonfdam.targettrust.blog.RSSReader;
import br.com.jacksonfdam.targettrust.blog.adapters.PostItemAdapter;
import br.com.jacksonfdam.targettrust.blog.vo.PostData;

public class BlogPosts extends DebugFragment {
	public static final String LOG_TAG = BlogPosts.class.getSimpleName();
	private PostData[] listData;
	String key_items = "item";
	String key_title = "title";
	String key_description = "description";
	String key_link = "link";
	String key_date = "pubDate";
	ListView lstPost = null;
	List<HashMap<String, Object>> post_lists = new ArrayList<HashMap<String, Object>>();
	List<String> lists = new ArrayList<String>();
	ArrayAdapter<String> adapter = null;
	RSSReader rssfeed = new RSSReader();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.blog_posts, null);

		return view;
	}

	private void generateDummyData() {
		lstPost = (ListView) getActivity().findViewById(R.id.postListView);
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_2, android.R.id.text1, lists) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView txt1 = (TextView) view
						.findViewById(android.R.id.text1);
				TextView txt2 = (TextView) view
						.findViewById(android.R.id.text2);
				HashMap<String, Object> data = post_lists.get(position);
				txt1.setText(data.get(key_title).toString());
				txt2.setText(data.get(key_description).toString());
				return view;
			}

		};
		Document xmlFeed = rssfeed
				.getRSSFromServer("http://www.targettrust.com.br/blog/feed/");
		NodeList nodes = xmlFeed.getElementsByTagName("item");
		for (int i = 0; i < nodes.getLength(); i++) {
			Element item = (Element) nodes.item(i);
			HashMap<String, Object> feed = new HashMap<String, Object>();
			feed.put(key_title, rssfeed.getValue(item, key_title));
			feed.put(key_description, rssfeed.getValue(item, key_description));
			feed.put(key_link, rssfeed.getValue(item, key_link));
			feed.put(key_date, rssfeed.getValue(item, key_date));
			post_lists.add(feed);
			lists.add(feed.get(key_title).toString());
		}
		lstPost.setAdapter(adapter);
		lstPost.setOnItemClickListener(onItemClickListener);
	}

	@Override
	public void onStart() {
		super.onStart();
		generateDummyData();
	}

	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id) {
			HashMap<String, Object> data = post_lists.get(position);

			Bundle postInfo = new Bundle();
			postInfo.putString("title", data.get(key_title).toString());
			postInfo.putString("link",  data.get(key_link).toString());

			Intent postviewIntent = new Intent(getActivity(),
					PostViewActivity.class);
			postviewIntent.putExtras(postInfo);
			startActivity(postviewIntent);
		}
	};

	@Override
	public void onStop() {
		super.onStop();
	}

}
