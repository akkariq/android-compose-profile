# Profile App — Лабораторная работа №3

Интерактивное мобильное приложение с экраном профиля пользователя на базе Jetpack Compose. В проекте реализовано реактивное управление состоянием, модульная архитектура UI-компонентов и валидация пользовательских действий.

## Скриншот экрана
![Экран профиля](screenshots/profile_screen.png)

## Стек технологий
- **Язык разработки:** Kotlin
- **UI-фреймворк:** Jetpack Compose (Material 3)
- **Среда разработки:** Android Studio
- **Минимальная версия Android:** API 24 (Android 7.0)

## Структура проекта
- `app/src/main/java/ru/ivannikov/profile/MainActivity.kt` — точка входа Activity.
- `app/src/main/java/ru/ivannikov/profile/data/User.kt` — data class модели пользователя.
- `app/src/main/java/ru/ivannikov/profile/ui/ProfileScreen.kt` — главный экран и управление состоянием (remember, mutableStateOf).
- `app/src/main/java/ru/ivannikov/profile/ui/components/Avatar.kt` — компонент круглого аватара.
- `app/src/main/java/ru/ivannikov/profile/ui/components/ProfileInfo.kt` — текстовый блок информации о пользователе.
- `app/src/main/java/ru/ivannikov/profile/ui/components/ActionButtons.kt` — кнопки подписки и сброса.

## Инструкция по сборке и запуску
1. Склонируйте репозиторий:
   ```bash
   git clone [https://github.com/akkariq/android-compose-profile.git](https://github.com/akkariq/android-compose-profile.git)