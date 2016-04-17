package mobile.silong.mvvm.holder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lamtn on 4/15/16.
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

  final T mLayoutBinding;

  public BindingViewHolder(T layoutBinding) {
    super(layoutBinding.getRoot());
    mLayoutBinding = layoutBinding;
  }

  public T getLayoutBinding() {
    return mLayoutBinding;
  }
}
