package medical.common.progress;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JFrame;

//import saaspia.application.compliance.commoninfo.batch.service.ErpDataUploadVo;

public class ProgressWin extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension dimen0,dimen1; 
    private int _x,_y;
    private Label t1Labl;
    private Label t2Labl;
    private Label t3Labl;
    private Label customLabl;
    private Label customTotCntLabl;
    private Label customCntLabl;
    private Label vendorLabl;
    private Label vendorTotCntLabl;
    private Label vendorCntLabl;
    private Label itemLabl;
    private Label itemTotCntLabl;
    private Label itemCntLabl;
    private Label hsCodeLabl;
    private Label hsCodeTotCntLabl;
    private Label hsCodeCntLabl;
    private Label bomLabl;
    private Label bomTotCntLabl;
    private Label bomCntLabl;
    private Label purchaseLabl;
    private Label purchaseTotCntLabl;
    private Label purchaseCntLabl;
    private Label salesLabl;
    private Label salesTotCntLabl;
    private Label salesCntLabl;
    private Label originLabl;
    private Label originTotCntLabl;
    private Label originCntLabl;
    private Label execAllLabl;
    private Label execAllStateLabl;
    
	public Label getItemTotCntLabl() {
		return itemTotCntLabl;
	}

	public void setItemTotCntLabl(Label itemTotCntLabl) {
		this.itemTotCntLabl = itemTotCntLabl;
	}

	public Label getItemCntLabl() {
		return itemCntLabl;
	}

	public void setItemCntLabl(Label itemCntLabl) {
		this.itemCntLabl = itemCntLabl;
	}

	public Label getHsCodeTotCntLabl() {
		return hsCodeTotCntLabl;
	}

	public void setHsCodeTotCntLabl(Label hsCodeTotCntLabl) {
		this.hsCodeTotCntLabl = hsCodeTotCntLabl;
	}

	public Label getHsCodeCntLabl() {
		return hsCodeCntLabl;
	}

	public void setHsCodeCntLabl(Label hsCodeCntLabl) {
		this.hsCodeCntLabl = hsCodeCntLabl;
	}

	public Label getBomTotCntLabl() {
		return bomTotCntLabl;
	}

	public void setBomTotCntLabl(Label bomTotCntLabl) {
		this.bomTotCntLabl = bomTotCntLabl;
	}

	public Label getBomCntLabl() {
		return bomCntLabl;
	}

	public void setBomCntLabl(Label bomCntLabl) {
		this.bomCntLabl = bomCntLabl;
	}

	public Label getPurchaseTotCntLabl() {
		return purchaseTotCntLabl;
	}

	public void setPurchaseTotCntLabl(Label purchaseTotCntLabl) {
		this.purchaseTotCntLabl = purchaseTotCntLabl;
	}

	public Label getPurchaseCntLabl() {
		return purchaseCntLabl;
	}

	public void setPurchaseCntLabl(Label purchaseCntLabl) {
		this.purchaseCntLabl = purchaseCntLabl;
	}

	public Label getSalesTotCntLabl() {
		return salesTotCntLabl;
	}

	public void setSalesTotCntLabl(Label salesTotCntLabl) {
		this.salesTotCntLabl = salesTotCntLabl;
	}

	public Label getSalesCntLabl() {
		return salesCntLabl;
	}

	public void setSalesCntLabl(Label salesCntLabl) {
		this.salesCntLabl = salesCntLabl;
	}

	public Label getOriginTotCntLabl() {
		return originTotCntLabl;
	}

	public void setOriginTotCntLabl(Label originTotCntLabl) {
		this.originTotCntLabl = originTotCntLabl;
	}

	public Label getOriginCntLabl() {
		return originCntLabl;
	}

	public void setOriginCntLabl(Label originCntLabl) {
		this.originCntLabl = originCntLabl;
	}

	public Label getExecAllStateLabl() {
		return execAllStateLabl;
	}

	public void setExecAllStateLabl(Label execAllStateLabl) {
		this.execAllStateLabl = execAllStateLabl;
	}

	public Label getVendorTotCntLabl() {
		return vendorTotCntLabl;
	}

	public void setVendorTotCntLabl(Label vendorTotCntLabl) {
		this.vendorTotCntLabl = vendorTotCntLabl;
	}

	public Label getVendorCntLabl() {
		return vendorCntLabl;
	}

	public void setVendorCntLabl(Label vendorCntLabl) {
		this.vendorCntLabl = vendorCntLabl;
	}

	public Label getCustomCntLabl() {
		return customCntLabl;
	}

	public void setCustomCntLabl(Label customCntLabl) {
		this.customCntLabl = customCntLabl;
	}

	public Label getCustomTotCntLabl() {
		return customTotCntLabl;
	}

	public void setCustomTotCntLabl(Label customTotCntLabl) {
		this.customTotCntLabl = customTotCntLabl;
	}
