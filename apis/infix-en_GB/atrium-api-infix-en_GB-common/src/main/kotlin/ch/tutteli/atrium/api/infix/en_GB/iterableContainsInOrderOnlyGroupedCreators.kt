package ch.tutteli.atrium.api.infix.en_GB

import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.domain.builders.ExpectImpl
import ch.tutteli.atrium.domain.builders.creating.basic.contains.addAssertion
import ch.tutteli.atrium.domain.builders.utils.Group
import ch.tutteli.atrium.domain.builders.utils.groupsToList
import ch.tutteli.atrium.domain.creating.iterable.contains.IterableContains
import ch.tutteli.atrium.domain.creating.iterable.contains.IterableContains.Builder
import ch.tutteli.atrium.domain.creating.iterable.contains.searchbehaviours.InOrderOnlyGroupedWithinSearchBehaviour
import kotlin.jvm.JvmName

/**
 * Finishes the specification of the sophisticated `contains` assertion where the expected [Order.firstGroup] as well as
 * the [Order.secondGroup] and optionally [Order.otherExpectedGroups] of values need to be
 * contained in [Iterable] in the specified order whereas the values within the groups can occur in any order.
 *
 * @param order A parameter object containing the different groups which have to appear in order in the [Iterable].
 *
 * @return The [Expect] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E, T : Iterable<E>> Builder<E, T, InOrderOnlyGroupedWithinSearchBehaviour>.inAny(
    order: Order<E, Group<E>>
): Expect<T> = addAssertion(
    ExpectImpl.iterable.contains.valuesInOrderOnlyGrouped(
        this,
        groupsToList(order.firstGroup, order.secondGroup, order.otherExpectedGroups)
    )
)

/**
 * Finishes the specification of the sophisticated `contains` assertion where the expected [Order.firstGroup] as well as
 * the [Order.secondGroup] and optionally [Order.otherExpectedGroups] of identification lambdas, identifying an entry,
 * need to be contained in [Iterable] in the specified order whereas the identification lambdas within the groups
 * can occur in any order.
 *
 * An identification lambda can also be defined as `null` in which case it matches an entry which is `null` as well.
 *
 * @param order A parameter object containing the different groups which have to appear in order in the [Iterable].
 *
 * @return The [Expect] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
@JvmName("inAnyOrderEntries")
infix fun <E : Any, T : Iterable<E?>> Builder<E?, T, InOrderOnlyGroupedWithinSearchBehaviour>.inAnyOrder(
    order: Order<(Expect<E>.() -> Unit)?, Group<(Expect<E>.() -> Unit)?>>
): Expect<T> = addAssertion(
    ExpectImpl.iterable.contains.entriesInOrderOnlyGrouped(
        this,
        groupsToList(order.firstGroup, order.secondGroup, order.otherExpectedGroups)
    )
)
