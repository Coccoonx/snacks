package com.cactus.cactussnack.uis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import com.cactus.cactussnack.R;
import com.cactus.cactussnack.core.Command;
import com.cactus.cactussnack.core.Product;
import com.cactus.cactussnack.core.Profile;
import com.cactus.cactussnack.server.FakeServer;
import com.cactus.cactussnack.uis.CommandComponent.AutoCompleteAdapter;
import com.cactus.cactussnack.uis.CommandComponent.CommandAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CommandActivity extends AppCompatActivity {

    private static final String TAG = "CommandActivity";
    AutoCompleteAdapter autoCompleteAdapter;
    //    TreeSet selectedOnes;
    HashMap<String, Integer> productsRequested = new HashMap();
    private RecyclerView mRecyclerView;
    private CommandAdapter mCommandAdapter;
    private AutoCompleteTextView mFinder;
    private ArrayList<Product> selectedProducts;
    public static TextView productTotal;
    Command newCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedProducts = new ArrayList();

//        selectedProducts.add("Mandarine");

//        selectedOnes.add("Citron");
//        selectedOnes.add("Camanberd");
//        selectedOnes.add("Orange");

        productTotal = (TextView) findViewById(R.id.total_price);
        // Get the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        // Set an adapter to this recycler view
        mCommandAdapter = new CommandAdapter(this, selectedProducts);
        mRecyclerView.setAdapter(mCommandAdapter);

        // Set the behaviour of this recycler view
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFinder = (AutoCompleteTextView) findViewById(R.id.command_requester);
        autoCompleteAdapter = new AutoCompleteAdapter(this, FakeServer.listOfProducts());
        mFinder.setAdapter(autoCompleteAdapter);

        mFinder.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                HashMap<String, String> item = (HashMap<String, String>) parent.getItemAtPosition(position);
                String myCode = item.get("code");
                Log.d(TAG, "Item : " + item);
                Log.d(TAG, "Item Code: " + myCode);
                for (Product product : FakeServer.listOfProducts()) {
                    if (product.getCode().equals(myCode)) {
                        selectedProducts.add(product);
                        Log.d(TAG, "Element added " + selectedProducts.size());
                        mCommandAdapter.notifyItemInserted(selectedProducts.size() - 1);
                        Toast.makeText(CommandActivity.this, product.getIntitule() + " added", Toast.LENGTH_SHORT).show();
                        mFinder.setText("");
                        break;
                    }
                }

            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.command, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cancel) {
            finish();
            return true;
        }

        if (id == R.id.action_command) {
            sendCommand();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendCommand() {
        if (CommandAdapter.commandRows != null && CommandAdapter.commandRows.size() > 0) {
            newCommand = new Command();
            newCommand.setClientName("Lyonnel :-)");
            newCommand.setClientPhone("673632095");
            newCommand.setDateCommand(new Date());
            newCommand.setProductsRequested(CommandAdapter.commandRows);
            CommandAdapter.commandRows = new HashMap<>();
            Toast.makeText(CommandActivity.this, "Command saved", Toast.LENGTH_SHORT).show();
            Profile.getCommandList().add(newCommand);
            finish();
        }else
            Toast.makeText(CommandActivity.this, "No Product in your command", Toast.LENGTH_SHORT).show();

    }
}
