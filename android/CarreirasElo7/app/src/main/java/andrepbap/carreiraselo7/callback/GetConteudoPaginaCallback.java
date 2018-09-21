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
    private Intent intent;
    private LocalBroadcastManager localBroadcastManager;

    public GetConteudoPaginaCallback(Context context) {
        this.context = context;
        this.intent = new Intent();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @Override
    public void onResponse(Call<ConteudoPagina> call, Response<ConteudoPagina> response) {

        if(response.isSuccessful()){

            ConteudoPagina conteudo = response.body();

            intent.setAction("novo_conteudo");
            intent.putExtra("conteudo", conteudo);
            localBroadcastManager.sendBroadcast(intent);

        } else {

            intent.setAction("erro_conteudo");
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override
    public void onFailure(Call<ConteudoPagina> call, Throwable t) {
        Log.e("GetConteudoCallback", t.getMessage());

        intent.setAction("erro_conteudo");
        localBroadcastManager.sendBroadcast(intent);
    }
}
