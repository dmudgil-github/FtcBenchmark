package com.mudgil.demo1.commons.model;

public class TransactionSilver extends Transaction {
	
	
	// Record Details
	protected String recordType;
	protected String externalTransactionId;
	protected String dataSpecificationVersion;
	
	// Card Details
	protected String pan;
	
	// Customer Details
	protected String customerAcctNumber;
	protected String availableBalance;
	protected String dailyCashLimit;
	protected String dailyMerchandiseLimit;
	protected String custBankActNo;
	protected String custBankSortCode;
	protected String acctExpireDate;
	
	// Merchant Details
	
	protected String terminalId;
	protected String terminalVerificationResults;
	protected String cardVerificationResults;

	// Acquirer details
	protected String acquirerId;
	protected String acquirerBin;	
	protected String acquirerCountry;

	// Merchant Details
	protected String merchantId;
	protected String merchantCity;
	protected String merchantCountryCode;
	
	// Transaction Details
	protected TransactionType transactionType;
	protected String transactionDate;
	protected String transactionTime;
	protected String transactionAmount;
	protected String transactionCurrencyCode;
	protected String transactionCurrencyConversionR;
	
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getDataSpecificationVersion() {
		return dataSpecificationVersion;
	}
	public void setDataSpecificationVersion(String dataSpecificationVersion) {
		this.dataSpecificationVersion = dataSpecificationVersion;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getCustomerAcctNumber() {
		return customerAcctNumber;
	}
	public void setCustomerAcctNumber(String customerAcctNumber) {
		this.customerAcctNumber = customerAcctNumber;
	}
	public String getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getDailyCashLimit() {
		return dailyCashLimit;
	}
	public void setDailyCashLimit(String dailyCashLimit) {
		this.dailyCashLimit = dailyCashLimit;
	}
	public String getDailyMerchandiseLimit() {
		return dailyMerchandiseLimit;
	}
	public void setDailyMerchandiseLimit(String dailyMerchandiseLimit) {
		this.dailyMerchandiseLimit = dailyMerchandiseLimit;
	}
	public String getCustBankActNo() {
		return custBankActNo;
	}
	public void setCustBankActNo(String custBankActNo) {
		this.custBankActNo = custBankActNo;
	}
	public String getCustBankSortCode() {
		return custBankSortCode;
	}
	public void setCustBankSortCode(String custBankSortCode) {
		this.custBankSortCode = custBankSortCode;
	}
	public String getAcctExpireDate() {
		return acctExpireDate;
	}
	public void setAcctExpireDate(String acctExpireDate) {
		this.acctExpireDate = acctExpireDate;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getTerminalVerificationResults() {
		return terminalVerificationResults;
	}
	public void setTerminalVerificationResults(String terminalVerificationResults) {
		this.terminalVerificationResults = terminalVerificationResults;
	}
	public String getCardVerificationResults() {
		return cardVerificationResults;
	}
	public void setCardVerificationResults(String cardVerificationResults) {
		this.cardVerificationResults = cardVerificationResults;
	}
	public String getAcquirerId() {
		return acquirerId;
	}
	public void setAcquirerId(String acquirerId) {
		this.acquirerId = acquirerId;
	}
	public String getAcquirerBin() {
		return acquirerBin;
	}
	public void setAcquirerBin(String acquirerBin) {
		this.acquirerBin = acquirerBin;
	}
	public String getAcquirerCountry() {
		return acquirerCountry;
	}
	public void setAcquirerCountry(String acquirerCountry) {
		this.acquirerCountry = acquirerCountry;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantCity() {
		return merchantCity;
	}
	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}
	public String getMerchantCountryCode() {
		return merchantCountryCode;
	}
	public void setMerchantCountryCode(String merchantCountryCode) {
		this.merchantCountryCode = merchantCountryCode;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrencyCode() {
		return transactionCurrencyCode;
	}
	public void setTransactionCurrencyCode(String transactionCurrencyCode) {
		this.transactionCurrencyCode = transactionCurrencyCode;
	}
	public String getTransactionCurrencyConversionR() {
		return transactionCurrencyConversionR;
	}
	public void setTransactionCurrencyConversionR(String transactionCurrencyConversionR) {
		this.transactionCurrencyConversionR = transactionCurrencyConversionR;
	}
	protected String merchantName;
	
	

		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctExpireDate == null) ? 0 : acctExpireDate.hashCode());
		result = prime * result + ((acquirerBin == null) ? 0 : acquirerBin.hashCode());
		result = prime * result + ((acquirerCountry == null) ? 0 : acquirerCountry.hashCode());
		result = prime * result + ((acquirerId == null) ? 0 : acquirerId.hashCode());
		result = prime * result + ((availableBalance == null) ? 0 : availableBalance.hashCode());
		result = prime * result + ((cardVerificationResults == null) ? 0 : cardVerificationResults.hashCode());
		result = prime * result + ((custBankActNo == null) ? 0 : custBankActNo.hashCode());
		result = prime * result + ((custBankSortCode == null) ? 0 : custBankSortCode.hashCode());
		result = prime * result + ((customerAcctNumber == null) ? 0 : customerAcctNumber.hashCode());
		result = prime * result + ((dailyCashLimit == null) ? 0 : dailyCashLimit.hashCode());
		result = prime * result + ((dailyMerchandiseLimit == null) ? 0 : dailyMerchandiseLimit.hashCode());
		result = prime * result + ((dataSpecificationVersion == null) ? 0 : dataSpecificationVersion.hashCode());
		result = prime * result + ((externalTransactionId == null) ? 0 : externalTransactionId.hashCode());
		result = prime * result + ((merchantCity == null) ? 0 : merchantCity.hashCode());
		result = prime * result + ((merchantCountryCode == null) ? 0 : merchantCountryCode.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((pan == null) ? 0 : pan.hashCode());
		result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result + ((terminalId == null) ? 0 : terminalId.hashCode());
		result = prime * result + ((terminalVerificationResults == null) ? 0 : terminalVerificationResults.hashCode());
		result = prime * result + ((transactionAmount == null) ? 0 : transactionAmount.hashCode());
		result = prime * result + ((transactionCurrencyCode == null) ? 0 : transactionCurrencyCode.hashCode());
		result = prime * result
				+ ((transactionCurrencyConversionR == null) ? 0 : transactionCurrencyConversionR.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionTime == null) ? 0 : transactionTime.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionSilver other = (TransactionSilver) obj;
		if (acctExpireDate == null) {
			if (other.acctExpireDate != null)
				return false;
		} else if (!acctExpireDate.equals(other.acctExpireDate))
			return false;
		if (acquirerBin == null) {
			if (other.acquirerBin != null)
				return false;
		} else if (!acquirerBin.equals(other.acquirerBin))
			return false;
		if (acquirerCountry == null) {
			if (other.acquirerCountry != null)
				return false;
		} else if (!acquirerCountry.equals(other.acquirerCountry))
			return false;
		if (acquirerId == null) {
			if (other.acquirerId != null)
				return false;
		} else if (!acquirerId.equals(other.acquirerId))
			return false;
		if (availableBalance == null) {
			if (other.availableBalance != null)
				return false;
		} else if (!availableBalance.equals(other.availableBalance))
			return false;
		if (cardVerificationResults == null) {
			if (other.cardVerificationResults != null)
				return false;
		} else if (!cardVerificationResults.equals(other.cardVerificationResults))
			return false;
		if (custBankActNo == null) {
			if (other.custBankActNo != null)
				return false;
		} else if (!custBankActNo.equals(other.custBankActNo))
			return false;
		if (custBankSortCode == null) {
			if (other.custBankSortCode != null)
				return false;
		} else if (!custBankSortCode.equals(other.custBankSortCode))
			return false;
		if (customerAcctNumber == null) {
			if (other.customerAcctNumber != null)
				return false;
		} else if (!customerAcctNumber.equals(other.customerAcctNumber))
			return false;
		if (dailyCashLimit == null) {
			if (other.dailyCashLimit != null)
				return false;
		} else if (!dailyCashLimit.equals(other.dailyCashLimit))
			return false;
		if (dailyMerchandiseLimit == null) {
			if (other.dailyMerchandiseLimit != null)
				return false;
		} else if (!dailyMerchandiseLimit.equals(other.dailyMerchandiseLimit))
			return false;
		if (dataSpecificationVersion == null) {
			if (other.dataSpecificationVersion != null)
				return false;
		} else if (!dataSpecificationVersion.equals(other.dataSpecificationVersion))
			return false;
		if (externalTransactionId == null) {
			if (other.externalTransactionId != null)
				return false;
		} else if (!externalTransactionId.equals(other.externalTransactionId))
			return false;
		if (merchantCity == null) {
			if (other.merchantCity != null)
				return false;
		} else if (!merchantCity.equals(other.merchantCity))
			return false;
		if (merchantCountryCode == null) {
			if (other.merchantCountryCode != null)
				return false;
		} else if (!merchantCountryCode.equals(other.merchantCountryCode))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (pan == null) {
			if (other.pan != null)
				return false;
		} else if (!pan.equals(other.pan))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (terminalId == null) {
			if (other.terminalId != null)
				return false;
		} else if (!terminalId.equals(other.terminalId))
			return false;
		if (terminalVerificationResults == null) {
			if (other.terminalVerificationResults != null)
				return false;
		} else if (!terminalVerificationResults.equals(other.terminalVerificationResults))
			return false;
		if (transactionAmount == null) {
			if (other.transactionAmount != null)
				return false;
		} else if (!transactionAmount.equals(other.transactionAmount))
			return false;
		if (transactionCurrencyCode == null) {
			if (other.transactionCurrencyCode != null)
				return false;
		} else if (!transactionCurrencyCode.equals(other.transactionCurrencyCode))
			return false;
		if (transactionCurrencyConversionR == null) {
			if (other.transactionCurrencyConversionR != null)
				return false;
		} else if (!transactionCurrencyConversionR.equals(other.transactionCurrencyConversionR))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionTime == null) {
			if (other.transactionTime != null)
				return false;
		} else if (!transactionTime.equals(other.transactionTime))
			return false;
		if (transactionType != other.transactionType)
			return false;
		return true;
	}	
	
}
