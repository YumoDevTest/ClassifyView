package com.anarchy.classifyview.sample.normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anarchy.classify.ClassifyView;
import com.anarchy.classifyview.R;
import com.anarchy.classifyview.core.BaseFragment;
import com.anarchy.classifyview.core.MyAdapter;
import com.anarchy.classifyview.utils.DataGenerate;
import com.anarchy.classifyview.utils.Define;

/**
 * <p/>
 * Date: 16/6/12 09:51
 * Author: rsshinide38@163.com
 * <p/>
 */
public class NormalFragment extends BaseFragment{
    private ClassifyView mClassifyView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.normal1,container,false);
        mClassifyView = (ClassifyView) view.findViewById(R.id.classify_view);
        mClassifyView.setDragGravity(ClassifyView.CENTER);
        mClassifyView.setAdapter(new MyAdapter(DataGenerate.generateBean()));
        mClassifyView.setDebugAble(true);
        mClassifyView.enableMoveListener(true);
        mClassifyView.addDragListener(new ClassifyView.DragListener() {
            @Override
            public void onDragStart(ViewGroup parent, View selectedView, float startX, float startY, @ClassifyView.Region int region) {
                Log.i(Define.LOG_TAG, "onDragStart:"+startX+" "+startY+" "+region);
            }

            @Override
            public void onDragStartAnimationEnd(ViewGroup parent, View selectedView, int region) {
                Log.i(Define.LOG_TAG, "onDragStartAnimationEnd:"+selectedView.toString());
            }

            @Override
            public void onDragEnd(ViewGroup parent, @ClassifyView.Region int region) {
                Log.i(Define.LOG_TAG, "onDragEnd:"+region);
            }

            @Override
            public void onDragRelease(ViewGroup parent, float releaseX, float releaseY, @ClassifyView.Region int region) {
                Log.i(Define.LOG_TAG, "onDragRelease: "+releaseX+" "+releaseY+" "+region);
            }

            @Override
            public void onMove(ViewGroup parent, float touchX, float touchY, @ClassifyView.Region int region) {
                Log.i(Define.LOG_TAG, "onMove:"+touchX+" "+touchY+" "+region);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
