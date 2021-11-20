package sweet.wong.kaptdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sweet.wong.api.ExportedServiceImpl

@ExportedServiceImpl(values = [IAccountManager::class])
class MainActivity : AppCompatActivity() {

    private var count = 0

    private val pair = Pair("Good", "Boy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        println("You are")
    }

}