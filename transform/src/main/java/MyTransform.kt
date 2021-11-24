import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils
import org.apache.commons.codec.digest.DigestUtils

/**
 * 参考 [Gradle Plugin: Transform + Javassist 编译期操作Class文件](https://www.jianshu.com/p/882325acd200)
 */
class MyTransform : Transform() {

    override fun getName(): String {
        return "MyTransform"
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun transform(invocation: TransformInvocation) {
        val inputs = invocation.inputs
        val outputProvider = invocation.outputProvider

        inputs.forEach { input ->
            input.directoryInputs.forEach { dirInput ->
                val dest = outputProvider.getContentLocation(
                    dirInput.name,
                    dirInput.contentTypes,
                    dirInput.scopes,
                    Format.DIRECTORY
                )
                FileUtils.copyDirectory(dirInput.file, dest)
            }
            input.jarInputs.forEach { jarInput ->
                // 重命名输出文件（同目录 copyFile 会冲突）
                var jarName = jarInput.name
                if (jarName.endsWith(".jar")) {
                    jarName = jarName.substring(0, jarName.length - 4)
                }
                val md5Name = DigestUtils.md5Hex(jarInput.file.absolutePath)

                val dest = outputProvider.getContentLocation(
                    jarName + md5Name,
                    jarInput.contentTypes,
                    jarInput.scopes,
                    Format.JAR
                )

                FileUtils.copyFile(jarInput.file, dest)
            }
        }

    }

}