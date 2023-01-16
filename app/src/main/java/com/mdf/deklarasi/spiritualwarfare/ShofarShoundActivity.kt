package com.mdf.deklarasi.spiritualwarfare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivityShofarShoundBinding
import com.mdf.deklarasi.databinding.ItemDeclarationBinding
import com.mdf.deklarasi.model.ShofarSound
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class ShofarShoundActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShofarShoundBinding
    private lateinit var adapter: SimpleRecyclerAdapter<ShofarSound>
    private lateinit var database: IDeclarationDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shofar_shound)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        setupLayout()
        getShofarSoundList()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvShofarSound.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        adapter = SimpleRecyclerAdapter(listOf(), R.layout.item_declaration) { holder, item ->
            val itemBinding: ItemDeclarationBinding = holder.layoutBinding as ItemDeclarationBinding
            if (item != null) {
                itemBinding.tvDeclarationName.text = item.title
            }

            itemBinding.root.setOnClickListener {
                val intent = Intent(applicationContext, ShofarSoundPlayerActivity::class.java)
                intent.putExtra("title", item.title)
                intent.putExtra("filename", item.file)
                intent.putExtra("image", item.image)
                startActivity(intent)

            }
        }
        binding.rvShofarSound.adapter = adapter
    }

    private fun getShofarSoundList() {
        database.getAllShofarSound(getDatabaseSuccessListener(), getDatabaseErrorListener())
    }

    private fun getDatabaseSuccessListener(): DatabaseSuccessListener<List<ShofarSound>> {
        return object : DatabaseSuccessListener<List<ShofarSound>>() {
            override fun onSuccessResponse(results: List<ShofarSound>?) {
                adapter.mainData = results
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun getDatabaseErrorListener(): DatabaseErrorListener {
        return object : DatabaseErrorListener() {
            override fun onErrorResponseListener() {

            }
        }
    }
}