package com.recyclerviewmvvm

import com.recyclerviewmvvm.exceptions.ApiException
import retrofit2.Response
import java.io.IOException

/**
 * Project Name :RecyclerViewMvvm
 * Created By :Himanshu sharma on 27-02-2021
 * Package : com.recyclerviewmvvm
 */
abstract class SafeApiRequest {

    // a suspend function of type Generic will return type T
    // This apiRequest function takes another functionas a  parameter
    // This function is api call which we want to execute and it is a suspend function which gives aResponse of type T
    suspend fun <T:Any> apiRequest(call : suspend ()->Response<T>) : T? {
        val response=call.invoke()
        if (response.isSuccessful){
            return response.body()
        }else{
            throw ApiException(response.code().toString())
        }
    }
}

