package com.example.app.fragments;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.app.DirectDescActivity;
import com.example.app.R;
import com.example.app.adapter.Rec_home_HotAdapter;
import com.example.app.adapter.Rec_home_directAdapter;
import com.example.app.adapter.Rec_home_livingHomeAdapter;
import com.example.app.adapter.Rec_home_topicAdapter;
import com.example.app.adapter.Rec_home_yisiAdapter;
import com.example.app.base.BaseAdapter;
import com.example.app.base.BaseFragment;
import com.example.app.interfaces.IPersenter;
import com.example.app.interfaces.home.HomeContract;
import com.example.app.model.bean.ShouYeBean;
import com.example.app.percenter.HomePersenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment implements HomeContract.View{
    private Banner banner;
    private TabLayout tabHome;
    private RecyclerView rec_shouye_direct;
    private Rec_home_directAdapter adapter;
    private RecyclerView rec_shouye_yisi;
    private RecyclerView rec_shouye_livinghome;
    private RecyclerView rec_shouye_hot;
    private RecyclerView rec_shouye_topic;
    private Rec_home_yisiAdapter yisiAdapter;
    private TextView tvDirect;
    private TextView tvYisi;
    private TextView tvHot;
    private TextView tvTopic;
    private TextView tvlivinghome;
    private Rec_home_HotAdapter rec_home_hotAdapter;
    private Rec_home_livingHomeAdapter rec_home_livingHomeAdapter;
    private Rec_home_topicAdapter rec_home_topicAdapter;
    private List<ShouYeBean.DataBean.TopicListBean> topicList;
    private List<ShouYeBean.DataBean.HotGoodsListBean> hotGoodsList;
    private List<ShouYeBean.DataBean.NewGoodsListBean> newGoodsList;
    private List<ShouYeBean.DataBean.BrandListBean> brandList;
    private List<ShouYeBean.DataBean.CategoryListBean.GoodsListBean> goodsList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        tabHome = (TabLayout) view.findViewById(R.id.tab_home);
//direct 直供
        rec_shouye_direct = (RecyclerView) view.findViewById(R.id.rec_shouye_direct);
        rec_shouye_yisi = (RecyclerView) view.findViewById(R.id.rec_shouye_yisi);
        rec_shouye_hot = (RecyclerView) view.findViewById(R.id.rec_shouye_hot);
//topic 专题
        rec_shouye_topic = (RecyclerView) view.findViewById(R.id.rec_shouye_topic);
        rec_shouye_livinghome = (RecyclerView) view.findViewById(R.id.rec_shouye_livinghome);

        tvDirect = (TextView) view.findViewById(R.id.tv_direct);
        tvYisi = (TextView) view.findViewById(R.id.tv_yisi);
        tvHot = (TextView) view.findViewById(R.id.tv_hot);
        tvTopic = (TextView) view.findViewById(R.id.tv_topic);
        tvlivinghome = (TextView) view.findViewById(R.id.tv_livinghome);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2){

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rec_shouye_direct.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rec_shouye_livinghome.setLayoutManager(gridLayoutManager);
        rec_shouye_topic.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rec_shouye_hot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rec_shouye_hot.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        rec_shouye_yisi.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        //rec直供的适配器
        brandList = new ArrayList<>();
        adapter = new Rec_home_directAdapter(brandList);
        rec_shouye_direct.setAdapter(adapter);
//点击监听
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(context, "直供"+brandList.get(position).getId(), Toast.LENGTH_SHORT).show();
                GoToDesc(brandList.get(position).getId());
            }
        });

        //rec一四首发
        newGoodsList = new ArrayList<>();
        yisiAdapter = new Rec_home_yisiAdapter(newGoodsList);
        rec_shouye_yisi.setAdapter(yisiAdapter);
//点击监听
        yisiAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(context, "一四首发"+position, Toast.LENGTH_SHORT).show();

            }
        });

        //rec人气推荐
        hotGoodsList = new ArrayList<>();
        rec_home_hotAdapter = new Rec_home_HotAdapter(hotGoodsList);
        rec_shouye_hot.setAdapter(rec_home_hotAdapter);
//点击监听
        rec_home_hotAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(context, "人气推荐"+position, Toast.LENGTH_SHORT).show();

            }
        });

        //rec专题精选
        topicList = new ArrayList<>();
        rec_home_topicAdapter = new Rec_home_topicAdapter(topicList);
        rec_shouye_topic.setAdapter(rec_home_topicAdapter);
//点击监听
        rec_home_topicAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(context, "专题精选"+position, Toast.LENGTH_SHORT).show();

            }
        });

        //rec居家
        goodsList = new ArrayList<>();
        rec_home_livingHomeAdapter = new Rec_home_livingHomeAdapter(goodsList);
        rec_shouye_livinghome.setAdapter(rec_home_livingHomeAdapter);
//点击监听
        rec_home_livingHomeAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(context, "居家"+position, Toast.LENGTH_SHORT).show();

            }
        });

        //rec餐厨
    }

    private void GoToDesc(int id) {
        Intent intent = new Intent(activity, DirectDescActivity.class);
        intent.putExtra("id",id);
        activity.startActivity(intent);
    }


    @Override
    protected void initData() {
        ((HomePersenter)persenter).getHomeData();
    }

    @Override
    protected IPersenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void HomeDataReturn(final ShouYeBean shouYeBean) {

        List<ShouYeBean.DataBean.BannerBean> banners = shouYeBean.getData().getBanner();

        //banner图片资源的集合
        final ArrayList<String> imgs = new ArrayList<>();
        for (int i = 0; i < banners.size(); i++) {
            String image_url = banners.get(i).getImage_url();
            imgs.add(image_url);
        }

        //定义tab集合
        final ArrayList<String> tabs = new ArrayList<>();
        List<ShouYeBean.DataBean.CategoryListBean> categoryList = shouYeBean.getData().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            String name = categoryList.get(i).getName();
            tabs.add(name);
        }

        getActivity().runOnUiThread(new Runnable() {


            @Override
            public void run() {

                tvDirect.setText("品牌制造商直供");
                tvYisi.setText("周一周四·新品首发");
                tvHot.setText("人气推荐");
                tvTopic.setText("专题精选");
                tvlivinghome.setText("居家");

                //banner轮播图的实现
                banner.setImages(imgs).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load((String) path).into(imageView);
                    }
                }).start();

                //banner的点击监听
                banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                //tab的显示
                for (int i = 0; i < tabs.size(); i++) {
                    tabHome.addTab(tabHome.newTab().setText(tabs.get(i)));
                }

                //rec直供的适配器
                adapter.addData(shouYeBean.getData().getBrandList());

                //rec一四首发
                yisiAdapter.addData(shouYeBean.getData().getNewGoodsList());

                //rec人气推荐
                rec_home_hotAdapter.addData(shouYeBean.getData().getHotGoodsList());

                //rec专题精选
                rec_home_topicAdapter.addData(shouYeBean.getData().getTopicList());

                //rec居家
                rec_home_livingHomeAdapter.addData(shouYeBean.getData().getCategoryList().get(0).getGoodsList());
                //rec餐厨
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
}
