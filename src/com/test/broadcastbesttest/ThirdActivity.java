package com.test.broadcastbesttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdviewspot);
        
        Button thirdNext = (Button)findViewById(R.id.third_next);
        thirdNext.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
    }
}
