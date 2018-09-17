package andrepbap.carreiraselo7.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import andrepbap.carreiraselo7.R;
import andrepbap.carreiraselo7.app.ApiApplication;
import andrepbap.carreiraselo7.callback.GetAreasCallback;
import andrepbap.carreiraselo7.callback.GetCulturasCallback;
import andrepbap.carreiraselo7.component.ApiComponent;
import andrepbap.carreiraselo7.model.Area;
import andrepbap.carreiraselo7.model.Cultura;
import andrepbap.carreiraselo7.service.ApiService;

public class MainActivity extends AppCompatActivity {

    @Inject
    public ApiService apiService;
    private ApiComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiApplication app = (ApiApplication) getApplication();
        component = app.getComponent();
        component.inject(this);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_culturas"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_areas"));

        apiService.getCulturas()
                .enqueue(new GetCulturasCallback(this));

        apiService.getAreas()
                .enqueue(new GetAreasCallback(this));

        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.main_social_container);
    }

    @Override
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.unregisterReceiver(receiver);
    }

    private void montarLayoutCulturas (ArrayList<Cultura> culturas) {

        LinearLayout culturasLinearLayout = findViewById(R.id.culturas_linear_layout);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (Cultura cultura : culturas) {
            View view  = inflater.inflate(R.layout.cultura, culturasLinearLayout, false);

            TextView titulo = view.findViewById(R.id.cultura_titulo);
            titulo.setText(cultura.getTitulo());

            TextView texto = view.findViewById(R.id.cultura_texto);
            texto.setText(cultura.getTexto());

            ImageView imagem = view.findViewById(R.id.cultura_imagem);
            Resources resources = this.getResources();
            int idDoDrawable = resources.getIdentifier(cultura.getImagem()
                    ,"drawable", this.getPackageName());
            Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
            imagem.setImageDrawable(drawableImagemPacote);

            culturasLinearLayout.addView(view);
        }
    }

    private void montarLayoutAreas (ArrayList<Area> areas){

        FlexboxLayout areasContainer = (FlexboxLayout) findViewById(R.id.main_areas_flexbox);
        LayoutInflater inflaterAreas = LayoutInflater.from(this);

        for (Area area : areas) {
            View view = inflaterAreas.inflate(R.layout.area, areasContainer, false);

            TextView textLeft = view.findViewById(R.id.area_titulo);
            textLeft.setText(area.getTitulo());

            ImageView imagem = view.findViewById(R.id.area_imagem);
            Resources resources = this.getResources();
            int idDoDrawable = resources.getIdentifier(area.getImagem()
                    ,"drawable", this.getPackageName());
            Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
            imagem.setImageDrawable(drawableImagemPacote);

            areasContainer.addView(view);
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals("novas_culturas")) {

                ArrayList<Cultura> culturas = (ArrayList<Cultura>) intent.getSerializableExtra("culturas");
                montarLayoutCulturas(culturas);

            } else if (intent.getAction().equals("novas_areas")) {

                ArrayList<Area> areas = (ArrayList<Area>) intent.getSerializableExtra("areas");
                montarLayoutAreas(areas);

            }


        }
    };
}
