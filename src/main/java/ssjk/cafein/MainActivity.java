package ssjk.cafein;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener{

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyExpandableListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;
    private long lastTimeBackPressed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize(getApplicationContext());

        Button btn_toCoffee = (Button) findViewById(R.id. btn_toCoffee);
        Button btn_7gram = (Button) findViewById(R.id. btn_7gram);
        Button btn_CafeHoney = (Button) findViewById(R.id. btn_CafeHoney);
        Button btn_Soleil = (Button) findViewById(R.id. btn_Soleil);
        Button btn_LazyGeek = (Button) findViewById(R.id. btn_LazyGeek);
        Button btn_Hippo = (Button) findViewById(R.id. btn_Hippo);
        Button btn_CafeDan = (Button) findViewById(R.id. btn_CafeDan);
        Button btn_Agit = (Button) findViewById(R.id. btn_Agit);
        Button btn_Trianon = (Button) findViewById(R.id. btn_Trianon);
        Button btn_Creative = (Button) findViewById(R.id. btn_Creative);
        Button btn_TakeBean = (Button) findViewById(R.id. btn_TakeBean);
        Button btn_Hollys = (Button) findViewById(R.id. btn_Hollys);
        Button btn_Rehoboth = (Button) findViewById(R.id. btn_Rehoboth);
        Button btn_Botong = (Button) findViewById(R.id. btn_Botong);
        Button btn_BongJuice = (Button) findViewById(R.id. btn_BongJuice);
        Button btn_WafflePan = (Button) findViewById(R.id. btn_WafflePan);
        Button btn_Juicy = (Button) findViewById(R.id. btn_Juicy);
        Button btn_CafeLondon = (Button) findViewById(R.id. btn_CafeLondon);
        Button btn_TomNToms = (Button) findViewById(R.id. btn_TomNToms);
        Button btn_search = (Button) findViewById(R.id. btn_search);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent;
                int buttonid = v.getId();
                if (buttonid == R.id. btn_toCoffee){
                    intent = new Intent(MainActivity.this, CoffeeActivity.class);
                    startActivity(intent);
                }
                else if (buttonid > 0){
                    intent = new Intent(MainActivity.this, DataBaseOpenHelper.class);
                    switch (buttonid){
                        case R.id. btn_7gram:
                            intent.putExtra("CafeName","7gram");
                            break;
                        case R.id. btn_CafeHoney:
                            intent.putExtra("CafeName","CAFE HONEY");
                            break;
                        case R.id. btn_Soleil:
                            intent.putExtra("CafeName","Soleil");
                            break;
                        case R.id. btn_LazyGeek:
                            intent.putExtra("CafeName","LAZY GEEK");
                            break;
                        case R.id. btn_Hippo:
                            intent.putExtra("CafeName","HIPPO");
                            break;
                        case R.id. btn_CafeDan:
                            intent.putExtra("CafeName","카페단");
                            break;
                        case R.id. btn_Agit:
                            intent.putExtra("CafeName","Agit");
                            break;
                        case R.id. btn_Trianon:
                            intent.putExtra("CafeName","TRIANON");
                            break;
                        /*case R.id. btn_Creative:
                            intent.putExtra("CafeName","CREATIVE");
                            break;
                        case R.id. btn_TakeBean:
                            intent.putExtra("CafeName","TAKEBEAN");
                            break;*/
                        case R.id. btn_Hollys:
                            intent.putExtra("CafeName","HOLLYS");
                            break;
                        case R.id. btn_Rehoboth:
                            intent.putExtra("CafeName","Rehoboth");
                            break;
                        case R.id. btn_Botong:
                            intent.putExtra("CafeName","보통카페");
                            break;
                        case R.id. btn_BongJuice:
                            intent.putExtra("CafeName","봉쥬스");
                            break;
                        case R.id. btn_WafflePan:
                            intent.putExtra("CafeName","Waffle Pan");
                            break;
                        case R.id. btn_Juicy:
                            intent.putExtra("CafeName","JUICY");
                            break;
                        case R.id. btn_CafeLondon:
                            intent.putExtra("CafeName","CAFE LONDON");
                            break;
                        case R.id. btn_TomNToms:
                            intent.putExtra("CafeName","TOM N TOMS");
                            break;
                    }
                    startActivity(intent);
                }

            }
        };

        btn_toCoffee.setOnClickListener(listener);
        btn_7gram.setOnClickListener(listener);
        btn_CafeHoney.setOnClickListener(listener);
        btn_Soleil.setOnClickListener(listener);
        btn_LazyGeek.setOnClickListener(listener);
        btn_Hippo.setOnClickListener(listener);
        btn_CafeDan.setOnClickListener(listener);
        btn_Agit.setOnClickListener(listener);
        btn_Trianon.setOnClickListener(listener);
        btn_Creative.setOnClickListener(listener);
        btn_TakeBean.setOnClickListener(listener);
        btn_Hollys.setOnClickListener(listener);
        btn_Rehoboth.setOnClickListener(listener);
        btn_Botong.setOnClickListener(listener);
        btn_BongJuice.setOnClickListener(listener);
        btn_WafflePan.setOnClickListener(listener);
        btn_LazyGeek.setOnClickListener(listener);
        btn_Juicy.setOnClickListener(listener);
        btn_CafeLondon.setOnClickListener(listener);
        btn_TomNToms.setOnClickListener(listener);
        btn_search.setOnClickListener(listener);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();

        displayList();

        expandAll();

    }

    private void loadData(){
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;

        childRows.add(new ChildRow(R.drawable.search, "Lorem ipsum dolor sit"));
        childRows.add(new ChildRow(R.drawable.search, "Sit Fido, sit"));
        parentRow = new ParentRow("First Group", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.drawable.search, "Fido is the name of my dog"));
        childRows.add(new ChildRow(R.drawable.search, "Add two plus two"));
        parentRow = new ParentRow("Second Group", childRows);
        parentList.add(parentRow);
    }

    private void expandAll(){
        int count= listAdapter.getGroupCount();
        for (int i = 0; i < count; i ++){
            myList.expandGroup(i);
        }
    }

    private void displayList(){
        loadData();
        myList = (ExpandableListView)findViewById(R.id.expandableListView_search);
        listAdapter = new MyExpandableListAdapter(MainActivity.this, parentList);

        myList.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo
                (searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();

        return true;
    }


    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-lastTimeBackPressed<1500){
            finish();
            return;
        }

        Toast.makeText(this,"'뒤로' 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();

        lastTimeBackPressed = System.currentTimeMillis();

    }
    public static final String PACKAGE_DIR = "/data/data/ssjk.cafein/";
    public static final String DATABASE_NAME = "cafe.sqlite";
    public static final String COPY2DATABASE_NAME = "cafesd1.db";
    public static void initialize(Context ctx) {
        // check
        File folder = new File(PACKAGE_DIR + "databases");
        folder.mkdirs();
        File outfile = new File(PACKAGE_DIR + "databases/" + COPY2DATABASE_NAME);

        if (outfile.length() <= 0) {
            AssetManager assetManager = ctx.getResources().getAssets();
            try {
                InputStream is = assetManager.open(DATABASE_NAME, AssetManager.ACCESS_BUFFER);
                long filesize = is.available();
                byte [] tempdata = new byte[(int)filesize];
                is.read(tempdata);
                is.close();
                if (outfile.exists()){
                    outfile.delete();
                    outfile.createNewFile();
                }
                FileOutputStream fo = new FileOutputStream(outfile);
                fo.write(tempdata);
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }
}
