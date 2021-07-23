package cn.com.dto;

public class PurchaseDto {
	private int purchaseBillNumberDto;
	private double purchaseProductTotalDto;
	private double purchasePurchase_PriceDto;
	private int purchaseFlogDto ;
	private int purchaseProductNumberDto;
	private double purchaseSell_PriceDto;
	private double backProductTotalPriceDto;
	private int backProductNumberDto;
	
	
	
	private int sellNumber;
	private int sellBillNumber ;
	private double sellTotalPrice;
	private int sellBackNumber;
	private int sellBackBillNumber;
	private double sellBackTotalPrice;
	public int getSellNumber() {
		return sellNumber;
	}
	public void setSellNumber(int sellNumber) {
		this.sellNumber = sellNumber;
	}
	public int getSellBillNumber() {
		return sellBillNumber;
	}
	public void setSellBillNumber(int sellBillNumber) {
		this.sellBillNumber = sellBillNumber;
	}
	public double getSellTotalPrice() {
		return sellTotalPrice;
	}
	public void setSellTotalPrice(double sellTotalPrice) {
		this.sellTotalPrice = sellTotalPrice;
	}
	public int getSellBackNumber() {
		return sellBackNumber;
	}
	public void setSellBackNumber(int sellBackNumber) {
		this.sellBackNumber = sellBackNumber;
	}
	public int getSellBackBillNumber() {
		return sellBackBillNumber;
	}
	public void setSellBackBillNumber(int sellBackBillNumber) {
		this.sellBackBillNumber = sellBackBillNumber;
	}
	public double getSellBackTotalPrice() {
		return sellBackTotalPrice;
	}
	public void setSellBackTotalPrice(double sellBackTotalPrice) {
		this.sellBackTotalPrice = sellBackTotalPrice;
	}
	public int getBackProductNumberDto() {
		return backProductNumberDto;
	}
	public void setBackProductNumberDto(int backProductNumberDto) {
		this.backProductNumberDto = backProductNumberDto;
	}
	public int getBackBillNumberDto() {
		return backBillNumberDto;
	}
	public void setBackBillNumberDto(int backBillNumberDto) {
		this.backBillNumberDto = backBillNumberDto;
	}
	private int backBillNumberDto;
	public double getBackProductTotalPriceDto() {
		return backProductTotalPriceDto;
	}
	public void setBackProductTotalPriceDto(double backProductTotalPriceDto) {
		this.backProductTotalPriceDto = backProductTotalPriceDto;
	}
	public int getPurchaseBillNumberDto() {
		return purchaseBillNumberDto;
	}
	public void setPurchaseBillNumberDto(int purchaseBillNumberDto) {
		this.purchaseBillNumberDto = purchaseBillNumberDto;
	}

	public double getPurchaseProductTotalDto() {
		return purchaseProductTotalDto;
	}
	public void setPurchaseProductTotalDto(double purchaseProductTotalDto) {
		this.purchaseProductTotalDto = purchaseProductTotalDto;
	}
	public double getPurchasePurchase_PriceDto() {
		return purchasePurchase_PriceDto;
	}
	public void setPurchasePurchase_PriceDto(double purchasePurchase_PriceDto) {
		this.purchasePurchase_PriceDto = purchasePurchase_PriceDto;
	}
	public int getPurchaseFlogDto() {
		return purchaseFlogDto;
	}
	public void setPurchaseFlogDto(int purchaseFlogDto) {
		this.purchaseFlogDto = purchaseFlogDto;
	}
	public int getPurchaseProductNumberDto() {
		return purchaseProductNumberDto;
	}
	public void setPurchaseProductNumberDto(int purchaseProductNumberDto) {
		this.purchaseProductNumberDto = purchaseProductNumberDto;
	}
	public double getPurchaseSell_PriceDto() {
		return purchaseSell_PriceDto;
	}
	public void setPurchaseSell_PriceDto(double purchaseSell_PriceDto) {
		this.purchaseSell_PriceDto = purchaseSell_PriceDto;
	}
	
}
