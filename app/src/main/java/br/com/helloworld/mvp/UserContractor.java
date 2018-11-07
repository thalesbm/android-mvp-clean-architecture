package br.com.helloworld.mvp;

import br.com.helloworld.mvp.entity.User;

public interface UserContractor {

    interface View {
        void showErrorMessage();
    }

    interface Presenter {
        void saveUser(User user);
    }

    interface Repository {
        void saveUser(User user);
    }

    interface Provider {
        void saveUser(User user);
    }
}
