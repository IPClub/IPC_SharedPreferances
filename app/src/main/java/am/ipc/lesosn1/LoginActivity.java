package am.ipc.lesosn1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;


public class LoginActivity extends AppCompatActivity {
    EditText login;
    EditText pass;
    CheckBox rem_ch;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.i().changeLanguage(App.i().getLanguage());
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.pass);
        error = (TextView) findViewById(R.id.error);
        rem_ch = (CheckBox) findViewById(R.id.rem_ch);
        if (App.i().isRememeber()) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        }
    }

    public void login(View view) {
        if ((App.i().getLogin().equals(login.getText().toString()) &&
                App.i().getPassword().equals(pass.getText().toString()))) {
            App.i().saveRemember(rem_ch.isChecked());
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
            finish();
        } else {
            error.setText(R.string.error);
        }
    }

    public void register(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
