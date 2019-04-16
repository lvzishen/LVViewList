package com.mystudydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mystudydemo.utils.DisplayUtil;

/**
 * 创建日期：2019/4/16 on 15:01
 * 描述:
 * 作者: lvzishen
 */
public class CircleView extends View {
    private static final int RADIUS = (int) DisplayUtil.dp2px(80);
    private static final int PADDING = (int) DisplayUtil.dp2px(30);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = (PADDING + RADIUS) * 2;
        int height = (PADDING + RADIUS) * 2;
        //主要针对wrap_content  AT_MOST做一个处理，否则wrap_content和match_parent效果相同
        width = resolveSizeAndState(width, widthMeasureSpec, 0);
        height = resolveSizeAndState(height, widthMeasureSpec, 0);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint);
    }
}
