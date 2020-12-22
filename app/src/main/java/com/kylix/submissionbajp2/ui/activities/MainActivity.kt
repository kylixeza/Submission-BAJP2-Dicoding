package com.kylix.submissionbajp2.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kylix.submissionbajp2.R
import com.kylix.submissionbajp2.ui.movie.MovieFragment
import com.kylix.submissionbajp2.ui.setting.SettingFragment
import com.kylix.submissionbajp2.ui.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val bottomNavigationView = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_movie -> loadFragment(MovieFragment())
            R.id.nav_tvShow -> loadFragment(TvShowFragment())
            R.id.nav_setting -> loadFragment(SettingFragment())
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = getString(R.string.app_name)
        loadFragment(MovieFragment())
        bottom_nav.setOnNavigationItemSelectedListener(bottomNavigationView)
    }

    private fun loadFragment(fragment: Fragment?): Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fm_container, fragment)
                    .commit()
            return true
        }
        return false
    }
}