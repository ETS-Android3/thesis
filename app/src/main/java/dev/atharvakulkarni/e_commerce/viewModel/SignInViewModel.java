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

public class SignInViewModel extends BaseObservable {
    public static final String TAG = SignInViewModel.class.getSimpleName();

    private String mEmail;
    private String mPassword;

    private SignInViewModelCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    private User mUser;

    public interface SignInViewModelCallbacks{
        public void onSignInSuccess();
        public void onSignInFailure();
        public void onSignUpLabelClick();
    }

    public SignInViewModel(SignInViewModelCallbacks callBacks) {
        this.mCallbacks = callBacks;
    }
    public void onSignUpTextClicked(){
        mCallbacks.onSignUpLabelClick();
    }

    public void onSignInButtonClick() {
        mUser = new User(getEmail(),getPassword());
        if(mUser.isValidEmail()&& mUser.isValidPassword())
        {
            //perform firebase auth
            //if success start main/home activity
            //else show message user name or password is error
            mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(mUser.getEmail(), mUser.getPassword())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                mCallbacks.onSignInSuccess();
//                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                mCallbacks.onSignInFailure();
//                                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
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
}
