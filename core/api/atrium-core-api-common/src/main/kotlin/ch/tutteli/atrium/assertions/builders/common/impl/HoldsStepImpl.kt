package ch.tutteli.atrium.assertions.builders.common.impl

import ch.tutteli.atrium.assertions.builders.common.HoldsStep
import ch.tutteli.atrium.core.falseProvider

internal abstract class HoldsStepImpl<R> : HoldsStep<R> {
    //TODO use falseProvider https://youtrack.jetbrains.com/issue/KT-27736
    override val failing: R = withTest { false }
    //TODO use trueProvider https://youtrack.jetbrains.com/issue/KT-27736
    override val holding: R = withTest { true }

    override fun <T> withTest(@Suppress("DEPRECATION") subjectProvider: ch.tutteli.atrium.creating.SubjectProvider<T>, test: (T) -> Boolean): R = withTest {
        subjectProvider.maybeSubject.fold(falseProvider, test)
    }

    final override fun withTest(test: () -> Boolean): R = createNextStep(test)

    protected abstract fun createNextStep(test: () -> Boolean): R
}
