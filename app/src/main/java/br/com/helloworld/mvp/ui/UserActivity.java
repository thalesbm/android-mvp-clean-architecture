package br.com.helloworld.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.helloworld.mvp.R;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.entity.User;
import br.com.helloworld.mvp.interactor.UserInteractor;
import br.com.helloworld.mvp.presenter.UserPresenter;

/**
 * @author thales.bm92@gmail.com
 * @description The Activity will be responsible just to display the information that came from the
 * presenter, you will not write any business logic here, all the actions will call the interactor
 */
public class UserActivity extends AppCompatActivity implements UserContractor.View {
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

        UserInteractor interactor = new UserInteractor(new UserPresenter(this));
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
    private User setUser() {
        final User user = new User();
        user.setEmail("thales.bm92@gmail.com");
        user.setId(1L);
        user.setName("Thales");
        user.setSurname("Bertolini Marega");
        return user;
    }
}
