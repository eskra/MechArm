package com.example.eskra.mecharmcontrol;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.*;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private BluetoothAdapter _bluetooth = BluetoothAdapter.getDefaultAdapter();

    private static final int REQUEST_ENABLE = 0x1;

    private static final int REQUEST_DISCOVERABLE = 0x2;

    //add extra discoverable time
    private static final int DISCOVERABLE_DURATION = 300;

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                //Device found
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                //IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                //this.registerReceiver(broadcastReceiver, filter);

            }
            else if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {
                 //Device is now connected
            }
            else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                 //Done searching
            }
            /*else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) {
                 //Device is about to disconnect
            }
            else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {
                 //Device has disconnected
            }*/
        }
    };

    protected void discoverDevices(){
        if(_bluetooth.startDiscovery()) {
            Toast.makeText(getApplicationContext(), "Discovering other bluetooth devices, biatch.",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Discovery didn't start, stop breaking stuff.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //request to turn on bluetooth upon app startup
        Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enabler, REQUEST_ENABLE);

        //make bluetooth discoverable by other devices
        Intent discoverer = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverer.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, DISCOVERABLE_DURATION);
        startActivityForResult(discoverer, REQUEST_DISCOVERABLE);

        //register the found receiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, filter);

        System.out.print(mReceiver);
        //IntentFilter filter1 = new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
        //IntentFilter filter2 = new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
        //IntentFilter filter3 = new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        //this.registerReceiver(mReceiver, filter1);
        //this.registerReceiver(mReceiver, filter2);
        //this.registerReceiver(mReceiver, filter3);

    }

    //enable and disable methods of bluetooth
    //we need these so we can later securely
    // instantiate a bluetooth device by address

    /*public void OnEnable(View view){

        //Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        //startActivityForResult(enabler, REQUEST_ENABLE);

        _bluetooth.enable();

        /*Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(enabler, REQUEST_DISCOVERABLE);*/

    //}

    public void OnDisable(View view){

        _bluetooth.disable();

    }

    public boolean bluetoothIsEnabled(){

        return true;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //I made all the methods separate so it's easier to handle
    //this way, we know exactly which button was pressed, and don't have to distinguish
    //between ex: rotate cw being pressed or rotate ccw being pressed, it's already done


    public void rotate_cw(){

    }

    public void rotate_ccw(){

    }

    public void pivot_up(){

    }

    public void pivot_down(){

    }

    public void suction_on(){

    }

    public void suction_off(){

    }

    public void move_piston_up(){

    }

    public void move_piston_down(){

    }

    public void turn_motor_on(){

    }

    public void turn_motor_off(){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
