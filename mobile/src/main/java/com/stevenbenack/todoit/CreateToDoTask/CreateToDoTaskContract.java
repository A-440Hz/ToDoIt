package com.stevenbenack.todoit.CreateToDoTask;


import android.text.Editable;

import com.stevenbenack.todoit.BasePresenter;
import com.stevenbenack.todoit.BaseView;

public interface CreateToDoTaskContract {
    interface View extends BaseView<Presenter> {
        void setCurrentDateTimeText(String currentDateTime);
    }

    interface Presenter extends BasePresenter {
        void afterTitleChanged(Editable editable);

        void afterDueDateTimeChanged(Editable editable);

        void onAllDayTaskChecked(boolean isAllDayCheck);
    }
}
