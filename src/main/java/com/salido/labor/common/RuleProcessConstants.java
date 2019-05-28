package com.salido.labor.common;

public class RuleProcessConstants {
	private RuleProcessConstants() {
		super();
	}

	public static class RuleType {
		private RuleType() {
			super();
		}

		public static final String RULE_TYPE_OT = "OT";
		public static final String RULE_TYPE_SOH = "SoH";
		public static final String RULE_TYPE_TIPCREDIT = "TIPCREDIT";
	}

	public static class Timecard {
		private Timecard() {
			super();
		}

		public static final String DAY = "DAY";
		public static final String WORK_WEEK = "WORK_WEEK";
	}

	public static class VariableInit {
		private VariableInit() {
			super();
		}

		public static final String HOURS_WORKED = "HOURS_WORKED";
		public static final String DAYS_WORKED = "DAYS_WORKED";
		public static final String HOURS_WORKED_UNTIL = "HOURS_WORKED_UNTIL";
		public static final String DAYS_WORKED_UNTIL = "DAYS_WORKED_UNTIL";
		public static final String ALWAYS = "ALWAYS";
	}

	public static class Measure {
		private Measure() {
			super();
		}

		public static final String LESS_THEN = "<";
		public static final String LESS_THEN_EQUAL = "<=";
		public static final String GREATER_THEN = ">";
		public static final String GREATER_THEN_EQUAL = ">=";
	}

	public static class Rate {
		private Rate() {
			super();
		}

		public static final String BLENDED_RATE = "BLENDED_RATE";
		public static final String REGULAR_RATE = "REGULAR_RATE";
		public static final String MINIMUM_WAGE = "MINIMUM_WAGE";
		public static final String TIP_CREDIT = "TIP_CREDIT";
	}

	public static class Param {
		private Param() {
			super();
		}

		public static final String HOURS_WORKED_WEEK = "HOURS_WORKED_WEEK";
		public static final String TRUE = "TRUE";
		public static final String DAYS_WORKED_UNTIL_WEEK = "DAYS_WORKED_UNTIL_WEEK";
		public static final String DAYS_WORKED_WEEK = "DAYS_WORKED_WEEK";
		public static final String HOURS_WORKED_UNTIL_DAY = "HOURS_WORKED_UNTIL_DAY";
		public static final String HOURS_WORKED_DAY = "HOURS_WORKED_DAY";
	}

	public static class Modifire {
		private Modifire() {
			super();
		}

		public static final String OPERATOR = "Operator";
		public static final String RATE = "Rate";
		public static final String MULTIPLIER = "Multiplier";
	}

	public static class LaborCostKeys {
		private LaborCostKeys() {
			super();
		}

		public static final String ONE = "1.0";
		public static final String REG_WAGE_OBJECT = "reg_wage";
		public static final String OT_WAGE_OBJECT = "ot_wage";
		public static final String SOH_WAGE_OBJECT = "soh_wage";
		public static final String TIPCREDIT_WAGE_OBJECT = "tipcredit_wage";

		public static final String START_TIME = "pay_start_time";
		public static final String END_TIME = "pay_end_time";
		public static final String PAY_RATE = "pay_rate";
		
		
		public static final String SOH_PAYRATE = "soh_pay_rate";
		public static final String OT_TYPE = "ot_type";
		public static final String OT = "overtime";
		public static final String DOT = "double_overtime";
		public static final String WOT = "weekly_overtime";
		public static final String REG_AMOUNT = "regular_amount_total";
        public static final String TIPCREDIT_AMOUNT = "tipcredit_amount_total";
        public static final String SOH_AMOUNT = "soh_amount_total";
		public static final String AMOUNT = "amount_total";
		public static final String HOURS = "pay_hours";
		public static final String HAS_OT = "has_ot";
		public static final String HAS_SOH = "has_soh";
		public static final String TIPCREDIT = "tipcredit";
		public static final String REG = "regular";
		public static final String OT_UNDERSCORE = "ot_";
	}

}
