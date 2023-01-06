package com.khaldoun.sharabi.di
//Object is the same as class
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module //tell dagger hilt this is a module
@InstallIn (SingletonComponent::class)//specify the life of the dependencies inside the module
object AppModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance() //Injection of the dependency inside the fun

}