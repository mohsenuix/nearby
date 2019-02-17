package ir.cafebazzar.nearby.domain.interactor

import io.reactivex.Scheduler
import io.reactivex.Single
import ir.cafebazzar.nearby.domain.executor.PostExecutionThread
import ir.cafebazzar.nearby.domain.executor.UseCaseExecutor

/**
 * Each [UseCase] of the system orchestrate the flow of data to and from the entities.
 * Outer layers of system can execute use cases by calling [execute]} method.
 * ALso you can use [useCaseExecutor] to execute the job in a background thread and
 * [postExecutionThread] to post the result to another thread(UI thread).
 * @param Responses response type for use case.
 * @param Params input parameters for use case
 */
abstract class UseCase<Responses, Params>(protected val useCaseExecutor: UseCaseExecutor,
                                          protected val postExecutionThread: PostExecutionThread) {

    private fun getUseCaseExecutor(): Scheduler {
        return useCaseExecutor.scheduler
    }

    private fun getPostExecutionThread(): Scheduler {
        return postExecutionThread.scheduler
    }

    fun <T> Single<T>.applySchedulers(): Single<T> {
        return subscribeOn(getUseCaseExecutor()).observeOn(getPostExecutionThread())
    }
}

