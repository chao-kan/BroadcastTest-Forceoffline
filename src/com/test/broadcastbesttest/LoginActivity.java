package com.test.broadcastbesttest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity
{
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	
	private EditText accountEdit;
	private EditText passwordEdit;
	private Button loginButton;
	
	private CheckBox rememberPassword;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        pref = PreferenceManager.getDefaultSharedPreferences(this);     //得到SharePreference对象
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.login);
        rememberPassword = (CheckBox)findViewById(R.id.remember_password);       
        
        boolean isRemember = pref.getBoolean("remember_password", false);
        if(isRemember)
        {
        	String account = pref.getString("account", "");
        	String password = pref.getString("password", "");
        	
        	accountEdit.setText(account);
        	passwordEdit.setText(password);
        	rememberPassword.setChecked(true);
        }
        
        loginButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String account = accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();
				
				if(account.equals("ken") && password.equals("123456"))
				{
					
    				editor = pref.edit();
					if(rememberPassword.isChecked())
					{
						editor.putBoolean("remember_password", true);
						editor.putString("account", account);
						editor.putString("password", password);
					}
					else
					{
						editor.clear();
					}
					editor.commit();
					
					Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
					startActivity(intent);
					finish();
				}
				else
				{
					Toast.makeText(LoginActivity.this,"用户名或密码错误", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
}
