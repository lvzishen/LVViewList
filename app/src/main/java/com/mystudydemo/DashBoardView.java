package com.mystudydemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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
public class DashBoardView extends View {
    private static final float RADIUS = DisplayUtil.dp2px(100);
    private static final float SPACING_LENGTH = DisplayUtil.dp2px(5);
    private static final float ALL_ANGLE = 270;//总长度
    private int mSpacing = 20;//间隔
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    /**
     * new DashBoardView会走此构造方法
     */
    public DashBoardView(Context context) {
        super(context);
    }

    /**
     * XML文件创建会走此构造方法
     */
    public DashBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(DisplayUtil.dp2px(2));
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画线 三点钟方向为默认0度
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS, 90 + 90 / 2, ALL_ANGLE, false, paint);
        // 画刻度
        float one = ALL_ANGLE / mSpacing; //一个刻度的角度
        //顺时针旋转画布
        drawSpacing(canvas, one, true);
        //逆时针旋转画布
        drawSpacing(canvas, one, false);
        // 画指针
        //三角函数对边sin,Y  坐标临边cos,X坐标
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawLine(0, 0,
                (float) Math.cos(Math.toRadians(getAngleFromMark(4))) * RADIUS / 2,
                (float) Math.sin(Math.toRadians(getAngleFromMark(4))) * RADIUS / 2,
                paint);
        canvas.restore();

    }

    private int getAngleFromMark(int mark) {
        return (int) (90 + 45 + ((float) ALL_ANGLE) / 20 * mark);
    }

    private void drawSpacing(Canvas canvas, float one, boolean isCW) {
        canvas.save();
        if (!isCW) {
            one = -one;
        }
        for (int i = 0; i <= mSpacing / 2; i++) {
            if (i == mSpacing / 2) {
                //最后一个位置起始点需要往左或往右移动画笔宽度的一般，否则会刻度会多出画笔一般的宽度
                if (!isCW) {
                    canvas.drawLine(getWidth() / 2 + DisplayUtil.dp2px(2) / 2, getHeight() / 2 - RADIUS, getWidth() / 2 + DisplayUtil.dp2px(2) / 2, getHeight() / 2 - RADIUS + SPACING_LENGTH, paint);
                } else {
                    canvas.drawLine(getWidth() / 2 - DisplayUtil.dp2px(2) / 2, getHeight() / 2 - RADIUS, getWidth() / 2 - DisplayUtil.dp2px(2) / 2, getHeight() / 2 - RADIUS + SPACING_LENGTH, paint);
                }
            } else {
                canvas.drawLine(getWidth() / 2, getHeight() / 2 - RADIUS, getWidth() / 2, getHeight() / 2 - RADIUS + SPACING_LENGTH, paint);
            }
            canvas.rotate(one, getWidth() / 2, getHeight() / 2);
        }
        canvas.restore();
    }
}
