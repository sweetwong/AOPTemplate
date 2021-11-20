package sweet.wong.kaptdemo

import android.content.SharedPreferences

interface ISPManager {

    fun getSharedPreferences(): SharedPreferences
}