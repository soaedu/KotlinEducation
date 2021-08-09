package syntax.functions.type.lambda_func.example2

import java.util.*
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.Element
import javax.lang.model.type.ErrorType
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror
import javax.lang.model.type.TypeVisitor

fun main() {
    println("${ErrorProcessor().buildErrorDescList()}")
}

class ErrorProcessor {
    private val freshErrorId
        get() = UUID.randomUUID()

    private val ignoredErrorTypes = mutableSetOf<ErrorType>().apply {
        add(InternalError(1))
    }

    fun buildErrorDescList(): List<String> = getErrorList().filter { it.type !in ignoredErrorTypes}
                                                .map { freshErrorId to it}
                                                .map { (id, error) -> "[$id] ${error.msg}" }

    private fun getErrorList() = listOf(
            AppError(type = InternalError(1), msg = "Internal Error"),
            AppError(type = NetworkError(2), msg = "Network Error"),
            AppError(type = ServerError(3), msg = "Server Error")
    )
}

data class AppError(val type: ErrorType, val msg: String)
data class InternalError(val id: Int): ErrorType {
    override fun getKind(): TypeKind {
        TODO("Not yet implemented")
    }

    override fun <R : Any?, P : Any?> accept(v: TypeVisitor<R, P>?, p: P): R {
        TODO("Not yet implemented")
    }

    override fun getTypeArguments(): MutableList<out TypeMirror> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> getAnnotationsByType(annotationType: Class<A>?): Array<A> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> getAnnotation(annotationType: Class<A>?): A {
        TODO("Not yet implemented")
    }

    override fun asElement(): Element {
        TODO("Not yet implemented")
    }

    override fun getAnnotationMirrors(): MutableList<out AnnotationMirror> {
        TODO("Not yet implemented")
    }

    override fun getEnclosingType(): TypeMirror {
        TODO("Not yet implemented")
    }
}
data class ServerError(val id: Int): ErrorType {
    override fun getKind(): TypeKind {
        TODO("Not yet implemented")
    }

    override fun <R : Any?, P : Any?> accept(v: TypeVisitor<R, P>?, p: P): R {
        TODO("Not yet implemented")
    }

    override fun getTypeArguments(): MutableList<out TypeMirror> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> getAnnotationsByType(annotationType: Class<A>?): Array<A> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> getAnnotation(annotationType: Class<A>?): A {
        TODO("Not yet implemented")
    }

    override fun asElement(): Element {
        TODO("Not yet implemented")
    }

    override fun getAnnotationMirrors(): MutableList<out AnnotationMirror> {
        TODO("Not yet implemented")
    }

    override fun getEnclosingType(): TypeMirror {
        TODO("Not yet implemented")
    }
}
data class NetworkError(val id: Int): ErrorType {
    override fun getKind(): TypeKind {
        TODO("Not yet implemented")
    }

    override fun <R : Any?, P : Any?> accept(v: TypeVisitor<R, P>?, p: P): R {
        TODO("Not yet implemented")
    }

    override fun getTypeArguments(): MutableList<out TypeMirror> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> getAnnotationsByType(annotationType: Class<A>?): Array<A> {
        TODO("Not yet implemented")
    }

    override fun <A : Annotation?> getAnnotation(annotationType: Class<A>?): A {
        TODO("Not yet implemented")
    }

    override fun asElement(): Element {
        TODO("Not yet implemented")
    }

    override fun getAnnotationMirrors(): MutableList<out AnnotationMirror> {
        TODO("Not yet implemented")
    }

    override fun getEnclosingType(): TypeMirror {
        TODO("Not yet implemented")
    }
}