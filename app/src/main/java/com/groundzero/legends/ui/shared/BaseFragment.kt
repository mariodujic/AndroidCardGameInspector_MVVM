package com.groundzero.legends.ui.shared

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.groundzero.legends.ui.cards.CardsViewModel
import com.groundzero.legends.ui.cards.CardsViewModelFactory
import com.groundzero.legends.application.CustomApplication
import com.groundzero.legends.di.components.FoundationComponent
import com.groundzero.legends.di.modules.*
import com.groundzero.legends.utils.Logger
import javax.inject.Inject

open class BaseFragment(private val fragmentTitle: String) : Fragment() {

    @Inject
    lateinit var viewModelFactory: CardsViewModelFactory
    @Inject
    lateinit var logger: Logger
    protected lateinit var viewModel: CardsViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity!! as MainActivity).setToolbar(activity!!, fragmentTitle)
        getFoundationComponent().inject(this)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(CardsViewModel::class.java)
    }

    private fun getFoundationComponent(): FoundationComponent =
        (activity!!.application as CustomApplication)
            .getApplicationComponent()
            .foundationComponent(
                NetworkModule(),
                LogModule(),
                CardModule(),
                ViewModelModule()
            )

    fun showErrorToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}