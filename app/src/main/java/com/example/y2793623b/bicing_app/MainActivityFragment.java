package com.example.y2793623b.bicing_app;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.clustering.RadiusMarkerClusterer;
import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    private ArrayList<Bicing> staciones = new ArrayList<>();

    public MainActivityFragment() {
    }

    private MapView map;
    private IMapController mapController;
    private MyLocationNewOverlay myLocationOverlay;
    private ScaleBarOverlay mScaleBarOverlay;
    private CompassOverlay mCompassOverlay;
    private MinimapOverlay mMinimapOverlay;
    private RadiusMarkerClusterer bicingMarkers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        map = (MapView) view.findViewById(R.id.mapView);

        initializeMap();
        setZoom();
        setOverlays();
        putMarkers();
       
        map.invalidate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    //Agreguem els items de menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            super.onCreateOptionsMenu(menu, inflater);
            inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_markers)
        {
            putMarkers();
        }

        return super.onOptionsItemSelected(item);
    }


    private void initializeMap() {



        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        map.setTilesScaledToDpi(true);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

    }



    private void setZoom() {

        //  Setteamos el zoom al mismo nivel y ajustamos la posición a un geopunto
        mapController = map.getController();
        mapController.setZoom(14);

    }


    private void setOverlays() {

        final DisplayMetrics dm = getResources().getDisplayMetrics();


        myLocationOverlay = new MyLocationNewOverlay(
                getContext(),
                new GpsMyLocationProvider(getContext()),
                map
        );
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.runOnFirstFix(new Runnable() {
            @Override
            public void run() {
                mapController.animateTo( myLocationOverlay.getMyLocation());
            }
        });


        mScaleBarOverlay = new ScaleBarOverlay(map);
        mScaleBarOverlay.setCentred(true);
        mScaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);

        mCompassOverlay = new CompassOverlay(
                getContext(),
                new InternalCompassOrientationProvider(getContext()),
                map
        );
        mCompassOverlay.enableCompass();

        map.getOverlays().add(myLocationOverlay);
        //map.getOverlays().add(this.mMinimapOverlay);
        map.getOverlays().add(this.mScaleBarOverlay);
        map.getOverlays().add(this.mCompassOverlay);

    }


    private void putMarkers() {


        setupMarkerOverlay();
        if (staciones != null) {

            for (Bicing B : staciones) {
                Marker marker = new Marker(map);

                Log.d("ESTACION ----------_>",B.toString());
                GeoPoint point = new GeoPoint(
                        B.getLatitude(),
                        B.getLongitude()
                );



                marker.setPosition(point);

                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                //cuando le damos click al icono nos sale :
                marker.setTitle("En el calle : " + B.getStreetName() + "\n hay : " + B.getBikes() + " bicicletas.");
                marker.setAlpha(0.6f);

                if(B.getBikes() != 0 && B.getSlots() != 0)
                {
                    int ocupacion = ((B.getBikes() * 100)/(B.getBikes() + B.getSlots()));

                    if(B.getType().equals("BIKE"))
                    {
                        //un icono de una bici
                        if(ocupacion == 0 )
                        {
                            //de color azul
                            marker.setIcon(getResources().getDrawable(R.drawable.bike));
                        }
                        else if(ocupacion > 0 && ocupacion <= 25)
                        {
                            //de color gris
                            marker.setIcon(getResources().getDrawable(R.drawable.bikegris));
                        }
                        else if(ocupacion > 25 && ocupacion <= 50)
                        {
                            //de color amarillo
                            marker.setIcon(getResources().getDrawable(R.drawable.bikeamarillo));
                        }
                        else if(ocupacion > 50 && ocupacion <= 75)
                        {
                            //de color verde
                            marker.setIcon(getResources().getDrawable(R.drawable.bikeverde));
                        }
                        else if(ocupacion > 75 && ocupacion <= 100)
                        {
                            //de color rojo
                            marker.setIcon(getResources().getDrawable(R.drawable.bikerojo));
                        }
                    }
                    else if(B.getType().equals("BIKE-ELECTRIC"))
                    {
                        //un icono de un moto
                        if(ocupacion == 0 )
                        {
                            //de color azul
                            marker.setIcon(getResources().getDrawable(R.drawable.motorbike));
                        }
                        else if(ocupacion > 0 && ocupacion <= 25)
                        {
                            //de color gris
                            marker.setIcon(getResources().getDrawable(R.drawable.motorbikegris));
                        }
                        else if(ocupacion > 25 && ocupacion <= 50)
                        {
                            //de color amarillo
                            marker.setIcon(getResources().getDrawable(R.drawable.motorbikeamarillo));
                        }
                        else if(ocupacion > 50 && ocupacion <= 75)
                        {
                            //de color verde
                            marker.setIcon(getResources().getDrawable(R.drawable.motorbikeverde));
                        }
                        else if(ocupacion > 75 && ocupacion <= 100)
                        {
                            //de color rojo
                            marker.setIcon(getResources().getDrawable(R.drawable.motorbikerojo));
                        }
                    }
                }





                bicingMarkers.add(marker);
                bicingMarkers.invalidate();
                map.invalidate();

            }
        }
    }



    @Override
    public void onStart() {
        super.onStart();

        RefreshDataTask task = new RefreshDataTask();
        task.execute();

    }

    private void setupMarkerOverlay() {

        bicingMarkers = new RadiusMarkerClusterer(getContext());
        map.getOverlays().add(bicingMarkers);

        Drawable clusterIconD = getResources().getDrawable(R.mipmap.ic_launcher);
        Bitmap clusterIcon = ((BitmapDrawable)clusterIconD).getBitmap();

        bicingMarkers.setIcon(clusterIcon);
        bicingMarkers.setRadius(100);
    }


    private class RefreshDataTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            staciones = Api.cogerDatos();


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //putMarkers();
        }
    }
}
