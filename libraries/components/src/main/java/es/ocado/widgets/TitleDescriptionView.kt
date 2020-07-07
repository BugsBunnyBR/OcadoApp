package es.ocado.widgets

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import es.ocado.components.R
import es.ocado.components.databinding.ViewTitleDescriptionInternalLayoutBinding

class TitleDescriptionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding =
        ViewTitleDescriptionInternalLayoutBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutTransition = LayoutTransition()
        orientation = VERTICAL
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TitleDescriptionView,
            defStyleAttr,
            0
        ).apply {
            try {
                val title = getString(R.styleable.TitleDescriptionView_title)
                val description = getString(R.styleable.TitleDescriptionView_description)
                setTitle(title)
                setDescription(description)
            } finally {
                recycle()
            }
        }
    }

    private fun setTitle(title: String?) {
        updateVisibility(binding.title, title)
        binding.title.text = title
    }

    fun setDescription(description: String?) {
        updateVisibility(binding.description, description)
        binding.description.text = description
    }

    private fun updateVisibility(view: View, field: String?) {
        view.visibility = if (field.isNullOrBlank()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }
}
