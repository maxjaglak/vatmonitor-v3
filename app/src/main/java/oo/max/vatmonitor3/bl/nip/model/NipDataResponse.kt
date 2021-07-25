package oo.max.vatmonitor3.bl.nip.model

data class NipDataResponse(
    var result: Result? = null
)

data class Result(
    var subject: NipData? = null,
    var requestId: String? = null,
    var requestDateTime: String? = null,
)

data class NipData(
    var name: String? = null,
    var nip: String? = null,
    var statusVat: String? = null,
    var regon: String? = null,
    var krs: String? = null,
    var residentialAddress: String? = null,
    var workingAddress: String? = null,
    var registrationLegalDate: String? = null,
    var accountNumbers: List<String>? = null,
    var hasVirtualAccounts: String? = null,
)