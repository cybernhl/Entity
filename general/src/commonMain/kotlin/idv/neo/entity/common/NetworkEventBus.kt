package idv.neo.entity.common

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * 用於在網路層與 UI 層之間傳遞全域網路事件的 Bus
 */
object NetworkEventBus {
    private val _errors = MutableSharedFlow<ApiResponse.Error>(extraBufferCapacity = 5)
    val errors = _errors.asSharedFlow()

    fun emitError(error: ApiResponse.Error) {
        _errors.tryEmit(error)
    }
}
