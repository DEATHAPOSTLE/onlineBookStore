package com.entity;
public class Favorites {
	// 收藏夹ID
    private int favoritesId;

    // 用户ID    private int userId;

    // 商品ID    private String commodityId;

    // 数量
    private int num;
    public int getFavoritesId(){
        return this.favoritesId;
    }
    public void setFavoritesId(int favoritesId){
        this.favoritesId = favoritesId;
    }
    public int getUserid(){
        return this.userId;
    }
    public void setUserid(int userId){
        this.userId = userId;
    }
    public String getCommodityId(){
        return this.commodityId;
    }
    public void setCommodityId(String commodityId){
        this.commodityId = commodityId;
    }
    public int getNum(){
        return this.num;
    }
    public void setNum(int num){
        this.num = num;
    }
}
