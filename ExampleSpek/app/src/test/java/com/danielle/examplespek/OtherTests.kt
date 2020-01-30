package com.danielle.examplespek

import org.spekframework.spek2.Spek

class OtherTests  : Spek({
    afterGroup {
        print("AFTER GROUP\n")
//        CurrentAccountImplementation.disconnect()
    }
    afterEachTest {
        print("AFTER EACH TEST\n")
//        CurrentAccountImplementation.disconnect()
    }
})