package com.abdalla_mmdouh.myyelpcolne

import com.google.gson.annotations.SerializedName

data class YelpSearchResult (
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurant : List<YelpRestaurant>
)
data class YelpRestaurant(
    val name : String ,
    val rating : Double ,
    val price : String ,
    @SerializedName("review_count") val num_review : Int ,
    @SerializedName("distance") val distanceInMeters : Double ,
    @SerializedName("image_url") val image: String ,
    val categories : List<YelpCategories>,
    val location: YelpLocation
){
    fun displayDistance() : String{
        val kiloPerMeters = 0.001
        val distanceInKm = "0.2f".format(distanceInMeters * kiloPerMeters)
        return "$distanceInKm km"
    }
}
data class YelpCategories(
    @SerializedName("title") val menu : String
)
data class YelpLocation(
    val address1 : String
)