package com.danielle.examplespek

import com.google.common.truth.Truth.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.junit.jupiter.api.assertThrows
import java.lang.Exception

class CurrentAccountTests  : Spek({

    afterEachGroup {
        print("AFTER EACH GROUP ~~ resetting \n")
        CurrentAccountImplementation.disconnect()
    }

    afterEachTest {
        print("AFTER EACH TEST\n")
    }

    describe("end to end flow of typical user") {
        print("entering describe typical user\n")

        CurrentAccountImplementation.connect()

        it("balance starts at 0") {
            print("entering it balance 0\n")

            assertThat(CurrentAccountImplementation.getCurrentBalance()).isEqualTo(0)
        }

        it("balance is 10 when I add 10") {
            print("entering it balance is 10\n")
            CurrentAccountImplementation.addMoney(10)
            assertThat(CurrentAccountImplementation.getCurrentBalance()).isEqualTo(10)
        }

        it("balance is 5 when I withdraw 5") {
            print("entering it balance is 5\n")
            CurrentAccountImplementation.takeMoney(5)
            assertThat(CurrentAccountImplementation.getCurrentBalance()).isEqualTo(5)
        }
    }

    describe("error handling for insufficient funds") {
        print("entering describe error handling insufficient funds\n")
        CurrentAccountImplementation.connect()

        it("balance starts at 0") {
            print("entering it balance 0\n")
            assertThat(CurrentAccountImplementation.getCurrentBalance()).isEqualTo(0)
        }

        it("should throw an error with insufficient funds") {
            val exception = assertThrows<Exception>("Should throw an Exception") {
                CurrentAccountImplementation.takeMoney(100)
            }

            assertThat(exception).hasMessageThat().isEqualTo("insufficient funds")
        }

    }
})