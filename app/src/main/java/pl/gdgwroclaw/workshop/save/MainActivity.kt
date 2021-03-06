package pl.gdgwroclaw.workshop.save

import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_list, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(1000, 1000, 1).create();
        val page = document.startPage(pageInfo)
        nav_host_fragment.requireView().draw(page.canvas)
        document.finishPage(page)
        val file = File(filesDir, "pdfs/temp.pdf")
        file.parentFile?.mkdirs()
        file.outputStream().use {
            document.writeTo(it)
        }
        document.close()
        val uri = FileProvider.getUriForFile(this, "pl.gdgwroclaw.pdf", file)
        val intent = Intent(Intent.ACTION_SEND)
            .setType("application/pdf")
            .putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(Intent.createChooser(intent, "Choose app"))
        return true
    }
}