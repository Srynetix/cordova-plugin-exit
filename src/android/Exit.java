package im.ckk.cordova.exit;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

public class Exit extends CordovaPlugin {
    protected void pluginInitialize() {}

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        /*
         * Finishes the activity provided by CordovaInterface.
         */

        if (action.equals("exit")) {
            try {
                Activity activity = this.cordova.getActivity();

                // Takes user to home screen
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);

                // Kills all activities of app
                System.exit(0);

                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
            } catch (Exception e) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 1));
            }
            return true;
        }
        return false;
    }
}
