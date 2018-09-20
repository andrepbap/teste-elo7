package andrepbap.carreiraselo7.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import andrepbap.carreiraselo7.app.MyApplication;
import andrepbap.carreiraselo7.callback.GetAreasCallback;
import andrepbap.carreiraselo7.callback.GetConteudoPaginaCallback;
import andrepbap.carreiraselo7.callback.GetCulturasCallback;
import andrepbap.carreiraselo7.callback.GetMenuLinksCallback;
import andrepbap.carreiraselo7.callback.GetSocialCallback;
import andrepbap.carreiraselo7.util.Util;
import andrepbap.carreiraselo7.component.ApiComponent;
import andrepbap.carreiraselo7.model.Area;
import andrepbap.carreiraselo7.model.ConteudoPagina;
import andrepbap.carreiraselo7.model.Cultura;
import andrepbap.carreiraselo7.model.Social;
import andrepbap.carreiraselo7.model.MenuLink;
import andrepbap.carreiraselo7.service.ApiService;

public class MainActivity extends AppCompatActivity {

    // Injeta o serviço da API via dagger
    @Inject
    public ApiService apiService;
    private ApiComponent component;

    private Menu menu;

    // Objetos que serão carregados na tela através da API
    private ArrayList<MenuLink> menuLinks;
    private ArrayList<Cultura> culturas;
    private ArrayList<Area> areas;
    private ArrayList<Social> socials;
    private ConteudoPagina conteudoPagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication app = (MyApplication) getApplication();
        component = app.getComponent();
        component.inject(this);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novo_conteudo"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_culturas"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_areas"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novas_socials"));
        localBroadcastManager.registerReceiver(receiver, new IntentFilter("novos_links"));

        // Capta savedInstanceState para não precisar chamar a api novamente toda vez que a tela for remontada
        if (savedInstanceState != null) {
            conteudoPagina = (ConteudoPagina) savedInstanceState.getSerializable("conteudoPagina");
            menuLinks = (ArrayList<MenuLink>) savedInstanceState.getSerializable("menuLinks");
            culturas = (ArrayList<Cultura>) savedInstanceState.getSerializable("culturas");
            areas = (ArrayList<Area>) savedInstanceState.getSerializable("areas");
            socials = (ArrayList<Social>) savedInstanceState.getSerializable("socials");
        }

        // Faz chamada para API caso os objetos não estejam com salvos
        if(conteudoPagina == null) {
            apiService.getConteudo()
                    .enqueue(new GetConteudoPaginaCallback(this));
        } else {
            preencherConteudo();
        }

        if(culturas == null) {
            apiService.getCulturas()
                    .enqueue(new GetCulturasCallback(this));
        } else {
            montarLayoutCulturas();
        }

        if(areas == null) {
            apiService.getAreas()
                    .enqueue(new GetAreasCallback(this));
        } else {
            montarLayoutAreas();
        }

        if(socials == null) {
            apiService.getSocials()
                    .enqueue(new GetSocialCallback(this));
        } else {
            montarLayoutSocials();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("conteudoPagina", conteudoPagina);
        outState.putSerializable("menuLinks", menuLinks);
        outState.putSerializable("culturas", culturas);
        outState.putSerializable("areas", areas);
        outState.putSerializable("socials", socials);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        if(menuLinks == null){
            apiService.getMenu()
                    .enqueue(new GetMenuLinksCallback(this));
        } else {
            montarMenu();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            MenuLink menuLink = menuLinks.get(item.getItemId());
            Util.abrirURL(menuLink.getLink(), this);

            return true;

        } catch (IndexOutOfBoundsException exception) {
            return false;
        }
    }

    /*
        Monta menu de forma dinâmica
     */
    private void montarMenu () {

        if(menuLinks == null)
            return;

        int position = 0;

        for (MenuLink link : menuLinks) {
            MenuItem item = menu.add(Menu.NONE, position, Menu.NONE, link.getNome());
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

            position ++;
        }
    }

    // Os métodos abaixo são responsáveis pela montagem da tela com os dados obtidos através da API

    private void preencherConteudo() {

        if (conteudoPagina == null)
            return;

        TextView mainTituloCulturas = findViewById(R.id.main_titulo_culturas);
        mainTituloCulturas.setText(conteudoPagina.getTituloCulturas());

        TextView mainTextoCulturas = findViewById(R.id.main_texto_culturas);
        mainTextoCulturas.setText(conteudoPagina.getTextoCulturas());

        TextView mainTituloAreas = findViewById(R.id.main_titulo_areas);
        mainTituloAreas.setText(conteudoPagina.getTituloAreas());

        TextView mainTituloRodape = findViewById(R.id.main_titulo_rodape);
        mainTituloRodape.setText(conteudoPagina.getTituloRodape());

    }

    private void montarLayoutCulturas () {

        if(culturas == null){
            return;
        }

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
            Util.abrirURL(area.getLink(), MainActivity.this);
        }
    };

    private void montarLayoutAreas (){

        if(areas == null)
            return;

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
                    .resize(130,130)
                    .centerInside()
                    .into(imagem);

            areasContainer.addView(view);
        }

        final Spinner areasSpinner = findViewById(R.id.main_areas_spinner);
        areasSpinner.setAdapter(new AreasSpinnerAdapter(areas, this));

        areasSpinner.post(new Runnable() {
            @Override
            public void run() {
                areasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        ImageView arrow = view.findViewById(R.id.area_spinner_row_arrow);
                        arrow.setVisibility(View.VISIBLE);

                        AreasSpinnerAdapter adapter = (AreasSpinnerAdapter) adapterView.getAdapter();

                        String url = adapter.getItem(i).getLink();

                        if (url != null) {
                            Util.abrirURL(url, MainActivity.this);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });

    }

    private View.OnClickListener SocialClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Social social = (Social) v.getTag();
            Util.abrirURL(social.getLink(), MainActivity.this);
        }
    };

    private void montarLayoutSocials() {

        if(socials == null)
            return;


        FlexboxLayout socialsContainer = (FlexboxLayout) findViewById(R.id.main_social_container);

        for (Social social : socials) {

            ImageButton botao = new ImageButton(this);

            botao.setBackgroundColor(Color.TRANSPARENT);
            botao.setPadding(10,0,10,10);
            botao.setContentDescription(social.getNome());
            botao.setTag(social);
            botao.setOnClickListener(SocialClickListener);

            Picasso.with(this)
                    .load(social.getImagem())
                    .resize(70,70)
                    .centerInside()
                    .into(botao);

            socialsContainer.addView(botao);
        }
    }

    /*
        Trata retorno da API
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals("novo_conteudo")) {

                ConteudoPagina conteudoPagina = (ConteudoPagina) intent.getSerializableExtra("conteudo");
                MainActivity.this.conteudoPagina = conteudoPagina;
                preencherConteudo();

            } else if (intent.getAction().equals("novas_culturas")) {

                ArrayList<Cultura> culturas = (ArrayList<Cultura>) intent.getSerializableExtra("culturas");
                MainActivity.this.culturas = culturas;
                montarLayoutCulturas();

            } else if (intent.getAction().equals("novas_areas")) {

                ArrayList<Area> areas = (ArrayList<Area>) intent.getSerializableExtra("areas");
                MainActivity.this.areas = areas;
                montarLayoutAreas();

            } else if (intent.getAction().equals("novas_socials")) {

                ArrayList<Social> socials = (ArrayList<Social>) intent.getSerializableExtra("socials");
                MainActivity.this.socials = socials;
                montarLayoutSocials();

            } else if (intent.getAction().equals("novos_links")) {

                ArrayList<MenuLink> links = (ArrayList<MenuLink>) intent.getSerializableExtra("menuLinks");
                MainActivity.this.menuLinks = links;
                montarMenu();

            }

        }
    };

}
