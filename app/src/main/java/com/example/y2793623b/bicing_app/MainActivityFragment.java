package com.example.y2793623b.bicing_app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.views.MapView;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    private MapView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        map = (MapView) view.findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPQUESTOSM);
        map.setTilesScaledToDpi(true);
        
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);



        return view;
    }
}
