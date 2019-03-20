package com.mystudydemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mystudydemo.utils.DisplayUtil;

/**
 * 创建日期：2019/3/19 on 16:29
 * 描述:
 * 作者: lvzishen
 */
public class XfermodeView extends View {
    private static final float RADIUS = DisplayUtil.dp2px(100);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF savedArea = new RectF();
    Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    Bitmap bitmap;

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        savedArea.set(RADIUS, RADIUS, RADIUS * 2, RADIUS * 2);
        bitmap = getBitmap((int) RADIUS * 2);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#3F51B5"));
        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);//保存状态 开启离屏缓冲
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, RADIUS, paint);//DST
        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmap, getWidth() / 2, getHeight() / 2, paint);//SRC
        paint.setXfermode(null);
        canvas.restoreToCount(saved);
    }

    Bitmap getBitmap(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_apk, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_apk, options);
    }
}
