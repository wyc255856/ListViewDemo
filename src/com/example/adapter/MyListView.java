package com.example.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;

public class MyListView extends android.widget.ListView {  
    private View mTitle;  
      
    private boolean visible;  
      
    private int width;  
      
    private int height;  
      
    private MyAdapter mAdapter;  
  
    public MyListView(Context context) {  
        super(context);  
    }  
  
    public MyListView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
    }  
  
    public MyListView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
  
    @Override  
    protected void dispatchDraw(Canvas canvas) {  
        super.dispatchDraw(canvas);  
        if(visible){  
            drawChild(canvas, mTitle, getDrawingTime());  
        }  
    }  
  
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
        if(mTitle!=null){  
            measureChild(mTitle, widthMeasureSpec, heightMeasureSpec);  
            width=mTitle.getMeasuredWidth();  
            height=mTitle.getMeasuredHeight();  
        }  
    }  
  
    @Override  
    protected void onLayout(boolean changed, int l, int t, int r, int b) {  
        super.onLayout(changed, l, t, r, b);  
        if(mTitle!=null){  
            mTitle.layout(0, 0, width, height);  
            titleLayout(getFirstVisiblePosition());  
        }  
    }  
    public void setTitle(View view){  
        mTitle=view;  
        if(mTitle!=null){  
            setFadingEdgeLength(0);  
        }  
        requestLayout();  
    }  
    public void titleLayout(int firstVisiblePosition) {  
        if(mTitle==null){  
            return;  
        }  
        if(mAdapter==null||!(mAdapter instanceof MyAdapter)){  
            return;  
        }  
        int state=0;  
          
        state = mAdapter.getTitleState(firstVisiblePosition);  
        switch(state){  
        case 0:  
            visible=false;  
            break;  
        case 1:  
            if(mTitle.getTop()!=0){  
                mTitle.layout(0, 0, width, height);  
            }  
            mAdapter.setTitleText(mTitle,firstVisiblePosition);  
            visible=true;  
            break;  
        case 2:  
            View firstView=getChildAt(0);  
            if(firstView!=null){  
                int bottom=firstView.getBottom();  
                int headerHeight=mTitle.getHeight();  
                int top;  
                if(bottom<headerHeight){  
                    top=(bottom-headerHeight);  
                }else{  
                    top=0;  
                }  
                mAdapter.setTitleText(mTitle, firstVisiblePosition);  
                if(mTitle.getTop()!=top){  
                    mTitle.layout(0, top, width, height+top);  
                }  
                visible=true;  
            }  
            break;  
        }  
    }  
  
    @Override  
    public void setAdapter(ListAdapter adapter) {  
        if(adapter instanceof MyAdapter){  
            mAdapter=(MyAdapter) adapter;  
            super.setAdapter(adapter);  
        }  
    }  
      
      
      
}  