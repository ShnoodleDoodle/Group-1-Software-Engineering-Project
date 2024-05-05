package com.example.v2

class DataClass {
    var Resident: String? = null
    var Age: String? = null
    var Desc: String? = null
    var Medication: String? = null
    var Image: String? = null
    constructor(dataResident: String?, dataAge: String?, dataDesc: String?, dataMedication: String?, dataImage: String?){
        this.Resident = dataResident
        this.Age = dataAge
        this.Desc = dataDesc
        this.Medication = dataMedication
        this.Image = dataImage
    }
    constructor()
    {}
}