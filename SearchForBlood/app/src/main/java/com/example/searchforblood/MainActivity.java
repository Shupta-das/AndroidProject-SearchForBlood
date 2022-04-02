package com.example.searchforblood;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
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
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,mNavDrawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mNavDrawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void onBackPressed() {
        if(mNavDrawer.isDrawerOpen(GravityCompat.START))
        {
            mNavDrawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser==null)
        {
            SendUserToLoginActivity();
        }
        else
        {
           // SendUserToRegisterActivity();
        }
    }

    private void SendUserToRegisterActivity() {
        Intent loginIntent=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(loginIntent);
    }

    private void SendUserToLoginActivity() {

        Intent loginIntent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);


    }
}
