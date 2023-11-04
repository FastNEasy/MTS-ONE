package com.example.mtsrtone

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var spaceAdapter: SpaceArticleDataAdapter
    private var adapter: ArrayAdapter<SpaceArticleData.SpaceData>? = null

    private var spaceItems: MutableList<SpaceArticleData.SpaceData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val api = ApiClient.retrofit.create(ApiService::class.java)
        val call = api.getSpaceArticleData()

        call.enqueue(object : Callback<SpaceArticleData> {
            override fun onResponse(call: Call<SpaceArticleData>, response: Response<SpaceArticleData>) {
                if (response.isSuccessful) {
                    Log.d("MTS1", response.body().toString())
                    val retrievedSpaceArticles = response.body()
                    spaceItems.clear()
                    spaceItems = retrievedSpaceArticles?.results ?: ArrayList()
                    Log.d("MTS1", spaceItems.size.toString())
                    spaceAdapter = SpaceArticleDataAdapter(spaceItems)
                    recyclerView.adapter = spaceAdapter
                    recyclerView.addItemDecoration(
                        DividerItemDecoration(
                            baseContext,
                            (recyclerView.layoutManager as LinearLayoutManager).orientation
                        )
                    )
//                    adapter!!.notifyDataSetChanged()
                } else {
                    // Handle the error
                }
            }

            override fun onFailure(call: Call<SpaceArticleData>, t: Throwable) {
                // Handle network error
                Log.e("MTSR1", t.toString());
            }
        })
    }
}