package com.example.admin.youtubedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.HeadersSupportFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class LeftMenuIconFragment extends HeadersSupportFragment {
  private ArrayObjectAdapter arrayObjectAdapter;
  private List<LeftMenuIcon> leftMenuIcons;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setPresenterSelector(new PresenterSelector() {
      @Override
      public Presenter getPresenter(Object item) {
        return new LeftMenuIconPresenter(getActivity());
      }
    });
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setUpData();
    getVerticalGridView().setPadding(0, 0, 0, 0);
  }

  private void setUpData() {
    arrayObjectAdapter = new ArrayObjectAdapter();
    leftMenuIcons = new ArrayList<>();

    LeftMenuIcon iconSearch = new LeftMenuIcon("Search", R.drawable.search);
    leftMenuIcons.add(iconSearch);
    arrayObjectAdapter.add(new ListRow(iconSearch, new ArrayObjectAdapter(new LeftMenuIconPresenter(getActivity()))));

    LeftMenuIcon iconHome = new LeftMenuIcon("Home", R.drawable.home);
    leftMenuIcons.add(iconHome);
    arrayObjectAdapter.add(new ListRow(iconHome, new ArrayObjectAdapter(new LeftMenuIconPresenter(getActivity()))));

    LeftMenuIcon iconAccount = new LeftMenuIcon("Account", R.drawable.account);
    leftMenuIcons.add(iconAccount);
    arrayObjectAdapter.add(new ListRow(iconAccount, new ArrayObjectAdapter(new LeftMenuIconPresenter(getActivity()))));

    LeftMenuIcon iconMessger = new LeftMenuIcon("Messger", R.drawable.message);
    leftMenuIcons.add(iconMessger);
    arrayObjectAdapter.add(new ListRow(iconMessger, new ArrayObjectAdapter(new LeftMenuIconPresenter(getActivity()))));

    LeftMenuIcon iconSetting = new LeftMenuIcon("Setting", R.drawable.setting);
    leftMenuIcons.add(iconSetting);
    arrayObjectAdapter.add(new ListRow(iconSetting, new ArrayObjectAdapter(new LeftMenuIconPresenter(getActivity()))));

    setAdapter(arrayObjectAdapter);
  }
}
