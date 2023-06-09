package com.app.giffy.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.giffy.*
import kotlinx.android.synthetic.main.fragment_setting_list.*



class SettingListFragment : Fragment() {
    companion object {
        private const val SOURCE_CODE_URL = "https://github.com/"
        private const val KINGS_CUP_PACKAGE_NAME = "org.telegram.messenger"
        private const val SQUARK_PACKAGE_NAME = "com.facebook.katana"

        fun newInstance() = SettingListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLayouts()
        setupListeners()
    }

    private fun setupLayouts() {
        val versionName = BuildConfig.VERSION_NAME
        val versionCode = BuildConfig.VERSION_CODE

        this.buildNumberTextView.text = getString(R.string.message_build_version_name, versionName, versionCode)
    }

    private fun setupListeners() {
        val context = this.context ?: return

        this.kingscupViewGroup.setOnClickListener {
            context.launchPlayStore(KINGS_CUP_PACKAGE_NAME)
        }

        this.squarkViewGroup.setOnClickListener {
            context.launchPlayStore(SQUARK_PACKAGE_NAME)
        }

        this.sourceCodeButton.setOnClickListener {
            context.launchWebsite(SOURCE_CODE_URL)
        }

        this.creditButton.setOnClickListener {
            launchCreditFragment()
        }

        this.supportButton.setOnClickListener {
            context.launchPlayStore(context.packageName)
        }

        this.shareButton.setOnClickListener {
            context.shareAppIntent("HEY")
        }

        this.backButton.setOnClickListener {
            this.activity?.supportFragmentManager?.popBackStack()
        }
    }

    private fun launchCreditFragment() {
        val creditFragment = SettingCreditDetailFragment.newInstance()
        this.activity?.apply {
            supportFragmentManager.beginTransaction()
                .replace(R.id.routingContainer, creditFragment, creditFragment.javaClass.simpleName)
                .addToBackStack(creditFragment.javaClass.simpleName)
                .commit()
        }
    }
}