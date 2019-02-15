package ir.cafebazzar.app.domain

import kotlin.annotation.Retention
import javax.inject.Qualifier

/**
 * It is dagger's annotation's scope for application lifecycle
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ForApplication
