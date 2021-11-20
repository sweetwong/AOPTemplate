package sweet.wong.kaptdemo

import android.content.SharedPreferences
import sweet.wong.api.ExportedServiceApi

@ExportedServiceApi
interface ISPManager {

    fun getSharedPreferences(): SharedPreferences
}