package br.com.helloworld.mvp.presenter;

import android.util.Log;

import br.com.helloworld.mvp.UserContractor;

/**
 * @author thales.bm92@gmail.com
 *  @description The Presenter is responsible to do all the screen logic and call the view to display the info
 */
public class UserPresenter implements UserContractor.Presenter {
    private final String TAG = UserPresenter.class.getSimpleName();

    private final UserContractor.View mView;

    public UserPresenter(UserContractor.View view) {
        this.mView = view;
    }

    @Override
    public void savedUserSuccessful() {
        Log.d(TAG, "UserPresenter::savedUserSuccessful()");
        mView.showSuccessfulMessage();
    }

    @Override
    public void savedUserUnsuccessful() {
        Log.d(TAG, "UserPresenter::savedUserUnsuccessful()");
        mView.showUnsuccessfulMessage();
    }
}
