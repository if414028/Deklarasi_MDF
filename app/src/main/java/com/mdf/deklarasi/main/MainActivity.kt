package com.mdf.deklarasi.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivityMainBinding
import com.mdf.deklarasi.databinding.ItemModuleBinding
import com.mdf.deklarasi.declaration.DeclarationListActivity
import com.mdf.deklarasi.library.LibraryActivity
import com.mdf.deklarasi.settings.SettingsActivity
import com.mdf.deklarasi.spiritualwarfare.SpiritualWarfareActivity
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var adapter: SimpleRecyclerAdapter<ModuleView>
    private val moduleList = arrayListOf<ModuleView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()

        setupGridMenu()
    }

    private fun setupGridMenu() {
        setupModuleView()
        binding.rvMenu.layoutManager = GridLayoutManager(applicationContext, 2)
        adapter = SimpleRecyclerAdapter<ModuleView>(
            moduleList,
            R.layout.item_module
        ) { holder, item ->
            val itemBinding: ItemModuleBinding = holder.layoutBinding as ItemModuleBinding
            itemBinding.ivModule.setImageDrawable(resources.getDrawable(item.moduleIcon))
            itemBinding.tvModuleName.setText(item.moduleName)
            itemBinding.root.setOnClickListener {
                val intent: Intent = when (item.moduleName) {
                    resources.getString(R.string.declaration) ->
                        Intent(applicationContext, DeclarationListActivity::class.java)
                    resources.getString(R.string.spiritual_warfare) ->
                        Intent(applicationContext, SpiritualWarfareActivity::class.java)
                    resources.getString(R.string.library) ->
                        Intent(applicationContext, LibraryActivity::class.java)
                    resources.getString(R.string.setting) ->
                        Intent(applicationContext, SettingsActivity::class.java)
                    else -> Intent(applicationContext, DeclarationListActivity::class.java)
                }
                startActivity(intent)
            }
        }
        binding.rvMenu.adapter = adapter
    }

    private fun setupModuleView() {
        val declarationModule =
            ModuleView(resources.getString(R.string.declaration), R.drawable.declaration)
        val spiritualWarfareModule =
            ModuleView(resources.getString(R.string.spiritual_warfare), R.drawable.shield)
        val libraryModule = ModuleView(resources.getString(R.string.library), R.drawable.library)
        val settingModule = ModuleView(resources.getString(R.string.setting), R.drawable.settings)

        moduleList.add(declarationModule)
        moduleList.add(spiritualWarfareModule)
        moduleList.add(libraryModule)
        moduleList.add(settingModule)
    }
}