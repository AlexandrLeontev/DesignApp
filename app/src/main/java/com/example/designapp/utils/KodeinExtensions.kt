package com.example.designapp.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.on
import com.example.designapp.ViewModelFactory

inline fun <reified VM : ViewModel, T> T.activityScopedFragmentViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return viewModels(ownerProducer = { requireParentFragment() },
        factoryProducer = { getFactoryInstance() })
}

inline fun <reified VM : ViewModel, T> T.fragmentViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return viewModels(factoryProducer = { getFactoryInstance() })
}

inline fun <reified VM : ViewModel> Kodein.Builder.bindViewModel(overrides: Boolean? = null): Kodein.Builder.TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, overrides)
}

fun <T> T.getFactoryInstance(): ViewModelProvider.Factory where T : KodeinAware, T : Fragment {
    val viewModeFactory: ViewModelFactory by kodein.on(activity).instance()
    return viewModeFactory
}