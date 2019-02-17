package ir.cafebazzar.nearby.data.extractor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import ir.cafebazzar.nearby.domain.executor.UseCaseExecutor


/**
 * provides background thread to prevent locking ui when calling network api
 */

class NetworkJobExecutor : UseCaseExecutor {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}
