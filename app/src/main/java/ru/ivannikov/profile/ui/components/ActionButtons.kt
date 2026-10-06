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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Кнопки управления профилем без собственного состояния.
 *
 * @param isSubscribed Состояние подписки.
 * @param onSubscribeClick Обработчик переключения подписки.
 * @param onResetClick Обработчик сброса данных.
 * @param modifier Модификатор контейнера.
 * @author Иванников Сергей Сергеевич
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

/** Предпросмотр кнопок до подписки. */
@Preview(showBackground = true)
@Composable
fun ActionButtonsPreview() {
    MaterialTheme {
        ActionButtons(isSubscribed = false, onSubscribeClick = {}, onResetClick = {})
    }
}
