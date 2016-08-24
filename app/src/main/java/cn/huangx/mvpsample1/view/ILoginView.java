package cn.huangx.mvpsample1.view;

/**
 * Created by huangx on 2016/8/24.
 */
public interface ILoginView {
    /**
     * 从UI中获取用户输入的用户名
     *
     * @return
     */
    String getUsername();

    /**
     * 从UI中获取用户输入的密码
     *
     * @return
     */
    String getPassword();

    /**
     * 显示加loading
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * 取消loading显示
     */
    void hideLoading();

    /**
     * 显示结果
     *
     * @param result
     */
    void showResult(String result);
}
