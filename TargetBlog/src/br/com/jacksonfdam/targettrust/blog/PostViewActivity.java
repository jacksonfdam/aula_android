package br.com.jacksonfdam.targettrust.blog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class PostViewActivity extends Activity {
	private WebView webView;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_view);
		
		Bundle bundle = this.getIntent().getExtras();
		String postLink = bundle.getString("link");
		String postTitle = bundle.getString("title");
		
		TextView title = (TextView)findViewById(R.id.textView1);
		title.setText(postTitle);
		
		webView = (WebView)this.findViewById(R.id.webView1);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl(postLink);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.post_view, menu);
		return true;
	}

}
