package com.sarang.torang.data.finding

data class FindingFilter(
    var searchType: String = "AROUND",
    var keyword: String? = null,
    var distances: String? = null,
    var prices: List<String>? = null,
    var restaurantTypes: List<String>? = null,
    var ratings: List<String>? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var northEastLon: Double = 0.0,
    var northEastLat: Double = 0.0,
    var southWestLon: Double = 0.0,
    var southWestLat: Double = 0.0,
)
