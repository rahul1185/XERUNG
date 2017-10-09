package com.example.contactplusgroup.utils;

import com.mityung.contactdirectory.R;
import com.example.contactplusgroup.views.BadgeDrawable;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.Display;
import android.view.WindowManager;

public class Utils {
	
	
	/**
	 * Convert Dp to Pixel
	 * 将dp转换为pixel
	 */
	public static int dpToPx(float dp, Resources resources){
		float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
		return (int) px;
	}
	
	/**
	 * @param value
	 * @return 将dip或者dp转为float
	 */
	public static float dipOrDpToFloat(String value) {
		if (value.indexOf("dp") != -1) {
			value = value.replace("dp", "");
		}
		else {
			value = value.replace("dip", "");
		}
		return Float.parseFloat(value);
	}
	
	
	/**
	 * 这里看似是得到控件相对的坐标，但是如果这个滑动条在可以上下滚动的布局中就会出现问题。
	 * 因为这里的坐标都是死的，在上下滚动的view中父控件的top仍旧不变，但实际上是应该获得动态数值的。
	 * @param myView
	 * @return
	 */
	public static int getRelativeTop(View myView) {
		Rect bounds = new Rect();
		myView.getGlobalVisibleRect(bounds);
		return bounds.top;
	}
	
	public static int getRelativeLeft(View myView) {
//	    if (myView.getParent() == myView.getRootView())
		if(myView.getId() == android.R.id.content)
			return myView.getLeft();
		else
			return myView.getLeft() + getRelativeLeft((View) myView.getParent());
	}
	
	private static int screenWidth = 0;

    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }

	
}
