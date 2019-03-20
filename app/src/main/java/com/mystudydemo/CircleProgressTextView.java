package com.mystudydemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mystudydemo.utils.DisplayUtil;

/**
 * 创建日期：2019/3/19 on 17:25
 * 描述:
 * 作者: lvzishen
 */
public class CircleProgressTextView extends View {
    private static final float RING_WIDTH = DisplayUtil.dp2px(20);
    private static final float RADIUS = DisplayUtil.dp2px(140);
    private static final int CIRCLE_COLOR = Color.parseColor("#303F9F");
    private static final int HIGHLIGHT_COLOR = Color.parseColor("#FF4081");

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //    Rect rect = new Rect();
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

    public CircleProgressTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint.setColor(CIRCLE_COLOR);
        paint.setTextSize(DisplayUtil.dp2px(100));
//        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Quicksand-Regular.ttf"));
        paint.getFontMetrics(fontMetrics);
        paint.setTextAlign(Paint.Align.CENTER);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制环
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(CIRCLE_COLOR);
        paint.setStrokeWidth(RING_WIDTH);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, RADIUS, paint);

        // 绘制进度条
        paint.setColor(HIGHLIGHT_COLOR);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS, -90, 200, false, paint);


//        // 绘制文字
        paint.setStyle(Paint.Style.FILL);
        float offset = (fontMetrics.ascent + fontMetrics.descent) / 2;
//        paint.getTextBounds("abcd", 0, "abcd".length(), rect);
//        float offset = (rect.top + rect.bottom) / 2;
        canvas.drawText("abcd", getWidth() / 2, getHeight() / 2 - offset, paint);

        // 绘制文字左对齐
//        paint.setTextAlign(Paint.Align.LEFT);
//        Rect rect = new Rect();
//        paint.getTextBounds("abcd", 0, "abcd".length(), rect);
//        canvas.drawText("abcd", 0 - rect.left, 300, paint);
    }
}
