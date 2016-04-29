package androiduniverse.pokeapi;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GenerationAdapter extends BaseAdapter {

    // Liste de générations
    private List<Generation> mListG;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;

    //Contient la liste des listeners
    private ArrayList<GenerationAdapterListener> mListListener = new ArrayList<GenerationAdapterListener>();

    public GenerationAdapter(Context context, List<Generation> aListG) {
        mContext = context;
        mListG = aListG;
        mInflater = LayoutInflater.from(mContext);
    }

    public interface GenerationAdapterListener {
        public void onClickNom(Generation item, int position);
    }

    public int getCount() {
        return mListG.size();
    }

    public Object getItem(int position) {
        return mListG.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.generation_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tv_id = (TextView)layoutItem.findViewById(R.id.TV_id);

        //(3) : Renseignement des valeurs
        tv_id.setText(mListG.get(position).nom);

        /*(4) Changement de la couleur du fond de notre item
        if (mListP.get(position).genre == Personne.MASCULIN) {
            layoutItem.setBackgroundColor(Color.BLUE);
        } else {
            layoutItem.setBackgroundColor(Color.MAGENTA);
        }*/

        //------------ Début de l'ajout -------
        //On mémorise la position de la "Personne" dans le composant textview
        tv_id.setTag(position);
        //On ajoute un listener
        tv_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Lorsque l'on clique sur le nom, on récupère la position de la "Personne"
                Integer position = (Integer)v.getTag();

                //On prévient les listeners qu'il y a eu un clic sur le TextView "TV_Nom".
                sendListener(mListG.get(position), position);

            }

        });
        //------------ Fin de l'ajout -------

        //On retourne l'item créé.
        return layoutItem;
    }

    /**
     * Pour ajouter un listener sur notre adapter
     */
    public void addListener(GenerationAdapterListener aListener) {
        mListListener.add(aListener);
    }

    private void sendListener(Generation item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }
}

