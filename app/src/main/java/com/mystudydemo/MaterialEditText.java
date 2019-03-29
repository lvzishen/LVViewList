package com.mystudydemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mystudydemo.utils.DisplayUtil;

/**
 * 创建日期：2019/3/29 on 11:52
 * 描述:
 * 作者: lvzishen
 */
public class MaterialEditText extends android.support.v7.widget.AppCompatEditText {
    private static final float TEXT_SIZE = DisplayUtil.dp2px(12);
    private static final float TEXT_BOTTOM_MARGIN = DisplayUtil.dp2px(2);

    private static final int TEXT_VERTICAL_OFFSET = (int) DisplayUtil.dp2px(10);//文字除文字高度多设置一些高度省的贴边
    private static final int TEXT_HORIZONTAL_OFFSET = (int) DisplayUtil.dp2px(1);//文字距左边距

    private static final int ANIMTIME = 300;//动画时间
    private ValueAnimator animShow;
    private int floatTextColor;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private float offset;
    private float currentVal;
    private boolean textIsShowing; //防止连续输入时造成动画不断重新加载
    private int finalTextOffset; //文字上移的最终位置

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs, context);
        init();
    }


    private void init() {
        initValueAnimator();
        paint.setColor(floatTextColor);
        paint.setTextSize(TEXT_SIZE);
        paint.getFontMetrics(fontMetrics);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(0);
        initValueAnimator();
        offset = -(fontMetrics.ascent + fontMetrics.descent);
        //设置间距 空出上方区域
        setPadding(getPaddingLeft(), (int) (getPaddingTop() + TEXT_SIZE + TEXT_BOTTOM_MARGIN), getPaddingRight(), getPaddingBottom());
        finalTextOffset = (int) (offset + TEXT_VERTICAL_OFFSET);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (textIsShowing && TextUtils.isEmpty(s)) { //不显示上方字体
                    textIsShowing = false;
                    if (animShow != null) {
                        animShow.reverse();
                    }
                } else if (!textIsShowing && !TextUtils.isEmpty(s)) { //显示上方字体
                    textIsShowing = true;
                    if (animShow != null) {
                        animShow.start();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initAttrs(AttributeSet attrs, Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText);
        floatTextColor = typedArray.getColor(R.styleable.MaterialEditText_float_textcolor, Color.parseColor("#303F9F"));
        typedArray.recycle();
    }

    private void initValueAnimator() {
        animShow = ValueAnimator.ofFloat(0, 1);
        animShow.setDuration(ANIMTIME);
        animShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentVal = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAlpha((int) (255 * currentVal));
        float extraOffset = finalTextOffset * (1 - currentVal);
        canvas.drawText(getHint().toString(), TEXT_HORIZONTAL_OFFSET, finalTextOffset + extraOffset, paint);

    }
//
//      <FrameLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:layout_centerVertical="true"
//    android:background="@color/colorPrimary">
//
//        <com.mystudydemo.MaterialEditText
//    android:id="@+id/testview"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:hint="PassWord"
//    app:float_textcolor="@color/colorAccent" />
//    </FrameLayout>
}
