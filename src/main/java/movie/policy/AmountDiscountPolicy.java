package movie.policy;

import movie.DiscountCondition;
import movie.DiscountPolicy;
import movie.Money;
import movie.Screening;

/**
 * 할인정책
 */
public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
