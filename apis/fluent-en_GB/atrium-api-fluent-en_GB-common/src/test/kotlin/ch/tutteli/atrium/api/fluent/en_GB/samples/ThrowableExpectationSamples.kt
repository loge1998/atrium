package ch.tutteli.atrium.api.fluent.en_GB.samples

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.internal.expect
import kotlin.test.Test

class ThrowableExpectationSamples {

    @Test
    fun messageToContain() {
        expect(RuntimeException("abc")).messageToContain("b")

        fails {
            expect(RuntimeException("abc")).messageToContain("d")
        }
    }

    @Test
    fun messageFeature() {
        expect(RuntimeException("abc")).message.toContain("a")

        fails {
            expect(RuntimeException("abc")).message.toContain("d")
        }
    }

    @Test
    fun message() {
        expect(RuntimeException("abc")).message { // subject inside this block is of type String (actually "abc")
            toContain("a")
        }

        fails {
            expect(RuntimeException("abc")).message { // subject inside this block is of type String (actually "abc")
                toContain("d")
            }
        }
    }

    @Test
    fun causeFeature() {
        expect(IllegalStateException(IndexOutOfBoundsException("abc")))
            .cause<IndexOutOfBoundsException>() // subject is now of type IndexOutOfBoundsException
            .messageToContain("b")

        fails {
            expect(IllegalStateException(IndexOutOfBoundsException("abc")))
              .cause<IllegalStateException>()
              .messageToContain("d") // not shown in reporting as `cause<IllegalStateException>()` already fails

        }
    }

    @Test
    fun cause() {
        expect(IllegalStateException(IndexOutOfBoundsException("abc"))).cause<IndexOutOfBoundsException> { // subject is now of type IndexOutOfBoundsException
            messageToContain("b")
        }

        fails { // because wrong type expected (IllegalStateException instead of IndexOutOfBoundsException), but since we use a block...
            expect(IllegalStateException(IndexOutOfBoundsException("abc"))).cause<IllegalStateException> { 
                messageToContain("b") // ... reporting mentions that subject's message was expected `to contain: "b"`
            }
        }
    }
}
