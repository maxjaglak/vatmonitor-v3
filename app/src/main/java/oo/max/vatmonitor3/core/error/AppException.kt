package oo.max.vatmonitor3.core.error

import oo.max.vatmonitor3.R
import java.lang.RuntimeException

class ApiException(val apiError: ApiError): RuntimeException() {}

enum class ApiError(val resourceId: Int) {
    GeneralError(R.string.error_general),
    ServerError(R.string.bad_server_response)
}