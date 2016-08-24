package cn.huangx.mvpsample1.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.huangx.mvpsample1.R;
import cn.huangx.mvpsample1.model.UserModel;
import cn.huangx.mvpsample1.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText username;
    private EditText password;
    private ProgressDialog progressDialog;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        presenter = new LoginPresenter(this, new UserModel());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                presenter.login();
                break;
        }
    }

    /**
     * 从UI中获取用户输入的用户名
     *
     * @return
     */
    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    /**
     * 从UI中获取用户输入的密码
     *
     * @return
     */
    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    /**
     * 显示加loading
     *
     * @param msg
     */
    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    /**
     * 取消loading显示
     */
    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /**
     * 显示结果
     *
     * @param result
     */
    @Override
    public void showResult(String result) {
        Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}
