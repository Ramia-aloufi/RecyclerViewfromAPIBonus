package com.example.recyclerviewfromapibonus



object Constants {
     val url =  "https://dojo-recipes.herokuapp.com/"
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

}
