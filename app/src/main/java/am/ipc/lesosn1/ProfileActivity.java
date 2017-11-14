package am.ipc.lesosn1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    TextView login_tv;
    TextView pass_tv;
    TextView age_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        login_tv = (TextView) findViewById(R.id.login_tv);
        pass_tv = (TextView) findViewById(R.id.pass_tv);
        age_tv = (TextView) findViewById(R.id.age_tv);
        login_tv.setText(App.i().getLogin());
        pass_tv.setText(App.i().getPassword());
        age_tv.setText(""+App.i().getAge());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.settings,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.settings:
                i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;
            case  R.id.log_out:
                App.i().saveRemember(false);
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
