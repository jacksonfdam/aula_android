package br.com.jacksonfdam.targettrust.blog.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DebugFragment extends Fragment {
	protected static final String TAG = DebugFragment.class.getSimpleName();
	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG,"\t>DebugFragment.onAttach(): " + getClass().getSimpleName());
		super.onAttach(activity);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"\t>DebugFragment.onCreate(): " + getClass().getSimpleName());
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG,"\t>DebugFragment.onCreateView(): " + getClass().getSimpleName());
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d(TAG,"\t>DebugFragment.onActivityCreated(): " + getClass().getSimpleName());
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onStart() {
		Log.d(TAG,"\t>DebugFragment.onStart(): " + getClass().getSimpleName());
		super.onStart();
	}
	@Override
	public void onResume() {
		Log.d(TAG,"\t>DebugFragment.onResume(): " + getClass().getSimpleName());
		super.onResume();
	}
	@Override
	public void onPause() {
		Log.d(TAG,"\t>DebugFragment.onPause(): " + getClass().getSimpleName());
		super.onPause();
	}
	@Override
	public void onStop() {
		Log.d(TAG,"\t>DebugFragment.onStop(): " + getClass().getSimpleName());
		super.onStop();
	}
	@Override
	public void onDestroyView() {
		Log.d(TAG,"\t>DebugFragment.onDestroyView(): " + getClass().getSimpleName());
		super.onDestroyView();
	}
	@Override
	public void onDestroy() {
		Log.d(TAG,"\t>DebugFragment.onDestroy(): " + getClass().getSimpleName());
		super.onDestroy();
	}
	@Override
	public void onDetach() {
		Log.d(TAG,"\t>DebugFragment.onDetach(): " + getClass().getSimpleName());
		super.onDetach();
	}
}
