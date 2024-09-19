package syntax.functional_programming.function_type.anonymous_func.lambda_func.example_4

fun main() {
    val priceBeforeDiscount = 153.25

    val fiveBucksResult = formatPrice(
        calculateTotal(priceBeforeDiscount, discountForCouponCode(DiscountType.FIVE_BUCKS))
    )
    val nineBucksResult = formatPrice(
        calculateTotal(priceBeforeDiscount, discountForCouponCode(DiscountType.NINE_BUCKS))
    )
    val takeTenResult = formatPrice(
        calculateTotal(priceBeforeDiscount, discountForCouponCode(DiscountType.TAKE_10))
    )
    val takeFifteenResult = formatPrice(
        calculateTotal(priceBeforeDiscount, discountForCouponCode(DiscountType.TAKE_15))
    )
    val noDiscountResult = formatPrice(
        calculateTotal(priceBeforeDiscount, discountForCouponCode(DiscountType.NO_DISCOUNT))
    )
    println(
        "Make a discount for a $priceBeforeDiscount sell:" +
        "\n\t${DiscountType.FIVE_BUCKS.text} \t\t= $fiveBucksResult" +
        "\n\t${DiscountType.NINE_BUCKS.text} \t\t= $nineBucksResult" +
        "\n\t${DiscountType.TAKE_10.text} \t= $takeTenResult" +
        "\n\t${DiscountType.TAKE_15.text} \t= $takeFifteenResult" +
        "\n\t${DiscountType.NO_DISCOUNT.text} = $noDiscountResult"
    )
}

enum class DiscountType(val text: String, val value: Double) {
    NO_DISCOUNT("No discount", 0.0),
    FIVE_BUCKS( "$5 OFF", 5.0),
    NINE_BUCKS("$9 OFF", 9.0),
    TAKE_10("%10 OFF", 10.0),
    TAKE_15("%15 OFF", 15.0)
}

fun formatPrice(price: Double) = "%.2f".format(price)

// Higher order function that uses 'function type' as a second argument.
fun calculateTotal(
    initialPrice: Double,
    applyDiscount: (Double) -> Double
): Double {
    // Apply coupon discount
    val priceAfterDiscount = applyDiscount(initialPrice)

    // Tax is 9%, so we'll multiply by 109% to get the total with tax included.
    val taxMultiplier = 1.09

    // Apply tax
    val total = priceAfterDiscount * taxMultiplier

    return total
}

// Return lambda as a result of 'when' check block.
fun discountForCouponCode(
    couponCode: DiscountType
): (Double) -> Double = when (couponCode) {
    DiscountType.FIVE_BUCKS -> dollarAmountDiscount(DiscountType.FIVE_BUCKS.value)
    DiscountType.NINE_BUCKS -> dollarAmountDiscount(DiscountType.NINE_BUCKS.value)
    DiscountType.TAKE_10 -> percentageDiscount(DiscountType.TAKE_10.value)
    DiscountType.TAKE_15 -> percentageDiscount(DiscountType.TAKE_15.value)
    else -> { price -> price }
}

// Return lambda as a result
fun dollarAmountDiscount(dollarOff: Double): (Double) -> Double =
    { price -> price - dollarOff}

// Return lambda as a result
fun percentageDiscount(percentageOff: Double): (Double) -> Double {
    val multiplier = 1.0 - (percentageOff / 100)
    return { price -> price * multiplier }
}