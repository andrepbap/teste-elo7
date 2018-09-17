package andrepbap.carreiraselo7.callback;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

import andrepbap.carreiraselo7.model.Cultura;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCulturasCallback implements Callback<ArrayList<Cultura>>{

    private Context context;

    public GetCulturasCallback (Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<ArrayList<Cultura>> call, Response<ArrayList<Cultura>> response) {
        if(response.isSuccessful()){

            ArrayList<Cultura> culturas = response.body();

            Intent intent = new Intent("novas_culturas");
            intent.putExtra("culturas", culturas);

            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Cultura>> call, Throwable t) {
        Log.e("GetCulturasCallback", t.getMessage());
    }
}
