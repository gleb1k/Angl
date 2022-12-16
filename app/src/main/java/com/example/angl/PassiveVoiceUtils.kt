package com.example.angl

object PassiveVoiceUtils {

    val types: Map<String, String> = mapOf(
        "Present Simple" to "Present Simple",
        "Present Continuous" to "Present Continuous",
        "Present Perfect" to "Present Perfect",

        "Past Simple" to "Past Simple",
        "Past Continuous" to "Past Continuous",
        "Past Perfect" to "Past Perfect",

        "Future Simple" to "Future Simple",
    )
    val AmIsAre: List<String> = listOf("am", "is", "are")
    val WasWere: List<String> = listOf("was", "were")
    val HaveHas: List<String> = listOf("have", "has")
    val V3s: List<String> = listOf(
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


    fun isContainsV3(splittedSentence: List<String>): Boolean {
        return splittedSentence.any(V3s::contains)
    }

    fun isContainsAmIsAre(splittedSentence: List<String>): Boolean {
        return splittedSentence.any(AmIsAre::contains)
    }

    fun isContainsHaveHas(splittedSentence: List<String>): Boolean {
        return splittedSentence.any(HaveHas::contains)
    }

    fun isContainsHave(splittedSentence: List<String>): Boolean {
        return splittedSentence.any("have"::contains)
    }

    fun isContainsWasWere(splittedSentence: List<String>): Boolean {
        return splittedSentence.any(WasWere::contains)
    }

    fun isContainsBeing(splittedSentence: List<String>): Boolean {
        return splittedSentence.any("being"::contains)
    }

    fun isContainsHad(splittedSentence: List<String>): Boolean {
        return splittedSentence.any("had"::contains)
    }

    fun isContainsBeen(splittedSentence: List<String>): Boolean {
        return splittedSentence.any("been"::contains)
    }

    fun isContainsWill(splittedSentence: List<String>): Boolean {
        return splittedSentence.any("will"::contains)
    }

    fun isContainsBe(splittedSentence: List<String>): Boolean {
        return splittedSentence.any("be"::contains)
    }

    fun calculateType(sentence: List<String>): String? {
        if (!isContainsV3(sentence)) return null

        //Present
        if (isContainsAmIsAre(sentence)) {
            return if (isContainsBeing(sentence))
                types["Present Continuous"]
            else
                types["Present Simple"]
        }
        if (isContainsHaveHas(sentence) && isContainsBeen(sentence))
            return types["Present Perfect"]

        //Past
        if (isContainsWasWere(sentence)) {
            return if (isContainsBeing(sentence))
                types["Past Continuous"]
            else
                types["Past Simple"]
        }
        if (isContainsHad(sentence) && isContainsBeen(sentence))
            return types["Past Perfect"]

        //Future
        if (isContainsWill(sentence) && isContainsBe(sentence)) {
            return types["Future Simple"]
        }
        if (isContainsWill(sentence) && isContainsHave(sentence) && isContainsBeen(sentence))
            return types["Future Perfect"]

        return null
    }
}