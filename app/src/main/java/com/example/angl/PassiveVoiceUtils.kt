package com.example.angl

class PassiveVoiceUtils(
    private val sentence: List<String>
) {

    private val types: Map<String, String> = mapOf(
        "Present Simple" to "Present Simple",
        "Present Continuous" to "Present Continuous",
        "Present Perfect" to "Present Perfect",

        "Past Simple" to "Past Simple",
        "Past Continuous" to "Past Continuous",
        "Past Perfect" to "Past Perfect",

        "Future Simple" to "Future Simple",
        "Future Perfect" to "Future Perfect",
    )

    private val AmIsAre: List<String> = listOf("am", "is", "are")
    private val WasWere: List<String> = listOf("was", "were")
    private val HaveHas: List<String> = listOf("have", "has")
    private val V3s: List<String> = listOf(
        "beaten",
        "become",
        "begun",
        "bent",
        "bet",
        "bitten",
        "blown",
        "broken",
        "brought",
        "built",
        "bought",
        "caught",
        "chosen",
        "come",
        "cost",
        "Cut",
        "dealt",
        "dug",
        "done",
        "drawn",
        "drunk",
        "driven",
        "eaten",
        "fallen",
        "fed",
        "felt",
        "fought",
        "found",
        "flown",
        "forgotten",
        "frozen",
        "got",
        "given",
        "gone",
        "grown",
        "hung",
        "had",
        "heard",
        "hidden",
        "hit",
        "held",
        "hurt",
        "kept",
        "known",
        "laid",
        "led",
        "left",
        "lent",
        "let",
        "lain",
        "lit",
        "lost",
        "paid",
        "met",
        "made",
        "meant",
        "put",
        "read",
        "ridden",
        "rung",
        "risen",
        "sought",
        "sold",
        "set",
        "shaken",
        "shone",
        "shot",
        "shown",
        "shut",
        "sung",
        "sunk",
        "sat",
        "slept",
        "spoken",
        "spent",
        "stood",
        "stolen",
        "stuck",
        "struck",
        "sworn",
        "swept",
        "swung",
        "taken",
        "taught",
        "torn",
        "told",
        "thought",
        "thrown",
        "understood",
        "woken",
        "worn",
        "won",
        "written",

        //v3 normal form
        "wanted",
        "looked",
        "used",
        "worked",
        "called",
        "tried",
        "asked",
        "needed",
        "seemed",
        "helped",
        "talked",
        "turned",
        "started",
        "played",
        "moved",
        "liked",
        "believed",
        "happened",
        "provided",
        "included",
        "continued",
        "learned",
        "changed",
        "watched",
        "followed",
        "stopped",
        "created",
        "allowed",
        "added",
        "opened",
        "walked",
        "offered",
        "remembered",
        "loved",
        "considered",
        "appeared",
        "waited",
        "served",
        "died",
        "expected",
        "stayed",
        "reached",
        "killed",
        "remained",
        "suggested",
        "raised",
        "passed",
        "required",
        "reported",
        "decided",
        "pulled",
    )


    private fun isContainsV3(): Boolean {
        return sentence.any(V3s::contains)
    }

    private fun isContainsAmIsAre(): Boolean {
        return sentence.any(AmIsAre::contains)
    }

    private fun isContainsHaveHas(): Boolean {
        return sentence.any(HaveHas::contains)
    }

    private fun isContainsHave(): Boolean {
        return sentence.contains("have")
    }

    private fun isContainsWasWere(): Boolean {
        return sentence.any(WasWere::contains)
    }

    private fun isContainsBeing(): Boolean {
        return sentence.contains("being")
    }

    private fun isContainsHad(): Boolean {

        return sentence.contains("had")
    }

    private fun isContainsBeen(): Boolean {
        return sentence.contains("been")
    }

    private fun isContainsWill(): Boolean {
        return sentence.contains("will")
    }

    private fun isContainsBe(): Boolean {
        return sentence.contains("be")
    }

    fun calculateType(): String? {
        if (!isContainsV3()) return null

        //Present
        if (isContainsAmIsAre()) {
            //Проверка на дурака
            if (isContainsHaveHas() || isContainsWasWere() || isContainsHad()
                || isContainsBeen() || isContainsBe() || isContainsWill()
            )
                return null

            return if (isContainsBeing())
                types["Present Continuous"]
            else
                types["Present Simple"]
        }
        if (isContainsHaveHas() && isContainsBeen()) {
            //Проверка на дурака
            if (isContainsAmIsAre() || isContainsWasWere() || isContainsHad()
                || isContainsBe() || isContainsWill()
            )
                return null
            return types["Present Perfect"]
        }

        //Past
        if (isContainsWasWere()) {
            //Проверка на дурака
            if (isContainsHaveHas() || isContainsHad() || isContainsAmIsAre()
                || isContainsBeen() || isContainsBe() || isContainsWill()
            )
                return null

            return if (isContainsBeing())
                types["Past Continuous"]
            else
                types["Past Simple"]
        }
        if (isContainsHad() && isContainsBeen()) {
            //Проверка на дурака
            if (isContainsHaveHas() || isContainsWasWere() || isContainsAmIsAre()
                || isContainsBe() || isContainsWill() || isContainsBeing()
            )
                return null

            return types["Past Perfect"]
        }

        //Future
        if (isContainsWill() && isContainsBe()) {
            //Проверка на дурака
            if (isContainsHaveHas() || isContainsWasWere() || isContainsHad()
                || isContainsBeen() || isContainsBeing()
            )
                return null

            return types["Future Simple"]
        }
        if (isContainsWill() && isContainsHave() && isContainsBeen()) {
            //Проверка на дурака
            if (isContainsBe() || isContainsWasWere() || isContainsHad() || isContainsAmIsAre()
                || isContainsBeing()
            )
                return null

            return types["Future Perfect"]
        }


        return null
    }
}