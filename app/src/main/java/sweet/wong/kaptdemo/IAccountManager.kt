package sweet.wong.kaptdemo

import sweet.wong.api.ExportedServiceApi

@ExportedServiceApi
interface IAccountManager {

    fun login(account: String?, password: String?)

}