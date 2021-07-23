package cn.com.actions;

public abstract class ActionFactory {

    private ActionFactory() {
    	
    }

	public static Action createInventoryView_btnSearch_Action() {
		// TODO Auto-generated method stub
		return new PnlStoreView_btnSearch_Action();
	}
	
	public static Action createStockView_btnStock_Action() {
		return new PnlPurchaseView_btnStock_Action();
	}

	public static Action createInventoryView_btnAllot_Action() {
		// TODO Auto-generated method stub
		return new PnlStoreView_btnAllot_Action();
	}

	public static Action createInventortView_btnCheck_Action() {
		// TODO Auto-generated method stub
		return new PnlStoreView_btnCheck_Action();
	}

	public static Action createMainView_BtnStore_Action() {
		// TODO Auto-generated method stub
		return new MainView_BtnStore_Action();
	}


	public static Action createMainView_BtnPurchase_Action() {
		// TODO Auto-generated method stub
		return new MainView_BtnPurchase_Action();
	}


	public static Action createBackView_btnBack_Action() {
		// TODO Auto-generated method stub
		return new PnlPurchaseView_btnBack_Action();
	}
	
	public static Action createFirmView_Action() {
		// TODO Auto-generated method stub
		return new FirmInfoView_Action();
	}
	
	public static Action createFirmAddView_Action() {
		// TODO Auto-generated method stub
		return new FirmInfoAdd_Action();
	}
	
	public static Action createClouseView_Action() {
		// TODO Auto-generated method stub
		return new CloseView_Action();
	}


	public static Action createFirmUpdateView_Action() {
		// TODO Auto-generated method stub
		return  new FirmInfoUpdateView_Action();
	}


	public static Action createFirmDeleteView_Action() {
		// TODO Auto-generated method stub
		return new FrimInfoDeleteView_Action();
	}


	public static Action createSeachView_btnBack_Action() {
		// TODO Auto-generated method stub
		return new PnlPurchaseView_btnScachAction();
	}


	public static Action createFirmAddView_btnSave_Action() {
		// TODO Auto-generated method stub
		return new AddView_btnSave_Action();
	}


	public static Action createFirmInfoSelect_Action() {
		// TODO Auto-generated method stub
		return new FirmView_btnSelect_Action();
	}


	public static Action createMainView_BtnSell_Action() {
		// TODO Auto-generated method stub
		return new MainView_BtnSell_Action();
	}


	public static Action createPnlStoreView_btnStat_Action() {
		// TODO Auto-generated method stub
		return new PnlStoreView_btnStat_Action();
	}


	public static Action createPnlStoreView_btnAllot_Action() {
		// TODO Auto-generated method stub
		return new PnlStoreView_btnAllot_Action();
	}


	public static Action createPnlStoreView_btnWare_Action() {
		// TODO Auto-generated method stub
		return new PnlStoreView_btnWare_Action();
	}


	public static Action createPnlSystemView_btnClient_Action() {
		// TODO Auto-generated method stub
		return new PnlSystemView_btnClient_Action();
	}

	public static Action createPnlSystemView_btnParts_Action() {
		// TODO Auto-generated method stub
		return new PnlSystemView_btnParts_Action();
	}
	public static Action createUpdateAction() {

		return new FindPwdView_BtnUpdateAction();
	}
	public static Action createCancelAction() {

		return new FindPwdView_BtnCancelAction();
	}

	public static Action createLoginAction(){

		return new LoginView_BtnLoginAction();
	}
	public static Action createQuitAction(){

		return new LoginView_BtnQuitAction();
	}

	public static Action createChangeAction() {
		return  new MainView_BtnChangeAction();
	}
	public static Action  createAccountAction(){
		return new PnlSellView_BtnAccountAction();
	}
	public static Action  createSellDocumentAction(){
		return new PnlSellView_BtnSellDocumentAction();
	}

	public static Action  createSellStaffAction(){
		return new PnlSellView_BtnSellStaffAction();
	}

	public static Action createOfferStatisticAction() {
		// TODO Auto-generated method stub
		return new StatisticsView_BtnofferStatisticAction();
	}


	public static Action createBusinessStatisticAction() {
		// TODO Auto-generated method stub
		return new StaticsView_BtnBussinessStatisticAction();
	}

	public static Action createPurchaseAction(){
		return new MainView_BtnPurchaseAction();
	}
	public static Action createStatisticAction() {
		// TODO Auto-generated method stub
		return new MainView_StatisticsViewAction();
	}



}

