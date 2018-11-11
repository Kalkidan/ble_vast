package com.blevast.motion.di.module;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public interface ViewModelFactory {

    /**
     * Creates a new instance of the given {@code Class}.
     * <p>
     *
     * @param modelClass a {@code Class} whose instance is requested
     * @param <T>        The type parameter for the ViewModel.
     * @return a newly created ViewModel
     */
    @NonNull
    <T extends ViewModel> T create(@NonNull Class<T> modelClass);
}
