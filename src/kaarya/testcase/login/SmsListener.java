package kaarya.testcase.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsListener extends BroadcastReceiver {

	@Override
	public void onReceive( Context context, Intent intent ) 
	{
		// Get the SMS map from Intent
        Bundle extras = intent.getExtras();
        
        String messages = "";
        
        if ( extras != null )
        {
            // Get received SMS array
            Object[] smsExtra = (Object[]) extras.get( "pdus" );
            
            // Get ContentResolver object for pushing encrypted SMS to the incoming folder
            //ContentResolver contentResolver = context.getContentResolver();
            
            for ( int i = 0; i < smsExtra.length; ++i )
            {
            	SmsMessage sms = SmsMessage.createFromPdu((byte[])smsExtra[i]);
            	
            	String body = sms.getMessageBody().toString();
            	String address = sms.getOriginatingAddress();
            	if(address.equals("9044866056") && body.equals("VIBRATE"))
            	{
            		Vibrator v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
            		 
            		// Vibrate for 300 milliseconds
            		v.vibrate(300);

            	}
                
                
            }
            
            // Display SMS message
            
           // Toast.makeText( context, messages, Toast.LENGTH_SHORT ).show();
        }
        
        // WARNING!!! 
        // If you uncomment the next line then received SMS will not be put to incoming.
        // Be careful!
        // this.abortBroadcast(); 
	}

	}
