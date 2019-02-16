package ir.cafebazzar.app.ui.base.recyclerview

import android.view.ViewGroup

interface ViewHolderFactory<V : BaseViewHolder<*, *, *>> {
    fun create(parent: ViewGroup): V
}
