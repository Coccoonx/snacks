package com.cactus.cactussnack.uis.MainComponent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cactus.cactussnack.R;
import com.cactus.cactussnack.core.Command;
import com.cactus.cactussnack.core.Product;
import com.cactus.cactussnack.server.FakeServer;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class MainAdapter extends RecyclerView.Adapter<ListCommandViewHolder> {

    Context mContext;
    List<Command> items;

    public MainAdapter(Context context, List<Command> selectedItems) {
        mContext = context;
        items = selectedItems;
        Log.d(TAG, "In MainAdapter " + items.size());

    }


    @Override
    public ListCommandViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_command_item, viewGroup, false);
        ListCommandViewHolder pvh = new ListCommandViewHolder(mContext, v);
        Log.d("Adapter", "CommandViewHolder " + pvh);

        return pvh;
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @Override
    public void onBindViewHolder(final ListCommandViewHolder cardTitle, final int i) {
        // Setting font
//        UIUtils.setFont(UIUtils.Font.LIGHT, cardTitle.editInfo);
        final Command command = items.get(i);
//        commandRows.put(command.getCode(), 0);
        cardTitle.commandId.setText(command.getClientName());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        cardTitle.commandDate.setText(format.format(command.getDateCommand()));
        cardTitle.commandAmount.setText(format.format(command.getDateCommand()));
        if (command.isStatus()) {
            cardTitle.commandStatus.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            cardTitle.commandStatus.setText("LIVRE");
        } else {
            cardTitle.commandStatus.setTextColor(mContext.getResources().getColor(android.R.color.holo_orange_light));
            cardTitle.commandStatus.setText("NON LIVRE");

        }

        Log.d("Adapter", "Item " + command);

        double total = 0.0;
        for (Map.Entry<String, Integer> entry : command.getProductsRequested().entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            for (Product product : FakeServer.listOfProducts()) {
                if (product.getCode().equals(entry.getKey())) {
                    total += entry.getValue() * product.getPrixVente();
                    break;
                }
            }
        }
        cardTitle.commandAmount.setText("" + total);

    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    private List initData(List list) {
        return null;
    }
}
