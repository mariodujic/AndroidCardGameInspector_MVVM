package com.groundzero.legends.shared.ui.fragments

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.groundzero.legends.cards.viewmodel.CardsViewModelFactory
import com.groundzero.legends.shared.ui.activities.MainActivity
import com.groundzero.legends.shared.application.CustomApplication
import com.groundzero.legends.shared.di.components.FoundationComponent
import com.groundzero.legends.shared.di.modules.FoundationModule
import com.groundzero.legends.shared.di.modules.NetworkModule

open class BaseFragment(private val fragmentTitle: String) : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity!! as MainActivity).setToolbar(activity!!, fragmentTitle)
    }

    fun getFoundationComponent(): FoundationComponent =
        (activity!!.application as CustomApplication)
            .getApplicationComponent()
            .foundationComponent(
                FoundationModule(activity!!),
                NetworkModule()
            )

    fun cardsViewFactory() = CardsViewModelFactory(getFoundationComponent())


    fun showErrorToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}