package com.mdf.deklarasi.spiritualwarfare

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivitySpiritualWarfareSubCategoryBinding
import com.mdf.deklarasi.databinding.ItemDeclarationBinding
import com.mdf.deklarasi.model.SpiritualWarfareSubCategory
import com.mdf.deklarasi.model.SpiritualWarfareVerse
import com.mdf.deklarasi.utilities.SimpleFilterRecyclerAdapter
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class SpiritualWarfareSubCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpiritualWarfareSubCategoryBinding
    private lateinit var adapter: SimpleFilterRecyclerAdapter<SpiritualWarfareSubCategory>

    private var spiritualWarfareSubCategory: List<SpiritualWarfareSubCategory>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_spiritual_warfare_sub_category)
        supportActionBar?.hide()

        getArgument()
        setupLayout()
    }

    private fun getArgument() {
        val spiritualWarfareVerse =
            intent.getParcelableExtra("spiritualWarfare") as? SpiritualWarfareVerse
        spiritualWarfareSubCategory = spiritualWarfareVerse?.subCategory
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        setupRecyclerView()
        binding.etSearch.addTextChangedListener(getTextWatcher())
    }

    private fun setupRecyclerView() {
        binding.rvSpiritualWarfareCategory.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        adapter = SimpleFilterRecyclerAdapter(listOf(),
            R.layout.item_declaration,
            SimpleRecyclerAdapter.OnViewHolder { holder, item ->
                val itemBinding: ItemDeclarationBinding =
                    holder.layoutBinding as ItemDeclarationBinding

                itemBinding.tvDeclarationName.text = item?.subCategoryName
                itemBinding.root.setOnClickListener {
                    val spiritualWarfareVerse = SpiritualWarfareVerse()
                    spiritualWarfareVerse.id = item?.id.toString()
                    spiritualWarfareVerse.category = item?.subCategoryName.toString()
                    spiritualWarfareVerse.verses = item?.verses.toString()
                    val intent =
                        Intent(applicationContext, SpiritualWarfareDetailActivity::class.java)
                    intent.putExtra("spiritualWarfare", spiritualWarfareVerse)
                    startActivity(intent)
                }
            },
            object : SimpleFilterRecyclerAdapter.OnSearchListener<SpiritualWarfareSubCategory?> {
                override fun onSearchRules(
                    model: SpiritualWarfareSubCategory?,
                    searchedText: String?
                ): SpiritualWarfareSubCategory? {
                    if (searchedText?.let {
                            model?.verses?.lowercase()
                                ?.contains(it, ignoreCase = true) == true
                        } == true) {
                        binding.isEmpty = false
                        return model
                    }
                    return null
                }

                override fun onSearch(model: ArrayList<SpiritualWarfareSubCategory?>?) {

                }

                override fun onSearchEmpty(searchedText: String?) {
                    binding.isEmpty = true
                }
            })
        binding.rvSpiritualWarfareCategory.adapter = adapter
        adapter.mainData = spiritualWarfareSubCategory
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
                    adapter.mainData = spiritualWarfareSubCategory
                    binding.isEmpty = false
                } else {
                    adapter.filter(searchedText)
                }
            }

        }
    }
}