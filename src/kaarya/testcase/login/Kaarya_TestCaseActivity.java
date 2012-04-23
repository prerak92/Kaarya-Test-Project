package kaarya.testcase.login;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Kaarya_TestCaseActivity extends Activity {
    /** Called when the activity is first created. */
	EditText pin;
	TextView err_msg;
	Button submit;
	//View v;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pin = (EditText)findViewById(R.id.editText2);
        submit = (Button)findViewById(R.id.button1);
        err_msg = (TextView)findViewById(R.id.login_error);
        submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					//err_msg.setText("trying");
					ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
					postParameters.add(new BasicNameValuePair("pin", pin.getText().toString()));
					if(pin.getText().toString().length()==4){
					//Toast.makeText(getApplicationContext(), "Block", Toast.LENGTH_SHORT).show();
					String res = CustomHttpClient.executeHttpPost("http://asa.kaar-ma.com:8080/test/auth",postParameters);
					//Toast.makeText(getApplicationContext(),"after request", Toast.LENGTH_SHORT).show();
					if(Html.fromHtml(res).toString().trim().equals("Welcome"))
					{
						String main_str=CustomHttpClient.executeHttpGet("http://asa.kaar-ma.com:8080/test/peers");
						//Toast.makeText(getApplicationContext(), main_str, Toast.LENGTH_SHORT).show();
						JSONObject myjson = new JSONObject(main_str);
						JSONArray jsonMainArr = myjson.getJSONArray("peers");
						String str[]=new String[jsonMainArr.length()];
						for (int i = 0; i < jsonMainArr.length(); i++) {  // **line 2**
						     JSONObject peerJSONObject = jsonMainArr.getJSONObject(i);
						     String name = peerJSONObject.getString("NAME");
						     int id    = peerJSONObject.getInt("ID");
						     str[i] = id+" - "+name;
						     
						}
						Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_SHORT).show();
						Bundle b=new Bundle();
						b.putStringArray("0", str);
						Intent intent = new Intent(v.getContext(),List_View.class);
						intent.putExtras(b);
						startActivity(intent);
					}
					else {
						
						//Intent intent = new Intent(v.getContext(),List_View.class);
						//startActivityForResult(intent,0);
						Toast.makeText(getApplicationContext(), "Wrong PIN", Toast.LENGTH_SHORT).show();
					}
					}
					else
					{
						Toast.makeText(getApplicationContext(), "Wrong PIN", Toast.LENGTH_SHORT).show();
					}
					//else err_msg.setText(Html.fromHtml(res).toString());
				}
				catch (Exception e) {  
					  
					err_msg.setText(e.toString());  
					}
				
			}
		});
    }
}