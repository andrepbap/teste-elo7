package andrepbap.carreiraselo7.callback;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import andrepbap.carreiraselo7.model.ConteudoPagina;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetConteudoPaginaCallback implements Callback<ConteudoPagina>{

    private Context context;

    public GetConteudoPaginaCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<ConteudoPagina> call, Response<ConteudoPagina> response) {
        if(response.isSuccessful()){

            ConteudoPagina conteudo = response.body();

            Intent intent = new Intent("novo_conteudo");
            intent.putExtra("conteudo", conteudo);

            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ConteudoPagina> call, Throwable t) {
        Log.e("GetConteudoCallback", t.getMessage());
    }
}