/*
	public ProgressWin(String title, ErpDataUploadVo oErpDataUploadVo){
      super(title);
//      this.init();
//      this.start();
      int winHeight = 0;
      int heightGap = 17;
      this.setResizable(false);
      this.setExtendedState(JFrame.NORMAL);
      this.toFront();
      t1Labl = new Label();
      t1Labl.setSize(getMinimumSize());
      t1Labl.setAlignment(Label.LEFT);
      t1Labl.setText("항목");
      t2Labl = new Label();
      t2Labl.setSize(getMinimumSize());
      t2Labl.setAlignment(Label.CENTER);
      t2Labl.setText("총건수");
      t3Labl = new Label();
      t3Labl.setSize(getMinimumSize());
      t3Labl.setAlignment(Label.CENTER);
      t3Labl.setText("처리건수");
      GridLayout gl = new GridLayout(0,3);
      gl.setVgap(2);
      this.setLayout(gl);
      this.add(t1Labl);
      this.add(t2Labl);
      this.add(t3Labl);
      winHeight = winHeight + heightGap;
      if(oErpDataUploadVo.isCustomerIf()==true){
    	  customLabl = new Label();
          customLabl.setSize(getMinimumSize());
          customLabl.setAlignment(Label.LEFT);
          customLabl.setText("고객사");
          customTotCntLabl = new Label();
          customTotCntLabl.setSize(getMinimumSize());
          customTotCntLabl.setAlignment(Label.CENTER);
          customTotCntLabl.setText("0");
          customCntLabl = new Label();
          customCntLabl.setSize(getMinimumSize());
          customCntLabl.setAlignment(Label.CENTER);
          customCntLabl.setText("0");
          this.add(customLabl);
          this.add(customTotCntLabl);
          this.add(customCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isVendorIf()==true){
    	  vendorLabl = new Label();
    	  vendorLabl.setSize(getMinimumSize());
    	  vendorLabl.setAlignment(Label.LEFT);
    	  vendorLabl.setText("협력사");
    	  vendorTotCntLabl = new Label();
    	  vendorTotCntLabl.setSize(getMinimumSize());
    	  vendorTotCntLabl.setAlignment(Label.CENTER);
    	  vendorTotCntLabl.setText("0");
    	  vendorCntLabl = new Label();
    	  vendorCntLabl.setSize(getMinimumSize());
    	  vendorCntLabl.setAlignment(Label.CENTER);
    	  vendorCntLabl.setText("0");
          this.add(vendorLabl);
          this.add(vendorTotCntLabl);
          this.add(vendorCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isItemIf()==true){
    	  itemLabl = new Label();
    	  itemLabl.setSize(getMinimumSize());
    	  itemLabl.setAlignment(Label.LEFT);
    	  itemLabl.setText("품목");
    	  itemTotCntLabl = new Label();
    	  itemTotCntLabl.setSize(getMinimumSize());
    	  itemTotCntLabl.setAlignment(Label.CENTER);
    	  itemTotCntLabl.setText("0");
    	  itemCntLabl = new Label();
    	  itemCntLabl.setSize(getMinimumSize());
    	  itemCntLabl.setAlignment(Label.CENTER);
    	  itemCntLabl.setText("0");
          this.add(itemLabl);
          this.add(itemTotCntLabl);
          this.add(itemCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isHscodeIf()==true){
    	  hsCodeLabl = new Label();
    	  hsCodeLabl.setSize(getMinimumSize());
    	  hsCodeLabl.setAlignment(Label.LEFT);
    	  hsCodeLabl.setText("HS코드");
    	  hsCodeTotCntLabl = new Label();
    	  hsCodeTotCntLabl.setSize(getMinimumSize());
    	  hsCodeTotCntLabl.setAlignment(Label.CENTER);
    	  hsCodeTotCntLabl.setText("0");
    	  hsCodeCntLabl = new Label();
    	  hsCodeCntLabl.setSize(getMinimumSize());
    	  hsCodeCntLabl.setAlignment(Label.CENTER);
    	  hsCodeCntLabl.setText("0");
          this.add(hsCodeLabl);
          this.add(hsCodeTotCntLabl);
          this.add(hsCodeCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isBomIf()==true){
    	  bomLabl = new Label();
    	  bomLabl.setSize(getMinimumSize());
    	  bomLabl.setAlignment(Label.LEFT);
    	  bomLabl.setText("BOM");
    	  bomTotCntLabl = new Label();
    	  bomTotCntLabl.setSize(getMinimumSize());
    	  bomTotCntLabl.setAlignment(Label.CENTER);
    	  bomTotCntLabl.setText("0");
    	  bomCntLabl = new Label();
    	  bomCntLabl.setSize(getMinimumSize());
    	  bomCntLabl.setAlignment(Label.CENTER);
    	  bomCntLabl.setText("0");
          this.add(bomLabl);
          this.add(bomTotCntLabl);
          this.add(bomCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isPurchaseIf()==true){
    	  purchaseLabl = new Label();
    	  purchaseLabl.setSize(getMinimumSize());
    	  purchaseLabl.setAlignment(Label.LEFT);
    	  purchaseLabl.setText("구매원장");
    	  purchaseTotCntLabl = new Label();
    	  purchaseTotCntLabl.setSize(getMinimumSize());
    	  purchaseTotCntLabl.setAlignment(Label.CENTER);
    	  purchaseTotCntLabl.setText("0");
    	  purchaseCntLabl = new Label();
    	  purchaseCntLabl.setSize(getMinimumSize());
    	  purchaseCntLabl.setAlignment(Label.CENTER);
    	  purchaseCntLabl.setText("0");
          this.add(purchaseLabl);
          this.add(purchaseTotCntLabl);
          this.add(purchaseCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isSalesIf()==true){
    	  salesLabl = new Label();
    	  salesLabl.setSize(getMinimumSize());
    	  salesLabl.setAlignment(Label.LEFT);
    	  salesLabl.setText("매출원장");
    	  salesTotCntLabl = new Label();
    	  salesTotCntLabl.setSize(getMinimumSize());
    	  salesTotCntLabl.setAlignment(Label.CENTER);
    	  salesTotCntLabl.setText("0");
    	  salesCntLabl = new Label();
    	  salesCntLabl.setSize(getMinimumSize());
    	  salesCntLabl.setAlignment(Label.CENTER);
    	  salesCntLabl.setText("0");
          this.add(salesLabl);
          this.add(salesTotCntLabl);
          this.add(salesCntLabl);
          winHeight = winHeight + heightGap;
      }
      if(oErpDataUploadVo.isOriginIf()==true){
    	  originLabl = new Label();
    	  originLabl.setSize(getMinimumSize());
    	  originLabl.setAlignment(Label.LEFT);
    	  originLabl.setText("원재료수불부");
    	  originTotCntLabl = new Label();
    	  originTotCntLabl.setSize(getMinimumSize());
    	  originTotCntLabl.setAlignment(Label.CENTER);
    	  originTotCntLabl.setText("0");
    	  originCntLabl = new Label();
    	  originCntLabl.setSize(getMinimumSize());
    	  originCntLabl.setAlignment(Label.CENTER);
    	  originCntLabl.setText("0");
          this.add(originLabl);
          this.add(originTotCntLabl);
          this.add(originCntLabl);
          winHeight = winHeight + heightGap;
      }
      
      execAllLabl = new Label();
      execAllLabl.setSize(getMinimumSize());
      execAllLabl.setAlignment(Label.LEFT);
      execAllLabl.setText("FTA연계");
      execAllStateLabl = new Label();
      execAllStateLabl.setSize(getMinimumSize());
      execAllStateLabl.setAlignment(Label.CENTER);
      execAllStateLabl.setText("대기");
      this.add(execAllLabl);
      this.add(execAllStateLabl);
      winHeight = winHeight + heightGap;
      
      this.setSize(150,winHeight);                // or f.pack()  frame 크기설정
      dimen0=Toolkit.getDefaultToolkit().getScreenSize();
      dimen1=this.getSize();
      
      _x=(int)(dimen0.getWidth()/2 - dimen1.getWidth()/2);
      _y=(int)(dimen0.getHeight()/2 - dimen1.getHeight()/2);                  //프레임화면중앙에띄우기
      this.setLocation(_x,_y);	//위치지정
      this.setUndecorated(true);
      this.pack();
      this.setVisible(true);                 // f.show(true); 버전1.1이후로는 setVisible\
    }

	public void init(){
    }
    public void start(){

    }*/
}
