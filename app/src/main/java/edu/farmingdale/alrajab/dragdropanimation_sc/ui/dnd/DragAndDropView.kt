package edu.farmingdale.alrajab.dragdropanimation_sc.ui.dnd

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.farmingdale.alrajab.dragdropanimation_sc.model.Direction
import edu.farmingdale.alrajab.dragdropanimation_sc.ui.theme.DragDropAnimation_scTheme

@Preview
@Composable
fun DragAndDropView() {
	var slots by remember { mutableStateOf(listOf<Direction?>(null, null, null, null)) }
	DragDropAnimation_scTheme {
		DragAndDropContent(
			slots
		) { index, d ->
			val newSlots = ArrayList(slots)
			newSlots[index] = d
			slots = newSlots
		}
	}
}

@Composable
fun DragAndDropContent(
	slots: List<Direction?>,
	setAction: (slot: Int, Direction) -> Unit,
) {
	Scaffold(
		topBar = {
			Row {
				Card(
					Modifier
						.weight(.5f)
						.padding(8.dp)) {
					Row(Modifier.padding(4.dp)) {
						Direction.entries.forEach {
							DirectionSource(it, Modifier.weight(.25f))
						}
					}
				}

				Card(
					Modifier
						.weight(.5f)
						.padding(8.dp)) {
					Row(Modifier.padding(4.dp)) {
						slots.forEachIndexed { index, direction ->
							DirectionSlot(direction, Modifier.weight(.25f)) { setAction(index, it) }
						}
					}
				}
			}
		}
	) {
		AnimationRocket(
			Modifier
				.padding(it)
				.fillMaxSize()
		)
	}
}