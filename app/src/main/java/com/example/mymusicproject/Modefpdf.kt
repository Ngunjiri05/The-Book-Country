package com.example.mymusicproject

import java.sql.Timestamp

class Modefpdf {
    var uid:String = ""
    var id:String = ""
    var title:String = ""
    var description:String = ""
    var categoryId:String = ""
    var url:String = ""
    var timestamp:Long =0
    var viewscount:Long =0
    var downloadsCount:Long =0

    constructor()

    constructor(
        uid: String,
        id: String,
        title: String,
        description:String,
        categoryId:String,
        url: String,
        timestamp: Long,
        viewscount: Long,
        downloadsCount: Long,
    ){
        this.uid = uid
        this.id = id
        this.title = title
        this.description = description
        this.categoryId = categoryId
        this.url = url
        this.timestamp = timestamp
        this.viewscount = viewscount
        this.downloadsCount = downloadsCount
    }
}