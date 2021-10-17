package com.ldev.newsfeed.feature.main_screen.data

import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenArticleModel
import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenSourceModel
import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel
import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenSourceDomainModel

fun MainScreenSourceModel.toDomain() = MainScreenSourceDomainModel(name = name)

fun MainScreenArticleModel.toDomain() = MainScreenDomainModel(
    source = source.toDomain(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
    content

)




/*fun MainScreenArticleModel.toDomain(): List<MainScreenDomainModel>{
    return List<MainScreenDomainModel>()
}*/
