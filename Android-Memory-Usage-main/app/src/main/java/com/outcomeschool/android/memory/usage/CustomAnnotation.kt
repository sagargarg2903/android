package com.outcomeschool.android.memory.usage

import java.lang.annotation.ElementType
import java.lang.annotation.ElementType.METHOD
import java.lang.annotation.RetentionPolicy


/**
 * @Author: Sagar.Garg
 * @Date: 16/07/24
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)

public annotation class CustomAnnotation(
    val priority: Priority = Priority.LOW ,
    val author: String = "Amit" ,
    val completion: Int = 0
) {
    enum class Priority {
        LOW , MEDIUM , HIGH
    }
}
