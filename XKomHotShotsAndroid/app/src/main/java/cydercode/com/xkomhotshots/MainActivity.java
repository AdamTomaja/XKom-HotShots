package cydercode.com.xkomhotshots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cydercode.hotshots.xkom_api.client.XKomClient;

/**
 * Created by Adam Tomaja (CyderCode) on 2016-06-19.
 */
public class MainActivity extends AppCompatActivity implements DownloadTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new DownloadTask(this).execute();

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResult(DownloadTaskResult result) {
        final TextView view = (TextView) findViewById(R.id.outputTextView);
        view.setText(result.toString());
    }
}
