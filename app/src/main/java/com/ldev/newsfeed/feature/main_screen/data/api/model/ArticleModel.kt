package com.ldev.newsfeed.feature.main_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    @SerializedName("source")
    val source: ArticleSourceModel,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String?,
)
/*
    -"articles": [
    -{
        -"source": {
        "id": null,
        "name": "Juancole.com"
    },
        "author": "Clean Energy Wire",
        "title": "Germany: Tesla’s Electric Car sales overtake leading domestic automakers in September",
        "description": "By Edgar Meza | - ( Clean Energy Wire) - Tesla is flying high in Germany: In September, more electric Tesla Model 3s were registered in the country than leading domestic models, such as the BMW 3 Series, Audi A4 and Mercedes C-Class combined, business news ma…",
        "url": "https://www.juancole.com/2021/10/electric-automakers-september.html",
        "urlToImage": "https://www.juancole.com/images/2021/10/germany-teslas-electric-car-sale.jpg",
        "publishedAt": "2021-10-16T04:06:57Z",
        "content": "By Edgar Meza | – \r\n( Clean Energy Wire) – Tesla is flying high in Germany: In September, more electric Tesla Model 3s were registered in the country than leading domestic models, such as the BMW 3 S… [+2046 chars]"
    }
   ]*/