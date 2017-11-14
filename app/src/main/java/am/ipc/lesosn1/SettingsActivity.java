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
import android.widget.RadioButton;

import java.util.Locale;


public class SettingsActivity extends AppCompatActivity {

    RadioButton arm;
    RadioButton rus;
    RadioButton eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        arm = (RadioButton) findViewById(R.id.arm);
        rus = (RadioButton) findViewById(R.id.rus);
        eng = (RadioButton) findViewById(R.id.eng);

        String lng = App.i().getLanguage();
        switch (lng){
            case "hy":
                arm.setChecked(true);
                break;
            case "ru":
                rus.setChecked(true);
                break;
            case "en":
                eng.setChecked(true);
                break;
        }
    }

    public void save(View view) {
        if(arm.isChecked()){
            App.i().saveLanguage("hy");
            changeLanguage("hy");
        }else{
            if(rus.isChecked()){
                App.i().saveLanguage("ru");
                changeLanguage("ru");
            }else{
                App.i().saveLanguage("en");
                changeLanguage("en");
            }
        }
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

    private void changeLanguage(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }
}
