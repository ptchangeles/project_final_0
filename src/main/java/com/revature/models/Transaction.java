package com.revature.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {

		protected int transNo;
		protected int accountId;
		protected int transType;
		protected LocalDateTime transDate = LocalDateTime.now();
		
		public Transaction(int transNo, int accountId, int transType, LocalDateTime transDate) {
			super();
			this.transNo = transNo;
			this.accountId = accountId;
			this.transType = transType;
			this.transDate = transDate;
		}

		public int getTransNo() {
			return transNo;
		}

		public void setTransNo(int transNo) {
			this.transNo = transNo;
		}

		public int getAccountId() {
			return accountId;
		}

		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}

		public int getTransType() {
			return transType;
		}

		public void setTransType(int transType) {
			this.transType = transType;
		}

		public LocalDateTime getTransDate() {
			return transDate;
		}

		public void setTransDate(LocalDateTime transDate) {
			this.transDate = transDate;
		}

		@Override
		public int hashCode() {
			return Objects.hash(accountId, transDate, transNo, transType);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Transaction other = (Transaction) obj;
			return accountId == other.accountId && Objects.equals(transDate, other.transDate)
					&& transNo == other.transNo && transType == other.transType;
		}

		@Override
		public String toString() {
			return "Transaction [transNo=" + transNo + ", accountId=" + accountId + ", transType=" + transType
					+ ", transDate=" + transDate + "]";
		}
		
		
		
}
