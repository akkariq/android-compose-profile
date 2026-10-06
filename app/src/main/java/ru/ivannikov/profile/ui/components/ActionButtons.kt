package ru.ivannikov.profile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Блок кнопок управления профилем[cite: 1].
 *
 * @param isSubscribed Состояние подписки[cite: 1].
 * @param onSubscribeClick Обработчик нажатия на кнопку подписки[cite: 1].
 * @param onResetClick Обработчик сброса данных к значениям по умолчанию[cite: 1].
 * @param modifier Модификатор контейнера[cite: 1].
 * @author Иванников Сергей Сергеевич
 * @since 2026-09-03[cite: 1]
 */
@Composable
fun ActionButtons(
    isSubscribed: Boolean,
    onSubscribeClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = onSubscribeClick,
            modifier = Modifier.weight(1f),
            colors = if (isSubscribed) {
                ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            } else {
                ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            }
        ) {
            Text(text = if (isSubscribed) "Отписаться" else "Подписаться")
        }

        OutlinedButton(
            onClick = onResetClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Сбросить")
        }
    }
}