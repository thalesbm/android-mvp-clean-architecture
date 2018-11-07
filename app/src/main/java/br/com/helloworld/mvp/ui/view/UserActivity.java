package br.com.helloworld.mvp.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.R;
import br.com.helloworld.mvp.UserContractor;
import br.com.helloworld.mvp.entity.User;
import br.com.helloworld.mvp.ui.presenter.UserPresenter;

/**
 * @author thales.bm92@gmail.com
 */
public class UserActivity extends AppCompatActivity implements UserContractor.View {
    private final String TAG = UserActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedButton();
            }
        });
    }

    private void pressedButton() {
        User user = this.setUser();

        Log.d(TAG, "UserActivity::pressedButton()");
        UserContractor.Presenter presenter = new UserPresenter(new InitCallback() {
            @Override
            public void onSuccessful() {
                Log.d(TAG, "UserActivity::pressedButton()::onSuccessful()");
                Toast.makeText(UserActivity.this, "onSuccessful()", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onUnsuccessful() {
                Log.e(TAG, "UserActivity::pressedButton()::onUnsuccessful()");
                Toast.makeText(UserActivity.this, "onUnsuccessful()", Toast.LENGTH_LONG).show();
            }
        }, this);
        presenter.saveUser(user);
    }

    @Override
    public void showErrorMessage() {
        Log.e(TAG, "UserActivity::showErrorMessage()");
        Toast.makeText(this, "Usuario invalido", Toast.LENGTH_LONG).show();
    }

    private User setUser(){
        final User user = new User();
        user.setEmail("thales.bm92@gmail.com");
        user.setId(1L);
        user.setName("Thales");
        user.setSurname("Bertolini Marega");
        return user;
    }
}
