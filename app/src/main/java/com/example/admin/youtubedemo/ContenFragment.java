package com.example.admin.youtubedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.app.HeadersSupportFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContenFragment extends BaseRowsFragment {

  private List<ContentYouTube> mContentYouTubes;

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setupHeaderAdapter();

    // getVerticalGridView().setColumnWidth(2);
    setOnItemViewClickedListener(new OnItemViewClickedListener() {
      @Override
      public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        if (item instanceof String){
          // TO DO
        }else if (item instanceof ContentYouTube){

        }
      }
    });
  }

  private void setupHeaderAdapter() {
    mContentYouTubes = new ArrayList<>();

    mContentYouTubes.add(new ContentYouTube("2:30", "Noi ay con tim ve", "Am nhac", 200, 3, "http://file.vforum.vn/hinh/2018/02/top-nhung-hinh-anh-hoa-dep-bong-hoa-dep-nhat-17.jpg"));
    mContentYouTubes.add(new ContentYouTube("2:30", "Noi ay con tim ve", "Am nhac", 200, 3, "http://file.vforum.vn/hinh/2018/02/top-nhung-hinh-anh-hoa-dep-bong-hoa-dep-nhat-17.jpg"));
    mContentYouTubes.add(new ContentYouTube("2:30", "Noi ay con tim ve", "Am nhac", 200, 3, "http://file.vforum.vn/hinh/2018/02/top-nhung-hinh-anh-hoa-dep-bong-hoa-dep-nhat-17.jpg"));
    mContentYouTubes.add(new ContentYouTube("2:30", "Noi ay con tim ve", "Am nhac", 200, 3, "http://file.vforum.vn/hinh/2018/02/top-nhung-hinh-anh-hoa-dep-bong-hoa-dep-nhat-17.jpg"));
    mContentYouTubes.add(new ContentYouTube("2:30", "Noi ay con tim ve", "Am nhac", 200, 3, "http://file.vforum.vn/hinh/2018/02/top-nhung-hinh-anh-hoa-dep-bong-hoa-dep-nhat-17.jpg"));
    mContentYouTubes.add(new ContentYouTube("2:30", "Noi ay con tim ve", "Am nhac", 200, 3, "http://file.vforum.vn/hinh/2018/02/top-nhung-hinh-anh-hoa-dep-bong-hoa-dep-nhat-17.jpg"));

    getRowsAdapter().clear();


    for (int i = 0; i < 5; i++) {
      ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ProgramGridPresenter(getActivity(),false));
      Collections.shuffle(mContentYouTubes);
      arrayObjectAdapter.addAll(0,mContentYouTubes);
      HeaderItem headerItem = new HeaderItem("Row".concat(i+""));
      getRowsAdapter().add(new ListRow(headerItem,
          arrayObjectAdapter));
    }

  }
}
