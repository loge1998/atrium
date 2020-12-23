@file:Suppress(
    "FINAL_UPPER_BOUND" /* remove once https://youtrack.jetbrains.com/issue/KT-34257 is fixed */,
    "JAVA_MODULE_DOES_NOT_READ_UNNAMED_MODULE" /* TODO remove once https://youtrack.jetbrains.com/issue/KT-35343 is fixed */
)

package ch.tutteli.atrium.api.infix.en_GB

import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.logic.*
import java.time.DayOfWeek
import java.time.LocalDateTime

/**
 * Creates an [Expect] for the property [LocalDateTime.year][[LocalDateTime.getYear] of the subject of the assertion,
 * so that further fluent calls are assertions about it.
 *
 * @return The newly created [Expect] for the extracted feature.
 *
 * @since 0.12.0
 */
val Expect<LocalDateTime>.year: Expect<Int>
    get() = _logic.year().transform()

/**
 * Expects that the property [LocalDateTime.year][LocalDateTime.getYear] of the subject of the assertion
 * holds all assertions the given [assertionCreator] creates for it and
 * returns an [Expect] for the current subject of the assertion.
 *
 * @return An [Expect] for the current subject of the assertion.
 *
 * @since 0.12.0
 */
infix fun Expect<LocalDateTime>.year(assertionCreator: Expect<Int>.() -> Unit): Expect<LocalDateTime> =
    _logic.year().collectAndAppend(assertionCreator)

/**
 * Creates an [Expect] for the property [LocalDateTime.monthValue][LocalDateTime.getMonthValue]
 * of the subject of the assertion, so that further fluent calls are assertions about it.
 *
 * @return The newly created [Expect] for the extracted feature.
 *
 * @since 0.12.0
 */
val Expect<LocalDateTime>.month: Expect<Int>
    get() = _logic.month().transform()

/**
 * Expects that the property [LocalDateTime.monthValue][LocalDateTime.getMonthValue]of the subject of the assertion
 * holds all assertions the given [assertionCreator] creates for it and
 * returns an [Expect] for the current subject of the assertion.
 *
 * @return An [Expect] for the current subject of the assertion.
 *
 * @since 0.12.0
 */
infix fun Expect<LocalDateTime>.month(assertionCreator: Expect<Int>.() -> Unit): Expect<LocalDateTime> =
    _logic.month().collectAndAppend(assertionCreator)

/**
 * Creates an [Expect] for the property [LocalDateTime.dayOfWeek][LocalDateTime.getDayOfWeek]
 * of the subject of the assertion, so that further fluent calls are assertions about it.
 *
 * @return The newly created [Expect] for the extracted feature.
 *
 * @since 0.12.0
 */
val Expect<LocalDateTime>.dayOfWeek: Expect<DayOfWeek>
    get() = _logic.dayOfWeek().transform()

/**
 * Expects that the property [LocalDateTime.dayOfWeek][LocalDateTime.getDayOfWeek]of the subject of the assertion
 * holds all assertions the given [assertionCreator] creates for it and
 * returns an [Expect] for the current subject of the assertion.
 *
 * @return An [Expect] for the current subject of the assertion.
 *
 * @since 0.12.0
 */
infix fun Expect<LocalDateTime>.dayOfWeek(assertionCreator: Expect<DayOfWeek>.() -> Unit): Expect<LocalDateTime> =
    _logic.dayOfWeek().collectAndAppend(assertionCreator)

/**
 * Creates an [Expect] for the property [LocalDateTime.dayOfMonth][LocalDateTime.getDayOfMonth]
 * of the subject of the assertion, so that further fluent calls are assertions about it.
 *
 * @return The newly created [Expect] for the extracted feature.
 *
 * @since 0.12.0
 */
val Expect<LocalDateTime>.day: Expect<Int>
    get() = _logic.day().transform()

/**
 * Expects that the property [LocalDateTime.dayOfMonth][LocalDateTime.getDayOfMonth] of the subject of the assertion
 * holds all assertions the given [assertionCreator] creates for it and
 * returns an [Expect] for the current subject of the assertion.
 *
 * @return An [Expect] for the current subject of the assertion.
 *
 * @since 0.12.0
 */
infix fun Expect<LocalDateTime>.day(assertionCreator: Expect<Int>.() -> Unit): Expect<LocalDateTime> =
    _logic.day().collectAndAppend(assertionCreator)

