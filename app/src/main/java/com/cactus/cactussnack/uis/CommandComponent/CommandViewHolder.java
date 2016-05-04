package com.cactus.cactussnack.uis.CommandComponent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.*;
import com.cactus.cactussnack.R;

public class CommandViewHolder extends RecyclerView.ViewHolder {

    Context context;
    public EditText quantity;
    public TextView productLabel;
    public TextView productUnitPrice;
    public TextView productQtyFactor;
    public TextView productPrice;

    public CommandViewHolder(final Context context, View itemView) {
        super(itemView);
        this.context = context;
        quantity = (EditText) itemView.findViewById(R.id.product_quantity);
        productLabel = (TextView) itemView.findViewById(R.id.product_label);
        productUnitPrice = (TextView) itemView.findViewById(R.id.product_unit_price);
        productQtyFactor = (TextView) itemView.findViewById(R.id.product_qty_factor);
        productPrice = (TextView) itemView.findViewById(R.id.product_price);
    }
}

