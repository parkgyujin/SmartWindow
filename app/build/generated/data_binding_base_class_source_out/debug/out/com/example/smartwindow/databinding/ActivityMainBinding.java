// Generated by view binder compiler. Do not edit!
package com.example.smartwindow.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smartwindow.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Switch autoswitch;

  @NonNull
  public final TextView cityView;

  @NonNull
  public final TextView cityViewText;

  @NonNull
  public final TextView dust;

  @NonNull
  public final TextView dustText;

  @NonNull
  public final TextView errorText;

  @NonNull
  public final TextView gasText;

  @NonNull
  public final TextView gasView;

  @NonNull
  public final TextView heatText;

  @NonNull
  public final TextView humiText;

  @NonNull
  public final TextView humidity;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final Toolbar myToolbar;

  @NonNull
  public final TextView rainText;

  @NonNull
  public final TextView rainView;

  @NonNull
  public final Button readBtn;

  @NonNull
  public final TextView tempView;

  @NonNull
  public final TextView tempViewText;

  @NonNull
  public final TextView temper;

  @NonNull
  public final TextView temperText;

  @NonNull
  public final TextView toolbarTitle;

  @NonNull
  public final TextView weatherView;

  @NonNull
  public final TextView weatherViewText;

  @NonNull
  public final TextView windowstatus;

  @NonNull
  public final TextView windowstatus2;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull Switch autoswitch,
      @NonNull TextView cityView, @NonNull TextView cityViewText, @NonNull TextView dust,
      @NonNull TextView dustText, @NonNull TextView errorText, @NonNull TextView gasText,
      @NonNull TextView gasView, @NonNull TextView heatText, @NonNull TextView humiText,
      @NonNull TextView humidity, @NonNull ImageView imageView4, @NonNull Toolbar myToolbar,
      @NonNull TextView rainText, @NonNull TextView rainView, @NonNull Button readBtn,
      @NonNull TextView tempView, @NonNull TextView tempViewText, @NonNull TextView temper,
      @NonNull TextView temperText, @NonNull TextView toolbarTitle, @NonNull TextView weatherView,
      @NonNull TextView weatherViewText, @NonNull TextView windowstatus,
      @NonNull TextView windowstatus2) {
    this.rootView = rootView;
    this.autoswitch = autoswitch;
    this.cityView = cityView;
    this.cityViewText = cityViewText;
    this.dust = dust;
    this.dustText = dustText;
    this.errorText = errorText;
    this.gasText = gasText;
    this.gasView = gasView;
    this.heatText = heatText;
    this.humiText = humiText;
    this.humidity = humidity;
    this.imageView4 = imageView4;
    this.myToolbar = myToolbar;
    this.rainText = rainText;
    this.rainView = rainView;
    this.readBtn = readBtn;
    this.tempView = tempView;
    this.tempViewText = tempViewText;
    this.temper = temper;
    this.temperText = temperText;
    this.toolbarTitle = toolbarTitle;
    this.weatherView = weatherView;
    this.weatherViewText = weatherViewText;
    this.windowstatus = windowstatus;
    this.windowstatus2 = windowstatus2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.autoswitch;
      Switch autoswitch = ViewBindings.findChildViewById(rootView, id);
      if (autoswitch == null) {
        break missingId;
      }

      id = R.id.cityView;
      TextView cityView = ViewBindings.findChildViewById(rootView, id);
      if (cityView == null) {
        break missingId;
      }

      id = R.id.cityViewText;
      TextView cityViewText = ViewBindings.findChildViewById(rootView, id);
      if (cityViewText == null) {
        break missingId;
      }

      id = R.id.dust;
      TextView dust = ViewBindings.findChildViewById(rootView, id);
      if (dust == null) {
        break missingId;
      }

      id = R.id.dustText;
      TextView dustText = ViewBindings.findChildViewById(rootView, id);
      if (dustText == null) {
        break missingId;
      }

      id = R.id.errorText;
      TextView errorText = ViewBindings.findChildViewById(rootView, id);
      if (errorText == null) {
        break missingId;
      }

      id = R.id.gasText;
      TextView gasText = ViewBindings.findChildViewById(rootView, id);
      if (gasText == null) {
        break missingId;
      }

      id = R.id.gasView;
      TextView gasView = ViewBindings.findChildViewById(rootView, id);
      if (gasView == null) {
        break missingId;
      }

      id = R.id.heatText;
      TextView heatText = ViewBindings.findChildViewById(rootView, id);
      if (heatText == null) {
        break missingId;
      }

      id = R.id.humiText;
      TextView humiText = ViewBindings.findChildViewById(rootView, id);
      if (humiText == null) {
        break missingId;
      }

      id = R.id.humidity;
      TextView humidity = ViewBindings.findChildViewById(rootView, id);
      if (humidity == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.my_toolbar;
      Toolbar myToolbar = ViewBindings.findChildViewById(rootView, id);
      if (myToolbar == null) {
        break missingId;
      }

      id = R.id.rainText;
      TextView rainText = ViewBindings.findChildViewById(rootView, id);
      if (rainText == null) {
        break missingId;
      }

      id = R.id.rainView;
      TextView rainView = ViewBindings.findChildViewById(rootView, id);
      if (rainView == null) {
        break missingId;
      }

      id = R.id.read_btn;
      Button readBtn = ViewBindings.findChildViewById(rootView, id);
      if (readBtn == null) {
        break missingId;
      }

      id = R.id.tempView;
      TextView tempView = ViewBindings.findChildViewById(rootView, id);
      if (tempView == null) {
        break missingId;
      }

      id = R.id.tempViewText;
      TextView tempViewText = ViewBindings.findChildViewById(rootView, id);
      if (tempViewText == null) {
        break missingId;
      }

      id = R.id.temper;
      TextView temper = ViewBindings.findChildViewById(rootView, id);
      if (temper == null) {
        break missingId;
      }

      id = R.id.temperText;
      TextView temperText = ViewBindings.findChildViewById(rootView, id);
      if (temperText == null) {
        break missingId;
      }

      id = R.id.toolbar_title;
      TextView toolbarTitle = ViewBindings.findChildViewById(rootView, id);
      if (toolbarTitle == null) {
        break missingId;
      }

      id = R.id.weatherView;
      TextView weatherView = ViewBindings.findChildViewById(rootView, id);
      if (weatherView == null) {
        break missingId;
      }

      id = R.id.weatherViewText;
      TextView weatherViewText = ViewBindings.findChildViewById(rootView, id);
      if (weatherViewText == null) {
        break missingId;
      }

      id = R.id.windowstatus;
      TextView windowstatus = ViewBindings.findChildViewById(rootView, id);
      if (windowstatus == null) {
        break missingId;
      }

      id = R.id.windowstatus2;
      TextView windowstatus2 = ViewBindings.findChildViewById(rootView, id);
      if (windowstatus2 == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, autoswitch, cityView, cityViewText,
          dust, dustText, errorText, gasText, gasView, heatText, humiText, humidity, imageView4,
          myToolbar, rainText, rainView, readBtn, tempView, tempViewText, temper, temperText,
          toolbarTitle, weatherView, weatherViewText, windowstatus, windowstatus2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
