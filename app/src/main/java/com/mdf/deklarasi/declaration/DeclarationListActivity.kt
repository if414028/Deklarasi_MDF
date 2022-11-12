package com.mdf.deklarasi.declaration

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
import com.mdf.deklarasi.databinding.ActivityDeclarationListBinding
import com.mdf.deklarasi.databinding.ItemDeclarationBinding
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.SimpleFilterRecyclerAdapter
import com.mdf.deklarasi.utilities.SimpleRecyclerAdapter

class DeclarationListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeclarationListBinding
    private lateinit var database: IDeclarationDatabase
    private lateinit var adapter: SimpleFilterRecyclerAdapter<Declaration>

    private var declarationList: List<Declaration>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_declaration_list)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        setupLayout()
        getDeclarationList()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        setupDeclarationRecyclerView()
        binding.etSearch.addTextChangedListener(getTextWatcher())
    }

    private fun getDeclarationList() {
        database.getAllDeclaration(getDatabaseSuccessListener(), getDatabaseErrorListener())
    }

    private fun getDatabaseSuccessListener(): DatabaseSuccessListener<List<Declaration>> {
        return object : DatabaseSuccessListener<List<Declaration>>() {
            override fun onSuccessResponse(results: List<Declaration>?) {
                declarationList = results
                adapter.mainData = declarationList
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

    private fun setupDeclarationRecyclerView() {
        binding.rvDeclaration.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        adapter = SimpleFilterRecyclerAdapter(
            listOf(),
            R.layout.item_declaration,
            SimpleRecyclerAdapter.OnViewHolder { holder, item ->
                val itemBinding: ItemDeclarationBinding =
                    holder.layoutBinding as ItemDeclarationBinding
                if (item != null) {
                    itemBinding.tvDeclarationName.text = item.title
                }
            }, object : SimpleFilterRecyclerAdapter.OnSearchListener<Declaration?> {
                override fun onSearchRules(
                    model: Declaration?,
                    searchedText: String?
                ): Declaration? {
                    if (searchedText?.let {
                            model?.title
                                ?.lowercase()
                                ?.contains(it, ignoreCase = true)
                        } == true
                    ) {
                        binding.isEmpty = false
                        return model
                    }
                    return null
                }

                override fun onSearch(model: ArrayList<Declaration?>?) {}
                override fun onSearchEmpty(searchedText: String?) {
                    binding.isEmpty = true
                }
            }
        )
        binding.rvDeclaration.adapter = adapter
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
                    adapter.mainData = declarationList
                    binding.isEmpty = false
                } else {
                    adapter.filter(searchedText)
                }
            }

        }
    }
}