package androiduniverse.pokeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PokeListActivity extends AppCompatActivity {

    public int genId;
    TextView gen_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_list);

        genId = getIntent().getIntExtra("genId", 0);
        gen_tv = (TextView) findViewById(R.id.gen_id);
        gen_tv.setText(Integer.toString(genId));
    }
}
