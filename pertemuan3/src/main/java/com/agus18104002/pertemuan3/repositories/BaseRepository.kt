package com.agus18104002.pertemuan3.repositories

abstract class BaseRepository<DataStore> {
    protected var localDataStore: DataStore? = null
    protected var remoteDataStore: DataStore? = null

    fun init(localDataStore: DataStore, remoteDataStore: DataStore) {
        this.localDataStore = localDataStore
        this.remoteDataStore = remoteDataStore
    }
}