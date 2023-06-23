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

            description = "Meditation is a way to calm your mind and find inner peace. By sitting quietly and focusing your attention, you can relax your body and quiet your thoughts.\n\n" +
                    "It's like giving your mind a break from all the noise and busyness of life. Through regular practice, you can feel more calm, centered, and connected with yourself.\n\n" +
                    "Meditation is a simple yet powerful tool to help you feel better and find a sense of inner stillness.",
            bestAvoided =
                    "When you are extremely tired or sleepy " +
                    "\nDuring or immediately after a heavy meal" +
                    "\nWhen experiencing acute strong mental distress" +
                    "\nWhen under the influence of drugs/alcohol" +
                    "\nDuring a psychotic phase" +
                    "\nDuring trauma intrusions or flashbacks" ,
            videoUrl = listOf("z0GtmPnqAd8", "C5MaztWGaN0","nIb2LbqHtY4", "G1TD2uVdotM", "zdDQ5Nj8",
                "3eEITlaLjhc", "8xqvw9ocerg", "fVF56TnXjgQ", "IzV6J4WCwRM", "euCACO-KtHE")
            ),
        RelaxTechnique(
            id = "2",
            title = "Progressive Muscle Relaxation",
            inventor = "Edmund Jacobson (Psychiatrist)",
            description = "Improve your learning journey with Progressive Muscle Relaxation. Reduce stress, enhance concentration, and achieve a state of calm focus. Release muscle tension effortlessly, fostering a relaxed mind for effective studying. " +
                    "Experience the transformative benefits of this technique as you unwind and embrace a peaceful learning environment. Start your path to academic success by incorporating Progressive Muscle Relaxation into your routine. " +
                    "Discover the power of relaxation for optimal learning.",
            bestAvoided ="",
            videoUrl = listOf("D7QoBABZu8k", "pyxvL1O2duk","QkswdqpHqww","_1h-zizAGsc",
                "SNqYG95j_UQ", "86HUcX8ZtAk", "6wMkq5uUSN8", "fDZI-4udE_o", "IZub-H2G4d4", "B3anDh-jxw4&t" )
        ),

        RelaxTechnique(
            id = "3",
            title = "Autogenic Training",
            inventor = "Mega Guru",
            description = "Orge Entspannung",
            bestAvoided= "",
            videoUrl = listOf("PqnGEh0KIig", "H62t26iYF9o", "yof5RsL_62s", "_39ZYOUxj_8", "2kvjiWEcOy8",
                "ELdlFwJOeK8", "P-_6GlnlOtM", "MFxlK1ZvOmA", "ZAlkoCkb1Ws", "ZHoTgwG_v5U")
        )

    )


}