package andrepbap.carreiraselo7.callback;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

import andrepbap.carreiraselo7.model.Social;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSocialCallback implements Callback<ArrayList<Social>>{

    private Context context;

    public GetSocialCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<ArrayList<Social>> call, Response<ArrayList<Social>> response) {
        if(response.isSuccessful()){

            ArrayList<Social> socials = response.body();

            Intent intent = new Intent("novas_socials");
            intent.putExtra("socials", socials);

            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Social>> call, Throwable t) {
        Log.e("GetSocialsCallback", t.getMessage());
    }
}
