package es.ocado.features.product.list.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ConcatAdapter
import dagger.hilt.android.AndroidEntryPoint
import es.ocado.features.product.list.databinding.ActivityProductListBinding

import es.ocado.features.product.list.domain.model.ProductClusterEntity
import es.ocado.features.product.list.presentation.ViewState.ContentLoaded
import es.ocado.features.product.list.presentation.ViewState.Error
import es.ocado.features.product.list.presentation.adapter.ProductAdapter
import es.ocado.features.product.list.presentation.adapter.ProductHeaderAdapter
import es.ocado.navigation.features.products.detail.ProductDetailDestination
import es.ocado.navigation.features.products.detail.ProductDetailParams
import es.ocado.navigation.startDestination
import es.ocado.base.library.utils.exhaustive

@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductListBinding

    private val viewModel by viewModels<ProductListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.errorContainer.actionTryAgain.setOnClickListener {
            viewModel.onAction(ViewAction.LoadContent)
        }
        observeViewModel()
        if (savedInstanceState == null) {
            viewModel.onAction(ViewAction.LoadContent)
        }
    }

    private fun openProductDetail(params: ProductDetailParams) {
        startDestination(ProductDetailDestination(params))
    }

    private fun observeViewModel() {
        observerViewStateEvents()
        observeNavigationEvents()
    }

    private fun observerViewStateEvents() {
        viewModel.viewState.observe(this) { viewState ->
            when (viewState) {
                is ContentLoaded -> showContent(viewState.clusters)
                is Error -> showError()
            }.exhaustive
        }
    }

    private fun observeNavigationEvents() {
        viewModel.navigationEvent.observe(this) { event ->
            when (event) {
                is NavigationEvent.OpenProductDetail -> openProductDetail(event.params)
            }.exhaustive
        }
    }

    private fun showError() {
        binding.errorContainer.errorRoot.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showContent(clusters: List<ProductClusterEntity>) {
        binding.errorContainer.errorRoot.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        val clusterAdapters = clusters.map { cluster ->
            listOf(
                ProductHeaderAdapter(cluster.tag),
                ProductAdapter(cluster.items) { product ->
                    viewModel.onAction(ViewAction.SelectProduct(product))
                }
            )
        }.flatten()
        binding.recyclerView.adapter = ConcatAdapter(clusterAdapters)
    }
}
