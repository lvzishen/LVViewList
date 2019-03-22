package com.mystudydemo;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mystudydemo.utils.DisplayUtil;

/**
 * 创建日期：2019/3/21 on 18:05
 * 描述:Camera使用Demo
 * 作者: lvzishen
 */
public class CameraView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Camera camera = new Camera();

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        camera.rotateX(45);
        camera.setLocation(0, 0, DisplayUtil.getZForCamera()); // -8 = -8 * 72  进行拉伸的时候需要根据DP做适配 设置放缩点
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制上半部分
        canvas.save();
        canvas.translate(100 + 200 / 2, 100 + 200 / 2);
        canvas.rotate(-20);
        canvas.clipRect(- 200, - 200, 200, 0);
        canvas.rotate(20);
        canvas.translate(- (100 + 200 / 2), - (100 + 200 / 2));
        canvas.drawBitmap(DisplayUtil.getAvatar(getResources(), 200), 100, 100, paint);
        canvas.restore();

        // 绘制下半部分
        //用到camera画布的操作都需要反着来,camera原点为坐标系原点且不能移动
        canvas.save();
        canvas.translate(100 + 200 / 2, 100 + 200 / 2);
        canvas.rotate(-20);

        camera.applyToCanvas(canvas);

        canvas.clipRect(-200, 0, 200, 200);
        canvas.rotate(20);
        canvas.translate(-(100 + 200 / 2), -(100 + 200 / 2));

        canvas.drawBitmap(DisplayUtil.getAvatar(getResources(), 200), 100, 100, paint);
        canvas.restore();
    }
}