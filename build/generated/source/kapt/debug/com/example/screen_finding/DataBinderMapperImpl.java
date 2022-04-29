package com.example.screen_finding;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.screen_finding.databinding.FindingFragmentBindingImpl;
import com.example.screen_finding.databinding.FragmentTorangCardVpItemBindingImpl;
import com.example.screen_finding.databinding.FragmentViewPagerBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FINDINGFRAGMENT = 1;

  private static final int LAYOUT_FRAGMENTTORANGCARDVPITEM = 2;

  private static final int LAYOUT_FRAGMENTVIEWPAGER = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.screen_finding.R.layout.finding_fragment, LAYOUT_FINDINGFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.screen_finding.R.layout.fragment_torang_card_vp_item, LAYOUT_FRAGMENTTORANGCARDVPITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.screen_finding.R.layout.fragment_view_pager, LAYOUT_FRAGMENTVIEWPAGER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FINDINGFRAGMENT: {
          if ("layout/finding_fragment_0".equals(tag)) {
            return new FindingFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for finding_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTORANGCARDVPITEM: {
          if ("layout/fragment_torang_card_vp_item_0".equals(tag)) {
            return new FragmentTorangCardVpItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_torang_card_vp_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTVIEWPAGER: {
          if ("layout/fragment_view_pager_0".equals(tag)) {
            return new FragmentViewPagerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_view_pager is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(7);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.example.screen_map.DataBinderMapperImpl());
    result.add(new com.example.screen_search.DataBinderMapperImpl());
    result.add(new com.example.torang_core.DataBinderMapperImpl());
    result.add(new com.example.travelmode.DataBinderMapperImpl());
    result.add(new com.sarang.torangimageloader.DataBinderMapperImpl());
    result.add(new com.sryang.screen_filter.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(12);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "cardInfoViewModel");
      sKeys.put(2, "filterViewModel");
      sKeys.put(3, "keyword");
      sKeys.put(4, "name");
      sKeys.put(5, "nationItem");
      sKeys.put(6, "res");
      sKeys.put(7, "restaurant");
      sKeys.put(8, "search");
      sKeys.put(9, "selectNationViewModel");
      sKeys.put(10, "viewModel");
      sKeys.put(11, "vm");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/finding_fragment_0", com.example.screen_finding.R.layout.finding_fragment);
      sKeys.put("layout/fragment_torang_card_vp_item_0", com.example.screen_finding.R.layout.fragment_torang_card_vp_item);
      sKeys.put("layout/fragment_view_pager_0", com.example.screen_finding.R.layout.fragment_view_pager);
    }
  }
}
