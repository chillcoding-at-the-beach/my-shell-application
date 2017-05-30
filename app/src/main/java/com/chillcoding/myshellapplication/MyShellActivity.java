package com.chillcoding.myshellapplication;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.content.FileProvider;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.chillcoding.myshellapplication.dialogs.MyLikeDialogFragment;
import com.chillcoding.myshellapplication.fragment.MyHomeFragment;
import com.chillcoding.myshellapplication.fragment.MyProjectFragment;
import com.chillcoding.myshellapplication.list.MyAndroidConfectioneryActivity;
import com.chillcoding.myshellapplication.map.MyMapsActivity;
import com.chillcoding.myshellapplication.network.MyNetworkActivity;
import com.chillcoding.myshellapplication.view.MyGameActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyShellActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = "MY SHELL ACTIVITY";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private MyHomeFragment mHomeFrag;
    private MyProjectFragment mProjectFrag;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private int mFragmentState;
    private DialogFragment mLikeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shell);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        mProjectFrag = new MyProjectFragment();
        mHomeFrag = new MyHomeFragment();

        mDrawer = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        mToggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mToggle.syncState();
        mLikeDialog = new MyLikeDialogFragment();

        NavigationView navigationView = (NavigationView) findViewById(R.id.my_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.my_profil_action);

        setFragment(R.id.my_profil_action);
    }

    private void seeSharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean value = prefs.getBoolean(
                getString(R.string.sound_key),
                false);

        Log.v(TAG, "SOUND : " + value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.like_action:
                mLikeDialog.show(getFragmentManager(), TAG);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setFragment(int fragid) {
        switch (fragid) {
            case R.id.my_profil_action:
                getFragmentManager().beginTransaction()
                        .replace(R.id.my_content, mHomeFrag)
                        .commit();
                break;
            case R.id.my_project_action:
                getFragmentManager().beginTransaction()
                        .replace(R.id.my_content, mProjectFrag)
                        .commit();
                break;
            default:
                getFragmentManager().beginTransaction()
                        .replace(R.id.my_content, mHomeFrag)
                        .commit();
                break;
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.my_setting_action)
            openAnActivity(MyPushActivity.class);
        else {
            mFragmentState = item.getItemId();
            setFragment(mFragmentState);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void openListActivity(View view) {
        openAnActivity(MyAndroidConfectioneryActivity.class);
    }

    private void openAnActivity(Class activityClass) {
        Intent intent = new Intent(MyShellActivity.this, activityClass);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }


    @Override
    public void onClick(View v) {
        Log.v(TAG, "on click");
    }

    public void openSettings(View view) {
        PackageManager pckgManager = getPackageManager();
        Intent settingsIntent = pckgManager.getLaunchIntentForPackage("com.android.settings");
        if (settingsIntent != null)
            startActivity(settingsIntent);
    }

    public void takePicture(View view) {
        Toast.makeText(this, "Take picture", Toast.LENGTH_SHORT).show();
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mHomeFrag.setImage(imageBitmap);
        }
    }

    public void openNetworkActivity(View view) {
        openAnActivity(MyNetworkActivity.class);
    }

    public void openCustomActivity(View view) {
        openAnActivity(MyGameActivity.class);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mDrawer.addDrawerListener(mToggle);

    }

    @Override
    protected void onStop() {
        super.onStop();
        mDrawer.removeDrawerListener(mToggle);
    }

    public void openPDF(View view) {

        Toast.makeText(this, "open a pdf", Toast.LENGTH_SHORT).show();

        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        Uri pathUri;
        File file;

        AssetManager ass = getAssets();
        InputStream in = null;
        OutputStream out = null;

        file = new File(getFilesDir(), "cvmacha.pdf");

        try {
            in = ass.open("cvmacha.pdf");
            out = openFileOutput(file.getName(), Context.MODE_APPEND);
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
            in = null;
            out = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        pathUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
        pdfIntent.setDataAndType(pathUri, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        if (pdfIntent.resolveActivity(getPackageManager()) != null)
            startActivity(pdfIntent);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MyShellApplication.FRAGMENT_STATE, mFragmentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mFragmentState = savedInstanceState.getInt(MyShellApplication.FRAGMENT_STATE, mFragmentState);
        setFragment(mFragmentState);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    public void openMapActivity(View view) {
        openAnActivity(MyMapsActivity.class);
    }

    public void goTo(View view) {
        mLikeDialog.show(getFragmentManager(), TAG);
    }
}

