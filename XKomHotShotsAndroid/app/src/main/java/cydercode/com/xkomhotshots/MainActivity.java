package cydercode.com.xkomhotshots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cydercode.hotshots.xkom_api.model.HotShot;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

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
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        if(result.getType() == DownloadTaskResult.Type.OK) {
            final HotShot hotShot = result.getHotShot();
            setText(R.id.productName, hotShot.getProductName());
            setText(R.id.oldPrice, hotShot.getOldPrice());
            setText(R.id.newPrice, hotShot.getNewPrice());
            setText(R.id.discount, hotShot.getDiscount());
            setText(R.id.endHour, hotShot.getEndHour());

            UrlImageViewHelper.setUrlDrawable(imageView,  hotShot.getImageUrl());
            setViewVisibility(R.id.dataLayout, View.VISIBLE);
            setViewVisibility(R.id.progressLayout, View.GONE);
        } else {
            setText(R.id.errorTextView, result.getMessage());
            setViewVisibility(R.id.errorLayout, View.VISIBLE);
            setViewVisibility(R.id.progressLayout, View.GONE);
        }
    }

    private void setText(int id, String text) {
        ((TextView) findViewById(id)).setText(text);
    }

    private void setViewVisibility(int id, int visibility) {
        ((View) findViewById(id)).setVisibility(visibility);
    }


}
