package com.example.mad_project.relax

data class RelaxTechnique(
    val id: String,
    val title: String,
    val inventor: String,
    val description: String,
    val bestAvoided: String,
    val videoUrl: List<String>,
)

fun getRelaxTechnique(): List<RelaxTechnique> {
    return listOf(
        RelaxTechnique(
            id = "1",
            title = "Meditation",
            inventor = "Unknown, hence it exists decades" ,

            description = "\n" +
                    "Meditation is a way to calm your mind and find inner peace. By sitting quietly and focusing your attention, you can relax your body and quiet your thoughts. It's like giving your mind a break from all the noise and busyness of life. Through regular practice, you can feel more calm, centered, and connected with yourself. It's a simple yet powerful tool to help you feel better and find a sense of inner stillness.",
            bestAvoided =
                    "\nWhen you are extremely tired or sleepy " +
                    "\nDuring or immediately after a heavy meal" +
                    "\nWhen experiencing acute strong mental distress" +
                    "\nWhen under the influence of drugs/alcohol" +
                    "\nDuring a psychotic phase" +
                    "\nDuring trauma intrusions or flashbacks" ,
            videoUrl = listOf("z0GtmPnqAd8", "C5MaztWGaN0","nIb2LbqHtY4")
            ),
        RelaxTechnique(
            id = "2",
            title = "Progressive Muscle Relaxation",
            inventor = "Jacobson",
            description = "Muskel Entspannt Geist Entspannt ye",
            bestAvoided ="",
            videoUrl = listOf("D7QoBABZu8k", "pyxvL1O2duk","wGlWXiu4vLA","_1h-zizAGsc",
                "SNqYG95j_UQ", "86HUcX8ZtAk", "6wMkq5uUSN8", "fDZI-4udE_o" )
        ),

        RelaxTechnique(
            id = "3",
            title = "Autogenetic Training",
            inventor = "Mega Guru",
            description = "Orge Entspannung",
            bestAvoided= "",
            videoUrl = listOf("PqnGEh0KIig")
        )

    )


}