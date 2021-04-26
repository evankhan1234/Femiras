package com.femiras.framework.mvvm.ui

import android.animation.LayoutTransition
import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.ActivityHomeBinding
import com.femiras.framework.mvvm.utils.DrawerHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_appbar.view.*
@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appbarConfig: AppBarConfiguration
    lateinit var binding: ActivityHomeBinding
    private lateinit var drawerHelper: DrawerHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbar.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        initDrawer()
        setupNavController()
        binding.fab.setOnClickListener {
            navController.navigate(R.id.logFragment)
        }
    }
    private fun initDrawer(){
        drawerHelper = DrawerHelper(this, binding)
        drawerHelper.initDrawer()
    }
    fun getNavController() = navController


    private fun setupNavController() {
        Log.e("NAV", "SetupNavController")

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.home_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        appbarConfig = AppBarConfiguration(
            setOf(
                R.id.menu_feed,
                R.id.menu_tv,
            ),
            binding.drawerLayout
        )
//        setupActionBarWithNavController(navController, appbarConfig)
//        NavigationUI.setupActionBarWithNavController(this, navController, appbarConfig)
        tbar.toolbar.setupWithNavController(navController, appbarConfig)
        getSupportActionBar()?.setTitle("Emily Watson")
        binding.tbar.toolbar.setNavigationIcon(R.drawable.ic_menu)
        binding.sideNavigation.setupWithNavController(navController)
        binding.tabNavigator.setupWithNavController(navController)

        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomAppBar) { _, insets ->
            insets.consumeSystemWindowInsets()
        }

        binding.sideNavigation.setNavigationItemSelectedListener {
            drawerHelper.handleMenuItemById(it)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            supportFragmentManager.popBackStack(R.id.content_viewer,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

            binding.tbar.toolbar.setNavigationIcon(R.drawable.ic_menu)
        }

//        binding.sideNavigation.setNavigationItemSelectedListener {
//            binding.drawerLayout.closeDrawers()
//            return@setNavigationItemSelectedListener false
//        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}