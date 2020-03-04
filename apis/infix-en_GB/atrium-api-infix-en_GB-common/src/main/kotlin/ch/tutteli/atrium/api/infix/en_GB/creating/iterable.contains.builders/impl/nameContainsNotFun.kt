package ch.tutteli.atrium.api.infix.en_GB.creating.iterable.contains.builders.impl

import ch.tutteli.atrium.api.infix.en_GB.Values
import ch.tutteli.atrium.api.infix.en_GB.containsNot
import ch.tutteli.atrium.creating.Expect
import kotlin.reflect.KFunction3

internal object StaticName {
    private val f: KFunction3<Expect<Iterable<Double>>, Double, Array<out Double>, Expect<Iterable<Double>>> =
        Expect<Iterable<Double>>::containsNot
    val nameContainsNotValuesFun = "`${f.name} ${Values::class.simpleName}`"
}
