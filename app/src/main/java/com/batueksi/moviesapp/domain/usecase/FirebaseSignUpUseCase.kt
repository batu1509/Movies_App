package com.batueksi.moviesapp.domain.usecase

import com.batueksi.moviesapp.data.models.auth.User
import com.batueksi.moviesapp.domain.repository.AuthRepository
import com.batueksi.moviesapp.domain.repository.UserRepository
import com.batueksi.moviesapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository){

    suspend operator fun invoke(email:String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val userUID = authRepository.signUp(email, password)
        if (userUID.isNotEmpty()) {

            userRepository.createUser(User(
                email = email,
                uid = userUID
            ))
            emit(Resource.Success(true))
        } else {
            emit(Resource.Error("Sign up error"))
        }
    }
}