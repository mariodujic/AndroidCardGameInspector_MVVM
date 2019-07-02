package com.groundzero.legends.ui.shared

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.groundzero.legends.R
import com.groundzero.legends.application.CustomApplication
import com.groundzero.legends.ui.cards.CardsViewModel
import com.groundzero.legends.ui.cards.CardsViewModelFactory
import com.groundzero.legends.utils.Logger
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: CardsViewModelFactory
    @Inject
    protected lateinit var viewModel: CardsViewModel
    @Inject
    lateinit var logger: Logger
    // When entering new fragment, fragment title is being changed.
    protected val fragmentTitleSubject: Subject<String> = BehaviorSubject.create()
    private lateinit var fragmentTitleDisposables: Disposable
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity!!.application as CustomApplication).getFoundationComponent().inject(this)
        fragmentTitleSubject.subscribe(fragmentTitleObserver())
    }

    fun showErrorToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun fragmentTitleObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
            }

            override fun onSubscribe(disposable: Disposable) {
                fragmentTitleDisposables = disposable
            }

            override fun onNext(fragmentTitle: String) {
                (activity!! as MainActivity).setToolbar(activity!!, fragmentTitle)
            }

            override fun onError(e: Throwable) {
                 showErrorToast(resources.getString(R.string.error_cannot_set_fragment_title))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentTitleDisposables.dispose()
    }
}