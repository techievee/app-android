package org.coepi.android.ui.common

import android.app.Activity
import com.tapadoo.alerter.Alerter.Companion.create
import com.tapadoo.alerter.OnHideAlertListener
import org.coepi.android.R.color.green
import org.coepi.android.R.color.red
import org.coepi.android.R.style.Text_Alert
import org.coepi.android.ui.common.UINotificationData.Failure
import org.coepi.android.ui.common.UINotificationData.Success

class UINotification {
    fun show(notification: UINotificationData, activity: Activity) {
        when (notification) {
            is Success ->
                successAlert(notification.message, activity, notification.onHideAlertListener)
            is Failure ->
                errorAlert(notification.message, activity)
        }.show()
    }

    private fun successAlert(message: String, activity: Activity, onHideAlertListener : OnHideAlertListener) =
        alert(message, activity, onHideAlertListener)
            .setBackgroundColorRes(green)

    private fun errorAlert(message: String, activity: Activity) =
        alert(message, activity)
//            .setTitle("Error")
            .setBackgroundColorRes(red)

    private fun alert(message: String, activity: Activity, onHideAlertListener : OnHideAlertListener = OnHideAlertListener {  }) =
        create(activity)
            .hideIcon()
            .setTitleAppearance(Text_Alert)
            .setTextAppearance(Text_Alert)
            .setOnHideListener(onHideAlertListener)
            .setText(message)
}
