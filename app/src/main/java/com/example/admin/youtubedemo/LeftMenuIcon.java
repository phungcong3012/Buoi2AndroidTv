package com.example.admin.youtubedemo;

import android.support.v17.leanback.widget.HeaderItem;

public class LeftMenuIcon extends HeaderItem {
  private int mIcon;

  public int getmIcon() {
    return mIcon;
  }

  public void setmIcon(int mIcon) {
    this.mIcon = mIcon;
  }

  public LeftMenuIcon(String name, int mIcon) {
    super(name);
    this.mIcon = mIcon;
  }

  public LeftMenuIcon(long id, String name) {
    super(id, name);
  }
}
