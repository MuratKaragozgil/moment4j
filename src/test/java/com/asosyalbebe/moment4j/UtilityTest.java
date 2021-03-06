package com.asosyalbebe.moment4j;

import static com.asosyalbebe.moment4j.Moment.moment;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UtilityTest {

    @Test
    public void test_MomentComparator_Negative() {
	MomentComparator comparator = new MomentComparator();

	Moment lhs = moment(System.currentTimeMillis() - 1000);
	Moment rhs = moment(System.currentTimeMillis() + 1000);

	int result = comparator.compare(lhs, rhs);

	assertThat(result, lessThan(0));
    }

    @Test
    public void test_MomentComparator_Positive() {
	MomentComparator comparator = new MomentComparator();

	Moment lhs = moment(System.currentTimeMillis() - 1000);
	Moment rhs = moment(System.currentTimeMillis() + 1000);

	int result = comparator.compare(rhs, lhs);

	assertThat(result, greaterThan(0));
    }

    @Test
    public void test_MomentComparator_Zero() {
	MomentComparator comparator = new MomentComparator();

	Moment lhs = moment(System.currentTimeMillis());
	Moment rhs = moment(lhs.valueOf());

	int result = comparator.compare(rhs, lhs);

	assertThat(result, equalTo(0));
    }
}
