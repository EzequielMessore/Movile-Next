package br.com.ezequiel.kotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.ezequiel.kotlin.R
import br.com.ezequiel.kotlin.adapter.ProgrammingLanguageAdapter
import br.com.ezequiel.kotlin.adapter.RepositoryAdapter
import br.com.ezequiel.kotlin.api.RepositoryRetriever
import br.com.ezequiel.kotlin.model.GithubRepositoryResult
import br.com.ezequiel.kotlin.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object : Callback<GithubRepositoryResult> {
        override fun onFailure(call: Call<GithubRepositoryResult>, t: Throwable) {
            longToast("Fail loading repositories.")
        }

        override fun onResponse(call: Call<GithubRepositoryResult>,
                                response: Response<GithubRepositoryResult>) {
            longToast("load success")

            if (response.isSuccessful) {
                val resultList = response.body()?.repositories ?: emptyList()

                recyclerView.adapter = RepositoryAdapter(resultList) {
                    longToast("Clicked item: ${it.full_name}")
                }
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadDefaultRecyclerView()

    }

    private fun loadDefaultRecyclerView() {
        recyclerView.adapter = ProgrammingLanguageAdapter(recyclerViewItems()) {
            repositoryRetriever.getLanguageRepository(callback, it.title)
        }
    }

    private fun recyclerViewItems(): List<ProgrammingLanguage> {
        val kotlin = ProgrammingLanguage(
                title = "Kotlin",
                imageResourceId = R.drawable.kotlin,
                description = "Kotlin is a language",
                year = 2010)

        return listOf(kotlin)
    }
}
