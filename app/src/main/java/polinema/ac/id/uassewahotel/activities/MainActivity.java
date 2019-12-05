package polinema.ac.id.uassewahotel.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import polinema.ac.id.uassewahotel.R;
import polinema.ac.id.uassewahotel.fragment.AccountFragment;
import polinema.ac.id.uassewahotel.fragment.ExploreFragment;
import polinema.ac.id.uassewahotel.fragment.MyBookingsFragment;
import polinema.ac.id.uassewahotel.fragment.TalktoUsFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new ExploreFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_explore:
                fragment = new ExploreFragment();
                break;
            case R.id.action_boking:
                fragment = new MyBookingsFragment();
                break;
            case R.id.action_chat:
                fragment = new TalktoUsFragment();
                break;
            case R.id.action_account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

}
