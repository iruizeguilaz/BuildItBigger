package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button b1;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        b1 = (Button) root.findViewById(R.id.button_joke);
        b1.setOnClickListener(myhandlerJoke);
        return root;
    }

    View.OnClickListener myhandlerJoke = new View.OnClickListener() {
        public void onClick(View v) {

            //Joker joke = new Joker();

            //Intent myIntent = new Intent(getActivity(), ActivityModule.class);
            //myIntent.putExtra("Joke", joke.getJoke());
            //startActivity(myIntent);

            EndPointTaskWarpper endPointTaskWarpper = new EndPointTaskWarpper();
            endPointTaskWarpper.getJoke(getActivity());
            //new OLDEndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred"));

        }
    };



}
