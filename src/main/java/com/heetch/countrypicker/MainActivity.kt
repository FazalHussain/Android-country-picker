package com.heetch.countrypicker

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ListPopupWindow.MATCH_PARENT
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showCountryDialog()
    }

    /**
     * Show Country Dialog and select country
     */
    private fun showCountryDialog() {
        val typeFace = ResourcesCompat.getFont(this, R.font.avenir_heavy)
        val countryPicker =
                CountryPickerDialog(this,
                        CountryPickerCallbacks { country, flagResId ->
                            countryPickerTv.text = country?.dialingCode.toString()
                        }, typeFace)
        countryPicker.show()
        val window: Window? = countryPicker.window
        window?.setLayout(MATCH_PARENT, MATCH_PARENT)
    }
}