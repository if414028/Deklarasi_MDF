package com.mdf.deklarasi.declaration

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivityDeclarationDetailBinding
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration


class DeclarationDetailActivity : AppCompatActivity(), View.OnTouchListener {

    private lateinit var binding: ActivityDeclarationDetailBinding
    private lateinit var database: IDeclarationDatabase

    private var declaration: Declaration? = Declaration()
    private lateinit var declarationId: String

    private val move = 200f
    private var ratio= 1.0f
    private var bastDst = 0
    private var baseRatio = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_declaration_detail)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        getArguments()
        setupLayout()
        getDeclarationDetail()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.pointerCount == 2) {
            val action = event.action
            val mainaction = action and MotionEvent.ACTION_MASK
            if (mainaction === MotionEvent.ACTION_POINTER_DOWN) {
                bastDst = getDistance(event)
                baseRatio = ratio
            } else {
                // if ACTION_POINTER_UP then after finding the distance
                // we will increase the text size by 15
                val scale = (getDistance(event) - bastDst) / move
                val factor = Math.pow(2.0, scale.toDouble()).toFloat()
                ratio = Math.min(1024.0f, Math.max(0.1f, baseRatio * factor))
                binding.tvDeclaration.textSize = ratio + 15
            }
        }

        return true
    }

    private fun getDistance(event: MotionEvent): Int {
        val dx = (event.getX(0) - event.getX(1)).toInt()
        val dy = (event.getY(0) - event.getY(1)).toInt()
        return Math.sqrt((dx * dx + dy * dy).toDouble()).toInt()
    }

    private fun getArguments() {
        declarationId = intent.getStringExtra("declarationId").toString()
    }

    private fun setupLayout() {
        binding.tvDeclaration.textSize = ratio + 15
        binding.tvDeclaration.setTextIsSelectable(true)
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.icFav.setOnClickListener {
            database.setFavDeclaration(
                if (declaration?.fav == true) 0 else 1,
                declarationId,
                getSetFavDeclarationSuccessListener(),
                getErrorListener()
            )
        }
    }

    private fun fetchDataToLayout() {
        binding.tvTitle.text = declaration?.title
        binding.tvDeclaration.text = declaration?.declaration
        if (declaration?.fav == true)
            binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav_selected))
        else binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav))
    }

    private fun getDeclarationDetail() {
        database.getDetailDeclaration(
            declarationId,
            getDeclarationDetailSuccessListener(),
            getErrorListener()
        )
    }

    private fun getDeclarationDetailSuccessListener(): DatabaseSuccessListener<Declaration> {
        return object : DatabaseSuccessListener<Declaration>() {
            override fun onSuccessResponse(results: Declaration?) {
                declaration = results
                fetchDataToLayout()
            }
        }

    }

    private fun getErrorListener(): DatabaseErrorListener {
        return object : DatabaseErrorListener() {
            override fun onErrorResponseListener() {

            }
        }
    }

    private fun getSetFavDeclarationSuccessListener(): DatabaseSuccessListener<Boolean> {
        return object : DatabaseSuccessListener<Boolean>() {
            override fun onSuccessResponse(results: Boolean?) {
                if (results != null) {
                    declaration?.fav = results
                    if (results == true)
                        binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav_selected))
                    else binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav))
                }
            }
        }
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }
}