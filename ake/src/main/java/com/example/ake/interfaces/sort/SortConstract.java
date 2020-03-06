package com.example.ake.interfaces.sort;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.SortDetialBean;
import com.example.ake.models.bean.SortDetialGoodsBean;
import com.example.ake.models.bean.TabItemBean;
import com.example.ake.models.bean.VtlNameBean;

public interface SortConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getSortReturn(VtlNameBean result);
        void getSortItemReturn(TabItemBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getSort();
        void getSortItem(int id);
    }

    interface DetailView extends IBaseView {
        //返回数据结果
        void getSortDetailReturn(SortDetialBean result);
        void getSortDetailGoodsReturn(SortDetialGoodsBean result);
    }

    interface DetailPersenter extends IBasePersenter<DetailView> {
        //获取数据
        void getSortDetailTab(int id);
        void getSortDetailGoods(int id, int page, int size);
    }
}
