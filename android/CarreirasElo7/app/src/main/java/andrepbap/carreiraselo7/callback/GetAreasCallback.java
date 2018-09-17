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

    public GetAreasCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<ArrayList<Area>> call, Response<ArrayList<Area>> response) {
        if(response.isSuccessful()){

            ArrayList<Area> areas = response.body();

            Intent intent = new Intent("novas_areas");
            intent.putExtra("areas", areas);

            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Area>> call, Throwable t) {
        Log.e("GetAreasCallback", t.getMessage());
    }
}
