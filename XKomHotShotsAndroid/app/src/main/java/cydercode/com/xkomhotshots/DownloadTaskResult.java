package cydercode.com.xkomhotshots;

import com.cydercode.hotshots.xkom_api.model.HotShot;

/**
 * Created by Adam Tomaja (CyderCode) on 2016-06-19.
 */
public class DownloadTaskResult {

    public enum Type {
        OK, ERROR
    }

    private final String message;

    private final HotShot hotShot;

    private final Type type;

    public DownloadTaskResult(String message, HotShot hotShot, Type type) {
        this.message = message;
        this.hotShot = hotShot;
        this.type = type;
    }

    @Override
    public String toString() {
        return "DownloadTaskResult{" +
                "message='" + message + '\'' +
                ", hotShot=" + hotShot +
                ", type=" + type +
                '}';
    }
}
