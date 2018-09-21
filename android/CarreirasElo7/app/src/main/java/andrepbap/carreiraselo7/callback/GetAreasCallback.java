package andrepbap.carreiraselo7.callback;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

import andrepbap.carreiraselo7.model.Area;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAreasCallback implements Callback<ArrayList<Area>>{

    private Context context;
    private Intent intent;
    private LocalBroadcastManager localBroadcastManager;

    public GetAreasCallback(Context context) {
        this.context = context;
        this.intent = new Intent();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @Override
    public void onResponse(Call<ArrayList<Area>> call, Response<ArrayList<Area>> response) {
        if(response.isSuccessful()){

            ArrayList<Area> areas = response.body();

            intent.setAction("novas_areas");
            intent.putExtra("areas", areas);
            localBroadcastManager.sendBroadcast(intent);
        } else {
            intent.setAction("erro_areas");
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Area>> call, Throwable t) {
        Log.e("GetAreasCallback", t.getMessage());

        intent.setAction("erro_areas");
        localBroadcastManager.sendBroadcast(intent);
    }
}
