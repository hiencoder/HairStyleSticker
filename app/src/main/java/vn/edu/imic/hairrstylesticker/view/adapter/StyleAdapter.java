package vn.edu.imic.hairrstylesticker.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.network.Style;

/**
 * Created by GMO on 4/20/2018.
 */

public class StyleAdapter extends RecyclerView.Adapter<StyleAdapter.TypeHolder>{
    private Context context;
    private List<Style> styles;
    private StyleClickListener clickListener;
    public StyleAdapter(Context context, List<Style> styles, StyleClickListener listener) {
        this.context = context;
        this.styles = styles;
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public TypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_style,parent,false);
        return new TypeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeHolder holder, final int position) {
        holder.bind(styles.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(styles.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return styles.size();
    }

    public class TypeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_style)
        ImageView imgStyle;

        @BindView(R.id.tv_style)
        TextView tvStyle;
        public TypeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Style style){
            imgStyle.setImageResource(style.getIcon());
            tvStyle.setText(style.getStyle());
        }
    }

    public interface StyleClickListener{
        void onClick(Style style);
    }
}
