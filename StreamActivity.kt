// Updated StreamActivity.kt

class StreamActivity : AppCompatActivity() {
    private var isPanelVisible: Boolean = false

    // Touch event debouncing constant
    private val debounceDelay: Long = 300 // milliseconds
    private var lastTouchTimestamp: Long = 0

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastTouchTimestamp < debounceDelay) {
            return false // Ignore rapid touch events
        }
        lastTouchTimestamp = currentTime

        when (event.action) {
            MotionEvent.ACTION_DOWN -> handleTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }

    private fun handleTouchEvent(event: MotionEvent) {
        // Handle touch event
        // Toggle panel visibility using a state machine
        togglePanelVisibility()
    }

    private fun togglePanelVisibility() {
        isPanelVisible = !isPanelVisible
        updatePanelVisibility() // Function to update UI based on visibility state
    }

    private fun updatePanelVisibility() {
        if (isPanelVisible) {
            // Show the panel
            channelsPanel.visibility = View.VISIBLE
        } else {
            // Hide the panel
            channelsPanel.visibility = View.GONE
        }
    }
}