package cydercode.com.xkomhotshots;

import android.os.AsyncTask;

import com.cydercode.hotshots.xkom_api.client.XKomClient;
import com.cydercode.hotshots.xkom_api.client.XKomClientException;

/**
 * Created by Adam Tomaja (CyderCode) on 2016-06-19.
 */
public class DownloadTask extends AsyncTask<Void, Void, DownloadTaskResult> {

    private final XKomClient client = new XKomClient();

    private final DownloadTaskListener listener;

    public DownloadTask(DownloadTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected DownloadTaskResult doInBackground(Void... params) {
        try {
            return new DownloadTaskResult("HotShot fetched sucessfully", client.fetchCurrentHotShot(), DownloadTaskResult.Type.OK);
        } catch (XKomClientException e) {
            return new DownloadTaskResult(e.getMessage(), null, DownloadTaskResult.Type.ERROR);
        }
    }

    @Override
    protected void onPostExecute(DownloadTaskResult downloadTaskResult) {
        listener.onResult(downloadTaskResult);
    }
}
