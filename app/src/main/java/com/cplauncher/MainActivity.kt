
package com.cplauncher

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private fun addText(
        parent: LinearLayout,
        text: String,
        size: Float
    ) {
        val view = TextView(this)
        view.text = text
        view.textSize = size
        view.setTextColor(Color.WHITE)
        view.setPadding(12, 16, 12, 16)
        parent.addView(view)
    }

    private fun addButton(
        parent: LinearLayout,
        text: String,
        action: () -> Unit
    ) {
        val button = Button(this)
        button.text = text
        button.setOnClickListener { action() }

        parent.addView(
            button,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL
        content.gravity = Gravity.CENTER_HORIZONTAL
        content.setPadding(24, 24, 24, 24)
        content.setBackgroundColor(Color.rgb(24, 27, 35))

        addText(content, "CP LAUNCHER", 28f)
        addText(content, "Minecraft Java Launcher", 16f)
        addText(content, "Version: 1.0", 14f)

        addButton(content, "Launch Minecraft") {
            Toast.makeText(
                this,
                "Minecraft runtime is not installed yet.",
                Toast.LENGTH_LONG
            ).show()
        }

        addButton(content, "Game Versions") {
            Toast.makeText(
                this,
                "Version manager coming next.",
                Toast.LENGTH_SHORT
            ).show()
        }

        addButton(content, "Settings") {
            Toast.makeText(
                this,
                "Settings coming next.",
                Toast.LENGTH_SHORT
            ).show()
        }

        addButton(content, "About CP Launcher") {
            Toast.makeText(
                this,
                "CP Launcher - Android Edition",
                Toast.LENGTH_SHORT
            ).show()
        }

        val scroll = ScrollView(this)
        scroll.addView(content)
        setContentView(scroll)
    }
}
