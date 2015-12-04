package signin.udacity.com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityModule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Joke");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("Joke");
        }

        Toast.makeText(this, newString,
                Toast.LENGTH_LONG).show();

    }
}
