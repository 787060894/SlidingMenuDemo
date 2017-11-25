package com.zbb.slidingmenudemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/11/24.
 */

public class MenuFragment extends Fragment {

    private final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new Fragment1();
                    break;
                case 1:
                    fragment = new Fragment2();
                    break;
                case 2:
                    fragment = new Fragment3();
                    break;
            }
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.replacefragment(fragment);
            //关闭菜单页
            mainActivity.toggle();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView listView = new ListView(getActivity());
        String datas[] = {"个性装扮", "我的收藏", "我的相册"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);
        return listView;
    }
}
