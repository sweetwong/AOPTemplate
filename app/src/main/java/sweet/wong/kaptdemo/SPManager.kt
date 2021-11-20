package sweet.wong.kaptdemo

import android.content.SharedPreferences
import sweet.wong.api.ExportedServiceImpl

@ExportedServiceImpl(values = [ISPManager::class])
class SPManager : ISPManager {

    override fun getSharedPreferences(): SharedPreferences {
        TODO("Not yet implemented")
    }
}