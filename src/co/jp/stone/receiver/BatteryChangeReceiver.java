package co.jp.stone.receiver;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.TextView;

public class BatteryChangeReceiver extends BroadcastReceiver{

	Activity mActivity;
	
	public BatteryChangeReceiver(Activity activity){
	    this.mActivity = activity;	
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		// �c��
		TextView tvBatteryLevel = (TextView) mActivity.findViewById(R.id.BatteryLevel);
		int level =intent.getIntExtra("level", 0);
		int scale =intent.getIntExtra("scale", 0);
		tvBatteryLevel.setText(level + "/" + scale + "(%)");
		
		// �[�d���
		TextView tvBatteryCharge = (TextView) mActivity.findViewById(R.id.BatteryCharge);
        switch (intent.getIntExtra("status", 0)){
        case BatteryManager.BATTERY_STATUS_CHARGING://�[�d��
        	tvBatteryCharge.setText(context.getString(R.string.label_detect_charging));
        	break;
        case BatteryManager.BATTERY_STATUS_DISCHARGING://���d��
        case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
        	tvBatteryCharge.setText(context.getString(R.string.label_detect_discharging));
        	break;
        case BatteryManager.BATTERY_STATUS_FULL://���^��
        	tvBatteryCharge.setText(context.getString(R.string.label_detect_fullbattery));
        	break;
        case BatteryManager.BATTERY_STATUS_UNKNOWN://�s��
        	tvBatteryCharge.setText(context.getString(R.string.label_detect_status_unknown));
        	break;
�@�@�@�@�@�@�@}
        
	}
	

}
