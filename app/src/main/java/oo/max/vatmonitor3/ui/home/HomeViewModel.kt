package oo.max.vatmonitor3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val model: HomeModel
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = model.getLabel()
    }
    val text: LiveData<String> = _text
}