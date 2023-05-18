// Generated by view binder compiler. Do not edit!
package com.example.mymusicproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.mymusicproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddCategoryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ImageButton mBtnImg;

  @NonNull
  public final Button mBtnSubmit;

  @NonNull
  public final EditText mEdtCategory;

  @NonNull
  public final TextView mEdtNew;

  private ActivityAddCategoryBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageButton mBtnImg,
      @NonNull Button mBtnSubmit, @NonNull EditText mEdtCategory, @NonNull TextView mEdtNew) {
    this.rootView = rootView;
    this.imageView4 = imageView4;
    this.imageView5 = imageView5;
    this.mBtnImg = mBtnImg;
    this.mBtnSubmit = mBtnSubmit;
    this.mEdtCategory = mEdtCategory;
    this.mEdtNew = mEdtNew;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_category, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddCategoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.mBtnImg;
      ImageButton mBtnImg = ViewBindings.findChildViewById(rootView, id);
      if (mBtnImg == null) {
        break missingId;
      }

      id = R.id.mBtnSubmit;
      Button mBtnSubmit = ViewBindings.findChildViewById(rootView, id);
      if (mBtnSubmit == null) {
        break missingId;
      }

      id = R.id.mEdtCategory;
      EditText mEdtCategory = ViewBindings.findChildViewById(rootView, id);
      if (mEdtCategory == null) {
        break missingId;
      }

      id = R.id.mEdtNew;
      TextView mEdtNew = ViewBindings.findChildViewById(rootView, id);
      if (mEdtNew == null) {
        break missingId;
      }

      return new ActivityAddCategoryBinding((ConstraintLayout) rootView, imageView4, imageView5,
          mBtnImg, mBtnSubmit, mEdtCategory, mEdtNew);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}