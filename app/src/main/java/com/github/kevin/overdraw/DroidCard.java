package com.github.kevin.overdraw;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class DroidCard {
    Resources res;
    int iconId;
    float x;
    Bitmap bitmap;
    float height;

    public DroidCard(Resources res, int iconId, int x) {
        this.res = res;
        this.iconId = iconId;
        this.x = x;
        this.bitmap = BitmapFactory.decodeResource(res, iconId);
        this.height = this.bitmap.getHeight();
    }

}
