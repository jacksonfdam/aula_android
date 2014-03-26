package br.com.jacksonfdam.targettrust.blog.fragments;

import java.text.DecimalFormat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import br.com.jacksonfdam.targettrust.blog.GPSTracker;
import br.com.jacksonfdam.targettrust.blog.R;

public class Localizacao extends DebugFragment {
	public static final String LOG_TAG = Localizacao.class.getSimpleName();
	private GPSTracker gps;
	private GoogleMap googleMap;
	private FragmentActivity aba;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_localizacao, null);

		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		new LongOperation().execute("");
	}
	
	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		gps = new GPSTracker(getActivity());
		
		
	}
	private void setUpMap() {

		if (googleMap == null) {
			googleMap = ((SupportMapFragment) getFragmentManager()
					.findFragmentById(R.id.mapa_localizacao)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(this.getActivity().getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}
		}

	}

	private void addMarkers() {
		if (googleMap == null) {
			return;
		}

		googleMap.setMyLocationEnabled(true);
		googleMap.getUiSettings().setCompassEnabled(true);
		googleMap.getUiSettings().setMyLocationButtonEnabled(true);
		googleMap.getUiSettings().setRotateGesturesEnabled(true);

		Intent intent = this.getActivity().getIntent();

		Location userlocation = gps.getLocation();
		double distance = 0.0;

		distance = gps.calcDistance(-30.015208, -51.190946);
		LatLng latLng = new LatLng(-30.015208, -51.190946);

		// getDistanceMeters()
		
		String distanceMsg = "";
		DecimalFormat df = new DecimalFormat("0.000");
		DecimalFormat dfk = new DecimalFormat("0.00");
		if(Math.round(distance / 1000) > 0){
			distanceMsg = df.format(distance / 1000) + " km";
		}else if(Math.round(distance / 1000) < 1){
			distanceMsg = dfk.format(distance) + " m";
		}else{
			distanceMsg = Math.ceil(distance) / 1000  + " km";
		}
		
		MarkerOptions marker = new MarkerOptions().position(latLng)
				.title("TargetTrust Treinamento e Tecnologia")
				.snippet("à " + distanceMsg);
		marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

		googleMap.addMarker(marker);

		/*
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));

		// Zoom in, animating the camera.
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

		CameraPosition cameraPosition = CameraPosition.builder().target(latLng)
				.zoom(16).bearing(90).build();

		// Animate the change in camera view over 2 seconds
		googleMap.animateCamera(
				CameraUpdateFactory.newCameraPosition(cameraPosition), 2000,
				null);
				
		*/
		if (userlocation != null) {
			double lat = userlocation.getLatitude();
			double lng = userlocation.getLongitude();
			LatLng ll = new LatLng(lat, lng);

			LatLngBounds.Builder builder = new LatLngBounds.Builder();

			builder.include(latLng);
			builder.include(ll);
			LatLngBounds bounds = builder.build();

			int padding = 15; // offset from edges of the map in pixels
			CameraUpdate camu = CameraUpdateFactory.newLatLngBounds(bounds,	padding);
			googleMap.animateCamera(camu);

		} else {
			googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
			// Zoom in, animating the camera.
			googleMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
			CameraPosition cameraPosition = CameraPosition.builder().target(latLng).zoom(16).bearing(90).build();
			// Animate the change in camera view over 2 seconds
			googleMap.animateCamera(
					CameraUpdateFactory.newCameraPosition(cameraPosition),
					2000, null);
		}
	}
	
	private class LongOperation extends AsyncTask<String, Void, String> {
		ProgressDialog dialog;

		@Override
		protected String doInBackground(String... params) {
			try {
				// Loading map
				setUpMap();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) {
			addMarkers();
			dialog.dismiss();
		}

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(aba);
			// dialog.setMessage(getString(R.string.please_wait_while_loading));
			dialog.setIndeterminate(true);
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}
}
