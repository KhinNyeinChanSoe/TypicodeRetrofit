package com.example.typicoderetrofit.model

import com.google.gson.annotations.SerializedName

data class Hospital(

	@field:SerializedName("hospitals")
	val hospitals: List<HospitalsItem?>? = null
)

data class HospitalsItem(

	@field:SerializedName("website_link")
	val websiteLink: String? = null,

	@field:SerializedName("phone_no")
	val phoneNo: String? = null,

	@field:SerializedName("hospital_image")
	val hospitalImage: String? = null,

	@field:SerializedName("facebook_link")
	val facebookLink: String? = null,

	@field:SerializedName("hospital_banner")
	val hospitalBanner: String? = null,

	@field:SerializedName("place")
	val place: String? = null,

	@field:SerializedName("hospital_id")
	val hospitalId: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("specialities")
	val specialities: List<SpecialitiesItem?>? = null,

	@field:SerializedName("hospital_name")
	val hospitalName: String? = null
)

data class SpecialitiesItem(

	@field:SerializedName("speciality_mname")
	val specialityMname: String? = null,

	@field:SerializedName("speciality_image")
	val specialityImage: String? = null,

	@field:SerializedName("speciality_id")
	val specialityId: Int? = null,

	@field:SerializedName("speciality_ename")
	val specialityEname: String? = null
)
