package oo.max.vatmonitor3.bl.nip

import oo.max.vatmonitor3.bl.nip.model.NipData
import oo.max.vatmonitor3.core.error.ApiError
import oo.max.vatmonitor3.core.error.ApiException
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NipDataRepositoryApiImpl @Inject constructor(
    private val mfApiClient: MFApiClient
) : NipDataRepository {

    companion object {
        val apiDateOnlyFormat = DateTimeFormat.forPattern("yyyy-MM-dd")
    }

    override fun getNipDataForToday(nip: String): NipData {
        val today = apiDateOnlyFormat.print(DateTime.now())
        val response = mfApiClient.getNipData(nip, today).execute()
        if(!response.isSuccessful) {
            throw ApiException(ApiError.ServerError)
        }
        response.body()?.result?.subject?.let {
            return it
        }
        throw ApiException(ApiError.ServerError)
    }

}

interface NipDataRepository {
    fun getNipDataForToday(nip: String): NipData
}