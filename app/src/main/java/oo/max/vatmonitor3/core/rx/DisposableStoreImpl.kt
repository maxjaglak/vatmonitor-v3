package oo.max.vatmonitor3.core.rx

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DisposableStoreImpl : DisposableStore {

    var compositeDisposable: CompositeDisposable? = null

    override fun dispose() {
        getDisposable().dispose()
    }

    override fun add(disposable: Disposable) {
        getDisposable().add(disposable)
    }

    private fun getDisposable(): CompositeDisposable {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        return compositeDisposable!!
    }

}