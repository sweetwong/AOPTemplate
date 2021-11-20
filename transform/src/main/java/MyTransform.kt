import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation

class MyTransform : Transform() {

    override fun getName(): String {
        return "MyTransform"
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return mutableSetOf(QualifiedContent.DefaultContentType.CLASSES)
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return mutableSetOf(QualifiedContent.Scope.PROJECT)
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun transform(invocation: TransformInvocation) {
        println(invocation)
        val inputs = invocation.inputs
        inputs.forEach { input ->
            input.directoryInputs.forEach { directoryInput ->
                directoryInput.file.walk().forEach { file ->
                    println(file)
                }
            }
            input.jarInputs.forEach { jarInput ->
                println(jarInput.file)
            }
        }
    }

}