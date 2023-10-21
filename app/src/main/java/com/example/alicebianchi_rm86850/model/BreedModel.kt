package com.example.alicebianchi_rm86850.model

data class BreedModel(
    val country_code: String,
    val country_codes: String,
    val id: String,
    val life_span: String,
    val name: String,
    val origin: String,
    val temperament: String,
    val weight: WeightModel,
    val wikipedia_url: String
)