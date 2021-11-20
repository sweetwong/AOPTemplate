package sweet.wong.kaptdemo

import sweet.wong.api.ExportedServiceImpl

@ExportedServiceImpl(values = [IAccountManager::class])
class AccountManager {
}