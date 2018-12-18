package com.example.billy.exampleandroidcleanarchitecturekotlin.core.exception

sealed class Failure {
    class NetworkConnection : Failure()
    class ServerError() : Failure()

    abstract class FreatureFailure() : Failure()
}