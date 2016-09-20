package app.st1ch.redditclient.presentation.app.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by st1ch on 17.09.2016.
 */
public class PostImageView extends ImageView {
    public PostImageView(Context context) {
        super(context);
    }

    public PostImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PostImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PostImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        width = width / 6;
        int height = width;
//        int mWidthMeasureSpec1 = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
//        super.onMeasure(mWidthMeasureSpec1, mWidthMeasureSpec1);

        setMeasuredDimension(width, height);
    }
}
