package edu.bo.ucb.express_app.Data.Source.Remote.Dto

import edu.bo.ucb.express_app.Domain.Model.Character

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin,
        gender = gender,
        location = location,
        image = image
    )
}