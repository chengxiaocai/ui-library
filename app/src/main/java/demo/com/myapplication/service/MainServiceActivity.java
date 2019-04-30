package demo.com.myapplication.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.com.myapplication.R;

public class MainServiceActivity extends AppCompatActivity {
    private MyStartService.LocalBinder binder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyStartService.LocalBinder) service;
            binder.getService().showToast();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyStartService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyStartService.class);
        stopService(intent);
    }

    public void bindService(View view) {
        Intent intent = new Intent(this, MyStartService.class);
        bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
    }

    public void callService(View view) {
        binder.getService().showToast();
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(this, MyStartService.class);
        startService(intent);
    }

    public void unBindService(View view) {
        unbindService(serviceConnection);
    }
}
