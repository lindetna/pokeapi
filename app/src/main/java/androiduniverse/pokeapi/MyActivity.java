package androiduniverse.pokeapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;




public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        TextView test = (TextView)findViewById(R.id.text);
        //AsyncTask<String, String, String> text = new httpcall().execute("http://pokeapi.co/api/v2/pokemon/1");
        test.setText("test");
        //test.setText(httpcall.getinfo("http://pokeapi.co/api/v2/pokemon/1"));
      /*  HttpResponse<JsonNode> response = null;

        // These code snippets use an open-source library. http://unirest.io/java
       try {
             response = Unirest.get("https://phalt-pokeapi.p.mashape.com/pokemon/1/")
                     .header("X-Mashape-Key", "zt7UYnPZsrmshGb9MJjLRCwh0Ly0p1q5O5Kjsn1dHVW2qAZugj")
                     .asJson();
           test.setText("ok");

           Log.v("test", "ok");
        } catch (UnirestException e) {
            e.printStackTrace();
        }
*/
        //ArticleFragment articleFragment = new ArticleFragment();
    }



    /*public class ArticleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.activity_my, container, false);
        }
    }*/
}