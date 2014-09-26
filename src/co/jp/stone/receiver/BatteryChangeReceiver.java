package co.jp.stone.receiver;


import java.io.IOException;

import co.jp.sample.R;
import co.jp.stone.service.BootupService;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.TextView;

public class BatteryChangeReceiver extends BroadcastReceiver{

	Activity mActivity;
	
	public BatteryChangeReceiver(Activity activity){
	    this.mActivity = activity;	
	}
	@Override
	public void onReceive(Context context, Intent arg1) {
		
		Intent intent = new Intent(context, BootupService.class);
		intent.putExtra("level", arg1.getIntExtra("level", 0));
        context.startService(intent);
		
		// �[�d���
//		TextView tvBatteryCharge = (TextView) mActivity.findViewById(R.id.BatteryCharge);
//        switch (intent.getIntExtra("status", 0)){
//        case BatteryManager.BATTERY_STATUS_CHARGING://�[�d��
//        	tvBatteryCharge.setText(context.getString(R.string.label_detect_charging));
//        	break;
//        case BatteryManager.BATTERY_STATUS_DISCHARGING://���d��
//        case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
//        	tvBatteryCharge.setText(context.getString(R.string.label_detect_discharging));
//        	break;
//        case BatteryManager.BATTERY_STATUS_FULL://���^��
//        	tvBatteryCharge.setText(context.getString(R.string.label_detect_fullbattery));
//        	break;
//        case BatteryManager.BATTERY_STATUS_UNKNOWN://�s��
//            Log.d("BatteryChange",context.getString(R.string.label_detect_status_unknown));
//            break;
//        }
	}
}	

