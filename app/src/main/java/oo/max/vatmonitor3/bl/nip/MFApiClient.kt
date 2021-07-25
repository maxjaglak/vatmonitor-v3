package oo.max.vatmonitor3.bl.nip

import io.reactivex.Single
import oo.max.vatmonitor3.bl.nip.model.NipDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MFApiClient {

    @GET("/api/search/nip/{nip}")
    fun getNipData(@Path("nip") nip: String, @Query("date") date: String): Call<NipDataResponse>

}