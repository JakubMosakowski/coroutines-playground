package com.jakmos.coroutinesplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.jakmos.coroutinesplayground.databinding.ActivityMainBinding
import com.jakmos.coroutinesplayground.leak.NextActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_fake_view_model -> {
            navController.navigate(R.id.toFakeViewModelFragment)
            true
        }
        R.id.action_service -> {
            navController.navigate(R.id.toServiceFragment)
            true
        }
        R.id.action_leak -> {
            startActivity(Intent(this, NextActivity::class.java))
            finish()
            Log.v("KUBA", "After on finish")
            true
        }
        R.id.action_guide -> {
            navController.navigate(R.id.toGuideFragment)
            true
        }
        R.id.action_emit -> {
            navController.navigate(R.id.toEmitFragment)
            true
        }
        R.id.action_collect -> {
            navController.navigate(R.id.toCollectFragment)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("KUBA", "After on destroy")
    }

    private val navController get() = findNavController(R.id.nav_host_fragment_content_main)
}
