package demo.com.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyStartService extends Service {

    public void showToast() {
        Toast.makeText(this, "调用服务器service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        Log.e("service:", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service:", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("service:", "onBind");

        return new LocalBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("service:", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service:", "onDestroy");
    }

    public class LocalBinder extends Binder {
        public MyStartService getService() {
            return MyStartService.this;
        }

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e("service:", "onRebind");
    }
}
