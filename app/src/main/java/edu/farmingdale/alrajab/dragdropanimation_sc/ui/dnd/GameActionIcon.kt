package edu.farmingdale.alrajab.dragdropanimation_sc.ui.dnd

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import edu.farmingdale.alrajab.dragdropanimation_sc.model.Direction
import edu.farmingdale.alrajab.dragdropanimation_sc.R

@Preview
@Composable
fun PreviewDirectionIcon() {
	Surface {
		DirectionIcon(Direction.UP)
	}
}

/**
 * Icon for a given action
 */
@Composable
fun DirectionIcon(
	direction: Direction
) {
	when (direction) {
		Direction.LEFT ->
			Icon(Icons.Default.KeyboardArrowLeft, stringResource(R.string.left))

		Direction.RIGHT ->
			Icon(Icons.Default.KeyboardArrowRight, stringResource(R.string.right))

		Direction.UP ->
			Icon(Icons.Default.KeyboardArrowUp, stringResource(R.string.up))

		Direction.DOWN ->
			Icon(Icons.Default.KeyboardArrowDown, stringResource(R.string.down))
	}
}