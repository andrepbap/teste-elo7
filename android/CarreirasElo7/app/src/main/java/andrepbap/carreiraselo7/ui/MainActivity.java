package andrepbap.carreiraselo7.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

import andrepbap.carreiraselo7.R;
import andrepbap.carreiraselo7.model.Area;
import andrepbap.carreiraselo7.model.Cultura;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cultura c1 = new Cultura("@drawable/criatividade", "CRIATIVIDADE", "Texto criatividade");
        Cultura c2 = new Cultura("@drawable/colaboracao", "COLABORAÇÃO", "Texto colaboração");
        Cultura c3 = new Cultura("@drawable/tec_ino", "TECNOLOGIA E INOVAÇÃO", "Texto tec ino");

        List<Cultura> culturas = new ArrayList<>();
        culturas.add(c1);
        culturas.add(c2);
        culturas.add(c3);

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

        List<Area> areas = new ArrayList<Area>();
        areas.add(new Area("@drawable/ic_engenharia", "ENGENHARIA"));
        areas.add(new Area("@drawable/ic_atandimento", "ATENDIMENTO"));
        areas.add(new Area("@drawable/ic_comunicacao_mkt", "COMUNICAÇÃO E MARKETING"));
        areas.add(new Area("@drawable/ic_desenvolvimento_vendedores", "DESENVOLVIMENTO DE VENDEDORES"));

        FlexboxLayout areasContainer = (FlexboxLayout) findViewById(R.id.main_areas_flexbox);
        LayoutInflater inflaterAreas = LayoutInflater.from(this);

        for (int i = 0; i < areas.size(); i++) {
            View view = inflater.inflate(R.layout.area, areasContainer, false);

            TextView textLeft = view.findViewById(R.id.area_titulo);
            textLeft.setText(areas.get(i).getTitulo());

            areasContainer.addView(view);
        }

        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.main_social_container);


    }
}
