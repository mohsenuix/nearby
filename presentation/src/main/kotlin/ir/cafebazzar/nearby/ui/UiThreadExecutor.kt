package ir.cafebazzar.nearby.ui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import ir.cafebazzar.nearby.domain.executor.PostExecutionThread


/**
 * provides Ui thread for [io.reactivex]
 */

class UiThreadExecutor : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
