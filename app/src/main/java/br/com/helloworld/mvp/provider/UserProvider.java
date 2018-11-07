package br.com.helloworld.mvp.provider;

import android.util.Log;

import java.util.Random;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.entity.User;

/**
 * @author thales.bm92@gmail.com
 */
public class UserProvider implements UserContractor.Provider {
    private final String TAG = UserProvider.class.getSimpleName();

    private final InitCallback mCallback;

    public UserProvider(InitCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void saveUser(User user) {

        // TODO: salva o usuario em algum lugar

        Log.d(TAG, "UserProvider::saveUser()");

        Random random = new Random();

        if (random.nextBoolean()) {
            Log.d(TAG, "UserProvider::saveUser()::nextBoolean==true");
            mCallback.onSuccessful();
        } else {
            Log.d(TAG, "UserProvider::saveUser()::nextBoolean==false");
            mCallback.onUnsuccessful();
        }
    }
}