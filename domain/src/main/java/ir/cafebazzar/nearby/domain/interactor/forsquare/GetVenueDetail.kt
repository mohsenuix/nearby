package ir.cafebazzar.nearby.domain.interactor.forsquare
import io.reactivex.Single
import ir.cafebazzar.nearby.domain.entity.VenueModel
import ir.cafebazzar.nearby.domain.executor.PostExecutionThread
import ir.cafebazzar.nearby.domain.executor.UseCaseExecutor
import ir.cafebazzar.nearby.domain.interactor.SingleUseCase
import ir.cafebazzar.nearby.domain.repository.DataLayerRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetVenueDetail @Inject
constructor(useCaseExecutor: UseCaseExecutor, postExecutionThread: PostExecutionThread,
            dataLayerRepository: DataLayerRepository)
    : SingleUseCase<List<VenueModel>, String>(useCaseExecutor,
        postExecutionThread, dataLayerRepository) {
    override fun interact(params: String?): Single<List<VenueModel>> {
        return dataLayerRepository.getVenueDetails(params!!)
    }
}