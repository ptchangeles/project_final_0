package com.revature.models;

import java.time.LocalDate;

import java.util.Objects;

public class Account {

		protected int accountId;
		protected long accountBal;
		protected int approveBy;
		protected LocalDate appDate = LocalDate.now();
		protected int deletedBy;
		protected LocalDate delDate = LocalDate.now();
		protected boolean status;
		
		public Account(int accountId, long accountBal,  boolean status) {
			super();
			this.accountId = accountId;
			this.accountBal = accountBal;
			this.status = status;
		}

		public int getAccountId() {
			return accountId;
		}

		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}

		public long getAccountBal() {
			return accountBal;
		}

		public void setAccountBal(long accountBal) {
			this.accountBal = accountBal;
		}

		public int getApproveBy() {
			return approveBy;
		}

		public void setApproveBy(int approveBy) {
			this.approveBy = approveBy;
		}

		public int getDeletedBy() {
			return deletedBy;
		}

		public void setDeletedBy(int deletedBy) {
			this.deletedBy = deletedBy;
		}

		public LocalDate getAppDate() {
			return appDate;
		}

		public void setAppDate(LocalDate appDate) {
			this.appDate = appDate;
		}

		public LocalDate getDelDate() {
			return delDate;
		}

		public void setDelDate(LocalDate delDate) {
			this.delDate = delDate;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		@Override
		public int hashCode() {
			return Objects.hash(accountBal, accountId, appDate, approveBy, delDate, deletedBy, status);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			return accountBal == other.accountBal && accountId == other.accountId
					&& Objects.equals(appDate, other.appDate) && approveBy == other.approveBy
					&& Objects.equals(delDate, other.delDate) && deletedBy == other.deletedBy && status == other.status;
		}

		@Override
		public String toString() {
			return "Account [accountId=" + accountId + ", accountBal=" + accountBal + ", approveBy=" + approveBy
					+ ", deletedBy=" + deletedBy + ", appDate=" + appDate + ", delDate=" + delDate + ", status="
					+ status + "]";
		}

		
}

