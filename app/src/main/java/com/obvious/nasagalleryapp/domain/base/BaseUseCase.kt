package com.obvious.nasagalleryapp.domain.base

abstract class BaseUseCase<T> {
    abstract suspend operator fun invoke(): T
}