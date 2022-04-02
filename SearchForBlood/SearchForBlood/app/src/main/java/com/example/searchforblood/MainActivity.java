package com.example.searchforblood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mNavDrawer;

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);

        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();

        Toolbar toolbar=findViewById(R.id.toolBarId);
        setSupportActionBar(toolbar);

        mNavDrawer=findViewById(R.id.drawer_layoutId);

        NavigationView navigationView = findViewById(R.id.navigationViewId);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,mNavDrawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mNavDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onBackPressed() {
        if(mNavDrawer.isDrawerOpen(GravityCompat.START))
        {
            mNavDrawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();

    }
    /*protected void onStart() {
        super.onStart();
        if(currentUser==null)
        {
            SendUserToLoginActivity();
        }
        else
        {
           // SendUserToRegisterActivity();
        }
    }*/

    private void SendUserToSaveDataActivity() {
        Intent loginIntent=new Intent(MainActivity.this,SaveDataActivity.class);
        startActivity(loginIntent);
    }
    private void SendUserToLoginActivity() {
        Intent loginIntent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.searchId:
            {
                Intent intent=new Intent(this,SearchBloodActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.warningId:
            {
                Intent intent=new Intent(this,WarningJsonActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.profileInfoId:
            {
                Intent intent=new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.logOutId:
            {
                mAuth.signOut();
                SendUserToLoginActivity();
                break;
            }
            case R.id.updateId:
            {
                SendUserToSaveDataActivity();
                break;
            }

        }
        mNavDrawer.closeDrawer(GravityCompat.START);

        return true;
    }

}
