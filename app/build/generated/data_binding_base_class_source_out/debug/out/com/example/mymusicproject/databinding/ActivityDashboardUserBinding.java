// Generated by view binder compiler. Do not edit!
package com.example.mymusicproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public final class ActivityDashboardUserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button mBtnAdmin;

  @NonNull
  public final ImageButton mBtnLogout;

  @NonNull
  public final TextView mEdtAdmin;

  @NonNull
  public final TextView mEdtEm;

  private ActivityDashboardUserBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button mBtnAdmin, @NonNull ImageButton mBtnLogout, @NonNull TextView mEdtAdmin,
      @NonNull TextView mEdtEm) {
    this.rootView = rootView;
    this.mBtnAdmin = mBtnAdmin;
    this.mBtnLogout = mBtnLogout;
    this.mEdtAdmin = mEdtAdmin;
    this.mEdtEm = mEdtEm;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDashboardUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDashboardUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dashboard_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDashboardUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.mBtnAdmin;
      Button mBtnAdmin = ViewBindings.findChildViewById(rootView, id);
      if (mBtnAdmin == null) {
        break missingId;
      }

      id = R.id.mBtnLogout;
      ImageButton mBtnLogout = ViewBindings.findChildViewById(rootView, id);
      if (mBtnLogout == null) {
        break missingId;
      }

      id = R.id.mEdtAdmin;
      TextView mEdtAdmin = ViewBindings.findChildViewById(rootView, id);
      if (mEdtAdmin == null) {
        break missingId;
      }

      id = R.id.mEdtEm;
      TextView mEdtEm = ViewBindings.findChildViewById(rootView, id);
      if (mEdtEm == null) {
        break missingId;
      }

      return new ActivityDashboardUserBinding((ConstraintLayout) rootView, mBtnAdmin, mBtnLogout,
          mEdtAdmin, mEdtEm);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
