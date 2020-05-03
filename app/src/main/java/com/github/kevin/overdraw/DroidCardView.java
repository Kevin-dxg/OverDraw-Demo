package com.github.kevin.overdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DroidCardView extends View {
    //拼图间的间距
    private int mCardSpacing = 150;
    private int mCardleft = 0;
    private List<DroidCard> mDroidCards = new ArrayList<>();
    private Paint paint = new Paint();

    public DroidCardView(Context context) {
        super(context);
        initCards();
    }

    public DroidCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCards();
    }

    /**
     * 初始化卡片集合
     */
    private void initCards() {
        Resources res = getResources();
        mDroidCards.add(new DroidCard(res, R.drawable.notebook, mCardleft));

        mCardleft += mCardSpacing;
        mDroidCards.add(new DroidCard(res, R.drawable.folder, mCardleft));

        mCardleft += mCardSpacing;
        mDroidCards.add(new DroidCard(res, R.drawable.calendar, mCardleft));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将前面几张图片进行抽取，单独绘制
        for (int i = 0; i < mDroidCards.size() - 1; i++) {
            drawDroidCard(canvas, mDroidCards, i);
        }
        drawDroidCard(canvas, mDroidCards.get(mDroidCards.size() - 1));

    }

    private void drawDroidCard(Canvas canvas, List<DroidCard> pDroidCards, int i) {
        DroidCard c = pDroidCards.get(i);
        canvas.save();
        canvas.clipRect(c.x, 0f, mDroidCards.get(i + 1).x, c.height);
        canvas.drawBitmap(c.bitmap, c.x, 0f, paint);
        canvas.restore();
    }

    /**
     * 绘制DroidCard
     *
     * @param canvas
     * @param c
     */
    private void drawDroidCard(Canvas canvas, DroidCard c) {
        canvas.drawBitmap(c.bitmap, c.x, 0f, paint);
    }
}
