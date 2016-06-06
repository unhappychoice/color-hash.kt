package com.github.unhappychoice.colorhash

import android.graphics.Color
import com.winterbe.expekt.expect
import io.polymorphicpanda.kspec.*
import io.polymorphicpanda.kspec.junit.JUnitKSpecRunner
import org.junit.runner.RunWith

@RunWith(JUnitKSpecRunner::class)
class ColorHashTest: KSpec() {
    override fun spec() {
        describe("ColorHash") {
            it("has default properties") {
                val colorHash = ColorHash("hash")
                expect(colorHash.string).to.equal("hash")
                expect(colorHash.lightness).to.equal(listOf(0.35, 0.5, 0.65))
                expect(colorHash.saturation).to.equal(listOf(0.35, 0.5, 0.65))
                expect(colorHash.minHue).to.equal(0)
                expect(colorHash.maxHue).to.equal(360)
            }

            describe("#Lightness & Saturation") {
                it("should return the hash color based on default lightness and saturation") {
                    val hsl = ColorHash("").toHSL()
                    expect(hsl.saturation).to.equal(0.35)
                    expect(hsl.lightness).to.equal(0.35)
                }

                it("should return the hash color based on the given lightness and saturation") {
                    val hsl = ColorHash("", listOf(0.5), listOf(0.5)).toHSL()
                    expect(hsl.saturation).to.equal(0.5)
                    expect(hsl.lightness).to.equal(0.5)
                }

                it("should return the hash color based on the given lightness array and saturation array") {
                    var hsl = ColorHash("", listOf(0.9, 1.0), listOf(0.9, 1.0)).toHSL()
                    expect(hsl.saturation).to.equal(0.9)
                    expect(hsl.lightness).to.equal(0.9)
                }
            }

            describe("transform methods") {
                xit("should returns android color") {
                    val color = ColorHash("color").toColor()
                    expect(color).to.equal(Color.HSVToColor(floatArrayOf(0.0f, 0.0f, 0.0f)))
                }

                it("should returns hex string") {
                    val hex = ColorHash("hex color").toHexString()
                    expect(hex).to.equal("#c5b587")
                }

                it("should returns RGB") {
                    val rgb = ColorHash("hex color").toRGB()
                    expect(rgb).to.equal(RGB(197, 181, 135))
                }
            }

            xdescribe("#CustomHash") {  // TODO: Implement custom hash
                fun customHash(string: String): Long {
                    return string.fold(0L) { acc, char -> char.toLong() + acc }
                }

                val colorHash = ColorHash("abc")
                val hsl = HSL((customHash("abc") % 359).toDouble(), 0.35, 0.35)
                val rgb = hsl.toRGB()
                val hex = hsl.toRGB().toHex()

                xit("#hsl: should return the hsl color based on the given hash function") {
                    expect(colorHash.toHSL()).to.equal(hsl)
                }
                xit("#rgb: should return the rgb color based on the given hash function") {
                    expect(colorHash.toRGB()).to.equal(rgb)
                }
                it("#hex: should return the hex color based on the given hash function") {
                    expect(colorHash.toHexString()).to.equal(hex)
                }
            }
        }
    }
}
