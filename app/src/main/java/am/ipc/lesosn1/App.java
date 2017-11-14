package am.ipc.lesosn1;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by haykc on 11/14/2017.
 */

public class App extends Application {

    private static App instance;
    private SharedPreferences pref;
    public static final String PREF_NAME = "IPC";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    public static App i(){
        if(instance == null){
            instance = new App();
        }
        return instance;
    }

    public void saveLogin(String login){
        pref.edit().putString("login",login).commit();
    }

    public void savePassword(String pass){
        pref.edit().putString("pass",pass).commit();
    }
    public void saveAge(int age){
        pref.edit().putInt("age",age).commit();
    }
    public void saveRemember(boolean isRemember){
        pref.edit().putBoolean("remember",isRemember).commit();
    }
    public void saveLanguage(String lng){
        pref.edit().putString("lng",lng).commit();
    }

    public int getAge(){
        return pref.getInt("age",-1);
    }

    public String getLogin(){
        return pref.getString("login","");
    }

    public String getPassword(){
        return pref.getString("pass","");
    }
    public String getLanguage(){
        return pref.getString("lng","en");
    }
    public boolean isRememeber(){
        return pref.getBoolean("remember",false);
    }

    public void changeLanguage(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }
}
