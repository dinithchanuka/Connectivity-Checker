package ase.dinith.connectivityChecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ase.dinith.connectivityChecker.components.BluetoothChecker;
import ase.dinith.connectivityChecker.components.NetworkChecker;

public class MainActivity extends AppCompatActivity {

    private NetworkChecker networkChecker;
    private BluetoothChecker bluetoothChecker;

    private TextView tvNetworkStatus,tvBluetoothStatus;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNetworkStatus = findViewById(R.id.text_view_network_status);
        tvBluetoothStatus = findViewById(R.id.text_view_bluetooth_status);

        btnCheck = findViewById(R.id.button_check);

        this.networkChecker = new NetworkChecker(this);
        this.bluetoothChecker = new BluetoothChecker();

        btnCheck.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                getNetworkStatus();
                getBluetoothStatus();
            }
        });

    }

    private void getNetworkStatus(){
        if(networkChecker.getNetworkStatus()){
            tvNetworkStatus.setText("Connected");
        }else{
            tvNetworkStatus.setText("Not Connected");
        }
    }

    private void getBluetoothStatus(){
        if(bluetoothChecker.getBluetoothStatus()){
            tvBluetoothStatus.setText("Device Paired");
        }else{
            tvBluetoothStatus.setText("Not Connected");
        }
    }
}