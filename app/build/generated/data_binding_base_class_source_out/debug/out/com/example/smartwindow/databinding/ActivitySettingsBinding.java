// Generated by view binder compiler. Do not edit!
package com.example.smartwindow.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smartwindow.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySettingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView dustView;

  @NonNull
  public final TextView humiView;

  @NonNull
  public final Toolbar myToolbar;

  @NonNull
  public final Button resetBtn;

  @NonNull
  public final SeekBar seekBar;

  @NonNull
  public final SeekBar seekBar2;

  @NonNull
  public final SeekBar seekBar3;

  @NonNull
  public final Switch switch1;

  @NonNull
  public final TextView tempView;

  @NonNull
  public final TextView temptextView2;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView toolbarTitle;

  private ActivitySettingsBinding(@NonNull ConstraintLayout rootView, @NonNull TextView dustView,
      @NonNull TextView humiView, @NonNull Toolbar myToolbar, @NonNull Button resetBtn,
      @NonNull SeekBar seekBar, @NonNull SeekBar seekBar2, @NonNull SeekBar seekBar3,
      @NonNull Switch switch1, @NonNull TextView tempView, @NonNull TextView temptextView2,
      @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull TextView toolbarTitle) {
    this.rootView = rootView;
    this.dustView = dustView;
    this.humiView = humiView;
    this.myToolbar = myToolbar;
    this.resetBtn = resetBtn;
    this.seekBar = seekBar;
    this.seekBar2 = seekBar2;
    this.seekBar3 = seekBar3;
    this.switch1 = switch1;
    this.tempView = tempView;
    this.temptextView2 = temptextView2;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.toolbarTitle = toolbarTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dustView;
      TextView dustView = ViewBindings.findChildViewById(rootView, id);
      if (dustView == null) {
        break missingId;
      }

      id = R.id.humiView;
      TextView humiView = ViewBindings.findChildViewById(rootView, id);
      if (humiView == null) {
        break missingId;
      }

      id = R.id.my_toolbar;
      Toolbar myToolbar = ViewBindings.findChildViewById(rootView, id);
      if (myToolbar == null) {
        break missingId;
      }

      id = R.id.resetBtn;
      Button resetBtn = ViewBindings.findChildViewById(rootView, id);
      if (resetBtn == null) {
        break missingId;
      }

      id = R.id.seekBar;
      SeekBar seekBar = ViewBindings.findChildViewById(rootView, id);
      if (seekBar == null) {
        break missingId;
      }

      id = R.id.seekBar2;
      SeekBar seekBar2 = ViewBindings.findChildViewById(rootView, id);
      if (seekBar2 == null) {
        break missingId;
      }

      id = R.id.seekBar3;
      SeekBar seekBar3 = ViewBindings.findChildViewById(rootView, id);
      if (seekBar3 == null) {
        break missingId;
      }

      id = R.id.switch1;
      Switch switch1 = ViewBindings.findChildViewById(rootView, id);
      if (switch1 == null) {
        break missingId;
      }

      id = R.id.tempView;
      TextView tempView = ViewBindings.findChildViewById(rootView, id);
      if (tempView == null) {
        break missingId;
      }

      id = R.id.temptextView2;
      TextView temptextView2 = ViewBindings.findChildViewById(rootView, id);
      if (temptextView2 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.toolbar_title;
      TextView toolbarTitle = ViewBindings.findChildViewById(rootView, id);
      if (toolbarTitle == null) {
        break missingId;
      }

      return new ActivitySettingsBinding((ConstraintLayout) rootView, dustView, humiView, myToolbar,
          resetBtn, seekBar, seekBar2, seekBar3, switch1, tempView, temptextView2, textView2,
          textView3, textView4, toolbarTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
