package ir.cafebazzar.nearby.domain.interactor

import io.reactivex.Single
import ir.cafebazzar.nearby.domain.executor.PostExecutionThread
import ir.cafebazzar.nearby.domain.executor.UseCaseExecutor
import ir.cafebazzar.nearby.domain.repository.DataLayerRepository


/**
 * @param Responses The response value emitted by the Observable.
 * @param Params The request value.
 */
abstract class SingleUseCase<Responses, Params>(useCaseExecutor: UseCaseExecutor,
                                                postExecutionThread: PostExecutionThread,
                                                protected var dataLayerRepository: DataLayerRepository) :
        UseCase<Single<Responses>, Params>(useCaseExecutor, postExecutionThread) {

    open fun execute(params: Params?): Single<Responses> {
        return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params?): Single<Responses>

}

