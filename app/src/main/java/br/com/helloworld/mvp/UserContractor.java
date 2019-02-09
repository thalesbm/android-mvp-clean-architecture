package br.com.helloworld.mvp;

import br.com.helloworld.mvp.entity.User;

/**
 * @author thales.bm92@gmail.com
 */
public interface UserContractor {

    interface View {
        void showSuccessfulMessage();

        void showUnsuccessfulMessage();
    }

    interface Presenter {
        void savedUserSuccessful();

        void savedUserUnsuccessful();
    }

    interface Interactor {
        void saveUser(User user);
    }

    interface Provider {
        void saveUser(User user, InitCallback callback);
    }
}
