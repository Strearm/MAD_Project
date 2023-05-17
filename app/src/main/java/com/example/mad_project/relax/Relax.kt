package com.example.mad_project.relax

data class RelaxTechnique(
    val id: String,
    val title: String,
    val inventor: String,
    val description: String,
)

fun getRelaxTechnique(): List<RelaxTechnique> {
    return listOf(
        RelaxTechnique(id = "1",
            title = "Meditation",
            inventor = "Guru Diese",
            description = "Meditationstechnikbeschreibung"
            ),
        RelaxTechnique(id = "2",
            title = "Progressive Muscle Relaxation",
            inventor = "Jacobson",
            description = "Muskel Entspannt Geist Entspannt ye"
        ),

        RelaxTechnique(id = "3",
            title = "Autogenetic Training",
            inventor = "Mega Guru",
            description = "Orge Entspannung"
        )

    )


}