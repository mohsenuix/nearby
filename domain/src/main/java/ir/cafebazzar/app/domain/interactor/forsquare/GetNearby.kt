package ir.cafebazzar.app.domain.interactor.forsquare

import io.reactivex.Single
import ir.cafebazzar.app.domain.entity.LatLng
import ir.cafebazzar.app.domain.entity.VenueModel
import ir.cafebazzar.app.domain.executor.PostExecutionThread
import ir.cafebazzar.app.domain.executor.UseCaseExecutor
import ir.cafebazzar.app.domain.interactor.SingleUseCase
import ir.cafebazzar.app.domain.repository.DataLayerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNearby @Inject
constructor(useCaseExecutor: UseCaseExecutor, postExecutionThread: PostExecutionThread,
            dataLayerRepository: DataLayerRepository)
    : SingleUseCase<List<VenueModel>, LatLng>(useCaseExecutor,
        postExecutionThread, dataLayerRepository) {
    override fun interact(params: LatLng?): Single<List<VenueModel>> {
        return dataLayerRepository.getNearbyVenues("${params?.lat},${params?.lng}")
    }
}