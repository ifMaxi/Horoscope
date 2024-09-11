package com.maxidev.horoscope.utils

import com.maxidev.horoscope.R
import com.maxidev.horoscope.presentation.horoscope.home.Signs
import com.maxidev.horoscope.presentation.horoscope.sign.Sign

object SignUtils {
    val signs = listOf(
        Signs(
            image = R.drawable.aries,
            sign = R.string.sign_aries,
            signName = "Aries",
            date = "Mar 21 - Apr 19"
        ),
        Signs(
            image = R.drawable.taurus,
            sign = R.string.sign_taurus,
            signName = "Taurus",
            date = "Apr 20 - May 20"
        ),
        Signs(
            image = R.drawable.gemini,
            sign = R.string.sign_gemini,
            signName = "Gemini",
            date = "May 21 - Jun 20"
        ),
        Signs(
            image = R.drawable.cancer,
            sign = R.string.sign_cancer,
            signName = "Cancer",
            date = "Jun 21 - Jul 22"
        ),
        Signs(
            image = R.drawable.leo,
            sign = R.string.sign_leo,
            signName = "Leo",
            date = "Jul 23 - Aug 22"
        ),
        Signs(
            image = R.drawable.virgo,
            sign = R.string.sign_virgo,
            signName = "Virgo",
            date = "Aug 23 - Sep 22"
        ),
        Signs(
            image = R.drawable.libra,
            sign = R.string.sign_libra,
            signName = "Libra",
            date = "Sep 23 - Oct 22"
        ),
        Signs(
            image = R.drawable.scorpio,
            sign = R.string.sign_scorpio,
            signName = "Scorpio",
            date = "Oct 23 - Nov 21"
        ),
        Signs(
            image = R.drawable.sagittarius,
            sign = R.string.sign_sagittarius,
            signName = "Sagittarius",
            date = "Nov 22 - Dec 21"
        ),
        Signs(
            image = R.drawable.capricorn,
            sign = R.string.sign_capricorn,
            signName = "Capricorn",
            date = "Dec 22 - Jan 19"
        ),
        Signs(
            image = R.drawable.aquarius,
            sign = R.string.sign_aquarius,
            signName = "Aquarius",
            date = "Jan 20 - Feb 18"
        ),
        Signs(
            image = R.drawable.pisces,
            sign = R.string.sign_pisces,
            signName = "Pisces",
            date = "Feb 19 - Mar 20"
        )
    ).sortedBy { it.sign }

    val signsDaily = listOf(
        Sign(
            image = R.drawable.aries_a,
            icon = R.drawable.aries_icon,
            signName = "Aries"
        ),
        Sign(
            image = R.drawable.taurus_t,
            icon = R.drawable.taurus_icon,
            signName = "Taurus"
        ),
        Sign(
            image = R.drawable.gemini_g,
            icon = R.drawable.gemini_icon,
            signName = "Gemini"
        ),
        Sign(
            image = R.drawable.cancer_c,
            icon = R.drawable.cancer_icon,
            signName = "Cancer"
        ),
        Sign(
            image = R.drawable.leo_l,
            icon = R.drawable.leo_icon,
            signName = "Leo"
        ),
        Sign(
            image = R.drawable.virgo_v,
            icon = R.drawable.virgo_icon,
            signName = "Virgo"
        ),
        Sign(
            image = R.drawable.libra_l,
            icon = R.drawable.libra_icon,
            signName = "Libra"
        ),
        Sign(
            image = R.drawable.scorpio_s,
            icon = R.drawable.scorpio_icon,
            signName = "Scorpio"
        ),
        Sign(
            image = R.drawable.sagittarius_s,
            icon = R.drawable.sagittarius_icon,
            signName = "Sagittarius"
        ),
        Sign(
            image = R.drawable.capricorn_c,
            icon = R.drawable.capricorn_icon,
            signName = "Capricorn"
        ),
        Sign(
            image = R.drawable.aquarius_a,
            icon = R.drawable.aquarius_icon,
            signName = "Aquarius"
        ),
        Sign(
            image = R.drawable.pisces_p,
            icon = R.drawable.pisces_icon,
            signName = "Pisces"
        )
    )
}