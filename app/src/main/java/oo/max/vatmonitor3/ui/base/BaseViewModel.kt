package oo.max.vatmonitor3.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import oo.max.vatmonitor3.core.error.ApiError
import oo.max.vatmonitor3.core.error.ApiException
import oo.max.vatmonitor3.core.rx.DisposableStore

abstract class BaseViewModel : ViewModel(), DisposableStore {

    private val compositeDisposable = CompositeDisposable()

    protected val progressMutable = MutableLiveData<Boolean>().apply {
        value = false
    }
    val progress: LiveData<Boolean> = progressMutable

    protected val errorMutable = MutableLiveData<ApiException>()
    val error: LiveData<ApiException> = errorMutable

    override fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun dispose() {
        compositeDisposable.dispose()
    }

    protected fun dispatchThrowable(throwable: Throwable?) {
        if (throwable is ApiException) {
            errorMutable.value = throwable
        } else {
            errorMutable.value = ApiException(ApiError.GeneralError)
        }
    }

}