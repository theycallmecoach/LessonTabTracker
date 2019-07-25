package cagey.lessontab.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Extends RecyclerView adding in support for a view to show when the list is empty
 */
class CageyRecyclerView : RecyclerView {

    var viewState: CageyRecyclerViewState? = CageyRecyclerViewState.EMPTY
        set(value) {
            field = value
            setState()
        }

    var emptyView: View? = null

    private val observer = object : AdapterDataObserver() {

        override fun onChanged() {
            onChangeState()
        }

        override fun onItemRangeInserted(posStart: Int, itemCount: Int) {
            super.onItemRangeInserted(posStart, itemCount)
            onChangeState()
        }

        override fun onItemRangeRemoved(posStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(posStart, itemCount)
            onChangeState()
        }
    }

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)


    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(observer)
        observer.onChanged()
    }

    fun setState() {
        when (this.viewState) {
            CageyRecyclerViewState.EMPTY -> {
                emptyView!!.visibility = VISIBLE
                this@CageyRecyclerView.visibility = GONE
            }
            CageyRecyclerViewState.NORMAL -> {
                emptyView!!.visibility = GONE
                this@CageyRecyclerView.visibility = VISIBLE
            }
        }
    }

    fun onChangeState() {
        if (adapter != null) {
            if (adapter?.itemCount == 0) {
                emptyView!!.visibility = VISIBLE
                this@CageyRecyclerView.visibility = GONE
            } else {
                emptyView!!.visibility = GONE
                this@CageyRecyclerView.visibility = VISIBLE
            }
        }
    }
}