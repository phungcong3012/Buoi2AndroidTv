package com.example.admin.youtubedemo;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
  public static final String LEFT_MENU = "left_menu";
  public static final String CONTENT_SHOW = "content_show";
  public static final String ICON_LEFT_MENU = "icon_left_menu";
  private static final String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.fragment_menu_icon)
  FrameLayout fragment_menu_icon;

  @BindView(R.id.fragment_menu_left)
  FrameLayout fragment_left_menu;

  @BindView(R.id.fragment_content)
  FrameLayout fragment_content;

  @BindView(R.id.container)
  CustomConstraintLayout mContainer;

  FragmentManager fragmentManager = getSupportFragmentManager();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    showLeft();

  }

  private void showLeft() {

    final LeftMenuIconFragment leftMenuIconFragment = new LeftMenuIconFragment();
    final LeftMenuFragment leftMenuFragment = new LeftMenuFragment();
    final ContenFragment contenFragment = new ContenFragment();

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_menu_icon, leftMenuIconFragment, ICON_LEFT_MENU)
        .commit();

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_menu_left, leftMenuFragment, LEFT_MENU)
        .commit();

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_content, contenFragment, CONTENT_SHOW)
        .commit();

//    leftMenuFragment.setOnItemSelectedListener(new LeftMenuFragment.OnClickItemSelectedListener() {
//      @Override
//      public void onClickListener(int id) {
//        if (id == 1) {
//          Toast.makeText(MainActivity.this, "Trang chủ", Toast.LENGTH_SHORT).show();
//        } else if (id == 2) {
//          Toast.makeText(MainActivity.this, "Đề Xuất", Toast.LENGTH_SHORT).show();
//        } else {
//          Toast.makeText(MainActivity.this, "Thịnh Hành", Toast.LENGTH_SHORT).show();
//          Toast.makeText(MainActivity.this, "Âm Nhạc", Toast.LENGTH_SHORT).show();
//          Toast.makeText(MainActivity.this, "Giải Trí", Toast.LENGTH_SHORT).show();
//        }
//      }
//    });


    mContainer.setOnChildFocusListener(new OnChildFocusListener() {
      @Override
      public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return false;
      }

      @Override
      public void onRequestChildFocus(View child, View focused) {
        if (child.getId() == R.id.fragment_content) {
          FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
          LeftMenuFragment leftMenu = (LeftMenuFragment) getSupportFragmentManager().findFragmentByTag(LEFT_MENU);
          if (leftMenu != null) {
            fragmentTransaction.remove(leftMenuFragment);
            fragmentTransaction.commit();
            fragment_left_menu.setVisibility(View.GONE);
          }
        } else if (child.getId() == R.id.fragment_menu_icon){
          if (!leftMenuFragment.isAdded()) {
            fragment_left_menu.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_menu_left, leftMenuFragment, LEFT_MENU)
                .commit();
          }
        }
      }
    });
  }

}