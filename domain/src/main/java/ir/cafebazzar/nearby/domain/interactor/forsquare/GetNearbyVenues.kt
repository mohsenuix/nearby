package ir.cafebazzar.nearby.domain.interactor.forsquare

import io.reactivex.Single
import ir.cafebazzar.nearby.domain.entity.LatLng
import ir.cafebazzar.nearby.domain.entity.VenueModel
import ir.cafebazzar.nearby.domain.executor.PostExecutionThread
import ir.cafebazzar.nearby.domain.executor.UseCaseExecutor
import ir.cafebazzar.nearby.domain.interactor.SingleUseCase
import ir.cafebazzar.nearby.domain.repository.DataLayerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNearbyVenues @Inject
constructor(useCaseExecutor: UseCaseExecutor, postExecutionThread: PostExecutionThread,
            dataLayerRepository: DataLayerRepository)
    : SingleUseCase<List<VenueModel>, LatLng>(useCaseExecutor,
        postExecutionThread, dataLayerRepository) {
    override fun interact(params: LatLng?): Single<List<VenueModel>> {
        return dataLayerRepository.getNearbyVenues("${params?.lat},${params?.lng}")
    }
}