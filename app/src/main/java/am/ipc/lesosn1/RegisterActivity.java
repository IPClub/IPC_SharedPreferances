package am.ipc.lesosn1;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {

    EditText login;
    EditText pass;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.pass);
        age = (EditText) findViewById(R.id.age);
    }


    public void register(View view) {
        App.i().saveLogin(login.getText().toString());
        App.i().savePassword(pass.getText().toString());
        App.i().saveAge(Integer.parseInt(age.getText().toString()));
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);

    }
}
