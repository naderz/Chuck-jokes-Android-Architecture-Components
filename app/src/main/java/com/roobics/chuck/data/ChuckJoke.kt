package com.roobics.chuck.data

import com.google.gson.annotations.SerializedName

data class ChuckJoke(@SerializedName("icon_url")
                     val iconUrl: String = "",
                     @SerializedName("id")
                     val id: String = "",
                     @SerializedName("value")
                     val value: String = "",
                     @SerializedName("url")
                     val url: String = "")