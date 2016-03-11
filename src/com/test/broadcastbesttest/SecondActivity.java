package com.test.broadcastbesttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondviewspot);
        
        Button secondNext = (Button)findViewById(R.id.second_next);
        secondNext.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
    }
}
