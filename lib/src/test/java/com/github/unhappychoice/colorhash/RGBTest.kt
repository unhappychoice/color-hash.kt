package com.github.unhappychoice.colorhash

import com.winterbe.expekt.expect
import io.polymorphicpanda.kspec.KSpec
import io.polymorphicpanda.kspec.describe
import io.polymorphicpanda.kspec.it
import io.polymorphicpanda.kspec.junit.JUnitKSpecRunner
import org.junit.runner.RunWith

@RunWith(JUnitKSpecRunner::class)
class RGBTest(): KSpec() {
    override fun spec() {
        describe("RGB") {
            it("should return hex for rgb") {
                val hex = RGB(Triple(255, 64, 0)).toHex()
                expect(hex).to.equal("#ff4000")
            }
            it("should return 6 digits hex for even small rgb values") {
                val hex = RGB(Triple(1, 15, 16)).toHex()
                expect(hex).to.equal("#010f10")
            }
        }
    }
}