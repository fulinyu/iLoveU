package i.Love.U;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.text.format.*;
import java.util.*;
import java.text.*;
import android.text.*;
import android.graphics.*;

public class MainActivity extends Activity implements Runnable
{

	@Override
	public void run()
	{

		if (sum < 3)
		{
			
			currentTime.setToNow();
			year = currentTime.year - theTime.year;
			month = currentTime.month - theTime.month;
			day = currentTime.monthDay - theTime.monthDay;
			hour = currentTime.hour - theTime.hour;
			minute = currentTime.minute - theTime.minute;
			second = currentTime.second - theTime.second;

			if (second < 0)
			{
				minute--;
				second += 60;
			}
			if (minute < 0)
			{
				hour--;
				minute += 60;
			}
			if (hour < 0)
			{
				day--;
				hour += 24;
			}
			if (day < 0)
			{
				month--;
				day += monthDay[currentTime.month - 2];
			}
			if (month < 0)
			{
				year--;
				month += 12;
			}

			mTextView2.setText(Html.fromHtml("<font color=\"#ff0000\">" + year + "</font> years <font color=\"#ff0000\">" + month + "</font> months <font color=\"#ff0000\">" + day + "</font> days"));
			mTextView3.setText(Html.fromHtml("<font color=\"#ff0000\">" + hour + "</font> hours <font color=\"#ff0000\">" + minute + "</font> minutes <font color=\"#ff0000\">" + second + "</font> seconds"));

			mHandler.postDelayed(this, 100);
		}
		if(sum>1){
			if(!mMyView.mPath.isEmpty()){
			if(mMyView.a<2*Math.PI){


				
				mMyView.mPath.lineTo(mMyView.getXX(mMyView.a),mMyView.getYY(mMyView.a));
				mMyView.invalidate();
				mMyView.a+=0.02;
			if(!isDrawAll){
				if(sum>2)
				mHandler.postDelayed(this, 100);
			}
			}
		}
		}
		
	}

	MyView mMyView;
	TextView mTextView1,mTextView2,mTextView3;
	int sum=0,year,month,day,hour,minute,second;
	Toast mToast;
	Boolean isDrawAll=false;
	int[] monthDay={31,28,31,30,31,30,31,31,30,31,30,31};
	Time currentTime=new Time(),theTime=new Time();
	Handler mHandler=new Handler();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		theTime.set(0, 0, 20, 10, 0, 2010);
		mMyView = (MyView)findViewById(R.id.mMyView);
		mMyView.setVisibility(View.GONE);
		
		mToast=new Toast(this);
		mToast=Toast.makeText(this,"",1);
		mTextView1 = (TextView)findViewById(R.id.mTextView1);
		mTextView2 = (TextView)findViewById(R.id.mTextView2);
		mTextView3 = (TextView)findViewById(R.id.mTextView3);
    }

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				sum++;

				
}
		
		switch (sum)
		{
			case 1:
				mTextView1.setText("I have loved u for");
				
				mHandler.post(this);
				break;
			case 2:
				
				mMyView.setVisibility(View.VISIBLE);
				mMyView.mPath=new Path();
				mMyView.mPath.moveTo(mMyView.getXX(0),mMyView.getYY(0));
				
			
				break;
			case 3:
				
				int addMonth = (12 * year + month);
				int addDay = 0;
				for(int i=0;i<addMonth;i++){
			
						addDay+=monthDay[((11 + i) % 12)];
				}
					
				mTextView1.setText("");
				mTextView2.setTextSize(40);
				mTextView2.setText(Html.fromHtml("It's <font color=\"#ff0000\">"+addDay+"</font> days"));
				mTextView3.setText("");
				break;
			case 4:
				mTextView1.setText("I have made sure");
				mTextView2.setTextSize(30);
				mTextView2.setText("Love u ever and forever");
				mTextView3.setText("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b-flyu");
				
				break;
			case 5:
				this.finish();
				break;
		}
		
		return true;
	}

	@Override
	public void onBackPressed()
	{
		if(sum!=5){
			mToast.setText("还没看完，不许退出");
			mToast.show();
		}
		
	}






}
