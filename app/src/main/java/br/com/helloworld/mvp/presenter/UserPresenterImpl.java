package br.com.helloworld.mvp.presenter;

import android.util.Log;

import br.com.helloworld.mvp.view.IUserView;

/**
 * @author thales.bm92@gmail.com
 *  @description The Presenter is responsible to do all the screen logic and call the view to display the info
 */
public class UserPresenterImpl implements IUserPresenter {
    private final String TAG = UserPresenterImpl.class.getSimpleName();

    private final IUserView mView;

    public UserPresenterImpl(IUserView view) {
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
