package sweet.wong.kaptdemo

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class FtButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatButton(context, attrs), INNProperties {

    override val skinMode: Int
        get() = TODO("Not yet implemented")

    override val fontLevel: Int
        get() = TODO("Not yet implemented")
}