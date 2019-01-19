package pub.ljh.wcpay.model;

import java.util.List;

public class Detail {

	private int costPrice;
	private String receiptId;
	private List<GoodsDetail> goodDetail;

	public class GoodsDetail {

		private String goodsId;
		private String wxpayGoodsId;
		private String goodsName;
		private int quantity;
		private int price;

		public String getGoodsId() {
			return goodsId;
		}

		public void setGoodsId(String goodsId) {
			this.goodsId = goodsId;
		}

		public String getWxpayGoodsId() {
			return wxpayGoodsId;
		}

		public void setWxpayGoodsId(String wxpayGoodsId) {
			this.wxpayGoodsId = wxpayGoodsId;
		}

		public String getGoodsName() {
			return goodsName;
		}

		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "GoodsDetail{" + "goodsId=" + goodsId + ", wxpayGoodsId=" + wxpayGoodsId + ", goodsName=" + goodsName + ", quantity=" + quantity + ", price=" + price + '}';
		}
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public List<GoodsDetail> getGoodDetail() {
		return goodDetail;
	}

	public void setGoodDetail(List<GoodsDetail> goodDetail) {
		this.goodDetail = goodDetail;
	}

	@Override
	public String toString() {
		return "Detail{" + "costPrice=" + costPrice + ", receiptId=" + receiptId + ", goodDetail=" + goodDetail + '}';
	}

}
