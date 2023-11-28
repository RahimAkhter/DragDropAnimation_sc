package edu.farmingdale.alrajab.dragdropanimation_sc.ui.dnd

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.farmingdale.alrajab.dragdropanimation_sc.model.Direction


@Preview
@Composable
fun PreviewDirectionSlot() {
	Surface {
		DirectionSlot(direction = Direction.DOWN, Modifier.size(48.dp), setAction = {})
	}
}

val SLOT_DEFAULT_COLOR = Color.LightGray
val SLOT_DROP_COLOR = Color.Green

/**
 * Given slot that the user can set to an action
 *
 * @param setAction set the action for this slot
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DirectionSlot(
	direction: Direction?,
	modifier: Modifier = Modifier,
	setAction: (Direction) -> Unit,
) {
	/**
	 * Color of this slot
	 */
	var slotColor by remember { mutableStateOf(SLOT_DEFAULT_COLOR) }

	Box(
		modifier
			.padding(4.dp)
			.aspectRatio(1f)
			.border(4.dp, slotColor)
			// Mark this view as a target
			.dragAndDropTarget(
				shouldStartDragAndDrop = {
					it.toAndroidDragEvent().localState is Direction
				},
				DragAndDropTarget(
					onDrop = {
						val dnd = (it.toAndroidDragEvent().localState as Direction)
						setAction(dnd)
						true
					},
					onEntered = {
						if (it.toAndroidDragEvent().localState is Direction) {
							slotColor = SLOT_DROP_COLOR
						}
					},
					onExited = {
						slotColor = SLOT_DEFAULT_COLOR
					},
					onEnded = {
						slotColor = SLOT_DEFAULT_COLOR
					}
				)
			),
		contentAlignment = Alignment.Center
	) {
		if (direction != null)
			DirectionIcon(direction)
	}
}