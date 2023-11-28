package edu.farmingdale.alrajab.dragdropanimation_sc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import edu.farmingdale.alrajab.dragdropanimation_sc.ui.dnd.DragAndDropView

class DragAndDropViews : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			DragAndDropView()
		}
	}
}