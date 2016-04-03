package licenta.socializer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import licenta.socializer.R;
import licenta.socializer.WiFiServiceDiscoveryActivity;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Madalina on 01.03.2016.
 */
public class LoginFragment extends Fragment{

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    @Bind(R.id.emailWrapper) TextInputLayout emailWrapper;
    @Bind(R.id.passwordWrapper) TextInputLayout passwordWrapper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnLogin)
    public void handleLogin() {
        String email = emailWrapper.getEditText().getText().toString();
        String password = passwordWrapper.getEditText().getText().toString();
        if (!validateEmail(email)) {
            emailWrapper.setError("Not a valid email address!");
        } else if (!validatePassword(password)) {
            emailWrapper.setErrorEnabled(false);
            passwordWrapper.setError("Not a valid password!");
        } else {
            emailWrapper.setErrorEnabled(false);
            passwordWrapper.setErrorEnabled(false);
            doLogin();
        }
    }

    @OnClick(R.id.btnRegister)
    public void handleRegister() {
        Intent registerIntent = new Intent(getActivity(), RegisterAccountActivity.class);
        startActivity(registerIntent);
    }

    @OnClick(R.id.btnLocation)
    public void handleLocation() {
        Intent registerIntent = new Intent(getActivity(), DeviceLocation.class);
        startActivity(registerIntent);
    }

    @OnClick(R.id.forgotPassword)
    public void resetPassword() {
        Toast.makeText(getActivity(), "Reset password!", LENGTH_SHORT).show();
    }

    public boolean validateEmail(String email) {
        boolean validator = false;
        matcher = pattern.matcher(email);
        if (matcher.matches()){
            validator=true;
        }
        return validator;
    }

    public boolean validatePassword(String password) {
        boolean validator = false;
        if (password.length() > 5){
            validator=true;
        }
        return validator;
    }

    public void doLogin() {
        Intent serviceDiscoveryIntent = new Intent(getActivity(), WiFiServiceDiscoveryActivity.class);
        startActivity(serviceDiscoveryIntent);
    }
}
