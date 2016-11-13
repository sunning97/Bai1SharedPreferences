package cheng.com.bai1sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SHARED_PREFERENCES_NAME ="thangcoder";
    private final String MY_NAME ="my_name";
    private final String AGE ="age";
    private final String IS_SINGLE ="is_single";
    private final String WEIGHT = "weight";
    private Button btnSaveData;
    private Button btnReadData;
    private Button btnRemoveKey;
    private Button btnRemoveAll;
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaveData = (Button) findViewById(R.id.btn_save_date);
        btnReadData = (Button) findViewById(R.id.btn_read_data);
        btnRemoveKey = (Button) findViewById(R.id.btn_remove_key);
        btnRemoveAll = (Button) findViewById(R.id.btn_remove_all);
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
        btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });
        btnRemoveKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeByKey(MY_NAME);
                readData();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();

            }
        });


    }
    public void addData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_NAME,"Truong Dinh Chien");
        editor.putInt(AGE,25);
        editor.putBoolean(IS_SINGLE,false);
        editor.putLong(WEIGHT,60);

        editor.apply();
        Toast.makeText(MainActivity.this, "Save Successfully", Toast.LENGTH_SHORT).show();
        //editor.commit();

    }
    public void readData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(MY_NAME,"Cheng");
        int age = sharedPreferences.getInt(AGE,20);
        boolean isSingle = sharedPreferences.getBoolean(IS_SINGLE,false);
        long weight = sharedPreferences.getLong(WEIGHT,0);
        String address = sharedPreferences.getString("ADDRESS","Ho Chi Minh");

        Log.d(TAG, "Thangcoder: "
                +"Name: "+name +"\n"
                +"Age:" +age +"\n"
                +"Single: "+isSingle +"\n"
                + "Weight: "+weight +"\n"
                +"Address: "+address);
    }
    public void removeByKey(String key){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(key);
        editor.apply();
    }
    public void removeAll(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
