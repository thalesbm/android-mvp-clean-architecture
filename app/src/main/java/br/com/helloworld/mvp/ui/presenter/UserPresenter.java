package br.com.helloworld.mvp.ui.presenter;

import android.util.Log;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.data.UserRepository;
import br.com.helloworld.mvp.entity.User;

/**
 * @author thales.bm92@gmail.com
 */
public class UserPresenter implements UserContractor.Presenter {
    private final String TAG = UserPresenter.class.getSimpleName();

    private final InitCallback mCallback;
    private final UserContractor.View mView;

    public UserPresenter(InitCallback callback, UserContractor.View view) {
        this.mCallback = callback;
        this.mView = view;
    }

    @Override
    public void saveUser(User user) {
        Log.d(TAG, "UserPresenter::saveUser()");

        if (user.getName().isEmpty() || user.getSurname().isEmpty() || user.getEmail().isEmpty()) {
            mView.showErrorMessage();
        } else {

            UserContractor.Repository repository = new UserRepository(new InitCallback() {
                @Override
                public void onSuccessful() {
                    Log.d(TAG, "UserPresenter::saveUser()::onSuccessful()");
                    mCallback.onSuccessful();
                }

                @Override
                public void onUnsuccessful() {
                    Log.e(TAG, "UserPresenter::saveUser()::onUnsuccessful()");
                    mCallback.onUnsuccessful();
                }
            });
            repository.saveUser(user);
        }
    }
}
