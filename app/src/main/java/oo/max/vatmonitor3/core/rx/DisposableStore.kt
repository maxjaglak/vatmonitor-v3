package oo.max.vatmonitor3.core.rx

import io.reactivex.disposables.Disposable

interface DisposableStore {
    fun add(disposable: Disposable)
    fun dispose()
}