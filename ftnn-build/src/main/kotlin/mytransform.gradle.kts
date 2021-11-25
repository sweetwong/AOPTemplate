import com.android.build.gradle.BaseExtension

extensions.findByType(BaseExtension::class)?.registerTransform(MyTransform())