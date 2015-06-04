package subjectdenied.gmail.com.myappportfolio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    private HashMap<Integer, String> links = new HashMap<Integer, String>();
    private List<Button> buttons;
    private String toastPrefix = "This button will launch the ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create List with key button-id and value toast-msg
        links.put(R.id.btSpotify, "\"Spotify Streamer\" App");
        links.put(R.id.btScores, "\"Scores \" App");
        links.put(R.id.btLibrary, "\"Library\" App");
        links.put(R.id.btBuild, "\"Build It Bigger\" App");
        links.put(R.id.btReader, "\"XYZ Reader\" App");
        links.put(R.id.btCapstone, "\"Capstone: My Own App\"");

        for (Map.Entry<Integer, String> entry : links.entrySet()) {
            Integer id = entry.getKey();
            final String msg = entry.getValue();

            Button button = (Button) findViewById(id);

            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Context context = getApplicationContext();
                    CharSequence toastMessage = toastPrefix + msg;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, toastMessage, duration);
                    toast.show();

                }

            });

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
