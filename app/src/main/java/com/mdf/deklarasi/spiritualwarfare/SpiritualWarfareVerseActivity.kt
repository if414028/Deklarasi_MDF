package com.mdf.deklarasi.spiritualwarfare

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivitySpiritualWarfareVerseBinding
import com.mdf.deklarasi.databinding.ItemDeclarationBinding
import com.mdf.deklarasi.model.SpiritualWarfareVerse
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.SimpleFilterRecyclerAdapter
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class SpiritualWarfareVerseActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpiritualWarfareVerseBinding
    private lateinit var database: IDeclarationDatabase
    private lateinit var adapter: SimpleFilterRecyclerAdapter<SpiritualWarfareVerse>

    private var spiritualWarfareVerses: List<SpiritualWarfareVerse>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spiritual_warfare_verse)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        setupLayout()
        getSpiritualWarfareCategory()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        setupSpiritualWarfareVerseRecyclerView()
        binding.etSearch.addTextChangedListener(getTextWatcher())
    }

    private fun getSpiritualWarfareCategory() {
        database.getAllSpiritualWarfareVerse(
            getDatabaseSuccessListener(),
            getDatabaseErrorListener()
        )
    }

    private fun getDatabaseSuccessListener(): DatabaseSuccessListener<List<SpiritualWarfareVerse>> {
        return object : DatabaseSuccessListener<List<SpiritualWarfareVerse>>() {
            override fun onSuccessResponse(results: List<SpiritualWarfareVerse>?) {
                spiritualWarfareVerses = results
                adapter.mainData = spiritualWarfareVerses
                adapter.notifyDataSetChanged()
                binding.isEmpty = false
            }
        }
    }

    private fun getDatabaseErrorListener(): DatabaseErrorListener {
        return object : DatabaseErrorListener() {
            override fun onErrorResponseListener() {

            }
        }
    }

    private fun setupSpiritualWarfareVerseRecyclerView() {
        binding.rvSpiritualWarfareCategory.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        adapter = SimpleFilterRecyclerAdapter(listOf(),
            R.layout.item_declaration,
            SimpleRecyclerAdapter.OnViewHolder { holder, item ->
                val itemBinding: ItemDeclarationBinding =
                    holder.layoutBinding as ItemDeclarationBinding
                if (item != null) itemBinding.tvDeclarationName.text = item.category
            },
            object : SimpleFilterRecyclerAdapter.OnSearchListener<SpiritualWarfareVerse?> {
                override fun onSearchRules(
                    model: SpiritualWarfareVerse?,
                    searchedText: String?
                ): SpiritualWarfareVerse? {
                    if (searchedText?.let {
                            model?.category?.lowercase()?.contains(it, ignoreCase = true) == true
                        } == true) {
                        binding.isEmpty = false
                        return model
                    }
                    return null
                }

                override fun onSearch(model: ArrayList<SpiritualWarfareVerse?>?) {

                }

                override fun onSearchEmpty(searchedText: String?) {
                    binding.isEmpty = true
                }
            })
        binding.rvSpiritualWarfareCategory.adapter = adapter
    }

    private fun getTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(editable: Editable?) {
                val searchedText = editable.toString()
                if (searchedText.isBlank()) {
                    adapter.mainData = spiritualWarfareVerses
                    binding.isEmpty = false
                } else {
                    adapter.filter(searchedText)
                }
            }

        }
    }
}