package com.example.jgeestman.firstactivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button MineOreButton, ChopWoodButton, DigSandButton, BuildButton;
    private int Ore, Wood, Sand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MineOreButton = (Button) findViewById(R.id.MineOreButton);
        ChopWoodButton = (Button) findViewById(R.id.ChopWoodButton);
        DigSandButton = (Button) findViewById(R.id.DigSandButton);
        BuildButton = (Button) findViewById(R.id.BuildButton);

        BuildButton.setVisibility(View.INVISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onMineOreClick(View view) {

        Ore++;
        ((TextView) findViewById(R.id.OreGathered)).setText("Ore: " + Ore + "/5");

        checkAllResources();

    }

    public void onChopWoodClick(View view) {

        Wood++;
        ((TextView) findViewById(R.id.WoodGathered)).setText("Wood: " + Wood + "/5");

        checkAllResources();

    }

    public void onDigSandClick(View view) {

        Sand++;
        ((TextView) findViewById(R.id.SandGathered)).setText("Sand: " + Sand + "/5");
        checkAllResources();

    }

    private void checkAllResources() {

        if ((Wood >= 5) && (Ore >= 5) && (Sand >= 5)){
            Toast.makeText(this, "You can build the building!", Toast.LENGTH_SHORT).show();
            ((Button)findViewById(R.id.BuildButton)).setVisibility(View.VISIBLE);
        }
    }

    private void updateResources() {

    }

    public void onBuildClick(View view) {
        final View l = findViewById(R.id.Layout);
        ((TextView)findViewById(R.id.BuildButton)).setText("You built the building");
        l.setBackgroundColor(Color.GREEN);
    }
}
