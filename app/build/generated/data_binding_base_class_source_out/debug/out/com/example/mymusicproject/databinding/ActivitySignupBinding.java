// Generated by view binder compiler. Do not edit!
package com.example.mymusicproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button mBtnLog;

  @NonNull
  public final Button mBtnSignUp;

  @NonNull
  public final EditText mEdtLastName;

  @NonNull
  public final TextView mEdtLog;

  @NonNull
  public final EditText mEdtMail;

  @NonNull
  public final EditText mEdtName;

  @NonNull
  public final EditText mEdtPassword;

  @NonNull
  public final EditText mEdtPhone;

  @NonNull
  public final EditText mEdtRePass;

  private ActivitySignupBinding(@NonNull ConstraintLayout rootView, @NonNull Button mBtnLog,
      @NonNull Button mBtnSignUp, @NonNull EditText mEdtLastName, @NonNull TextView mEdtLog,
      @NonNull EditText mEdtMail, @NonNull EditText mEdtName, @NonNull EditText mEdtPassword,
      @NonNull EditText mEdtPhone, @NonNull EditText mEdtRePass) {
    this.rootView = rootView;
    this.mBtnLog = mBtnLog;
    this.mBtnSignUp = mBtnSignUp;
    this.mEdtLastName = mEdtLastName;
    this.mEdtLog = mEdtLog;
    this.mEdtMail = mEdtMail;
    this.mEdtName = mEdtName;
    this.mEdtPassword = mEdtPassword;
    this.mEdtPhone = mEdtPhone;
    this.mEdtRePass = mEdtRePass;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.mBtnLog;
      Button mBtnLog = ViewBindings.findChildViewById(rootView, id);
      if (mBtnLog == null) {
        break missingId;
      }

      id = R.id.mBtnSignUp;
      Button mBtnSignUp = ViewBindings.findChildViewById(rootView, id);
      if (mBtnSignUp == null) {
        break missingId;
      }

      id = R.id.mEdtLastName;
      EditText mEdtLastName = ViewBindings.findChildViewById(rootView, id);
      if (mEdtLastName == null) {
        break missingId;
      }

      id = R.id.mEdtLog;
      TextView mEdtLog = ViewBindings.findChildViewById(rootView, id);
      if (mEdtLog == null) {
        break missingId;
      }

      id = R.id.mEdtMail;
      EditText mEdtMail = ViewBindings.findChildViewById(rootView, id);
      if (mEdtMail == null) {
        break missingId;
      }

      id = R.id.mEdtName;
      EditText mEdtName = ViewBindings.findChildViewById(rootView, id);
      if (mEdtName == null) {
        break missingId;
      }

      id = R.id.mEdtPassword;
      EditText mEdtPassword = ViewBindings.findChildViewById(rootView, id);
      if (mEdtPassword == null) {
        break missingId;
      }

      id = R.id.mEdtPhone;
      EditText mEdtPhone = ViewBindings.findChildViewById(rootView, id);
      if (mEdtPhone == null) {
        break missingId;
      }

      id = R.id.mEdtRePass;
      EditText mEdtRePass = ViewBindings.findChildViewById(rootView, id);
      if (mEdtRePass == null) {
        break missingId;
      }

      return new ActivitySignupBinding((ConstraintLayout) rootView, mBtnLog, mBtnSignUp,
          mEdtLastName, mEdtLog, mEdtMail, mEdtName, mEdtPassword, mEdtPhone, mEdtRePass);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}