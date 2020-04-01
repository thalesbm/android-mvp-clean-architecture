package br.com.helloworld.mvp.interactor;

import android.util.Log;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.model.UserModel;
import br.com.helloworld.mvp.presenter.IUserPresenter;
import br.com.helloworld.mvp.provider.IUserProvider;

/**
 * @author thales.bm92@gmail.com
 * @description The Interactor will be responsible for all the business logic and to call the provider,
 * get the callback and call the presenter
 */
public class UserInteractorImpl implements IUserInteractor {
    private final String TAG = UserInteractorImpl.class.getSimpleName();

    private final IUserPresenter mPresenter;
    private final IUserProvider mProvider;

    public UserInteractorImpl(IUserPresenter presenter, IUserProvider provider) {
        this.mPresenter = presenter;
        this.mProvider = provider;
    }

    @Override
    public void saveUser(UserModel user) {
        Log.d(TAG, "UserInteractor::saveUser()");

        mProvider.saveUser(user, new InitCallback() {
            @Override
            public void onSuccessful() {
                mPresenter.savedUserSuccessful();
            }

            @Override
            public void onUnsuccessful() {
                mPresenter.savedUserUnsuccessful();
            }
        });
    }
}
