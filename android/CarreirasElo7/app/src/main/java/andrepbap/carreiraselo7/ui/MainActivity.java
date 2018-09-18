package andrepbap.carreiraselo7.ui;

import android.support.v7.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import andrepbap.carreiraselo7.R;
import andrepbap.carreiraselo7.adapter.AreasSpinnerAdapter;
import andrepbap.carreiraselo7.app.ApiApplication;
import andrepbap.carreiraselo7.callback.GetAreasCallback;
import andrepbap.carreiraselo7.callback.GetCulturasCallback;
import andrepbap.carreiraselo7.callback.GetSocialCallback;
import andrepbap.carreiraselo7.component.ApiComponent;
import andrepbap.carreiraselo7.model.Area;
import andrepbap.carreiraselo7.model.Cultura;
import andrepbap.carreiraselo7.model.Social;
import andrepbap.carreiraselo7.service.ApiService;

public class MainActivity extends AppCompatActivity {

    @Inject
    public ApiService apiService;
    private ApiComponent component;

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiApplication app = (ApiApplication) getApplication();
        component = app.getComponent();
        component.inject(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_culturas"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_areas"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_socials"));

        apiService.getCulturas()
                .enqueue(new GetCulturasCallback(this));

        apiService.getAreas()
                .enqueue(new GetAreasCallback(this));

        apiService.getSocials()
                .enqueue(new GetSocialCallback(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuItem item = menu.add(Menu.NONE, 1, Menu.NONE, "Engenharia");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        MenuItem item2 = menu.add(Menu.NONE, 1, Menu.NONE, "Eventos");
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            default:
                return false;
        }
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
            Picasso.with(this)
                    .load(cultura.getImagem())
                    .resize(500,500)
                    .centerInside()
                    .into(imagem);

            culturasLinearLayout.addView(view);
        }
    }

    private View.OnClickListener AreaClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Area area = (Area) v.getTag();

            String url = area.getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    };

    private void montarLayoutAreas (ArrayList<Area> areas){

        FlexboxLayout areasContainer = findViewById(R.id.main_areas_flexbox);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (Area area : areas) {
            View view = inflater.inflate(R.layout.area, areasContainer, false);

            view.setTag(area);
            view.setOnClickListener(AreaClickListener);

            TextView textLeft = view.findViewById(R.id.area_titulo);
            textLeft.setText(area.getTitulo());

            ImageView imagem = view.findViewById(R.id.area_imagem);
            Picasso.with(this)
                    .load(area.getImagem())
                    .resize(150,150)
                    .centerInside()
                    .into(imagem);

            areasContainer.addView(view);
        }

        Spinner areasSpinner = findViewById(R.id.main_areas_spinner);
        areasSpinner.setAdapter(new AreasSpinnerAdapter(areas, this));

        areasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ImageView arrow = view.findViewById(R.id.area_spinner_row_arrow);
                arrow.setVisibility(View.VISIBLE);

                AreasSpinnerAdapter adapter = (AreasSpinnerAdapter) adapterView.getAdapter();

                String url = adapter.getItem(i).getLink();

                if(url != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private View.OnClickListener SocialClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Social social = (Social) v.getTag();

            String url = social.getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    };

    private void montarLayoutSocials(ArrayList<Social> socials) {

        FlexboxLayout socialsContainer = (FlexboxLayout) findViewById(R.id.main_social_container);

        for (Social social : socials) {

            ImageButton botao = new ImageButton(this);

            botao.setBackgroundColor(Color.TRANSPARENT);
            botao.setPadding(5,0,5,0);
            botao.setContentDescription(social.getNome());
            botao.setTag(social);
            botao.setOnClickListener(SocialClickListener);

            Picasso.with(this)
                    .load(social.getImagem())
                    .resize(100,100)
                    .centerInside()
                    .into(botao);

            socialsContainer.addView(botao);
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

            } else if (intent.getAction().equals("novas_socials")) {

                ArrayList<Social> socials = (ArrayList<Social>) intent.getSerializableExtra("socials");
                montarLayoutSocials(socials);

            }


        }
    };
}
