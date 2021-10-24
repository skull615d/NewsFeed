package com.ldev.newsfeed.base

import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}

fun mapToList(
    oldList: List<ArticleDomainModel>,
    newList: List<ArticleDomainModel>
): List<ArticleDomainModel> {
    return oldList.map { article ->
        article.copy(isBookmarked = newList.map { it.url }.contains(article.url))
    }
}