package sweet.wong.kaptdemo

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class FtTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs), INNProperties {

    override val skinMode: Int
        get() = TODO("Not yet implemented")

    override val fontLevel: Int
        get() = TODO("Not yet implemented")

}