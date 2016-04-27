package androiduniverse.pokeapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MyActivity extends AppCompatActivity {

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        queue = Volley.newRequestQueue(this);
        final TextView test = (TextView) findViewById(R.id.text);

        //AsyncTask<String, String, String> text = new httpcall().execute("http://pokeapi.co/api/v2/pokemon/1");
       // test.setText("test");

        // Instantiate the RequestQueue.
        //RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://pokeapi.co/api/v2/generation/";
        final String TAG = "Type";

        // Request a string response from the provided URL.
        /*StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        test.setText("Response is: " + response.substring(0,50));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                test.setText("That didn't work!");
            }

        });*/

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsnarray = null;
                        String name = null;
                        String generation_url = null;

                        try {
                            jsnarray = response.getJSONArray("results");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                            for (Integer x = 0; jsnarray.getJSONObject(x) != null; x++) {
                                try {
                                    name = jsnarray.getJSONObject(x).getString("name");
                                    generation_url = jsnarray.getJSONObject(x).getString("url");
                                    test.setText(test.getText() + "Response: " + name);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });



        //stringRequest.setTag(TAG);
        // Add the request to the RequestQueue.
        queue.add(jsObjRequest);

        //StopRequest(TAG);

        }

        protected void StopRequest (String TAG) {
        super.onStop();
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }


        //ArticleFragment articleFragment = new ArticleFragment();





    /*public class ArticleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.activity_my, container, false);
        }
    }*/
}