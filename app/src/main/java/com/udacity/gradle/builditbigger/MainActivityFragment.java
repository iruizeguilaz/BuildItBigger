package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.jokes.Joker;
import signin.udacity.com.mylibrary.ActivityModule;

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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        b1 = (Button) root.findViewById(R.id.button_joke);
        b1.setOnClickListener(myhandlerJoke);
        return root;
    }

    View.OnClickListener myhandlerJoke = new View.OnClickListener() {
        public void onClick(View v) {

            Joker joke = new Joker();

            Intent myIntent = new Intent(getActivity(), ActivityModule.class);
            myIntent.putExtra("Joke", joke.getJoke());
            startActivity(myIntent);

        }
    };
}
