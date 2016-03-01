package licenta.socializer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import licenta.socializer.R;

/**
 * Created by Madalina on 01.03.2016.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.login_container, new LoginFragment())
                    .commit();
        }
    }
}