package com.example.mad_project.relax

data class RelaxTechnique(
    val id: String,
    val title: String,
    val inventor: String,
    val description: String,
    val videoUrl: List<String>,
)

fun getRelaxTechnique(): List<RelaxTechnique> {
    return listOf(
        RelaxTechnique(
            id = "1",
            title = "Meditation",
            inventor = "Guru Diese",
            description = "Meditationstechnikbeschreibung",
            videoUrl = listOf("z0GtmPnqAd8", "C5MaztWGaN0","nIb2LbqHtY4")
            ),
        RelaxTechnique(
            id = "2",
            title = "Progressive Muscle Relaxation",
            inventor = "Jacobson",
            description = "Muskel Entspannt Geist Entspannt ye",
            videoUrl = listOf("D7QoBABZu8k", "pyxvL1O2duk","wGlWXiu4vLA","_1h-zizAGsc",
                "SNqYG95j_UQ", "86HUcX8ZtAk", "6wMkq5uUSN8", "fDZI-4udE_o" )
        ),

        RelaxTechnique(
            id = "3",
            title = "Autogenetic Training",
            inventor = "Mega Guru",
            description = "Orge Entspannung",
            videoUrl = listOf("PqnGEh0KIig")
        )

    )


}