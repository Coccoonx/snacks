package com.cactus.cactussnack.uis.MainComponent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.cactus.cactussnack.R;

public class ListCommandViewHolder extends RecyclerView.ViewHolder {

    Context context;
    public TextView commandId;
    public TextView commandAmount;
    public TextView commandDate;
    public TextView commandStatus;
//    public TextView productPrice;

    public ListCommandViewHolder(final Context context, View itemView) {
        super(itemView);
        this.context = context;
        commandId = (TextView) itemView.findViewById(R.id.command_id);
        commandAmount = (TextView) itemView.findViewById(R.id.command_amount);
        commandDate = (TextView) itemView.findViewById(R.id.command_date);
        commandStatus = (TextView) itemView.findViewById(R.id.command_status);
    }
}

