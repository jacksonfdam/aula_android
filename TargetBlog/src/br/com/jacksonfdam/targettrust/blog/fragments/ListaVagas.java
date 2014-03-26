package br.com.jacksonfdam.targettrust.blog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import br.com.jacksonfdam.targettrust.blog.R;

public class ListaVagas extends DebugFragment {
	public static final String LOG_TAG = ListaVagas.class.getSimpleName();
	private WebView webView;

	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_lista_vagas, null);

		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		webView = (WebView) getActivity().findViewById(R.id.webView1);
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLoadWithOverviewMode(true);

		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("http://www.targettrust.com.br/calendario");
	}
}
