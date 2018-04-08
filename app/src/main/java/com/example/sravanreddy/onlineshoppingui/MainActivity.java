package com.example.sravanreddy.onlineshoppingui;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private RecyclerView recyclerView;
    List<Products> productsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolBar);
        drawerLayout=findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        navigationView=findViewById(R.id.navigation_view);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        gaggeredGridLayoutManager=new StaggeredGridLayoutManager(2,1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
        populateList();
        MyAdapter myAdapter=new MyAdapter(productsList, MainActivity.this);
        recyclerView.setAdapter(myAdapter);
//        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_drawer,R.string.close_drawer);
//        drawerLayout.setDrawerListener(toggle);
//        toggle.syncState();
    }

    private void populateList() {
        productsList.add(new Products(R.drawable.shopping,"", ""));
        productsList.add(new Products(R.drawable.blazers,"Blazers", "view more >>"));
        productsList.add(new Products(R.drawable.shirts,"Shirts", "view more >>"));
        productsList.add(new Products(R.drawable.shoes,"Shoes", "view more >>"));
        productsList.add(new Products(R.drawable.tshirts,"T shirts", "view more >>"));
        productsList.add(new Products(R.drawable.suits,"Suits", "view more >>"));
        productsList.add(new Products(R.drawable.black,"View All Catogeries", "view more >>"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_id:
                Toast.makeText(this, "Cart clicked", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                //drawerLayout.openDrawer(GravityCompat.START);
                Toast.makeText(this, "Navigation clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
