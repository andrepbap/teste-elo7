package andrepbap.carreiraselo7.adapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import andrepbap.carreiraselo7.R;
import andrepbap.carreiraselo7.model.Area;

public class AreasSpinnerAdapter extends BaseAdapter {

    private List<Area> areas;
    private Context context;

    public AreasSpinnerAdapter(List<Area> areas,  Context context) {

        // Coloca a dica na primeira posição da lista. Para não impactar na lista principal, criei uma nova e concatenei com a original
        this.areas = new ArrayList<>();
        this.areas.add(0, new Area(null, "Escolha um departamento", null));
        this.areas.addAll(areas);

        this.context = context;
    }

    @Override
    public int getCount() {
        return areas.size();
    }

    @Override
    public Area getItem(int i) {
        return areas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = LayoutInflater.from(context).inflate(R.layout.area_spinner_row, viewGroup, false);

        Area area = areas.get(i);

        TextView areaSpinnerText = row.findViewById(R.id.area_spinner_row_text);
        areaSpinnerText.setText(area.getTitulo());

        ImageView arrow = row.findViewById(R.id.area_spinner_row_arrow);
        arrow.setVisibility(View.INVISIBLE);

        // Caso a url da imagem seja nula, remove o elemento
        ImageView icon = row.findViewById(R.id.area_spinner_row_icon);
        if(area.getImagem() != null){
            Picasso.with(context)
                    .load(area.getImagem())
                    .into(icon);
        } else {
            icon.setVisibility(View.GONE);
        }

        return row;
    }
}
