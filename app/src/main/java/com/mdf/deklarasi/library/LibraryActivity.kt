package com.mdf.deklarasi.library

import android.content.Intent
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
import com.mdf.deklarasi.databinding.ActivityLibraryBinding
import com.mdf.deklarasi.databinding.ItemDeclarationBinding
import com.mdf.deklarasi.model.Library
import com.mdf.deklarasi.spiritualwarfare.SpiritualWarfareDetailActivity
import com.mdf.deklarasi.spiritualwarfare.SpiritualWarfareSubCategoryActivity
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.SimpleFilterRecyclerAdapter
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class LibraryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLibraryBinding
    private lateinit var database: IDeclarationDatabase
    private lateinit var adapter: SimpleFilterRecyclerAdapter<Library>

    private var libraries: List<Library>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_library)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        setupLayout()
        getLibraries()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        setupLibrariesRecyclerView()
        binding.etSearch.addTextChangedListener(getTextWatcher())
    }

    private fun getLibraries() {
        database.getAllLibrary(object : DatabaseSuccessListener<List<Library>>() {
            override fun onSuccessResponse(results: List<Library>?) {
                libraries = results
                adapter.mainData = libraries
                adapter.notifyDataSetChanged()
                binding.isEmpty = false
            }
        }, object : DatabaseErrorListener() {
            override fun onErrorResponseListener() {
                binding.isEmpty = true
            }
        })
    }

    private fun setupLibrariesRecyclerView() {
        binding.rvLibrary.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        adapter = SimpleFilterRecyclerAdapter(listOf(), R.layout.item_declaration,
            SimpleRecyclerAdapter.OnViewHolder { holder, item ->
                val itemBinding: ItemDeclarationBinding =
                    holder.layoutBinding as ItemDeclarationBinding
                if (item != null) itemBinding.tvDeclarationName.text = item.title
                itemBinding.root.setOnClickListener {
                    if (item?.subtitle?.isNotEmpty() == true) {
                        val intent = Intent(
                            applicationContext, SubLibraryActivity::class.java)
                        intent.putExtra("subLibrary", item)
                        startActivity(intent)
                    } else {
                        val intent = Intent(
                            applicationContext, LibraryDetailActivity::class.java)
                        intent.putExtra("library", item)
                        startActivity(intent)
                    }
                }
            },
            object : SimpleFilterRecyclerAdapter.OnSearchListener<Library?> {
                override fun onSearchRules(model: Library?, searchedText: String?): Library? {
                    if (searchedText?.let {
                            model?.title?.lowercase()?.contains(it, ignoreCase = true) == true ||
                                    model?.content?.lowercase()?.contains(it, ignoreCase = true) == true
                        } == true) {
                        binding.isEmpty = false
                        return model
                    }
                    return null
                }

                override fun onSearch(model: ArrayList<Library?>?) {

                }

                override fun onSearchEmpty(searchedText: String?) {
                    binding.isEmpty = true
                }
            })
        binding.rvLibrary.adapter = adapter
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
                    adapter.mainData = libraries
                    binding.isEmpty = false
                } else {
                    adapter.filter(searchedText)
                }
            }

        }
    }
}