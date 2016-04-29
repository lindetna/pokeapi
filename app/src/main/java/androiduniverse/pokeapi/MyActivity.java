package androiduniverse.pokeapi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MyActivity extends AppCompatActivity implements GenerationAdapter.GenerationAdapterListener {

    private Generation generation;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final VolleyCallback callback = new VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {

            }
        };

        generation  = new Generation(1);
        Log.v("Check1", "ok");

        initGenList(callback);
        myWebServiceFun();
        ArrayList<Generation> listG = generation.getGenList();
        GenerationAdapter adapter = new GenerationAdapter(this, listG);

        adapter.addListener(this);

        ListView list = (ListView) findViewById(R.id.idListGen);

        list.setAdapter(adapter);
    }


    public void onClickNom(Generation item, int position) {
        Intent intent = new Intent(getApplicationContext(), PokeListActivity.class);
        intent.putExtra("genId", item.id);
        startActivity(intent);
    }



    public interface VolleyCallback {
        void onSuccessResponse(JSONObject result);
    }

    private void initGenList(final VolleyCallback callback) {

        GoogleApiClient client;

        queue = Volley.newRequestQueue(this);

        String url = "http://pokeapi.co/api/v2/generation/";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccessResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                    }
                });
        queue.add(jsObjRequest);
    }

    public void myWebServiceFun() {

        String url = "http://pokeapi.co/api/v2/generation/";

        initGenList(new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(JSONObject result) {
                        generation.setGenList(result);
                    }
                });
    }

    protected void StopRequest (String TAG) {
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }
}

