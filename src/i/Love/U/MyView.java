package i.Love.U;
import android.view.*;
import android.graphics.*;
import android.content.*;
import android.util.*;
import android.os.*;
import android.widget.*;

public class MyView extends View 
{

	

	public MyView(Context c, AttributeSet as)
	{
		super(c, as);
		
		mPaint = new Paint();
		mPath = new Path();
		
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth((float)(3));
		LinearGradient linearGradient = new LinearGradient((float)(false ? 1 : 0), (float)(false ? 1 : 0), (float)(100), (float)(100), new int[]{-16711936, -65536, -16776961, -256}, (float[])(null), Shader.TileMode.MIRROR);
		mPaint.setShader((Shader)(linearGradient));
		

	}
	
	Path mPath;
	Paint mPaint;
	double a=0;
	

   float getXX(double d)
	{
        return (float)(((double)((this.getWidth() / 2)) + ((double)(16) * 19.5 * Math.pow((double)(Math.sin((double)(d))), (double)(3)) * (double)(this.getHeight())) / (double)(578.47)));
    }

    float getYY(double d)
	{
        return (float)(((double)((this.getHeight() / 2)) + ((-50.76 - (double)(20) * ((double)(13) * Math.cos((double)(d)) - (double)(5) * Math.cos((double)((d * (double)(2)))) - (double)(2) * Math.cos((double)((d * (double)(3)))) - Math.cos((double)((d * (double)(4)))))) * (double)(this.getHeight())) / (double)(578.47)));
    }

    @Override
    public void onDraw(Canvas canvas)
	{
        
      canvas.drawPath(mPath,mPaint);
	 
		super.onDraw(canvas);

        
    }

}
