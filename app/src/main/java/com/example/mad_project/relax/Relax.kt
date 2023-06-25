package com.example.mad_project.relax

data class RelaxTechnique(
    val id: String,
    val title: String,
    val inventor: String,
    val description: String,
    val contraindications: String,
    val videoUrl: List<String>,
)

fun getRelaxTechnique(): List<RelaxTechnique> {
    return listOf(
        RelaxTechnique(
            id = "1",
            title = "Meditation",
            inventor = "Unknown, hence it exists decades",

            description = "Meditation is a way to calm your mind and find inner peace. By sitting quietly and focusing your attention, you can relax your body and quiet your thoughts.\n\n" +
                    "It's like giving your mind a break from all the noise and busyness of life. Through regular practice, you can feel more calm, centered, and connected with yourself.\n\n" +
                    "Meditation is a simple yet powerful tool to help you feel better and find a sense of inner stillness.",
            contraindications =
            "• Extreme tiredness\n" +
                    "• Fullness a heavy meal\n" +
                    "• Flashbacks or intrusions\n" +
                    "• An acute psychotic episode\n" +
                    "• Severe depression or suicidal thoughts\n" +
                    "• Bipolar disorder (during manic episodes)\n",
            videoUrl = listOf(
                "z0GtmPnqAd8", "C5MaztWGaN0", "nIb2LbqHtY4", "G1TD2uVdotM", "zdDQ5Nj8",
                "3eEITlaLjhc", "8xqvw9ocerg", "fVF56TnXjgQ", "IzV6J4WCwRM", "euCACO-KtHE"
            )
        ),
        RelaxTechnique(
            id = "2",
            title = "Progressive Muscle Relaxation",
            inventor = "Edmund Jacobson (Psychiatrist)",
            description = "Progressive Muscle Relaxation (PMR) is a technique that involves deliberately tensing and then releasing different muscle groups in your body. By intentionally tensing the muscles and then letting go, you become more aware of the sensations of tension and relaxation." +
                    "PMR helps you achieve a state of calm concentration. Incorporate PMR into your routine for optimal learning and academic success.",
            contraindications =
            "• Musculoskeletal injuries or conditions\n" +
                    "• Acute or chronic pain\n" +
                    "• Cardiovascular disorders\n" +
                    "• Respiratory conditions\n" +
                    "• Severe cognitive impairments\n" +
                    "• Uncontrolled hypertension\n" +
                    "• Epilepsy or seizure disorders\n" +
                    "• Recent surgery or trauma\n" +
                    "• Pregnancy complications\n" +
                    "• Infectious diseases or fevers\n",
            videoUrl = listOf(
                "D7QoBABZu8k",
                "pyxvL1O2duk",
                "QkswdqpHqww",
                "_1h-zizAGsc",
                "SNqYG95j_UQ",
                "86HUcX8ZtAk",
                "6wMkq5uUSN8",
                "fDZI-4udE_o",
                "IZub-H2G4d4",
                "B3anDh-jxw4&t"
            )
        ),

        RelaxTechnique(
            id = "3",
            title = "Autogenic Training",
            inventor = "Johannes Heinrich Schultz (German psychiatrist)",
            description = "Autogenic Training is a relaxation technique that focuses on self-regulation and self-control. " +
                    "By using self-suggestions and visualizations, it aims to induce a state of deep relaxation and reduce stress. " +
                    "Practitioners learn to focus on specific bodily sensations, such as warmth or heaviness, and use affirmations to promote relaxation and well-being.\n" +
                    "Crush exam anxiety, absorb knowledge, and unlock your true learning potential.\n",
            contraindications = "• Severe cognitive impairments\n" +
                    "• Uncontrolled high blood pressure\n" +
                    "• Epilepsy or history of seizures\n" +
                    "• Acute psychosis\n" +
                    "• Harmful intrusive thoughts\n" +
                    "• Severe depression",
            videoUrl = listOf(
                "PqnGEh0KIig", "H62t26iYF9o", "yof5RsL_62s", "_39ZYOUxj_8", "2kvjiWEcOy8",
                "ELdlFwJOeK8", "P-_6GlnlOtM", "MFxlK1ZvOmA", "ZAlkoCkb1Ws", "ZHoTgwG_v5U"
            )
        )

    )


}