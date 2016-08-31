package id.co.warungdeveloper.searchingsqliterecyclerview.mRecyler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.co.warungdeveloper.searchingsqliterecyclerview.R;
import id.co.warungdeveloper.searchingsqliterecyclerview.mDataObject.Planet;

/**
 * Created by CLient-Pc on 30/08/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Planet> planets;

    public MyAdapter(Context c, ArrayList<Planet> planets) {
        this.c = c;
        this.planets = planets;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvName.setText(planets.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }
}




















