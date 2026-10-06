package ru.ivannikov.profile.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ivannikov.profile.data.User
import ru.ivannikov.profile.ui.components.ActionButtons
import ru.ivannikov.profile.ui.components.Avatar
import ru.ivannikov.profile.ui.components.ProfileInfo

/**
 * Экран профиля пользователя, управляющий локальным состоянием элементов[cite: 1].
 *
 * @param modifier Модификатор контейнера[cite: 1].
 * @author Иванников Сергей Сергеевич
 * @since 2026-09-03[cite: 1]
 */
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val initialUser = remember { User() }

    // Локальное состояние экрана[cite: 1]
    var statusText by remember { mutableStateOf(initialUser.status) }
    var isSubscribed by remember { mutableStateOf(initialUser.isSubscribed) }
    var followerCount by remember { mutableIntStateOf(initialUser.followers) }
    var likesCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Avatar()

        ProfileInfo(
            user = User(
                name = initialUser.name,
                surname = initialUser.surname,
                status = statusText,
                followers = followerCount,
                isSubscribed = isSubscribed
            )
        )

        // Поле динамического редактирования статуса[cite: 1]
        OutlinedTextField(
            value = statusText,
            onValueChange = { statusText = it },
            label = { Text("Редактировать статус") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))

        // Кнопки подписки и сброса[cite: 1]
        ActionButtons(
            isSubscribed = isSubscribed,
            onSubscribeClick = {
                isSubscribed = !isSubscribed
                followerCount += if (isSubscribed) 1 else -1
            },
            onResetClick = {
                statusText = initialUser.status
                isSubscribed = initialUser.isSubscribed
                followerCount = initialUser.followers
                likesCount = 0
            }
        )

        // Интерактивный счетчик лайков[cite: 1]
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Отметки «Нравится»",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Всего: $likesCount",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }

                FilledIconButton(onClick = { likesCount++ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Поставить лайк")
                }
            }
        }
    }
}

/**
 * Предпросмотр экрана профиля в Android Studio[cite: 1].
 */
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen()
    }
}