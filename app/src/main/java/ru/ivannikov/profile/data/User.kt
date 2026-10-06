package ru.ivannikov.profile.data

/**
 * Модель данных, описывающая профиль пользователя.
 *
 * @property name Имя пользователя.
 * @property surname Фамилия пользователя.
 * @property status Текущий статус пользователя.
 * @property followers Количество подписчиков.
 * @property isSubscribed Флаг подписки на данный профиль.
 * @author Иванников Сергей Сергеевич
 * @since 2026-09-03
 */
data class User(
    val name: String = "Сергей",
    val surname: String = "Иванников",
    val status: String = "Студент СКФУ | ПИН-б-о-24-1 (2)",
    val followers: Int = 128,
    val isSubscribed: Boolean = false
)