package oo.max.vatmonitor3.core.rx

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.ioMain(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
}

fun <T> Observable<T>.subscribeAndManageDisposable(disposableStore: DisposableStore) {
    val disposable = this.subscribe()
    disposableStore.add(disposable)
}


fun <T> Single<T>.ioMain(): Single<T> {
    return this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
}

fun Disposable.store(disposableStore: DisposableStore) {
    disposableStore.add(this)
}