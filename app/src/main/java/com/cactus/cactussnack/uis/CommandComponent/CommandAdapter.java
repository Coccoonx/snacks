package com.cactus.cactussnack.uis.CommandComponent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cactus.cactussnack.R;
import lombok.Data;

import java.util.List;


public class CommandAdapter extends RecyclerView.Adapter<CommandViewHolder> {

    Context mContext;
    List items;


    public CommandAdapter(Context context, List selectedItems) {
        mContext = context;
        items = selectedItems;
    }

    private List intitData(List selectedItems) {
        return null;
    }

    @Override
    public CommandViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_command_row, viewGroup, false);
        CommandViewHolder pvh = new CommandViewHolder(mContext, v);
        return pvh;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(CommandViewHolder cardTitle, final int i) {
        // Setting font
//        UIUtils.setFont(UIUtils.Font.LIGHT, cardTitle.editInfo);
        cardTitle.productLabel.setText(""+items.get(i));

    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    private List initData(List list){
        return  null;
    }


//    @Data
    class ProductDetail {
        String code;
        String unitPrice;
        String label;

        public ProductDetail(String code, String unitPrice, String label) {
            this.code = code;
            this.unitPrice = unitPrice;
            this.label = label;
        }
    }
}
