package br.com.movilenext.testing

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SdkSuppress
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until
import org.hamcrest.Matchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class MainActivityAutomatorTest {
    companion object {
        private const val BASIC_SAMPLE_PACKAGE = "br.com.movilenext.testing"
        private const val LAUNCH_TIMEOUT = 5000
    }

    private lateinit var mDevice: UiDevice
    @Test
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        mDevice.pressHome()

        // Wait for launcher
        val launcherPackage = mDevice.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        mDevice.wait(
            Until.hasObject(
                By.pkg(launcherPackage).depth(0)
            ),
            LAUNCH_TIMEOUT.toLong()
        )

        // Launch the app
        val context = InstrumentationRegistry.getContext()
        val intent = context.packageManager.getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE)

        // Clear out any previous instances
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // Wait for the app to appear
        mDevice.wait(
            Until.hasObject(
                By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)
            ),
            LAUNCH_TIMEOUT.toLong()
        )
    }
}
