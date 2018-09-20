package andrepbap.carreiraselo7.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Util {

    public static void abrirURL (String url, Context context){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }
}
