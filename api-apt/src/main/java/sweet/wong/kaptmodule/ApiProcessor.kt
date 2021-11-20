package sweet.wong.kaptmodule

import com.google.auto.service.AutoService
import sweet.wong.api.ExportedServiceImpl
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

@AutoService(Processor::class)
class ApiProcessor : AbstractProcessor() {

    private lateinit var filer: Filer
    private lateinit var messager: Messager
    private lateinit var utils: Elements

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        filer = processingEnv.filer
        messager = processingEnv.messager
        utils = processingEnv.elementUtils
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        println("getSupportedAnnotationTypes")
        return mutableSetOf(ExportedServiceImpl::class.java.name)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        println("getSupportedSourceVersion")
        return SourceVersion.latestSupported()
    }

    override fun process(set: MutableSet<out TypeElement>, env: RoundEnvironment): Boolean {
        val elements = env.getElementsAnnotatedWith(ExportedServiceImpl::class.java)
        elements.forEach { element ->
            if (element !is TypeElement) return@forEach

            println("Good")
        }
        return true
    }

}