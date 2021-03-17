package com.femiras.framework.mvvm.data.api

import com.femiras.framework.mvvm.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}