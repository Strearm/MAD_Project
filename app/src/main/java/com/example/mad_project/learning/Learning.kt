package com.example.mad_project.learning

data class Learning(
    val id: String,
    val title: String,
    val subtitle: String,
    val shortDesc: String,
    val description: String,
    val source: String,
    val image: String)

fun getLearnings(): List<Learning> {
    return listOf(
        Learning(
            id = "1",
            title = "The 2 Minute Rule",
            subtitle = "Work with full focus just for 2 minutes",
            shortDesc = "You start to work just for 2 minutes. After the 2 minutes you decide what to fo next. This Rule is a mental trick that forces you into action.",
            description = "Overcoming procrastination and laziness can be hard, but it doesn’t always have to be.\n" +
                    "\n" +
                    "A strategy that couldn’t be easier to use is the two-minute rule, which is designed to help you stop procrastinating and stick to good habits at the same time. The rule is simple: Starting a new habit should never take more than two minutes to do.\n" +
                    "\n" +
                    "(The name of this strategy was inspired by the author and productivity consultant David Allen. He has his own 2-minute rule for improving productivity, which states, “If it takes less than two minutes, then do it now.”)\n" +
                    "\n" +
                    "Generally, you’ll find that any habit can be scaled down into a two-minute version:\n" +
                    "\n" +
                    "• “Read before bed each night” becomes “read one page before bed each night.”\n" +
                    "• “Do 30 minutes of yoga” becomes “take out my yoga mat.”\n" +
                    "• “Study for class” becomes “open my notes.”\n" +
                    "• “Fold the laundry” becomes “fold one pair of socks.”\n" +
                    "• “Run three miles” becomes “tie my running shoes.”",
            source = "https://www.cnbc.com/2019/02/01/the-2-minute-rule-how-to-stop-procrastinating-and-start-new-habits.html",
            image = "https://www.jobillico.com/blog/wp-content/uploads/2020/09/The-2-Minute-Rule.jpg"
        ),
        Learning(
            id = "2",
            title = "52/17",
            subtitle = "Work for 52 min - Break for 17 min",
            shortDesc = "A group find out that the most productive way is to work for 52 minutes, then take breaks for 17 minutes.",
            description = "Have you ever worked so hard without a break that by the time you stand up you’re practically sprinting to the bathroom? Have you ever found yourself nodding off in front of your work, unable to focus? Well, guess what? Neither our bodies nor our brains are made to work without a break all day long.\n" +
                    "\n" +
                    "Taking a break, in fact, helps keep our memories intact. Scientists have long known that sleep helps solidify memory. Now it turns out that resting while awake–meaning taking a periodic break from work–plays a different but equal role in processing and ingraining information into the brain. Downtime, in essence, is a cognitive necessity not an indulgent treat. It replenishes attention and motivation, creativity and productivity.\n" +
                    "\n" +
                    "Scientists have even figured out the perfect formula for this break, down to the minute. It’s the 52/17 rule: 52 minutes on, 17 minutes off.",
            source = "https://neurotrack.com/resources/take-a-break-the-52-17-rule",
            image = "https://karrierebibel.de/wp-content/uploads/2017/05/Arbeitsrhythmus-Pausen-Intervall-52-17-Schema.png"
        ),
        Learning(
            id = "3",
            title = "90 Minute Focus Block",
            subtitle = "Similar to Pomodoro Technique",
            shortDesc = "The idea is to work in 90-minute blocks rather than 25 minute periods and make breaks for 20 minutes.",
            description = "The 90-minute focus block is similar to the Pomodoro technique except for the recommendation of working in long, 90-minute blocks rather than 25 minute periods.\n" +
                    "\n" +
                    "The concept lends itself to the book The Enchanted World of Sleep by Peretz Lavie and the idea of “ultradian rhythms“. These are phases similar to rapid eye movement (REM) sleep that is linked strongly to hormonal release. Our cognitive functions and energies are reported to be at their maximal during these periods.\n" +
                    "\n" +
                    "Occurring periodically throughout the day in 90-minute bursts of high-frequency brain activity, the idea is you “lock on” to this timing. Scheduling your productivity sessions alongside them, is the name of the game.",
            source = "https://willpeachmd.com/study-techniques-like-the-pomodoro-method#3_90_Minute_Focus_Block",
            image = "https://images.ctfassets.net/lzny33ho1g45/JXBeYRVZXnfu8B4s900mH/50030122c2f1dd6ef50388827b902bd4/ultradian_rhythm?w=1400"
        ),
        Learning(
            id = "4",
            title = "Pomodoro",
            subtitle = "Work for 25 min - short Break for 5 min",
            shortDesc = "1. Set a timer for 25 minutes\n" +
                    "2. Don't let you distract\n" +
                    "3. Take a 5 min break\n" +
                    "4. After four breaks do a 15 min break\n" +
                    "5. Repeat!",
            description = "The Pomodoro Technique was developed in the late 1980s by then university student Francesco Cirillo. Cirillo was struggling to focus on his studies and complete assignments. Feeling overwhelmed, he asked himself to commit to just 10 minutes of focused study time. Encouraged by the challenge, he found a tomato (pomodoro in Italian) shaped kitchen timer, and the Pomodoro technique was born.\n" +
                    "\n" +
                    "Though Cirillo went on to write a 130-page book about the method, its biggest strength is its simplicity:\n" +
                    "\n" +
                    "1) Get a to-do list and a timer.\n" +
                    "2) Set your timer for 25 minutes, and focus on a single task until the timer rings.\n" +
                    "3) When your session ends, mark off one pomodoro and record what you completed.\n" +
                    "4) Then enjoy a five-minute break.\n" +
                    "5) After four pomodoros, take a longer, more restorative 15-30 minute break.\n" +
                    "\n" +
                    "The 25-minute work sprints are the core of the method, but a Pomodoro practice also includes three rules for getting the most out of each interval:\n" +
                    "\n" +
                    "1) Break down complex projects. If a task requires more than four pomodoros, it needs to be divided into smaller, actionable steps. Sticking to this rule will help ensure you make clear progress on your projects.\n" +
                    "2) Small tasks go together. Any tasks that will take less than one Pomodoro should be combined with other simple tasks. For example, \"write rent check,\" \"set vet appointment,\" and \"read Pomodoro article\" could go together in one session.\n" +
                    "3) Once a pomodoro is set, it must ring. The pomodoro is an indivisible unit of time and can not be broken, especially not to check incoming emails, team chats, or text messages. Any ideas, tasks, or requests that come up should be taken note of to come back to later. A digital task manager like Todoist is a great place for these, but pen and paper will do too.\n" +
                    "\n" +
                    "In the event of an unavoidable disruption, take your five-minute break and start again. Cirillo recommends that you track interruptions (internal or external) as they occur and reflect on how to avoid them in your next session.\n" +
                    "\n" +
                    "The rule applies even if you do finish your given task before the timer goes off. Use the rest of your time for overlearning, or improving skills or scope of knowledge. For example, you could spend the extra time reading up on professional journals or researching networking opportunities.",

            source = "https://www.asundergrad.pitt.edu/study-lab/pomodoro-technique",
            image = "https://images.upgrad.com/8fad03a6-be50-411b-8e89-1903b8febada-shutterstock_2178474403%20(1).jpg"
        )
    ) }