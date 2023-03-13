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
import com.mdf.deklarasi.databinding.ActivitySubLibraryBinding
import com.mdf.deklarasi.databinding.ItemDeclarationBinding
import com.mdf.deklarasi.model.Library
import com.mdf.deklarasi.model.SubLibrary
import com.mdf.deklarasi.utilities.SimpleFilterRecyclerAdapter
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class SubLibraryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubLibraryBinding
    private lateinit var adapter: SimpleFilterRecyclerAdapter<SubLibrary>

    private var subLibrary: List<SubLibrary>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_library)
        supportActionBar?.hide()

        getArgument()
        setupLayout()
    }

    private fun getArgument() {
        val library =
            intent.getParcelableExtra("subLibrary") as? Library
        subLibrary = library?.subtitle
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        setupRecyclerView()
        binding.etSearch.addTextChangedListener(getTextWatcher())
    }

    private fun setupRecyclerView() {
        binding.rvSubLibrary.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        adapter = SimpleFilterRecyclerAdapter(listOf(),
            R.layout.item_declaration,
            SimpleRecyclerAdapter.OnViewHolder { holder, item ->
                val itemBinding: ItemDeclarationBinding =
                    holder.layoutBinding as ItemDeclarationBinding

                itemBinding.tvDeclarationName.text = item?.title
                itemBinding.root.setOnClickListener {
                    val library = Library()
                    library.id = item?.id.toString()
                    library.title = item?.title.toString()
                    library.content = item?.content.toString()
                    library.image = item?.image.toString()
                    val intent =
                        Intent(applicationContext, LibraryDetailActivity::class.java)
                    intent.putExtra("library", library)
                    startActivity(intent)
                }
            },
            object : SimpleFilterRecyclerAdapter.OnSearchListener<SubLibrary?> {
                override fun onSearchRules(
                    model: SubLibrary?,
                    searchedText: String?
                ): SubLibrary? {
                    if (searchedText?.let {
                            model?.title?.lowercase()?.contains(it, ignoreCase = true) == true ||
                                    model?.content?.lowercase()
                                        ?.contains(it, ignoreCase = true) == true
                        } == true) {
                        binding.isEmpty = false
                        return model
                    }
                    return null
                }

                override fun onSearch(model: ArrayList<SubLibrary?>?) {

                }

                override fun onSearchEmpty(searchedText: String?) {
                    binding.isEmpty = true
                }
            })
        binding.rvSubLibrary.adapter = adapter
        adapter.mainData = subLibrary
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
                    adapter.mainData = subLibrary
                    binding.isEmpty = false
                } else {
                    adapter.filter(searchedText)
                }
            }

        }
    }
}