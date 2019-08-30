package io.github.iamyours.wandroid.ui.login

import android.os.Bundle
import androidx.lifecycle.Observer
import io.github.iamyours.wandroid.R
import io.github.iamyours.wandroid.base.BaseActivity
import io.github.iamyours.wandroid.databinding.ActivityLoginBinding
import io.github.iamyours.wandroid.extension.viewModel
import io.github.iamyours.wandroid.util.SP

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_login

    val vm by viewModel<LoginVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = vm
        vm.attachLoading(loadingState)
        vm.loginUser.observe(this, Observer {
            it?.run {
                SP.put(SP.KEY_IS_LOGIN, true)
                SP.put(SP.KEY_NICK_NAME, nickname)
                SP.put(SP.KEY_USER_NAME, username)
                finish()
            }
        })

    }
}