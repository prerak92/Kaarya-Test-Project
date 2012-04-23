package kaarya.testcase.login;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
public class List_View extends ListActivity {

	/** Called when the activity is first created. */
		
	//static final String[] Names = {"hy","jh"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Bundle b=this.getIntent().getExtras();
	    String[] Names = b.getStringArray("0");
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, Names));

	    ListView lv = getListView();
	    lv.setTextFilterEnabled(true);

	    lv.setOnItemClickListener(new OnItemClickListener() {
	      public void onItemClick(AdapterView<?> parent, View view,
	          int position, long id) {
	        // When clicked, show a toast with the TextView text
	        Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	            Toast.LENGTH_SHORT).show();
	      }
	    });

	    // TODO Auto-generated method stub
	}

}
