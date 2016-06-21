package cydercode.com.xkomhotshots;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by Adam Tomaja (CyderCode) on 2016-06-19.
 */
public class HotShotWidget extends AppWidgetProvider {

    public static String RELOAD_ACTION = "ReloadAction",
            MORE_ACTION = "MoreAction";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.hot_shot_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        addOnClickPendingIntent(views, context, R.id.reloadButton, RELOAD_ACTION);
//        addOnClickPendingIntent(views, context, R.id.moreButton, MORE_ACTION);

        Intent moreIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingMoreIntent = PendingIntent.getActivity(context, 0, moreIntent, 0);
        views.setOnClickPendingIntent(R.id.moreButton, pendingMoreIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    private static void addOnClickPendingIntent(RemoteViews views, Context context, int viewId, String action) {
        Intent intent = new Intent(context, HotShotWidget.class);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        views.setOnClickPendingIntent(viewId, pendingIntent);
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        System.out.println(intent.getAction());
        if(intent.getAction().equals(RELOAD_ACTION) || intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE")) {
            reloadData(context);
        } else if(intent.getAction().equals(MORE_ACTION)) {
            Intent moreIntent = new Intent(context, MainActivity.class);
            context.startActivity(moreIntent);
        }
        super.onReceive(context, intent);
    }

    private void reloadData(final Context context) {
        new DownloadTask(new DownloadTaskListener() {
            @Override
            public void onResult(DownloadTaskResult result) {
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.hot_shot_widget);
                AppWidgetManager manager = AppWidgetManager.getInstance(context);

                if(result.getType() == DownloadTaskResult.Type.OK) {
                    views.setTextViewText(R.id.appwidget_text, result.getHotShot().getProductName());
                } else {
                    views.setTextViewText(R.id.appwidget_text, "Błąd: " + result.getMessage());
                }

                manager.updateAppWidget(new ComponentName(context, HotShotWidget.class), views);
            }
        }).execute();
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
         for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

