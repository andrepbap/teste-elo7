package andrepbap.carreiraselo7.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Funcoes {

    public static void abrirURL (String url, Context context){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }
}
