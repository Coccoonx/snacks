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

import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;


public class CommandAdapter extends RecyclerView.Adapter<CommandViewHolder> {

    Context mContext;
    List items;


    public CommandAdapter(Context context, List selectedItems) {
        mContext = context;
        Collections.reverse(selectedItems);
        items = selectedItems;
        Log.d(TAG, "In CommandAdapter " + items.size());

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
        cardTitle.productLabel.setText("" + items.get(i));
        Log.d("Adapter", "Item " + items.get(i));

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
                    cardTitle.productQtyFactor.setText("x " + qty + " =");
                    cardTitle.productPrice.setText("" + result);
                    cardTitle.productQtyFactor.setVisibility(View.VISIBLE);
                    cardTitle.productPrice.setVisibility(View.VISIBLE);
                }else {
                    cardTitle.productQtyFactor.setVisibility(View.INVISIBLE);
                    cardTitle.productPrice.setVisibility(View.INVISIBLE);
                }
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

    private List initData(List list) {
        return null;
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
