package com.app.giffy.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.giffy.R
import com.app.giffy.launchWebsite
import kotlinx.android.synthetic.main.fragment_setting_credit_detail.*



class SettingCreditDetailFragment : Fragment() {
    companion object {
        fun newInstance() = SettingCreditDetailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting_credit_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        val context = this.context ?: return

        this.leagueImageView.setOnClickListener {
            context.launchWebsite("https://github.com/bravobit/FFmpeg-Android")
        }

        this.bravobitImageView.setOnClickListener {
            context.launchWebsite("https://github.com/bravobit/FFmpeg-Android")
        }

        this.backButton.setOnClickListener {
            this.activity?.supportFragmentManager?.popBackStack()
        }
    }
}