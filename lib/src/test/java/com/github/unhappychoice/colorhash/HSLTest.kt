package com.github.unhappychoice.colorhash

import com.winterbe.expekt.expect
import io.polymorphicpanda.kspec.KSpec
import io.polymorphicpanda.kspec.describe
import io.polymorphicpanda.kspec.it
import io.polymorphicpanda.kspec.junit.JUnitKSpecRunner
import org.junit.runner.RunWith

@RunWith(JUnitKSpecRunner::class)
class HSLTest(): KSpec() {
    override fun spec() {
        describe("HSL") {
            it("should return correct RGB of the given HSL #1") {
                val rgb = HSL(0.0, 1.0, 0.5).toRGB()
                expect(rgb).to.equal(RGB(255, 0, 0))
            }
            it("should return correct RGB of the given HSL #2") {
                val rgb = HSL(120.0, 1.0, 0.75).toRGB()
                expect(rgb).to.equal(RGB(128, 255, 128))
            }
            it("should return correct RGB of the given HSL #3") {
                val rgb = HSL(240.0, 1.0, 0.25).toRGB()
                expect(rgb).to.equal(RGB(0, 0, 128))
            }
            it("should return correct RGB of the given HSL #4") {
                // test example generated using gpick
                val rgb = HSL(330.0, 1.0, 0.75).toRGB()
                expect(rgb).to.equal(RGB(255, 128, 191))
            }
        }
    }
}
