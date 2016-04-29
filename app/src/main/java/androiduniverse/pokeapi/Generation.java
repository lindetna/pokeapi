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
public class Generation {
    //private static ArrayList<Generation> listGen;
    public int id;
    public String nom;
    RequestQueue queue;
    private ArrayList<Generation> listGen;

    public Generation(int tmpId) {
        listGen = new ArrayList<Generation>();
        id = tmpId;
        nom = "Génération " + Integer.toString(tmpId);
    }

    /**
     * Initialise une liste de personnes
     * @return une liste de "Personne"
     */

    public ArrayList<Generation> getGenList() {
        Log.v("listGen2", String.valueOf(this.listGen.isEmpty()));
        return this.listGen;
    }

    public void setGenList(JSONObject jsnobject) {
        JSONArray jsnarray = null;

        try {
            jsnarray = jsnobject.getJSONArray("results");
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
            this.listGen.add(new Generation(x + 1));
        }
        Log.v("listGen", String.valueOf(this.listGen.isEmpty()));
        //return listGen;
        Log.v("List", String.valueOf(listGen));
    }


}
