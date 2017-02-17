package com.example.y2793623b.bicing_app;

import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by y2793623b on 14/02/17.
 */

public class Api {


    public static ArrayList<Bicing> cogerDatos()
    {
        Uri BASE_URL = Uri.parse("http://wservice.viabicing.cat/v2/stations")
                .buildUpon()
                .build();
        String url = BASE_URL.toString();


        try {

            String Json = HttpUtils.get(url);

            ArrayList<Bicing> Stations = new ArrayList<>();

            JSONObject datos = new JSONObject(Json);


            JSONArray ArrayStations = datos.getJSONArray("stations");

            for (int i = 0; i < ArrayStations.length(); i++)
            {
                JSONObject object = ArrayStations.getJSONObject(i);
                Gson g = new Gson();

                Bicing StationInfo = g.fromJson(object.toString(),Bicing.class);
                Log.d("---------------------", StationInfo.toString());

                Stations.add(StationInfo);

            }

            return Stations;



        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
