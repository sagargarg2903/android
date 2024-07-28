package me.amitshekhar.dagger.compiler

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import me.amitshekhar.dagger.Component
import java.io.File
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

class Processor : AbstractProcessor() {

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(Component::class.java.canonicalName)
    }

    override fun process(
        annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment
    ): Boolean {
        val kaptKotlinGeneratedDir = processingEnv.options["kapt.kotlin.generated"] ?: return false
        roundEnv.getElementsAnnotatedWith(Component::class.java).forEach {
            val packageName = processingEnv.elementUtils.getPackageOf(it).toString()
            val interfaceName = it.simpleName.toString()
            val className = "Dagger${interfaceName}"
            val typeSpec = TypeSpec.classBuilder(ClassName(packageName, className)).build()
            FileSpec.builder(packageName, className)
                .addType(typeSpec).build()
                .writeTo(File(kaptKotlinGeneratedDir))
        }
        return true
    }
}