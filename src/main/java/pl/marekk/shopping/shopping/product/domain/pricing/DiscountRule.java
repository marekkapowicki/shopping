package pl.marekk.shopping.shopping.product.domain.pricing;

class DiscountRule {
    private final int payForUnitNumber;
    private final int takeUnitNumber;

    DiscountRule(int payForUnitNumber, int takeUnitNumber) {
        this.payForUnitNumber = payForUnitNumber;
        this.takeUnitNumber = takeUnitNumber;
    }
}
