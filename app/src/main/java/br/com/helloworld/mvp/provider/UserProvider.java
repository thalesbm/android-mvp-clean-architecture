package br.com.helloworld.mvp.provider;

import android.util.Log;

import java.util.Random;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.entity.User;

/**
 * @author thales.bm92@gmail.com
 * @description The provider is responsible to call the REST server and get the response
 */
public class UserProvider implements UserContractor.Provider {
    private final String TAG = UserProvider.class.getSimpleName();

    @Override
    public void saveUser(User user, InitCallback callback) {
        Log.d(TAG, "UserProvider::saveUser()");

        Random random = new Random();

        if (random.nextBoolean()) {
            // user was saved with success

            Log.d(TAG, "UserProvider::saveUser()::nextBoolean == true");

            callback.onSuccessful();
        } else {
            // it was not possible to save the user

            Log.d(TAG, "UserProvider::saveUser()::nextBoolean == false");

            callback.onUnsuccessful();
        }
    }
}