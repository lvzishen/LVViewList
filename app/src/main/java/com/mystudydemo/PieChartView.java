package com.mystudydemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mystudydemo.utils.DisplayUtil;

/**
 * 创建日期：2019/3/16 on 11:51
 * 描述:仪表盘View
 * 作者: lvzishen
 */
public class PieChartView extends View {
    private static final int RADIUS = (int) DisplayUtil.dp2px(100);
    private static final int LENGTH = (int) DisplayUtil.dp2px(20);
    private static final int PULLED_OUT_INDEX = 2;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds;
    int[] angles = {70, 110, 35, 145};
    int[] colors = {Color.parseColor("#2979FF"), Color.parseColor("#C2185B"),
            Color.parseColor("#009688"), Color.parseColor("#FF8F00")};

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bounds == null) {
            bounds = new RectF();
            bounds.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
        }
        int currentAngle = 0;
        for (int i = 0; i < angles.length; i++) {
            paint.setColor(colors[i]);
            if (i == 1) {
                canvas.drawArc(bounds, currentAngle, angles[i], true, paint);
            } else {
                canvas.drawArc(bounds, currentAngle, angles[i], true, paint);
            }
            currentAngle += angles[i];
        }

    }

}
