package edu.farmingdale.alrajab.dragdropanimation_sc.ui.dnd

import android.graphics.drawable.AnimationDrawable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import edu.farmingdale.alrajab.dragdropanimation_sc.R

@Preview
@Composable
fun PreviewAnimationRocket() {
	AnimationRocket(
		Modifier.fillMaxSize()
	)
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimationRocket(
	modifier: Modifier = Modifier,
) {
	val context = LocalContext.current

	val drawable = remember {
		AnimationDrawable().apply {
			addFrame(context.getDrawable(R.drawable.rocket01)!!, 200)
			addFrame(context.getDrawable(R.drawable.rocket02)!!, 200)
			addFrame(context.getDrawable(R.drawable.rocket03)!!, 200)
		}
	}

	var isRunning by remember { mutableStateOf(false) }

	LaunchedEffect(drawable, isRunning) {
		if (isRunning)
			drawable.start()
		else drawable.stop()
	}

	Box(modifier, contentAlignment = Alignment.Center) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally
		) {

			val spinTransition = rememberInfiniteTransition(label = "Spin")

			val rotator by spinTransition.animateFloat(
				initialValue = 0f,
				targetValue = 360f,
				animationSpec = infiniteRepeatable(
					animation = tween(1000, easing = LinearEasing),
					repeatMode = RepeatMode.Restart
				),
				label = "Shake"
			)

			val upDownTransition = rememberInfiniteTransition(label = "UpDown")

			val offset by upDownTransition.animateFloat(
				initialValue = 0f,
				targetValue = -200f,
				animationSpec = infiniteRepeatable(
					animation = tween(1000, easing = LinearEasing),
					repeatMode = RepeatMode.Reverse
				),
				label = "Shake"
			)

			Image(
				rememberDrawablePainter(drawable),
				"Rocket",
				Modifier.let {
					if (isRunning) {
						it
							.offset(y = offset.toInt().dp)
							.rotate(rotator)
					} else {
						it
					}
				}
			)

			IconToggleButton(
				isRunning,
				onCheckedChange = {
					isRunning = it
				}
			) {
				if (isRunning) {
					Icon(painterResource(R.drawable.baseline_pause_24), "Stop")
				} else {
					Icon(Icons.Default.PlayArrow, "Play")
				}
			}
		}
	}
}