package com.test.broadcastbesttest;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(final Context context, Intent intent)
	{
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("Warning");
		dialogBuilder.setMessage("���ѱ�ǿ�����ߣ������µ�¼");
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("OK", new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				 ActivityCollector.finishAll();  //�������л
				 Intent intent = new Intent(context, LoginActivity.class);
				 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				 context.startActivity(intent);  //��������LoginActivity
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
		
	}

}
