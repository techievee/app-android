package org.coepi.android.ui.common

import com.tapadoo.alerter.OnHideAlertListener

sealed class UINotificationData(open val message: String, open val onHideAlertListener: OnHideAlertListener = OnHideAlertListener {  }) {
    data class Success(override val message: String, override val onHideAlertListener: OnHideAlertListener): UINotificationData(message, onHideAlertListener)
    data class Failure(override val message: String): UINotificationData(message)
}
