package ch.tutteli.atrium.assertions.builders

/**
 * Contract for sub option steps which are based on a defined or absent subject of the assertion.
 */
interface SubjectBasedOption {

    /**
     * Sub option step in case the subject is defined.
     *
     * @param T The type of the subject of the assertion
     * @param R The resulting type which should be created.
     */
    interface DefinedOption<T, R, AO : AbsentOption<T, R>> {
        /**
         * Defines the failure hint factory which should be used if the subject of the assertion is defined.
         */
        fun ifDefined(failureHintFactory: (T) -> R): AO
    }

    /**
     * Sub option step in case the subject is absent
     *
     * @param T The type of the subject of the assertion
     * @param R The resulting type which should be created.
     */
    interface AbsentOption<T, R> {
        /**
         * The previously defined factory in case the subject of the assertion is defined.
         */
        val ifDefined: (T) -> R

        /**
         * Defines the failure hint factory which should be used if the subject of the assertion is not defined.
         */
        infix fun ifAbsent(failureHintFactory: () -> R): Pair<() -> R, (T) -> R> =
            failureHintFactory to ifDefined
    }

    companion object {
        @Suppress("DEPRECATION")
        operator fun <T, R, PO : DefinedOption<T, R, *>> invoke(
            subjectProvider: ch.tutteli.atrium.creating.SubjectProvider<T>,
            subStep: PO.() -> Pair<() -> R, (T) -> R>,
            presentOptionFactory: () -> PO
        ): R {
            val (ifAbsent, ifPresent) = presentOptionFactory().subStep()
            return subjectProvider.maybeSubject.fold(ifAbsent, ifPresent)
        }
    }
}
