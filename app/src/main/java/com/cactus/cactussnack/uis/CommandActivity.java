package com.cactus.cactussnack.uis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import com.cactus.cactussnack.R;
import com.cactus.cactussnack.uis.CommandComponent.CommandAdapter;

import java.util.ArrayList;
import java.util.TreeSet;

public class CommandActivity extends AppCompatActivity {

    private static final String TAG = "CommandActivity";
    ArrayAdapter<String> autoCompleteAdapter;
    private RecyclerView mRecyclerView;
    private CommandAdapter mCommandAdapter;
    private AutoCompleteTextView mFinder;
    private ArrayList selectedProducts;
//    TreeSet selectedOnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedProducts = new ArrayList();
        selectedProducts.add("Citon");
        selectedProducts.add("Carotte");
        selectedProducts.add("Mandarine");
//
//        selectedOnes.add("Citron");
//        selectedOnes.add("Camanberd");
//        selectedOnes.add("Orange");

        // Get the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        // Set an adapter to this recycler view
        mCommandAdapter = new CommandAdapter(this, selectedProducts);
        mRecyclerView.setAdapter(mCommandAdapter);

        // Set the behaviour of this recycler view
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] products = {"Coca", "Fanta", "Grenadine"};


        mFinder = (AutoCompleteTextView) findViewById(R.id.command_requester);
        autoCompleteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        mFinder.setAdapter(autoCompleteAdapter);

        mFinder.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                Object item = parent.getItemAtPosition(position);
                if (item instanceof String) {
                    selectedProducts.add(item);
                    Log.d(TAG, "Element added "+ selectedProducts.size());
                    mCommandAdapter.notifyItemInserted(selectedProducts.size()-1);
                    Toast.makeText(CommandActivity.this, item + " added", Toast.LENGTH_SHORT).show();
                    mFinder.setText("");
                }
            }
        });


    }

}
