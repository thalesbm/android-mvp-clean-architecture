package br.com.helloworld.mvp.data;

import android.util.Log;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.entity.User;
import br.com.helloworld.mvp.provider.UserProvider;

/**
 * @author thales.bm92@gmail.com
 */
public class UserRepository implements UserContractor.Repository {
    private final String TAG = UserRepository.class.getSimpleName();

    private final InitCallback mCallback;

    public UserRepository(InitCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void saveUser(User user) {
        Log.d(TAG, "UserRepository::saveUser()");

        this.checkAge(user);

        UserContractor.Provider provider = new UserProvider(new InitCallback() {
            @Override
            public void onSuccessful() {
                Log.d(TAG, "UserRepository::saveUser()::onSuccessful()");
                mCallback.onSuccessful();
            }

            @Override
            public void onUnsuccessful() {
                Log.e(TAG, "UserRepository::saveUser()::onUnsuccessful()");
                mCallback.onUnsuccessful();
            }
        });
        provider.saveUser(user);
    }

    private void checkAge(User user) {
        Log.d(TAG, "UserRepository::checkAge");
        if (user.getAge() >= 18) {
            Log.d(TAG, "UserRepository::checkAge:: >= 18");
        } else {
            Log.d(TAG, "UserRepository::checkAge:: < 18");
        }
    }
}
