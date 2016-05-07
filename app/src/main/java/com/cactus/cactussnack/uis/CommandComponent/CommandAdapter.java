package com.cactus.cactussnack.uis.CommandComponent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cactus.cactussnack.R;
import com.cactus.cactussnack.core.Product;
import com.cactus.cactussnack.uis.CommandActivity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class CommandAdapter extends RecyclerView.Adapter<CommandViewHolder> {

    Context mContext;
    List<Product> items;
    public static HashMap<String, Integer> commandRows = new HashMap<>();


    public CommandAdapter(Context context, List<Product> selectedItems) {
        mContext = context;
        Collections.reverse(selectedItems);
        items = selectedItems;
        Log.d(TAG, "In MainAdapter " + items.size());

    }

    private List intitData(List selectedItems) {
        return null;
    }

    @Override
    public CommandViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_command_row, viewGroup, false);
        CommandViewHolder pvh = new CommandViewHolder(mContext, v);
        Log.d("Adapter", "CommandViewHolder " + pvh);

        return pvh;
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @Override
    public void onBindViewHolder(final CommandViewHolder cardTitle, final int i) {
        // Setting font
//        UIUtils.setFont(UIUtils.Font.LIGHT, cardTitle.editInfo);
        final Product product = items.get(i);
//        commandRows.put(product.getCode(), 0);
        cardTitle.productLabel.setText("" + product.getIntitule());
        cardTitle.productUnitPrice.setText("" + product.getPrixVente());
        Log.d("Adapter", "Item " + product);

        cardTitle.quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")) {
                    int qty = Integer.parseInt(editable.toString());
                    double result = qty * Double.parseDouble(cardTitle.productUnitPrice.getText().toString());
                    commandRows.put(product.getCode(), qty);
                    Log.d("CommandRow", "Items :" + commandRows);
                    cardTitle.productQtyFactor.setText("x " + qty + " =");
                    cardTitle.productPrice.setText("" + result);
                    cardTitle.productQtyFactor.setVisibility(View.VISIBLE);
                    cardTitle.productPrice.setVisibility(View.VISIBLE);
                } else {
                    cardTitle.productQtyFactor.setVisibility(View.INVISIBLE);
                    commandRows.put(product.getCode(), 0);
                    cardTitle.productPrice.setVisibility(View.INVISIBLE);
                }
                CommandActivity.productTotal.setText(""+computeTotal());

            }
        });

    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    double computeTotal() {

        double total = 0.0;
        for (Map.Entry<String, Integer> entry : commandRows.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            for (Product product : items) {
                if (product.getCode().equals(entry.getKey())) {
                    total+= entry.getValue() * product.getPrixVente();
                    break;
                }
            }
        }
        return total;
    }

    private List initData(List list) {
        return null;
    }
}
