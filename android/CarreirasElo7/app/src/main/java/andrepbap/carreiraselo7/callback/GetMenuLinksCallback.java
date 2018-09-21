package andrepbap.carreiraselo7.callback;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

import andrepbap.carreiraselo7.model.MenuLink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMenuLinksCallback implements Callback<ArrayList<MenuLink>>{

    private Context context;
    private Intent intent;
    private LocalBroadcastManager localBroadcastManager;

    public GetMenuLinksCallback(Context context) {
        this.context = context;
        this.intent = new Intent();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @Override
    public void onResponse(Call<ArrayList<MenuLink>> call, Response<ArrayList<MenuLink>> response) {
        if(response.isSuccessful()){

            ArrayList<MenuLink> menuLinks = response.body();

            intent.setAction("novos_links");
            intent.putExtra("menuLinks", menuLinks);
            localBroadcastManager.sendBroadcast(intent);
        } else {
            intent.setAction("erro_links");
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<MenuLink>> call, Throwable t) {
        Log.e("GetMenuLinksCallback", t.getMessage());
        intent.setAction("erro_links");
        localBroadcastManager.sendBroadcast(intent);
    }
}
