package br.com.wappalarme.data.repository

import br.com.wappalarme.data.local.UserConfigDao
import br.com.wappalarme.data.model.UserConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserConfigRepository @Inject constructor(
    private val dao: UserConfigDao
) {
    fun getConfig(): Flow<UserConfig?> = dao.getConfig()

    suspend fun getConfigOnce(): UserConfig? = dao.getConfigOnce()

    suspend fun saveConfig(config: UserConfig) = dao.saveConfig(config)

    suspend fun updateLastCheckDate(date: String) = dao.updateLastCheckDate(date)

    /**
     * Retorna a configuração atual ou um padrão se não existir.
     */
    suspend fun getOrDefault(): UserConfig =
        dao.getConfigOnce() ?: UserConfig()
}
