package com.example.mad_project.relax

data class RelaxTechnique(
    val id: String,
    val title: String,
    val inventor: String,
    val description: String,
    val videoUrl: String,
)

fun getRelaxTechnique(): List<RelaxTechnique> {
    return listOf(
        RelaxTechnique(
            id = "1",
            title = "Meditation",
            inventor = "Guru Diese",
            description = "Meditationstechnikbeschreibung",
            videoUrl = "t6jrkbgb9os&list=PL-yvVpWvnO7ZMJiPnrRFu18JPnYoktFxy"
            ),
        RelaxTechnique(
            id = "2",
            title = "Progressive Muscle Relaxation",
            inventor = "Jacobson",
            description = "Muskel Entspannt Geist Entspannt ye",
            videoUrl = "D7QoBABZu8k"
        ),

        RelaxTechnique(
            id = "3",
            title = "Autogenetic Training",
            inventor = "Mega Guru",
            description = "Orge Entspannung",
            videoUrl = "PqnGEh0KIig&list=PL-yvVpWvnO7Z8H5zkeI_RDu75RjaU_Tq2"
        )

    )


}