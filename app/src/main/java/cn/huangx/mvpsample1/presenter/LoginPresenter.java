package cn.huangx.mvpsample1.presenter;

import cn.huangx.mvpsample1.model.Callback;
import cn.huangx.mvpsample1.model.IUserModel;
import cn.huangx.mvpsample1.view.ILoginView;

/**
 * Created by huangx on 2016/8/24.
 */
public class LoginPresenter implements ILoginPresenter {

    private ILoginView loginView;
    private IUserModel userModel;

    public LoginPresenter(ILoginView loginView, IUserModel userModel) {
        this.loginView = loginView;
        this.userModel = userModel;
    }

    /**
     * 登录
     */
    @Override
    public void login() {
        loginView.showLoading("登录中...");
        userModel.login(loginView.getUsername(), loginView.getPassword(), new Callback() {
            @Override
            public void onSuccess() {
                loginView.hideLoading();
                loginView.showResult("登录成功");
            }

            @Override
            public void onFailure(String errorMsg) {
                loginView.hideLoading();
                loginView.showResult(errorMsg);
            }
        });
    }
}
