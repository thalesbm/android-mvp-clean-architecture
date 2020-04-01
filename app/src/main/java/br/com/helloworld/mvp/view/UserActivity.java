package br.com.helloworld.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.helloworld.mvp.R;
import br.com.helloworld.mvp.model.UserModel;
import br.com.helloworld.mvp.interactor.UserInteractorImpl;
import br.com.helloworld.mvp.presenter.UserPresenterImpl;
import br.com.helloworld.mvp.provider.UserProviderImpl;

/**
 * @author thales.bm92@gmail.com
 * @description The Activity will be responsible just to display the information that came from the
 * presenter, you will not write any business logic here, all the actions will call the interactor
 */
public class UserActivity extends AppCompatActivity implements IUserView {
    private final String TAG = UserActivity.class.getSimpleName();

    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        this.init();
        this.initEvents();
    }

    // -----------------------
    // INIT METHODS
    // -----------------------

    private void init() {
        mBtnStart = findViewById(R.id.button);
    }

    private void initEvents() {
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedButton();
            }
        });
    }

    // -----------------------
    // ACTION METHODS
    // -----------------------

    private void pressedButton() {
        Log.d(TAG, "UserActivity::pressedButton()");

        UserInteractorImpl interactor = new UserInteractorImpl(new UserPresenterImpl(this), new UserProviderImpl());
        interactor.saveUser(this.setUser());
    }

    // -----------------------
    // CALLBACK METHODS
    // -----------------------

    @Override
    public void showSuccessfulMessage() {
        Log.e(TAG, "UserActivity::showSuccessfulMessage()");

        Toast.makeText(this, "showSuccessfulMessage()", Toast.LENGTH_LONG).show();
    }


    @Override
    public void showUnsuccessfulMessage() {
        Log.e(TAG, "UserActivity::showUnsuccessfulMessage()");

        Toast.makeText(this, "showUnsuccessfulMessage()", Toast.LENGTH_LONG).show();
    }

    /**
     * This method simulates the information you got from the XML
     *
     * @return User
     */
    private UserModel setUser() {
        final UserModel user = new UserModel();
        user.setEmail("thales.bm92@gmail.com");
        user.setId(1L);
        user.setName("Thales");
        user.setAge(27);
        user.setSurname("Bertolini Marega");
        return user;
    }
}
