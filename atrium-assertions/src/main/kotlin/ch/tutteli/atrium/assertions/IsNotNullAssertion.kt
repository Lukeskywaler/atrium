package ch.tutteli.atrium.assertions

import ch.tutteli.atrium.reporting.RawString

/**
 * Represents an `is not null` assertion for a given `subject`.
 */
class IsNotNullAssertion(subject: Any?) : IOneMessageAssertion {
    override val message by lazy {
        Message(MESSAGE_DESCRIPTION, RawString.Companion.NULL, subject != null)
    }

    override fun toString() = message.toString()

    companion object {
        internal const val MESSAGE_DESCRIPTION = "is not"
    }
}