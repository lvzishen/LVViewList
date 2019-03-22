package com.mystudydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mystudydemo.utils.DisplayUtil;

public class ImageTextView extends View {
    private static final float IMAGE_WIDTH = DisplayUtil.dp2px(120);
    private static final float IMAGE_Y = DisplayUtil.dp2px(50);
    private boolean isLeft = true;
    private boolean isInImage = false;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    String text = "This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text,This is text.";
    float[] cutWidth = new float[1];

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        bitmap = getAvatar((int) IMAGE_WIDTH);
        paint.setTextSize(DisplayUtil.dp2px(14));
        paint.getFontMetrics(fontMetrics);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, getWidth() / 2 - IMAGE_WIDTH / 2, IMAGE_Y, paint);
        int length = text.length();
        float verticalOffset = -fontMetrics.top;

        for (int start = 0; start < length; ) {
            int maxWidth;
            float textTop = verticalOffset + fontMetrics.top;
            float textBottom = verticalOffset + fontMetrics.bottom;
            //判断是否在图片区域内
            if (textTop > IMAGE_Y && textTop < IMAGE_Y + IMAGE_WIDTH
                    || textBottom > IMAGE_Y && textBottom < IMAGE_Y + IMAGE_WIDTH) {
                // 文字和图片在同一行,减去图片的宽度
                isInImage = true;
                maxWidth = (int) (getWidth() / 2 - IMAGE_WIDTH / 2);
            } else {
                isInImage = false;
                // 文字和图片不在同一行
                maxWidth = getWidth();
            }
            int count = paint.breakText(text, start, length, true, maxWidth, cutWidth);
            if (isInImage) {//如果是图片显示区域内
                if (isLeft) { //在图片左边
                    isLeft = false;
                    canvas.drawText(text, start, start + count, 0, verticalOffset, paint);
                } else { //在图片右边
                    isLeft = true;
                    canvas.drawText(text, start, start + count, getWidth() / 2 + IMAGE_WIDTH / 2, verticalOffset, paint);
                    verticalOffset += paint.getFontSpacing();  //再右边才换行
                }
            } else {
                canvas.drawText(text, start, start + count, 0, verticalOffset, paint);
                verticalOffset += paint.getFontSpacing(); //换行
            }
            start += count;
        }
    }

    Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_apk, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_apk, options);
    }
}