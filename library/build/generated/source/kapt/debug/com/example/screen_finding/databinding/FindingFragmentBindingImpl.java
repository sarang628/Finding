package com.example.screen_finding.databinding;
import com.example.screen_finding.R;
import com.example.screen_finding.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FindingFragmentBindingImpl extends FindingFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.filter_container, 2);
        sViewsWithIds.put(R.id.sv_map, 3);
        sViewsWithIds.put(R.id.tv_keyword, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FindingFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private FindingFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) bindings[1]
            , (androidx.fragment.app.FragmentContainerView) bindings[2]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[4]
            );
        this.btnMylocation.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.uiState == variableId) {
            setUiState((com.example.screen_finding.finding.FindUiState) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUiState(@Nullable com.example.screen_finding.finding.FindUiState UiState) {
        this.mUiState = UiState;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.uiState);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.screen_finding.finding.FindUiState uiState = mUiState;
        int uiStateHasGrantLocationPermissionBtnMylocationAndroidColorColorSecondaryLightBtnMylocationAndroidColorGray = 0;
        boolean uiStateHasGrantLocationPermission = false;

        if ((dirtyFlags & 0x3L) != 0) {



                if (uiState != null) {
                    // read uiState.hasGrantLocationPermission
                    uiStateHasGrantLocationPermission = uiState.getHasGrantLocationPermission();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(uiStateHasGrantLocationPermission) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read uiState.hasGrantLocationPermission ? @android:color/colorSecondaryLight : @android:color/gray
                uiStateHasGrantLocationPermissionBtnMylocationAndroidColorColorSecondaryLightBtnMylocationAndroidColorGray = ((uiStateHasGrantLocationPermission) ? (getColorFromResource(btnMylocation, R.color.colorSecondaryLight)) : (getColorFromResource(btnMylocation, R.color.gray)));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.btnMylocation.setBackgroundTintList(androidx.databinding.adapters.Converters.convertColorToColorStateList(uiStateHasGrantLocationPermissionBtnMylocationAndroidColorColorSecondaryLightBtnMylocationAndroidColorGray));
            }
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): uiState
        flag 1 (0x2L): null
        flag 2 (0x3L): uiState.hasGrantLocationPermission ? @android:color/colorSecondaryLight : @android:color/gray
        flag 3 (0x4L): uiState.hasGrantLocationPermission ? @android:color/colorSecondaryLight : @android:color/gray
    flag mapping end*/
    //end
}