package com.quickcoach.customs

interface ResponseListener {

    //API Response Listener
    fun onResponse(
        tag:String,
        result: String,
        obj: Any?
    )
    {}
}