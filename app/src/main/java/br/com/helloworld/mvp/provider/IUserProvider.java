package br.com.helloworld.mvp.provider;

import br.com.helloworld.mvp.InitCallback;
import br.com.helloworld.mvp.model.UserModel;

/**
 * @author thales.bm92@gmail.com
 */
public interface IUserProvider {
    void saveUser(UserModel user, InitCallback callback);
}
