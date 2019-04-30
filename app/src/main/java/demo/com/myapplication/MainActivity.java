package demo.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.com.myapplication.ipc.IpcTest1Activity;
import demo.com.myapplication.service.MainServiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoIPC(View view) {
        Intent intent = new Intent(this, IpcTest1Activity.class);
        startActivity(intent);

    }

    public void gotoService(View view) {

        Intent intent = new Intent(this, MainServiceActivity.class);
        startActivity(intent);
    }
}
