package ch.tutteli.atrium.creating.charsequence.contains.builders

import ch.tutteli.atrium.creating.charsequence.contains.CharSequenceContains
import ch.tutteli.atrium.creating.charsequence.contains.CharSequenceContains.SearchBehaviour
import ch.tutteli.atrium.creating.charsequence.contains.checkers.CheckerFactory

/**
 * The base class for builders which create a `contains not` check within the fluent API of a sophisticated
 * `contains` assertion for [CharSequence].
 *
 * @param T The input type of the search.
 * @param S The search behaviour which should be applied for the input of the search.
 *
 * @constructor The base class for builders which create a `contains at least` check within the fluent API of a
 *   sophisticated `contains` assertion for [CharSequence].
 */
abstract class NotCheckerBuilderBase<out T : CharSequence, out S : SearchBehaviour>(
    override val containsBuilder: CharSequenceContains.Builder<T, S>
) : CharSequenceContains.CheckerBuilder<T, S> {

    override val checkers = listOf(
        CheckerFactory.newNotChecker()
    )
}
