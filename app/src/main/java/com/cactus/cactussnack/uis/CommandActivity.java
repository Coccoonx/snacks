package com.cactus.cactussnack.uis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.cactus.cactussnack.R;
import com.cactus.cactussnack.uis.CommandComponent.CommandAdapter;

import java.util.ArrayList;

public class CommandActivity extends AppCompatActivity {

    ArrayAdapter<String> autoCompleteAdapter;
    private RecyclerView mRecyclerView;
    private CommandAdapter mCommandAdapter;
    private AutoCompleteTextView mFinder;
    private ArrayList selectedProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedProducts = new ArrayList();

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
                    mCommandAdapter = new CommandAdapter(CommandActivity.this, selectedProducts);
                    mRecyclerView.setAdapter(mCommandAdapter);
//                    mCommandAdapter.notifyDataSetChanged();
                }
            }
        });


    }

}
