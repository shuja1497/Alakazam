package com.droidco.alakazam.core

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import com.droidco.alakazam.ImagePickerActivity
import kotlin.IllegalStateException

class Alakazam {

    private var activity: Activity? = null
    private var fragment: Fragment? = null
    private var requestCode: Int = 0
    private var maxSelection: Int = 10
    private var disableCamera: Boolean = false
    private var singleSelect: Boolean = true

    fun requestCode(requestCode: Int) = apply { this.requestCode = requestCode }
    private fun maxSelection(maxSelection: Int) = apply { this.maxSelection = maxSelection }
    private fun disableCamera(disableCamera: Boolean) = apply { this.disableCamera = disableCamera }
    fun fromActivity(activity: Activity) = apply { this.activity = activity }
    fun fromFragment(fragment: Fragment) = apply { this.fragment = fragment }
    private fun singleSelect(singleSelect: Boolean) = apply { this.singleSelect = singleSelect }

    fun show() {


        if (activity == null && fragment == null) {
            throw IllegalStateException("No Activity or Fragment was passed. Function required - fromActivity or fromFragment")
        }

        val intent = Intent()
        if (activity != null) {
            startActivityForResult(activity!!, requestCode, intent)
        } else {
            startActivityForResult(fragment!!, requestCode, intent)
        }

    }

    private fun startActivityForResult(
        fragment: Fragment,
        requestCode: Int,
        intent: Intent
    ) {
        intent.setClass(fragment.context!!, ImagePickerActivity::class.java)
        fragment.startActivityForResult(intent, requestCode)
    }

    private fun startActivityForResult(
        activity: Activity,
        requestCode: Int,
        intent: Intent
    ) {
        intent.setClass(activity, ImagePickerActivity::class.java)
        activity.startActivityForResult(intent, requestCode)
    }
}