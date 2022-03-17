package dev.atharvakulkarni.e_commerce.viewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import dev.atharvakulkarni.e_commerce.BR;
import dev.atharvakulkarni.e_commerce.model.User;

public class SignUpViewModel extends BaseObservable {
    public static final String TAG = "SignUpViewModel";
    private FirebaseAuth mAuth;

    private String mName;
    private String mEmail;
    private String mPassword;
    private String mRePassword;
    private SignUpViewModelCallbacks mCallbacks;

    private User mUser;

    public SignUpViewModel(SignUpViewModelCallbacks callBacks)
    {
        this.mCallbacks = callBacks;
    }

    public interface SignUpViewModelCallbacks{
        public void onSignInLabelClick();
        public void onSignUpSuccess();
        public void onSignUpFailure();
    }
    public void onSignInTextClicked()
    {
        mCallbacks.onSignInLabelClick();
    }

    public void onSignUpButtonClick() {
        if (mRePassword.equals(mPassword)) {
            mUser = new User(getName(), getEmail(), getPassword());
            if (mUser.isValidEmail() && mUser.isValidPassword()) {
                mAuth = mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(mUser.getEmail(), mUser.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mCallbacks.onSignUpSuccess();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            mCallbacks.onSignUpFailure();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
            }
        }
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
        notifyPropertyChanged(BR.email);

    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
        notifyPropertyChanged(BR.password);

    }

    @Bindable
    public String getRePassword() {
        return mRePassword;
    }

    public void setRePassword(String rePassword) {
        mRePassword = rePassword;
        notifyPropertyChanged(BR.rePassword);

    }
}
