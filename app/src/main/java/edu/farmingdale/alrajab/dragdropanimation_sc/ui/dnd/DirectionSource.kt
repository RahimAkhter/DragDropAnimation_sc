package edu.farmingdale.alrajab.dragdropanimation_sc.ui.dnd

import android.content.ClipData
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.farmingdale.alrajab.dragdropanimation_sc.model.Direction
import edu.farmingdale.alrajab.dragdropanimation_sc.R

@Preview
@Composable
fun PreviewGameActionSource() {
	DirectionSource(
		Direction.UP,
		Modifier.size(48.dp)
	)
}

/**
 * The source of directions a user can pull from
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DirectionSource(
	direction: Direction,
	modifier: Modifier = Modifier
) {
	val context = LocalContext.current
	Box(
		modifier
			.aspectRatio(1f)
			.padding(4.dp)
			.background(Color.Green)
			// Mark a dnd source
			.dragAndDropSource {
				detectDragGestures { _, _ ->
					startTransfer(
						DragAndDropTransferData(
							ClipData.newPlainText(
								context.getString(R.string.action),
								direction.name
							),
							direction
						)
					)
				}
			},
		contentAlignment = Alignment.Center
	) {
		DirectionIcon(direction)
	}
}