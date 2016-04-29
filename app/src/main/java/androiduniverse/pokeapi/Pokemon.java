package androiduniverse.pokeapi;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by SuChi on 28/04/2016.
 */
public class Pokemon {

    public int id;
    public String nom;
    RequestQueue queue;
    private ArrayList<Pokemon> listGen;

    public Pokemon(int tmpId, String name) {
        listGen = new ArrayList<Pokemon>();
        id = tmpId;
        nom = name;
    }

    public ArrayList<Pokemon> getPokeList() {
        //Log.v("listGen2", String.valueOf(this.listGen.isEmpty()));
        return this.listGen;
    }

    public void setPokeList(JSONObject jsnobject) {
        JSONArray jsnarray = null;
        String name = null;
        String tmpid = null;
        Integer id = null;
        try {
            jsnarray = jsnobject.getJSONArray("pokemon_species");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*try {
            for (Integer y = 0; jsnarray.getJSONObject(y) != null; y++) {

                Log.v("test" + y, jsnarray.getJSONObject(y).getString("url"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        Log.v("arraynb", String.valueOf(jsnarray.length()));
        for (Integer x = 0; x < jsnarray.length(); x++) {
            try {
                name = jsnarray.getJSONObject(x).getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                tmpid = jsnarray.getJSONObject(x).getString("url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            tmpid = tmpid.substring(tmpid.length() - 2, tmpid.length() -1);
            id = Integer.valueOf(tmpid);
            this.listGen.add(new Pokemon(id, name));
        }
        Log.v("listGen", String.valueOf(this.listGen.isEmpty()));
        //return listGen;
        Log.v("List", String.valueOf(listGen));
    }


}
