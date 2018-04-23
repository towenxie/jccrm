package com.xe.b2b.data.access.model;

import java.util.List;

/**
 * 商品信息
 * 
 */
public class GoodsEntity extends BaseEntity {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -7044010828907875153L;
    
    private String goodsNumber;
    private String name;
    private Float price = new Float(0);
    private String unit;
    private String location;
    private String producter;
    private Integer stockNum = 0;
    
    private String group = null;
    
    private List<GoodsMediaEntity> medias;
    
    private List<GoodsStockEntity> stocks;

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<GoodsStockEntity> getStocks() {
		return stocks;
	}

	public void setStocks(List<GoodsStockEntity> stocks) {
		this.stocks = stocks;
	}

	public List<GoodsMediaEntity> getMedias() {
		return medias;
	}

	public void setMedias(List<GoodsMediaEntity> medias) {
		this.medias = medias;
	}

	public String getProducter() {
		return producter;
	}

	public void setProducter(String producter) {
		this.producter = producter;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public String getGroup() {
		return goodsNumber+"-"+unit+"-"+price;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GoodsEntity [goodsNumber=");
        builder.append(goodsNumber);
        builder.append(", name=");
        builder.append(name);
        builder.append(", price=");
        builder.append(price);
        builder.append(", unit=");
        builder.append(unit);
        builder.append(", location=");
        builder.append(location);
        builder.append(", producter=");
        builder.append(producter);
        builder.append(", stockNum=");
        builder.append(stockNum);
        builder.append(", group=");
        builder.append(group);
        builder.append(", medias=");
        builder.append(medias);
        builder.append(", stocks=");
        builder.append(stocks);
        builder.append("]");
        return builder.toString();
    }
}
