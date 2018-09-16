package andrepbap.carreiraselo7.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import andrepbap.carreiraselo7.R;
import andrepbap.carreiraselo7.model.Cultura;

class culturasAdapter extends BaseAdapter {

    private final List<Cultura> culturas;
    private Context context;

    public culturasAdapter (List<Cultura> culturas, Context context){
        this.culturas = culturas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return culturas.size();
    }

    @Override
    public Object getItem(int i) {
        return culturas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.cultura, viewGroup, false);
        return viewCriada;
    }
}
