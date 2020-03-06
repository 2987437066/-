package com.example.ake.models.api;

import com.example.ake.models.bean.BrandBean;
import com.example.ake.models.bean.BrandDetialBean;
import com.example.ake.models.bean.BrandGoodsBean;
import com.example.ake.models.bean.CartBean;
import com.example.ake.models.bean.HotCommoditBean;
import com.example.ake.models.bean.IndexBean;
import com.example.ake.models.bean.LookingBean;
import com.example.ake.models.bean.NewsCommoditBean;
import com.example.ake.models.bean.NewsDetailBean;
import com.example.ake.models.bean.RelatedBean;
import com.example.ake.models.bean.RelatedBottonBean;
import com.example.ake.models.bean.SortDetialBean;
import com.example.ake.models.bean.SortDetialGoodsBean;
import com.example.ake.models.bean.TabItemBean;
import com.example.ake.models.bean.TopBean;
import com.example.ake.models.bean.TopDetailBean;
import com.example.ake.models.bean.TopRecommend;
import com.example.ake.models.bean.TopicBean;
import com.example.ake.models.bean.UserBean;
import com.example.ake.models.bean.VerifyBean;
import com.example.ake.models.bean.VtlNameBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShopApi {
    @GET("index")
    Flowable<IndexBean> getIndexData();
    //品牌直供的详情页数据接口
    @GET("brand/detail")
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);
    //品牌直供详情的商品列表数据接口
    @GET("goods/list")
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);
    //分类名字的接口
    @GET("catalog/index")
    Flowable<VtlNameBean> getVtlNames();
    @GET("catalog/current")
    Flowable<TabItemBean> getSortItems(@Query("id") int id);
    @GET("index")
    Flowable<TopicBean> getTopicData();
    @GET("goods/category")
    Flowable<SortDetialBean> getSortDetialTab(@Query("id") int id);
    @GET("goods/list")
    Flowable<SortDetialGoodsBean> getSortDetailGoods(@Query("categoryId") int id, @Query("page") int page, @Query("size") int size);
    //新品详情页面的banner
    @GET("goods/hot")
    Flowable<NewsDetailBean> getNewsDetailBean();
    @GET("/brand/list")
    Flowable<BrandDetialBean> getBrandDetailBean(@Query("page") int page, @Query("size") int size);
    //新品，首发，居家等商品购买页的RecyclerView数据
    @GET("goods/related")
    Flowable<LookingBean> getLookBean(@Query("id") int id);
    //新品标题打开的列表页
    @GET("goods/list")
    Flowable<NewsCommoditBean> getNewsCommoditBean(@Query("isNew") int isNews, @Query("page") int page, @Query("size") int size, @Query("order") String order, @Query("sort") String sort, @Query("categoryId") int categoryId);
    //人气推荐标题打开的列表页
    @GET("goods/list")
    Flowable<HotCommoditBean> getHotCommoditBean(@Query("isHot") int isHot, @Query("page") int page, @Query("size") int size, @Query("order") String order, @Query("sort") String sort, @Query("categoryId") int categoryId);
    //专题列表
    @GET("topic/list")
    Flowable<TopBean> getTop();
    //专题详情
    @GET("topic/detail")
    Flowable<TopDetailBean> getTopDetail(@Query("id") int id);
    //专题推荐
    @GET("topic/related")
    Flowable<TopRecommend> getTopRecommend(@Query("id") int id);
    //商品购买页面的数据接口
    @GET("goods/detail")
    Flowable<RelatedBean> getRelatedData(@Query("id") int id);
    @GET("goods/related")
    Flowable<RelatedBottonBean> getBottonBean(@Query("id") int id);
    //验证码
    @GET("auth/verify")
    Flowable<VerifyBean> getVerify();
    //登录
    @POST("auth/login")
    Flowable<UserBean> login(@Field("nickname") String nickname, @Field("password") String password);
    //获取购物车的数据
    @GET("cart/index")
    Flowable<CartBean> getCartIndex();

}
