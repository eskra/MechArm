package com.example.eskra.mecharmcontrol;

import android.content.*;
import android.bluetooth.*;
import android.util.*;

/**
 * Created by Eskra on 15-03-24.
 */
public class DiscoveryActivity {

    /* Register Receiver*/
    IntentFilter discoveryFilter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
    //registerReceiver(_discoveryReceiver, discoveryFilter);
    IntentFilter foundFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
    //registerReceiver(_foundReceiver, foundFilter);

    /**
     * Receiver
     * When the discovery finished be called.
     */
    //private BroadcastReceiver _foundReceiver = new BroadcastReceiver() {
    //    public void onReceive(Context context, Intent intent) {
      /* get the search results */
      //      BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
      /* add to list */
      //      _devices.add(device);
      /* show the devices list */
      //      showDevices();
      //  }
    //};
    /*private BroadcastReceiver _discoveryReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent)
        {
      /* unRegister Receiver */
      /*      Log.d("EF-BTBee", ">>unregisterReceiver");
            unregisterReceiver(_foundReceiver);
            unregisterReceiver(this);
            _discoveryFinished = true;
        }
    };*/




}
