package br.com.helloworld.mvp.interactor;

import android.util.Log;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.entity.User;
import br.com.helloworld.mvp.presenter.UserPresenter;
import br.com.helloworld.mvp.provider.UserProvider;

/**
 * @author thales.bm92@gmail.com
 * @description The Interactor will be responsible for all the business logic and to call the provider,
 * get the callback and call the presenter
 */
public class UserInteractor implements UserContractor.Interactor {
    private final String TAG = UserInteractor.class.getSimpleName();

    private final UserContractor.Presenter mPresenter;
    private final UserProvider mProvider;

    public UserInteractor(UserPresenter presenter) {
        this.mPresenter = presenter;
        this.mProvider = new UserProvider();
    }

    @Override
    public void saveUser(User user) {
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
