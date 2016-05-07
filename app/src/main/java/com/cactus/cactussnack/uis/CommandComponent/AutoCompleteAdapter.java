package com.cactus.cactussnack.uis.CommandComponent;

import android.content.Context;
import com.cactus.cactussnack.R;
import com.cactus.cactussnack.core.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AutoCompleteAdapter extends android.widget.SimpleAdapter {

    static ArrayList<Map<String, String>> toMapList(Collection<Product> objectsCollection) {
        ArrayList<Map<String, String>> objectsList = new ArrayList<>(objectsCollection.size());
        for (Product obj : objectsCollection) {
            Map<String, String> map = new HashMap<>();
            map.put("code", obj.getCode());
            map.put("intitule", obj.getIntitule());
            objectsList.add(map);
        };
        return objectsList;
    }

    public AutoCompleteAdapter(Context context, Collection<Product> objects) {
        super(context,
                toMapList(objects),
                R.layout.custom_auto_complete_layout, new String[] {"code", "intitule"}, new int[] {R.id.code, R.id.label});
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }
}