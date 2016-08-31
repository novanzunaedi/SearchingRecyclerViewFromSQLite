package id.co.warungdeveloper.searchingsqliterecyclerview.mRecyler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import id.co.warungdeveloper.searchingsqliterecyclerview.R;

/**
 * Created by CLient-Pc on 30/08/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder {

    TextView tvName;

    public MyHolder(View itemView) {
        super(itemView);
        this.tvName = (TextView) itemView.findViewById(R.id.tvName);
    }
}









