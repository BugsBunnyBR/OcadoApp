package es.ocado.features.product.detail.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import es.ocado.features.product.detail.R
import es.ocado.features.product.detail.databinding.ActivityProductDetailBinding
import es.ocado.features.product.detail.presentation.ViewAction.LoadDetails
import es.ocado.base.library.utils.exhaustive
import es.ocado.base.library.utils.loadImage

@AndroidEntryPoint
class ProductDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityProductDetailBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<ProductDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        observeViewModel()
        viewModel.onAction(LoadDetails)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun observeViewModel() {
        viewModel.viewState.observe(this) { viewState ->
            when (viewState) {
                is ViewState.Content -> {
                    showProduct(viewState)
                }
            }.exhaustive
        }
        viewModel.errorState.observe(this) { event ->
            when (event) {
                is ErrorEvent.ShowError -> showError()
            }
        }
    }

    private fun showProduct(content: ViewState.Content) {

        with(binding) {
            productImage.loadImage(content.imageUrl)
            productTitle.text = content.title
            productDescription.setDescription(content.description)
            productAllergyInformation.setDescription(content.allergyInformation)
            productSize.setDescription(content.size)
            buyNowButton.text = content.price
        }
    }

    private fun showError() {
        Snackbar.make(
            binding.root,
            getString(R.string.product_detail_error_message),
            Snackbar.LENGTH_INDEFINITE
        ).setAction(getString(R.string.product_detail_retry_action)) {
            viewModel.onAction(LoadDetails)
        }.show()
    }
}
