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
    private Intent intent;
    private LocalBroadcastManager localBroadcastManager;

    public GetCulturasCallback (Context context) {
        this.context = context;
        this.intent = new Intent();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @Override
    public void onResponse(Call<ArrayList<Cultura>> call, Response<ArrayList<Cultura>> response) {
        if(response.isSuccessful()){

            ArrayList<Cultura> culturas = response.body();

            intent.setAction("novas_culturas");
            intent.putExtra("culturas", culturas);
            localBroadcastManager.sendBroadcast(intent);
        } else {

            intent.setAction("erro_culturas");
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Cultura>> call, Throwable t) {
        Log.e("GetCulturasCallback", t.getMessage());

        intent.setAction("erro_culturas");
        localBroadcastManager.sendBroadcast(intent);
    }
}
