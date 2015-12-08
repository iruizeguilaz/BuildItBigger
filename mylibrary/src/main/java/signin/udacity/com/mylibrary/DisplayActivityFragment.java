package signin.udacity.com.mylibrary;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayActivityFragment extends Fragment {

    public DisplayActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_display_activity, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(ActivityModule.JOKE);
        TextView jokeTextView = (TextView) root.findViewById(R.id.txtJoke);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }


        return root;
    }
}